;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 561)
(include sci.sh)
(use Main)
(use Inset)
(use PolyPath)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	safePicture 0
	safeDoor 1
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4]
)

(instance safePicture of Prop
	(properties
		x 82
		y 100
		noun 38
		modNum 561
		approachX 93
		approachY 149
		view 564
		loop 1
		priority 6
		signal 16
	)

	(method (init)
		(super init: &rest)
		(safe init: stopUpd:)
		(safeDoor init: stopUpd:)
		(self doVerb: 4)
	)

	(method (dispose)
		(sFX dispose:)
		(safe dispose:)
		(safeDoor dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== (self cel:) 0)
						(sFX number: 44 flags: 5 setLoop: 1 play:)
						(self setCycle: End)
					)
					((== (safeDoor cel:) 0)
						(sFX number: 45 flags: 5 setLoop: 1 play:)
						(self setCycle: Beg)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance safeDoor of Prop
	(properties
		x 76
		y 95
		noun 40
		modNum 561
		approachX 93
		approachY 149
		view 564
		loop 2
		priority 5
		signal 16
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inDial)
			)
			(8 ; magnifier
				(gCurRoom setInset: inDial)
			)
			(4 ; Do
				(gEgo setHeading: 270)
				(++ local3)
				(cond
					(local0
						(if (== (self cel:) 0)
							(= local3 0)
							(sFX number: 560 flags: 5 setLoop: 1 play:)
							(self setPri: 7 setCycle: End)
							(= local1 1)
						else
							(= local0 0)
							(self setScript: sCloseSafe)
						)
					)
					((< local3 3)
						(gCurRoom setInset: inDial)
					)
					(else
						(self setScript: sHeimlichEnters)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inDial of Inset
	(properties
		view 564
		loop 4
		x 53
		y 33
		disposeNotOnMe 1
		modNum 561
	)

	(method (init)
		(super init: &rest)
		(dialNumber init:)
		(zero init:)
		(one init:)
		(two init:)
		(three init:)
		(four init:)
		(five init:)
		(six init:)
		(seven init:)
		(eight init:)
		(nine init:)
		(safeDoor stopUpd:)
		(safePicture stopUpd:)
		(gEgo stopUpd:)
		(= local2 0)
		(= [local5 0] -1)
		(= [local5 1] -1)
		(= [local5 2] -1)
		(= [local5 3] -1)
	)

	(method (dispose)
		(dialNumber dispose:)
		(zero dispose:)
		(one dispose:)
		(two dispose:)
		(three dispose:)
		(four dispose:)
		(five dispose:)
		(six dispose:)
		(seven dispose:)
		(eight dispose:)
		(nine dispose:)
		(safeDoor startUpd:)
		(safePicture startUpd:)
		(gEgo startUpd:)
		(super dispose:)
	)
)

(instance dialNumber of Prop
	(properties
		x 61
		y 39
		noun 78
		modNum 561
		view 564
		loop 5
		priority 15
		signal 16
		cycleSpeed 18
	)

	(method (initialize))
)

(instance safe of View
	(properties
		x 55
		y 70
		noun 39
		modNum 561
		approachX 93
		approachY 149
		view 564
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local1
					(gCurRoom setInset: inDiary)
				else
					(gMessager say: 39 1 0 0 0 561) ; "It's a wall safe."
				)
			)
			(8 ; magnifier
				(if local1
					(gCurRoom setInset: inDiary)
				else
					(gMessager say: 39 1 0 0 0 561) ; "It's a wall safe."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inDiary of Inset
	(properties
		view 564
		loop 3
		x 53
		y 45
		disposeNotOnMe 1
		modNum 561
		noun 60
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gGame points: 1 174)
				((ScriptID 21 0) doit: 1030) ; addCluesCode, Sterling W-C Diary
				(gMessager say: 60 1 0 0 0 561) ; "It's the personal diary of former museum President Sterling Waldorf-Carlton."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sTurnTumbler of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0 (if (mod local2 2) -1 else 1))
				(sFX number: 562 flags: 1 play: setLoop: -1)
				(dialNumber
					setCycle: CT (mod (+ local4 register) 10) temp0 self
				)
			)
			(1
				(= local4 (dialNumber cel:))
				(if (< (++ local2) 5)
					(= [local5 (- local2 1)] local4)
				)
				(if (== local2 4)
					(if
						(and
							(== [local5 0] 0)
							(== [local5 1] 5)
							(== [local5 2] 2)
							(== [local5 3] 7)
						)
						(= local0 1)
						(sFX number: 558 flags: 1 setLoop: 1 play:)
					else
						(= local0 0)
						(sFX stop:)
					)
					(inDial dispose:)
					(dialNumber dispose:)
				else
					(sFX stop:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(safeDoor setPri: 5 setCycle: Beg self)
			)
			(1
				(sFX number: 561 flags: 5 play: setLoop: 1)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance sHeimlichEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic2 fade:)
				((ScriptID 560 4) locked: 0 exitType: 2 caller: self open:) ; westDoor
			)
			(1
				(gGameMusic2 number: 19 loop: -1 flags: 1 play:)
				(gGame handsOff:)
				(= ticks 60)
			)
			(2
				(Face gEgo (ScriptID 560 4)) ; westDoor
				(= ticks 60)
			)
			(3
				((ScriptID 32 0) ; aHeimlich
					init:
					setLoop: 0
					setCel: 5
					posn: 0 146
					setPri: 10
					room: 560
					view: 814
					setCycle: Walk
					setMotion: MoveTo 11 148 self
				)
			)
			(4
				((ScriptID 32 0) setMotion: PolyPath 64 163 self) ; aHeimlich
			)
			(5
				(Face gEgo (ScriptID 32 0)) ; aHeimlich
				((ScriptID 32 0) setPri: -1 setCycle: StopWalk -1) ; aHeimlich
				(= cycles 1)
			)
			(6
				(Face (ScriptID 32 0) gEgo) ; aHeimlich
				(= ticks 60)
			)
			(7
				(gMessager say: 3 0 87 0 self 1889) ; "ACHTUNG! Zis President's office ist VERBOTEN! Leave NOW or DIE!"
			)
			(8
				(gEgo setMotion: PolyPath 10 175 self)
			)
			(9
				(Face (ScriptID 32 0) gEgo) ; aHeimlich
				(gEgo setMotion: PolyPath 4 145 self)
			)
			(10
				(SetFlag 97)
				(gGameMusic2 fade: self)
			)
			(11
				(gGame handsOn:)
				(gCurRoom newRoom: 550)
				(self dispose:)
			)
		)
	)
)

(class DialFeature of Feature
	(properties
		dialPosn 0
	)

	(method (initialize))
)

(instance zero of DialFeature
	(properties
		y 100
		nsTop 38
		nsLeft 97
		nsBottom 50
		nsRight 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance one of DialFeature
	(properties
		y 100
		nsTop 45
		nsLeft 120
		nsBottom 57
		nsRight 135
		dialPosn 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance two of DialFeature
	(properties
		y 100
		nsTop 63
		nsLeft 133
		nsBottom 75
		nsRight 149
		dialPosn 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance three of DialFeature
	(properties
		y 100
		nsTop 87
		nsLeft 135
		nsBottom 100
		nsRight 150
		dialPosn 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance four of DialFeature
	(properties
		y 100
		nsTop 103
		nsLeft 123
		nsBottom 116
		nsRight 135
		dialPosn 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance five of DialFeature
	(properties
		y 100
		nsTop 109
		nsLeft 97
		nsBottom 123
		nsRight 111
		dialPosn 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance six of DialFeature
	(properties
		y 100
		nsTop 104
		nsLeft 76
		nsBottom 120
		nsRight 90
		dialPosn 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance seven of DialFeature
	(properties
		y 100
		nsTop 86
		nsLeft 58
		nsBottom 101
		nsRight 74
		dialPosn 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eight of DialFeature
	(properties
		y 100
		nsTop 54
		nsLeft 58
		nsBottom 75
		nsRight 75
		dialPosn 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nine of DialFeature
	(properties
		y 100
		nsTop 43
		nsLeft 74
		nsBottom 58
		nsRight 91
		dialPosn 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(dialNumber setScript: sTurnTumbler 0 dialPosn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

