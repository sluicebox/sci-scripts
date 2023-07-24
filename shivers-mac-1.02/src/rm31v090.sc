;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31090)
(include sci.sh)
(use Main)
(use n951)
(use n31001)
(use DText)
(use Str)
(use Motion)
(use Actor)
(use System)

(public
	rm31v090 0
)

(local
	[local0 5]
	[local5 55]
	[local60 5] = [34 47 59 72 84]
	[local65 11]
	local76
	[local77 11]
	local88
	[local89 5]
	[local94 5]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= [local89 temp0] ([local0 temp0] cel:))
		(= temp2 (+ (* temp0 11) local76))
		(if (== ([local5 temp2] cel:) 21)
			([local5 temp2] cel: 0)
		)
		(= [local94 temp0] ([local5 temp2] cel:))
	)
	(= temp3 0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if (== [local94 temp0] [local89 temp0])
			(+= temp3 10)
			(= [local89 temp0] -1)
			(= [local94 temp0] -1)
		)
	)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= temp2 (+ (* temp0 11) local76))
		(for ((= temp1 0)) (< temp1 5) ((++ temp1))
			(if
				(and
					(>= [local94 temp0] 0)
					(== [local94 temp0] [local89 temp1])
				)
				(+= temp3 1)
				(= [local89 temp1] -1)
				(= [local94 temp0] -1)
				(break)
			)
		)
	)
	(return temp3)
)

(instance rm31v090 of ShiversRoom
	(properties
		picture 31090
	)

	(method (init &tmp temp0 temp1)
		(proc31001_1)
		(gSounds fade: 23101 0 5 16 1 0)
		(proc951_9 23108)
		(gSounds play: 23108 -1 0 0)
		(gSounds fade: 23108 75 5 16 0 0)
		(efExitBack init: 8)
		(spLever init:)
		(spCover init:)
		(= local76 -1)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(= [local0 temp0]
				((Prop new:)
					view: 31090
					x: 66
					y: [local60 temp0]
					cel: (* (Random 0 6) 3)
					init:
					yourself:
				)
			)
		)
		(for ((= temp1 0)) (< temp1 11) ((++ temp1))
			(for ((= temp0 0)) (< temp0 5) ((++ temp0))
				(= [local5 (+ (* temp0 11) temp1)]
					((spTile new:)
						view: 31090
						pos: (+ (* temp0 11) temp1)
						x: (+ 84 (* temp1 15))
						y: [local60 temp0]
						cel: 0
						init:
						hide:
						yourself:
					)
				)
			)
			(= [local65 temp1]
				((spButton new:) view: 31090 loop: 3 cel: temp1 init: yourself:)
			)
		)
		(super init: &rest)
	)

	(method (newRoom)
		(proc31001_0)
		(super newRoom: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 31430
	)

	(method (init)
		(self
			createPoly: 0 0 0 143 262 143 262 0 1 0 15 20 3 30 3 42 13 110 255 110 255 19 15 19
		)
		(super init: &rest)
	)
)

(instance spLever of ShiversProp
	(properties
		x 16
		y 23
		view 31091
	)

	(method (doVerb)
		(gCurRoom setScript: sInitPuzzle)
	)
)

(class spTile of ShiversProp
	(properties
		view 31090
		pos 0
	)

	(method (handleEvent event &tmp temp0)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
				(!= global184 1)
				(not (self cycler:))
				(== (mod pos 11) local76)
			)
			(event claimed: 1)
			(= temp0 (event x:))
			(gSounds stop: 13105)
			(gSounds play: 13105 0 50 0)
			(if (< temp0 (+ x 8))
				(if (== cel 0)
					(= cel 21)
				)
				(self setCycle: CT (- cel 3) -1)
			else
				(if (== cel 21)
					(= cel 0)
				)
				(self setCycle: CT (+ cel 3) 1)
			)
		)
		(super handleEvent: event &rest)
	)
)

(instance spCover of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 31090
		loop 1
	)

	(method (doVerb)
		(self hide:)
		(gSounds stop: 13103)
		(gSounds play: 13103 0 50 0)
		(= local76 -1)
	)
)

(instance spButton of ShiversProp
	(properties
		priority 5
		fixPriority 1
		view 31090
		loop 3
	)

	(method (doVerb &tmp temp0 temp1)
		(if (== cel local76)
			(= loop 2)
			(gSounds stop: 13107)
			(gSounds play: 13107 0 50 0)
			(= cel local76)
			(= local88 (localproc_0))
			(= [local77 local76]
				((colScore new:)
					font: gSmallFont
					x: (+ 87 (* local76 15))
					y: 30
					init:
					yourself:
				)
			)
			(cond
				((== local88 50)
					(spCover hide:)
					(gCurRoom setScript: sSolved)
				)
				((< (++ local76) 11)
					(for ((= temp0 0)) (< temp0 5) ((++ temp0))
						([local5 (+ (* temp0 11) local76)] show:)
					)
				)
				(else
					(spCover hide:)
				)
			)
		)
	)
)

(instance sInitPuzzle of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spLever cel: 0 setCycle: End self)
				(gSounds stop: 13101)
				(gSounds stop: 13102)
				(gSounds stop: 13103)
				(gSounds stop: 13106)
				(gSounds stop: 13107)
				(gSounds stop: 33150)
				(gSounds play: 13102 0 50 0)
				(for ((= temp2 0)) (< temp2 11) ((++ temp2))
					(for ((= temp0 0)) (< temp0 5) ((++ temp0))
						([local5 (+ (* temp0 11) temp2)] cel: 0 hide:)
					)
					([local65 temp2] loop: 3)
					(if [local77 temp2]
						([local77 temp2] dispose: 1)
						(= [local77 temp2] 0)
					)
				)
			)
			(1
				(gSounds play: 13101 0 50 self)
				(gSounds play: 13103 0 50 0)
				(spCover hide:)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(= temp1 (mod (+ ([local0 temp0] cel:) (Random 0 2)) 21))
					([local0 temp0]
						setCycle: Fwd
						cel: temp1
						cycleSpeed: (Random 1 3)
					)
				)
				(= ticks 30)
			)
			(2
				(spLever setCycle: Beg self)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					([local0 temp0] cycleSpeed: (Random 2 4))
				)
			)
			(3
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					([local0 temp0] cycleSpeed: (Random 4 6))
				)
				(= ticks 30)
			)
			(4
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					([local0 temp0] cycleSpeed: (Random 6 8))
				)
				(= ticks 30)
			)
			(5
				(spCover show:)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(= temp1 (mod (+ ([local0 temp0] cel:) (Random 0 9)) 21))
					([local0 temp0] setCycle: 0 cel: (* 3 (/ temp1 3)))
				)
			)
			(6
				(gGame handsOn:)
				(= local76 0)
				(= local88 0)
				(gSounds play: 13107 0 50 0)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					([local5 (+ (* temp0 11) local76)] cycleSpeed: 4 show:)
				)
				(self dispose:)
			)
		)
	)
)

(instance colScore of DText
	(properties
		priority 255
		fixPriority 1
		fore 181
		font 2510
	)

	(method (init &tmp temp0)
		(= temp0 (Str format: {%3d} local88))
		(gSounds stop: 13106)
		(gSounds play: 13106 0 50 0)
		(self text: (temp0 data:) setSize: 250)
		(super init: &rest)
	)

	(method (dispose)
		(if text
			(KString 4 text) ; StrFree
			(= text 0)
		)
		(super dispose: &rest)
	)
)

(instance sSolved of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13108 0 90 self)
			)
			(1
				(gGame handsOn:)
				(= local76 -1)
				(SetFlag 65)
				(proc951_15 6750)
			)
		)
	)
)

