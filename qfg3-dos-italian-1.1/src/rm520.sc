;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm520 0
)

(local
	local0
)

(instance rm520 of Rm
	(properties
		noun 6
		picture 520
		vanishingY -20
	)

	(method (init)
		(HandsOff)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 142 278 149 222 158 222 172 202 172 202 158 161 158 153 154 123 158 111 150 114 145 95 140 61 140 61 126 93 126 93 101 121 101 121 96 100 96 100 91 43 91 42 104 35 143 17 189
					yourself:
				)
		)
		((ScriptID 58 0) view: 416) ; elderTalker
		((ScriptID 58 2) view: 416 nsLeft: 45 nsTop: 38) ; elderBust
		((ScriptID 58 4) view: 416 nsLeft: 41 nsTop: 30) ; elderEyes
		((ScriptID 58 3) view: 416 nsLeft: 45 nsTop: 38) ; elderMouth
		((ScriptID 58 1) ; Elder
			setScale: 180
			view: 414
			loop: 0
			cel: 0
			x: 111
			y: 93
			noun: 2
			ignoreActors: 1
			init:
		)
		(spear1 init:)
		(ring init:)
		(log init:)
		(thornWall init:)
		(thornFeat init:)
		(spear2 approachVerbs: 4 init:) ; Do
		(gEgo changeGait: 1 x: 5 y: 46 setScale: 180 ignoreActors: 1 init:) ; running
		((ScriptID 39 1) ; Yesufu
			view: 983
			x: 12
			y: 55
			origStep: 2054
			setScale: 180
			setPri: -1
			setCycle: StopWalk -1
			setLoop: -1
			setLoop: yesufuStopGroop
			noun: 9
			init:
		)
		(gCurRoom setScript: enterRoom)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(egoActions doVerb: 3)
			)
			(65 ; Rest
				(gMessager say: 10 6 6) ; "This Initiation contest is tiring, but resting will have to wait!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(DisposeScript 39)
		(DisposeScript 58)
		(super dispose:)
	)

	(method (doit)
		(if (and (gEgo mover:) (== (gEgo view:) 523))
			(gEgo
				view: 1
				origStep: 2053
				setStep:
				setLoop: -1
				setScale: 180
				setCycle: StopWalk 5
			)
			(spear2 init:)
		)
		(super doit: &rest)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((gCurRoom script:) 0)
					(
						(and
							(< 100 ((User curEvent:) y:) 160)
							(< 145 ((User curEvent:) x:) 300)
						)
						(if local0
							(gCurRoom setScript: egoGetRing)
						else
							(return 0)
						)
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance egoWalkToRing of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 39 1) setCycle: 0 cel: 0 setScript: 0) ; Yesufu
				(gEgo setMotion: MoveTo 209 128 self)
			)
			(1
				(gEgo view: 4 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(ring dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 13 setLoop: 0 setCycle: End self)
			)
			(4
				(gMessager say: 1 6 5 0 self) ; "The Prince of Shapeir is the winner this time."
			)
			(5
				(gEgo solvePuzzle: 289 5 9)
				(gEgo normalize: setMotion: MoveTo 143 160 self)
			)
			(6
				(client setScript: exitRoom)
			)
		)
	)
)

(instance climbLog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 39 1) ; Yesufu
					setScript: 0
					view: 983
					setCycle: StopWalk -1
					setScale: 180
					setLoop: -1
					setHeading: 90
					setLoop: yesufuStopGroop
				)
				(spear1 init:)
				(gEgo
					view: 1
					origStep: 2053
					setStep:
					setLoop: -1
					setScale: 180
					setCycle: StopWalk 5
					setMotion: PolyPath 137 153 self
				)
				(if (not (gCast contains: spear2))
					(spear2 init:)
				)
			)
			(1
				(gWalkHandler addToFront: gCurRoom)
				(egoActions init:)
				(gEgo actions: egoActions)
				(User canControl: 0)
				(gEgo y: 142 setPri: 10 setMotion: MoveTo 177 137 self)
			)
			(2
				(gEgo
					x: 180
					y: 142
					setPri: 10
					loop: 0
					setScale: 180
					setMotion: MoveTo 192 122 self
				)
			)
			(3
				(gEgo view: 4 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(ring dispose:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gMessager say: 1 6 5 0 self) ; "The Prince of Shapeir is the winner this time."
			)
			(6
				(gEgo normalize: setPri: 10 setMotion: MoveTo 180 142 self)
			)
			(7
				(gEgo x: 177 y: 137 setMotion: MoveTo 152 141 self)
			)
			(8
				(gEgo x: 142 y: 153 setMotion: MoveTo 130 160 self)
			)
			(9
				(client setScript: exitRoom)
			)
		)
	)
)

(instance getLog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 1
					origStep: 2053
					setStep:
					setLoop: -1
					setScale: 180
					setCycle: StopWalk 5
					setMotion: PolyPath 133 159 self
				)
				(if (not (gCast contains: spear2))
					(spear2 init:)
				)
			)
			(1
				(log dispose:)
				(logInThorn init:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 1) ; Yesufu
					view: 983
					origStep: 2053
					setScale: 180
					setPri: -1
					setCycle: StopWalk -1
					setLoop: -1
					setLoop: yesufuStopGroop
					setMotion: PolyPath ((ScriptID 39 1) x:) 160 self ; Yesufu
				)
			)
			(1
				(gMessager say: 1 6 4 0 self) ; "You may run!"
			)
			(2
				(= global126 (gEgo moveSpeed:))
				(gEgo setSpeed: 6 setMotion: PolyPath (gEgo x:) 220 self)
				((ScriptID 39 1) setMotion: PolyPath ((ScriptID 39 1) x:) 220) ; Yesufu, Yesufu
			)
			(3
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance egoGetRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 39 1) ; Yesufu
					setScript: 0
					view: 983
					setCycle: StopWalk -1
					setScale: 180
					setHeading: 90
					setLoop: -1
					setLoop: yesufuStopGroop
				)
				(spear1 init:)
				(gEgo setMotion: PolyPath 260 160 self)
			)
			(1
				(gEgo setMotion: MoveTo 209 128 self)
			)
			(2
				(gEgo view: 4 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(ring dispose:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 13 loop: 0 setCycle: End self)
			)
			(5
				(gMessager say: 1 6 5 0 self) ; "The Prince of Shapeir is the winner this time."
			)
			(6
				(gEgo solvePuzzle: 289 5 9)
				(gEgo normalize: setMotion: MoveTo 260 160 self)
			)
			(7
				(client setScript: exitRoom)
			)
		)
	)
)

(instance burnWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 225 160 self)
			)
			(1
				(gEgo view: 4 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(fire setCycle: Fwd init:)
				(gEgo setCycle: Beg self)
			)
			(3
				(= seconds 5)
			)
			(4
				(gEgo normalize:)
				(= local0 1)
				(fire dispose:)
				(thornWall dispose:)
				(thornFeat dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useSpear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 523
					setScale:
					scaleX: 128
					scaleY: 128
					cel: 0
					setLoop: 0
					setCycle: End self
				)
				(spear2 dispose:)
			)
			(1
				(gEgo loop: 1 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance yesufuGetRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(HandsOff)
				(gEgo setCycle: Beg)
				((ScriptID 39 1) ; Yesufu
					view: 983
					setCycle: StopWalk -1
					setScale: 180
					setLoop: -1
					setLoop: yesufuStopGroop
					setMotion: MoveTo (ring x:) (ring y:) self
				)
			)
			(2
				((ScriptID 39 1) ; Yesufu
					view: 521
					setLoop: 2
					setScale:
					scaleX: 128
					scaleY: 128
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(ring dispose:)
				((ScriptID 39 1) setCycle: End self) ; Yesufu
			)
			(4
				((ScriptID 39 1) ; Yesufu
					view: 983
					setCycle: StopWalk -1
					setScale: 180
					setLoop: -1
					setLoop: yesufuStopGroop
					setMotion: MoveTo 85 137 self
				)
			)
			(5
				(gMessager say: 1 6 3 0 self) ; "Yesufu again is the winner."
			)
			(6
				(gEgo
					normalize:
					setScale: 180
					setMotion: MoveTo 260 160 self
				)
			)
			(7
				(client setScript: exitRoom)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 1) setMotion: MoveTo 70 110 self) ; Yesufu
				(gEgo setMotion: MoveTo 60 110 self)
			)
			(1
				((ScriptID 39 1) setMotion: PolyPath 111 96 self) ; Yesufu
			)
			(2)
			(3
				((ScriptID 39 1) setHeading: 0) ; Yesufu
				(gMessager say: 1 6 1 0 self) ; "Yesufu is the winner of this race."
			)
			(4
				((ScriptID 39 1) setMotion: PolyPath 75 110 self) ; Yesufu
			)
			(5
				((ScriptID 39 1) setHeading: 180) ; Yesufu
				(= cycles 12)
			)
			(6
				(gMessager say: 1 6 2 0 self) ; "The first man to be getting the ring from the center of the thorns be the winner."
			)
			(7
				((ScriptID 39 1) setMotion: MoveTo 85 137 self) ; Yesufu
			)
			(8
				((ScriptID 39 1) ; Yesufu
					view: 521
					setLoop: 0
					cel: 0
					setScale:
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
				(spear1 dispose:)
			)
			(9
				((ScriptID 39 1) ; Yesufu
					setLoop: 1
					cel: 0
					setCycle: Fwd
					ignoreActors: 1
					setScript: yesufuGetRing
				)
				(gEgo
					setSpeed: global126
					setAvoider: PAvoider
					ignoreActors: 0
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance yesufuStopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(IsObject ((ScriptID 39 1) cycler:)) ; Yesufu
				(((ScriptID 39 1) cycler:) isKindOf: StopWalk) ; Yesufu
			)
			((ScriptID 39 1) view: (((ScriptID 39 1) cycler:) vWalking:)) ; Yesufu, Yesufu
		)
		(super doit: &rest)
	)
)

(instance thornFeat of Feature
	(properties
		x 215
		y 130
		noun 8
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; theTinderbox
				(thornWall doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spear1 of View
	(properties
		x 64
		y 135
		view 520
		loop 2
		signal 16384
	)
)

(instance spear2 of View
	(properties
		x 208
		y 169
		noun 7
		approachX 185
		approachY 169
		view 520
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: useSpear)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ring of View
	(properties
		x 209
		y 116
		noun 5
		view 520
		loop 6
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gCurRoom script:) 0)
					(local0
						(gCurRoom setScript: egoGetRing)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance thornWall of View
	(properties
		x 222
		y 118
		noun 8
		view 520
		loop 5
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; theTinderbox
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: burnWall)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance log of View
	(properties
		x 138
		y 154
		noun 3
		view 520
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: getLog)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 236
		y 146
		view 520
		loop 4
		cel 6
	)
)

(instance logInThorn of View
	(properties
		x 143
		y 132
		noun 4
		view 520
		loop 1
		cel 1
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: climbLog)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

