;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use TargFeature)
(use n026)
(use JumpX)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm810 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(sFx number: 931 play:)
	(deader init: setPri: 11 ignoreActors: 1 addToPic:)
	(switch global448
		(0 0)
		(1
			(deader1 init: ignoreActors: 1 addToPic:)
		)
		(2
			(deader1 init: ignoreActors: 1 addToPic:)
			(deader2 init: ignoreActors: 1 addToPic:)
		)
		(else
			(deader1 init: ignoreActors: 1 addToPic:)
			(deader2 init: ignoreActors: 1 addToPic:)
			(deader3 init: ignoreActors: 1 addToPic:)
		)
	)
	(++ global448)
)

(instance rm810 of Rm
	(properties
		noun 9
		picture 810
	)

	(method (init)
		(Scaler backY: 145)
		(gEgo x: -22 y: 168 init: setScale: Scaler 100 50 189 125 normalize:)
		(LoadMany rsVIEW 810 570 6)
		(HandsOn)
		(super init:)
		(gLongSong number: 810 setLoop: -1 play: 127)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 173 81 173 165 189 216 148 185 138 168 135 155 127 133 124 133 99 112 99 112 126 142 157 0 157
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 148 81 212 81 212 71 148 71
					yourself:
				)
		)
		(pedestal init:)
		(stairs init:)
		(leftStairs init:)
		(ruins init:)
		(rocks init:)
		(noWayToGo init:)
		(anubisStatue init:)
		(if (and (not (gEgo has: 34)) (not (IsFlag 136))) ; theOpal
			(opal setPri: 14 init: stopUpd:)
		)
		(if (IsFlag 136)
			(doorWay init: loop: 2 approachVerbs: 4 1 ignoreActors: 0) ; Do, Look
		else
			(doorWay init: approachVerbs: 4 1) ; Do, Look
		)
		(if (and (not (== global155 0)) (== gPrevRoomNum 550)) ; combatRm
			(gEgo x: 60 y: 169 code: quikChek)
			(localproc_0)
		else
			(self setScript: egoEnters)
		)
		(if (and (== gPrevRoomNum 550) (== global155 0)) ; combatRm
			(self setScript: egoIsDead)
		)
	)

	(method (setInset param1 param2 param3)
		(gEgo code: 0)
		(gTheIconBar disable: 6 1 5 3)
		(if inset
			(inset dispose:)
		)
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
		(if (IsFlag 136)
			(opal view: 810 loop: 1 setPri: 14 x: 158 y: 83 init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gEgo setScript: castProj 0 theVerb)
			)
			(83 ; forceBoltSpell
				(gEgo setScript: castProj 0 theVerb)
			)
			(32 ; theHorn
				(gEgo setScript: castProj 0 theVerb)
			)
			(20 ; theDaggers
				(gEgo setScript: castProj 0 theVerb)
			)
			(65 ; Rest
				(gMessager say: 1 6 1) ; "You can't rest here. You would surely be caught and killed by the Apeman guards."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gEgo code: 0)
		(UnLoad 128 810)
		(UnLoad 128 570)
		(UnLoad 128 6)
		(LoadMany 0 956 923 37 57)
		(if gList
			(gList eachElementDo: #dispose)
		)
		(super dispose:)
	)
)

(instance egoIsDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(EgoDead) ; "It's all over for now. Please try again."
			)
		)
	)
)

(instance castOpenOnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_14 125 101)
				(self setScript: (ScriptID 13 0) self) ; castOpenScript
			)
			(1
				(gMessager say: 1 6 6) ; "Your Open spell is not powerful enough to open the magically sealed door. You'll have to try opening it another way."
			)
			(2
				(HandsOn)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance egoFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					code: 0
					view: 35
					setLoop: 3
					cel: 0
					setCycle: CT 1 1 self
				)
				(= local2 (gEgo moveSpeed:))
			)
			(1
				(gEgo
					moveSpeed: 0
					ignoreActors: 1
					illegalBits: 0
					setMotion: JumpX -48 self
				)
			)
			(2
				(gEgo x: 162 y: 131 z: 0 setCycle: End self)
			)
			(3
				(sFx number: 920 setLoop: 1 play:)
				(ShakeScreen 10)
				(= cycles 11)
			)
			(4
				(gEgo loop: 5 cel: 0 illegalBits: -32768 setCycle: End self)
			)
			(5
				(if (or (gCast contains: apeMan) (gCast contains: apeMan1))
					(= global365 575)
					(= global156 180)
					(gCurRoom newRoom: 550) ; combatRm
				)
				(gEgo code: quikChek moveSpeed: local2 normalize:)
				(= local0 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cantExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 code: 0)
				(apeMan1
					setScale: Scaler 100 50 189 125
					x: 0
					y: 168
					init:
					setStep: 4 4
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 30 168 self
				)
			)
			(1
				(= global365 575)
				(= global156 180)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance apeManCrossLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(apeMan
					x: 322
					y: 79
					setPri: 0
					setScale: Scaler 100 50 189 50
					setCycle: Walk
					init:
					setStep: 4 4
					setMotion: MoveTo 96 79 self
				)
			)
			(1
				(apeMan setHeading: 180)
				(= seconds 5)
			)
			(2
				(apeMan setMotion: MoveTo 322 79 self)
			)
			(3
				(apeMan setScale: 189 setPri: -1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance castProj of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: (ScriptID 32 0) self register) ; project
			)
			(1
				(if (gCast contains: apeMan)
					(= global365 575)
					(= global156 180)
					(gCurRoom newRoom: 550) ; combatRm
				)
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance apeManCrossRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(apeMan
					setScale: Scaler 100 50 189 125
					x: 41
					y: 134
					init:
					setStep: 4 4
					setCycle: Walk
					setMotion: MoveTo 340 162 self
				)
			)
			(1
				(apeMan dispose:)
				(self dispose:)
			)
		)
	)
)

(instance climbDownPedestal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 166 70 self)
			)
			(1
				(sFx number: 928 play:)
				(gEgo view: 7 cel: 11 loop: 4 setCycle: Beg self)
			)
			(2
				(gEgo
					code: quikChek
					view: 7
					y: 93
					setStep: 2 1
					setLoop: 3
					setCycle: Rev
					setMotion: MoveTo 162 131 self
				)
			)
			(3
				(gEgo view: 5 normalize:)
				(HandsOn)
				(= local0 0)
				(if (not (gCast contains: apeMan))
					(gCurRoom setScript: apeManCrossLeft)
				else
					(= global365 575)
					(= global156 180)
					(gCurRoom newRoom: 550) ; combatRm
				)
				(self dispose:)
			)
		)
	)
)

(instance climbUpPedestal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 162 131 self)
			)
			(1
				(gEgo view: 7 setLoop: 3 setCycle: ForwardCounter 2 self)
				(sFx number: 928 play:)
			)
			(2
				(gEgo
					setCycle: Fwd
					cycleSpeed: 5
					setStep: 2 1
					setMotion: MoveTo 166 93 self
				)
			)
			(3
				(gEgo loop: 4 cel: 0 y: 70 setCycle: End self)
			)
			(4
				(gEgo view: 13 setHeading: 180 setCycle: End)
				(= seconds 3)
			)
			(5
				(gEgo code: fallChek setStep: 3 2 normalize:)
				(= local0 1)
				(HandsOn)
				(if (not (gCast contains: apeMan))
					(apeMan
						x: 41
						y: 144
						setScale: 189
						init:
						setStep: 4 4
						setScript: apeManCrossRight
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(apeMan
					setScale: Scaler 100 50 189 125
					init:
					setStep: 4 4
					setCycle: Walk
					setMotion: MoveTo 340 162 self
				)
			)
			(1
				(apeMan dispose:)
				(gEgo x: -20 y: 168 setMotion: PolyPath 60 169 self)
			)
			(2
				(if (IsFlag 150)
					(gMessager say: 1 6 7 0 self) ; "You have a feeling of danger near you."
				else
					(self cue:)
				)
			)
			(3
				(gEgo code: quikChek)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance hoarkOpal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					get: 34 ; theOpal
					solvePuzzle: 329 5 5
					setMotion: MoveTo 181 71 self
				)
			)
			(1
				(opal dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance apeMan1 of Actor
	(properties
		view 570
	)
)

(instance apeMan of TargActor
	(properties
		x 41
		y 134
		view 570
	)

	(method (getHurt)
		(= global365 575)
		(= global156 180)
		(gCurRoom newRoom: 550) ; combatRm
		(super getHurt:)
	)
)

(instance doorWay of View
	(properties
		x 116
		y 94
		noun 8
		nsTop 87
		nsLeft 114
		nsBottom 121
		nsRight 132
		sightAngle 40
		approachX 124
		approachY 137
		_approachVerbs 4
		view 811
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local0 0)
					(if (not (IsFlag 136))
						(gCurRoom setInset: anubisInset)
					else
						(super doVerb: theVerb)
					)
				else
					(gMessager say: 1 6 2) ; "You will have to climb down first."
				)
			)
			(1 ; Look
				(if (== local0 0)
					(gCurRoom setInset: anubisInset)
				else
					(gMessager say: 1 6 3) ; "The trees and ruined buildings block your view."
				)
			)
			(75 ; openSpell
				(if (not (gEgo script:))
					(gEgo setScript: castOpenOnDoor)
				)
			)
			(45 ; theOpal
				(if (== local0 0)
					(gCurRoom setInset: anubisInset)
				else
					(gMessager say: 1 6 2) ; "You will have to climb down first."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance opal of View
	(properties
		x 185
		y 56
		view 811
		signal 16384
	)
)

(instance deader of View
	(properties
		x 46
		y 189
		view 572
		loop 1
	)
)

(instance deader1 of View
	(properties
		x 114
		y 86
		view 572
		loop 1
		cel 1
		scaleSignal 1
		scaleX 81
		scaleY 81
	)
)

(instance deader2 of View
	(properties
		x 257
		y 75
		view 572
		loop 1
		cel 2
		scaleSignal 1
		scaleX 110
		scaleY 110
	)
)

(instance deader3 of View
	(properties
		x 227
		y 172
		view 572
		loop 1
		cel 4
		scaleSignal 1
		scaleX 111
		scaleY 111
	)
)

(instance anubisStatue of Feature
	(properties
		x 193
		y 57
		noun 2
		nsTop 46
		nsLeft 174
		nsBottom 69
		nsRight 212
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gCast contains: opal)
					(gMessager say: 10 1) ; "You see a stone statue carved in the shape of Anubis."
				else
					(gMessager say: 1 6 4) ; "The statue of Anubis stands in disrepair. Someone has stolen the gems which once formed its eyes."
				)
			)
			(4 ; Do
				(if
					(and
						(== local0 1)
						(not (IsFlag 136))
						(not (gEgo has: 34)) ; theOpal
					)
					(gEgo setScript: hoarkOpal)
				)
			)
			(82 ; fetchSpell
				(if (not (gEgo has: 34)) ; theOpal
					(if (== local0 1)
						(gMessager say: 1 6 5) ; "You don't need a spell for that. Try using your hands."
					else
						(proc0_14 186 53)
						(gCurRoom setScript: (ScriptID 37 0) 0 anubisStatue) ; castFetchScript
					)
				)
			)
			(-82 ; fetchSpell
				(opal dispose:)
				(gEgo get: 34 solvePuzzle: 329 5 6) ; theOpal
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pedestal of Feature
	(properties
		x 168
		y 94
		noun 2
		nsTop 71
		nsLeft 150
		nsBottom 118
		nsRight 186
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local0 0)
					(gEgo setScript: climbUpPedestal)
				else
					(gEgo setScript: climbDownPedestal)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairs of Feature
	(properties
		x 233
		y 104
		noun 3
		nsTop 75
		nsLeft 215
		nsBottom 133
		nsRight 252
		sightAngle 180
	)
)

(instance leftStairs of Feature
	(properties
		x 73
		y 102
		noun 4
		nsTop 82
		nsLeft 53
		nsBottom 122
		nsRight 93
		sightAngle 180
	)
)

(instance ruins of Feature
	(properties
		x 123
		y 47
		noun 5
		nsTop 31
		nsLeft 87
		nsBottom 63
		nsRight 160
		sightAngle 180
	)
)

(instance rocks of Feature
	(properties
		x 43
		y 122
		noun 6
		nsTop 87
		nsLeft 3
		nsBottom 158
		nsRight 83
		sightAngle 180
	)
)

(instance noWayToGo of Feature
	(properties
		x 280
		y 151
		noun 7
		nsTop 114
		nsLeft 242
		nsBottom 189
		nsRight 319
		sightAngle 180
	)
)

(instance sFx of Sound
	(properties)
)

(instance fallChek of Code
	(properties)

	(method (doit)
		(if (or (gEgo inRect: 156 73 218 76) (< (gEgo x:) 156))
			(gEgo setScript: egoFalls)
		)
	)
)

(instance quikChek of Code
	(properties)

	(method (doit)
		(cond
			((gEgo inRect: 0 152 36 200)
				(gEgo setScript: cantExit)
			)
			((and (IsFlag 136) (gEgo inRect: 115 118 134 120))
				(= global365 575)
				(= global156 180)
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance anubisInset of Inset
	(properties
		view 810
		x 160
		y 135
		disposeNotOnMe 1
		noun 11
	)

	(method (dispose)
		(gEgo code: quikChek)
		(gTheIconBar enable: 6 1 5 3)
		(if (IsFlag 136)
			(opal dispose:)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(45 ; theOpal
				(gEgo drop: 34 solvePuzzle: 330 8) ; theOpal
				(opal view: 810 loop: 1 setPri: 14 x: 158 y: 83 init:)
				(Animate (gCast elements:) 1)
				(doorWay loop: 2 ignoreActors: 1 approachY: 110)
				(SetFlag 136)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

