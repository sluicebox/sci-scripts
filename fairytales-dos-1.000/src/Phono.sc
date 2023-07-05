;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use goGet)
(use GameControls)
(use IconBar)
(use Window)
(use Sound)
(use Game)
(use System)

(public
	Phono 0
)

(local
	local0
	local1
	local2 = -1
	[local3 16] = [40 60 40 85 40 110 170 10 170 35 170 60 170 85 170 110]
	[local19 26] = [11 {Bach: Bouree in E minor} 2 {Bach: Brandenberg Concertos} 6 {Bach: "Jesus, Joy of Man's Desiring"} 7 {Bach: First Cello Suite} 20 {Beethoven: Ninth Symphony} 4 {Beethoven: "Ode to Joy"} 1 {Mozart: Lacrimosa} 22 {Mozart: Marriage of Figaro} 14 {Mozart: The Magic Flute} 12 {Rachmaninoff: Piano Concerto in C# minor} 28 {Tchaikovsky: Symphony #6} 19 {Vivaldi: Lute Concerto in D Major} 44 {Wagner: The Valkyries}]
	local45
)

(procedure (localproc_0 param1 param2)
	(return (if (>= global103 256) param1 else param2))
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(if (!= local2 -1)
		(= temp2 local2)
		(= local2 -1)
		(phonoSong client: 0 stop:)
		(if (and (songBook size:) (<= (= temp1 (* local0 7)) temp2 (+ temp1 6)))
			(= temp0 (songBook at: (mod temp2 7)))
			(temp0 highlight: (== temp0 (songBook curIcon:)))
		)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3)
	(= temp1 (* local0 7))
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		(= temp3 (+ temp1 temp0))
		(= temp2 (songBook at: temp0))
		(if (>= temp3 local1)
			(temp2 signal: (| (temp2 signal:) $0004))
		else
			(temp2 signal: (& (temp2 signal:) $fffb))
		)
		(temp2 mask: value: temp3 show:)
	)
)

(instance Phono of Rm
	(properties
		picture 500
	)

	(method (init)
		(SetPort 0 0 200 320 0 0)
		(super init: &rest)
		(= local1 (/ (- @local45 @local19) 4))
		(gGlobalMusic fade:)
		(gGlobalMusic2 fade:)
		(phonoSong init:)
		(self setScript: phonoScript)
	)

	(method (dispose)
		(localproc_1)
		(phonoSong dispose:)
		(DrawPic 802 100 1 global40)
		(Graph grFILL_BOX 0 0 26 320 1 0 -1 -1)
		(Graph grUPDATE_BOX 0 0 26 320 1)
		(SetPort 0 0 174 320 26 0)
		(super dispose: &rest)
	)
)

(instance phonoScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(songBook init: show:)
				(songBook dispose:)
				(gCurRoom newRoom: 235)
			)
		)
	)
)

(instance nextPageButton of IconI
	(properties
		view 480
		loop 0
		cel 0
		nsLeft 225
		nsTop 104
		signal 385
		highlightColor 9
		lowlightColor 58
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (>= (= temp0 (* (++ local0) 7)) local1)
				(= local0 (= temp0 0))
			)
			(localproc_2 local0)
		)
	)

	(method (highlight param1)
		(= cel (if param1 2 else 0))
		(self show:)
	)
)

(instance exitButton of IconI
	(properties
		view 480
		loop 1
		cel 0
		nsLeft 144
		nsTop 160
		signal 449
		highlightColor 9
		lowlightColor 58
	)
)

(class Song of IconI
	(properties
		signal 385
		highlightColor 9
		lowlightColor 67
		value 0
		underBits 0
		playColor 45
	)

	(method (init)
		(= highlightColor (localproc_0 9 12))
		(= lowlightColor (localproc_0 67 6))
		(= playColor (localproc_0 45 13))
	)

	(method (dispose)
		(self mask:)
		(super dispose: &rest)
	)

	(method (show &tmp temp0)
		(if (< value local1)
			(= nsLeft [local3 (= temp0 (* (mod value 7) 2))])
			(= nsTop [local3 (+ temp0 1)])
			(= nsRight (+ nsLeft 110))
			(= nsBottom (+ nsTop 20))
			(|= signal $0020)
			(if (& signal $0004)
				(self mask:)
			else
				(self highlight: (== self (songBook curIcon:)))
			)
			(if (and gPMouse (gPMouse respondsTo: #stop))
				(gPMouse stop:)
			)
		)
	)

	(method (mask)
		(if underBits
			(Display 480 0 dsRESTOREPIXELS underBits)
			(= underBits 0)
		)
	)

	(method (highlight param1 &tmp temp0)
		(= temp0
			(cond
				((== local2 value) playColor)
				((or (not argc) param1) highlightColor)
				(else lowlightColor)
			)
		)
		(if (& signal $0020)
			(self draw: temp0)
		)
	)

	(method (select param1 &tmp temp0 temp1)
		(cond
			((& signal $0004) 0)
			((and argc param1 (& signal $0001))
				(= temp1 1)
				(self draw: playColor)
				(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
					(temp0 localize:)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(= temp1 1)
								(self draw: playColor)
							)
						)
						(temp1
							(= temp1 0)
							(self draw: highlightColor)
						)
					)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(if temp1
					(self select:)
				)
			)
			(else
				(self draw: playColor)
				(localproc_1)
				(= local2 value)
				(phonoSong number: [local19 (* value 2)] loop: 1 play: self)
			)
		)
	)

	(method (cue &tmp temp0)
		(if
			(= temp0
				(switch (phonoSong number:)
					(2 5)
					(5 38)
					(38 39)
					(3 24)
					(9 37)
					(12 21)
					(14 15)
					(15 13)
					(16 26)
					(17 10)
					(19 9)
					(20 25)
					(21 16)
					(22 23)
					(23 8)
					(25 3)
					(26 27)
					(27 50)
					(50 49)
					(49 51)
					(28 29)
					(29 30)
					(30 31)
					(31 32)
					(32 33)
					(33 34)
					(34 35)
					(35 36)
					(37 17)
					(44 46)
					(else 0)
				)
			)
			(phonoSong number: temp0 play: self)
		else
			(localproc_1)
		)
	)

	(method (draw param1)
		(if underBits
			(Display 480 0 dsRESTOREPIXELS underBits)
			(= underBits 0)
		)
		(if (< value local1)
			(= underBits
				(Display
					[local19 (+ (* value 2) 1)]
					dsCOORD
					(+ nsLeft 5)
					(+ nsTop 3)
					dsWIDTH
					100
					dsCOLOR
					param1
					dsFONT
					3
					dsSAVEPIXELS
				)
			)
		)
	)
)

(instance songBook of GameControls
	(properties)

	(method (init &tmp temp0)
		(= window phonoWindow)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(self add: ((Song new:) value: temp0 init: yourself:))
		)
		(self add: nextPageButton exitButton)
		(super init: &rest)
	)

	(method (dispatchEvent)
		(gSounds eachElementDo: #check)
		(super dispatchEvent: &rest)
	)
)

(instance phonoWindow of SysWindow
	(properties
		bottom 176
		right 320
		color 15
		type 129
	)
)

(instance phonoSong of Sound
	(properties
		number 1
		priority 15
		loop 0
	)
)

