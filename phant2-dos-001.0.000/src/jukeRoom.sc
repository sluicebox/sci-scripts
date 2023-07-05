;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2900)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)
(use Str)
(use PolyEdit)
(use TextField)
(use Sound)
(use System)

(public
	jukeRoom 0
)

(local
	local0 = 1
	local1
	local2
	local3
	local4 = 1
	[local5 37] = [2910 2910 2920 2930 2931 2940 2941 2950 3011 3012 3013 3014 3020 3021 3022 3031 3032 3041 3042 3051 4601 4602 4771 4772 810 910 9400 10120 10505 42010 42280 6920 6930 6940 1910 1960 909]
	local42
)

(instance jukeRoom of CloseupRoom
	(properties
		picture 3000
	)

	(method (init &tmp [temp0 5])
		(= local2 (Str new:))
		(= local42 0)
		(if (gP2SongPlyr isPlaying:)
			(= local42 (gP2SongPlyr number:))
		)
		(gP2SongPlyr stop:)
		(= exitRoom gPrevRoomNum)
		(= local0 1)
		(= local4 1)
		(local2 format: {%d} local4)
		(upView init:)
		(downView init:)
		(leftView init:)
		(rightView init:)
		(gary init:)
		(jukeTitle
			setText: {Juke Box}
			setSize:
			init: gThePlane
			posn: 239 53
			setPri: 400
		)
		(trackText setText: setSize: init: gThePlane posn: 215 255 setPri: 400)
		(= local3 trackText)
		(aptText setText: setSize: init: gThePlane posn: 206 117 setPri: 400)
		(= local1 aptText)
		(SetCursor 70 251)
		(super init: &rest)
		(jukeSong play: 2910)
		(gGame handsOn:)
	)

	(method (dispose)
		(local2 dispose:)
		(jukeSong stop:)
		(jukeSong dispose:)
		(if (!= local42 0)
			(gP2SongPlyr start: local42)
		)
		(super dispose: &rest)
	)
)

(instance jukeTitle of TextView
	(properties)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: &rest)
		(text font: 7)
	)
)

(instance aptText of TextView
	(properties)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: {Apartment})
		(text font: 7)
	)
)

(instance wtText of TextView
	(properties)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: {WynTech/Threshold})
		(text font: 7)
	)
)

(instance mhText of TextView
	(properties)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: {Hospital})
		(text font: 7)
	)
)

(instance blText of TextView
	(properties)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: {Borderline})
		(text font: 7)
	)
)

(instance miscText of TextView
	(properties)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: {Misc. ('Shivers')})
		(text font: 7)
	)
)

(instance trackText of TextView
	(properties
		celHeight 40
		celWidth 40
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: (local2 data:))
		(text font: 7)
	)
)

(instance upView of View
	(properties
		x 178
		y 96
		view 999
	)

	(method (init)
		(super init: &rest)
		(self setPri: 2)
		(upFeat init:)
	)
)

(instance upFeat of P2Feature
	(properties)

	(method (init)
		(super init: 159 95 194 125)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(changeRoom doit: -1 1)
		)
		(event claimed:)
	)
)

(instance downView of View
	(properties
		x 178
		y 170
		view 999
		cel 4
	)

	(method (init)
		(super init: &rest)
		(self setPri: 2)
		(downFeat init:)
	)
)

(instance downFeat of P2Feature
	(properties)

	(method (init)
		(super init: 159 131 196 169)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(changeRoom doit: 1 1)
		)
		(event claimed:)
	)
)

(instance changeRoom of Code
	(properties)

	(method (doit param1)
		(if (> (+= local0 param1) 5)
			(= local0 1)
		)
		(if (< local0 1)
			(= local0 5)
		)
		(switch local0
			(1
				(local1 dispose:)
				(aptText
					setText:
					setSize:
					init: gThePlane
					posn: 206 117
					setPri: 400
				)
				(if (== argc 2)
					(= local4 1)
					(playSong doit: [local5 1])
				)
				(= local1 aptText)
			)
			(2
				(local1 dispose:)
				(wtText
					setText:
					setSize:
					init: gThePlane
					posn: 206 117
					setPri: 400
				)
				(if (== argc 2)
					(= local4 8)
					(playSong doit: [local5 8])
				)
				(= local1 wtText)
			)
			(3
				(local1 dispose:)
				(blText
					setText:
					setSize:
					init: gThePlane
					posn: 206 117
					setPri: 400
				)
				(if (== argc 2)
					(= local4 31)
					(playSong doit: [local5 31])
				)
				(= local1 blText)
			)
			(4
				(local1 dispose:)
				(mhText
					setText:
					setSize:
					init: gThePlane
					posn: 206 117
					setPri: 400
				)
				(if (== argc 2)
					(= local4 34)
					(playSong doit: [local5 34])
				)
				(= local1 mhText)
			)
			(5
				(local1 dispose:)
				(miscText
					setText:
					setSize:
					init: gThePlane
					posn: 206 117
					setPri: 400
				)
				(if (== argc 2)
					(= local4 36)
					(playSong doit: [local5 36])
				)
				(= local1 miscText)
			)
		)
	)
)

(instance leftView of View
	(properties
		x 163
		y 233
		view 999
		cel 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 2)
		(leftFeat init:)
	)
)

(instance leftFeat of P2Feature
	(properties)

	(method (init)
		(super init: 163 222 213 246)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(changeSong doit: -1)
		)
		(event claimed:)
	)
)

(instance rightView of View
	(properties
		x 283
		y 233
		view 999
		cel 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 2)
		(rightFeat init:)
	)
)

(instance rightFeat of P2Feature
	(properties)

	(method (init)
		(super init: 229 223 283 246)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(changeSong doit: 1)
		)
		(event claimed:)
	)
)

(instance changeSong of Code
	(properties)

	(method (doit param1)
		(if (> (+= local4 param1) 36)
			(= local4 1)
		)
		(if (< local4 1)
			(= local4 36)
		)
		(switch local0
			(1
				(if (> local4 7)
					(changeRoom doit: param1)
				)
			)
			(2
				(if (or (<= local4 7) (> local4 30))
					(changeRoom doit: param1)
				)
			)
			(3
				(if (or (<= local4 30) (> local4 33))
					(changeRoom doit: param1)
				)
			)
			(4
				(if (or (<= local4 33) (> local4 35))
					(changeRoom doit: param1)
				)
			)
			(5
				(if (<= local4 35)
					(changeRoom doit: param1)
				)
			)
		)
		(playSong doit: [local5 local4])
	)
)

(instance playSong of Code
	(properties)

	(method (doit param1)
		(gGame handsOff:)
		(PrintDebug {%d} param1)
		(jukeSong play: param1)
		(local2 format: {%d} local4)
		(local3 dispose:)
		(trackText setText: setSize: init: gThePlane posn: 215 255 setPri: 400)
		(= local3 trackText)
		(gGame handsOn:)
	)
)

(instance jukeSong of Sound
	(properties
		loop -1
	)

	(method (play param1)
		(if (ResCheck 140 param1) ; WAVE
			(= number param1)
			(super play: 0 global236)
		else
			(self stop:)
		)
	)
)

(instance gary of View
	(properties
		x 428
		y 32
		view 909
		loop 3
	)
)

