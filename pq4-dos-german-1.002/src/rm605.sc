;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 605)
(include sci.sh)
(use Main)
(use ExitArrow)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm605 0
	mitchTalker 1
)

(local
	local0
	local1
	local2
)

(instance rm605 of Room
	(properties
		noun 8
		picture 605
	)

	(method (init)
		(proc0_4 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 26 167 302 167 302 132 282 132 198 113 173 115 216 133 102 147 53 128 21 128 16 150
					yourself:
				)
		)
		(gEgo view: 0)
		(super init: &rest)
		(switch gPrevRoomNum
			(610
				(gEgo posn: 78 144 setHeading: 135)
				(if (and (= gDay 5) (not (gPqFlags test: 101)))
					(timerScript init:)
				)
			)
			(else
				(gEgo posn: 200 139 setHeading: 315)
			)
		)
		(gEgo
			setTalker: careyTalker
			setScaler: Scaler 123 90 152 115
			init:
			normalize: 0
		)
		(if (gPqFlags test: 169)
			(mitchell
				init:
				signal: (| (mitchell signal:) $4000)
				approachVerbs: 4 2 27 20 ; Do, Talk, badge, wallet
			)
		)
		(lDoor init: approachVerbs: 4) ; Do
		(rDoor init: approachVerbs: 4) ; Do
		(lPrograms init: approachVerbs: 1 4) ; Look, Do
		(rPrograms init: approachVerbs: 1 4) ; Look, Do
		(booth init: approachVerbs: 4) ; Do
		(rightWindow init: approachVerbs: 38 4 17 47 22 1 28 52 63) ; caseChalk, Do, glue, handcuffs, handgun, Look, newspaper, notebook, casePryBar
		(soundScript init:)
		(if
			(and
				(not (gPqFlags test: 101))
				(not (== gPrevRoomNum 610))
				(> gDay 4)
			)
			(mitchell
				init:
				signal: (| (mitchell signal:) $4000)
				approachVerbs: 4 2 27 20 ; Do, Talk, badge, wallet
			)
		)
		(toStreet init:)
		(toRight init:)
		(toLeft init:)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((> (gEgo y:) 148)
				(gCurRoom newRoom: 600)
			)
			((gEgo inRect: 0 148 31 153)
				(= global158 1)
				(gCurRoom newRoom: 600)
			)
			((gEgo inRect: 298 131 309 153)
				(= global158 2)
				(gCurRoom newRoom: 600)
			)
			((not (gCast contains: mitchell)) 0)
			(
				(and
					(not local2)
					(gPqFlags test: 169)
					(gEgo inRect: 152 132 170 153)
				)
				(if (not (CueObj client:))
					(self setScript: sitUpScript)
				)
				(= local2 1)
			)
			((and local2 (not (gEgo inRect: 152 132 170 153)))
				(= local2 0)
				(mitchell setCycle: Beg)
			)
		)
	)

	(method (dispose)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance timerScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 0)
				(= seconds 20)
			)
			(1
				(= local1 1)
				(self dispose:)
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (init)
		(gTheDoits add: self)
		(= state -1)
		(self cue:)
	)

	(method (cue)
		(self changeState: (+ state 1))
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(switch (Random 1 3)
						(1 905)
						(2 906)
						(3 907)
					)
				)
				(gGlobalSound0 number: temp0 setLoop: 1 play: self)
			)
			(1
				0
				(= state -1)
				(= seconds (Random 5 60))
			)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
	)
)

(instance sitUpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gEgo inRect: 142 132 164 153)
					(gEgo setHeading: 315 self)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (mitchell cel:)
					(self cue:)
				else
					(mitchell setCel: 0 setCycle: End self)
				)
			)
			(3
				(if (gEgo inRect: 142 132 164 153)
					(gMessager say: 5 3 0 0 self) ; "Good a... af... afternoon. Ma... may I help you?"
				else
					(gMessager say: 5 0 13 0 self) ; "We... welcome to... to the Third Eye Theater. Ma... may I he... help you?"
				)
			)
			(4
				(if (not register)
					(gGame handsOn:)
				else
					(= register 0)
				)
				(if (gEgo inRect: 142 132 164 153)
					(self cue:)
				else
					(= ticks 120)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance intoTheaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 0)
					(gEgo setMotion: PolyPath 189 113 self)
				else
					(gEgo setMotion: PolyPath 75 141 self)
				)
			)
			(1
				(if (== register 0)
					(gMessager say: 5 0 12 0 self) ; "Of... ficer, to... to your le... le... left!"
				else
					(gGlobalSound0 stop:)
					(gGlobalSound1 fade: 0 1 5 1 self)
					(gCurRoom newRoom: 610)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance booth of Feature
	(properties
		noun 3
		nsLeft 65
		nsTop 14
		nsRight 184
		nsBottom 130
		sightAngle 90
		approachX 168
		approachY 140
		approachDist 20
		x 154
		y 67
		z 60
	)
)

(instance mitchell of Prop
	(properties
		noun 5
		approachX 168
		approachY 140
		approachDist 20
		x 147
		y 79
		view 607
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; wallet
				(if (gPqFlags test: 102)
					(gMessager say: 5 20 14 0) ; "Ooh, nn... no! Pl... please ca... come in. E... enter to... to the left."
				else
					(gMessager say: 5 0 13 0) ; "We... welcome to... to the Third Eye Theater. Ma... may I he... help you?"
				)
			)
			(29 ; coins
				(if (gPqFlags test: 102)
					(gMessager say: 5 20 14 0) ; "Ooh, nn... no! Pl... please ca... come in. E... enter to... to the left."
				else
					(gMessager say: 5 0 13 0) ; "We... welcome to... to the Third Eye Theater. Ma... may I he... help you?"
				)
			)
			(27 ; badge
				(if (gPqPointFlags test: 31)
					(gMessager say: 5 27 3 0) ; "You have already identified yourself, no need to do so again."
				else
					(gGame points: 2 31)
					(gCurRoom setScript: showBadge)
				)
			)
			(2 ; Talk
				(if (== global136 1)
					(= global136 2)
					(gMessager say: 5 2 19 0 self) ; "What movie are you showing?"
				else
					(gCurRoom setScript: talkScript)
				)
			)
			(22 ; handgun
				(if local0
					(gCurRoom setScript: shootScript)
				else
					(= local0 1)
					(gMessager say: 5 22 21 0) ; "Ooohhh Mother!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shootScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 32 0) doit: 5 22 22 605) ; ShootHandgun
			)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (mitchell cel:))
					(= local2 1)
					(self setScript: sitUpScript self 1)
				else
					(= cycles 2)
				)
			)
			(1
				(cond
					(
						(and
							(gPqPointFlags test: 31)
							(== ((gInventory at: 22) state:) 1) ; folders
							(gPqFlags test: 102)
						)
						(gMessager say: 5 2 23 2 self) ; "Yes, pl... please come in. En... ter to the left."
					)
					(
						(and
							(gPqPointFlags test: 31)
							(== ((gInventory at: 22) state:) 1) ; folders
							(not (gPqFlags test: 102))
						)
						(gPqFlags set: 102)
						(gMessager say: 5 2 23 0 self) ; "I'd like to ask you a few questions."
					)
					((gPqPointFlags test: 31)
						(gMessager say: 5 2 (if global134 11 else 5) 0 self)
						(gPqFlags set: 102)
						(= global134 1)
					)
					((not (gPqPointFlags test: 31))
						(gMessager
							say:
								5
								2
								(switch global133
									(0 6)
									(1 7)
									(2 8)
									(3 9)
									(else 10)
								)
								0
								self
						)
						(++ global133)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (mitchell cel:))
					(= local2 1)
					(self setScript: sitUpScript self 1)
				else
					(= cycles 2)
				)
			)
			(1
				((ScriptID 38 0) init: self) ; BadgeOut
			)
			(2
				(gMessager say: 5 27 0 1 self) ; "Dectective Carey, LAPD."
			)
			(3
				((ScriptID 38 1) init: self) ; BadgeIn
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager
					say:
						5
						27
						(if (== ((gInventory at: 22) state:) 1) 23 else 24) ; folders
						0
						self
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance altEgo of Actor
	(properties)
)

(instance reachScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 300 self)
			)
			(1
				(gPqFlags set: 104)
				(altEgo
					setScaler: gEgo
					view: 9032
					loop: 1
					cel: 0
					x: (gEgo x:)
					y: (gEgo y:)
					init:
					setCycle: End self
				)
				(gEgo z: 1000)
			)
			(2
				(gPqFlags set: 104)
				(= global136 1)
				(gMessager say: 6 4 16 0 self) ; "Th... those are... are very old. Ma... ay I an... answer a ques... question?"
			)
			(3
				(altEgo setCycle: Beg self)
			)
			(4
				(gEgo z: 0)
				(altEgo dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lPrograms of Feature
	(properties
		noun 6
		nsLeft 126
		nsTop 63
		nsRight 141
		nsBottom 89
		sightAngle 40
		approachX 158
		approachY 146
		x 133
		y 80
	)

	(method (doVerb theVerb)
		(if (< gDay 5)
			(gMessager say: 6 0 20 0) ; "The date on these reads March 4, 1989. They're old, they won't"
		else
			(switch theVerb
				(1 ; Look
					(if (gCast contains: mitchell)
						(if (not global136)
							(gMessager say: 6 1 16 0) ; "Weather-worn movie programs. They look like they've"
						else
							(gMessager say: 5 2 19 0) ; "What movie are you showing?"
						)
					else
						(gMessager say: 6 0 20 0) ; "The date on these reads March 4, 1989. They're old, they won't"
					)
				)
				(4 ; Do
					(if (gCast contains: mitchell)
						(gCurRoom setScript: reachScript 0 0)
					else
						(gMessager say: 6 0 20 0) ; "The date on these reads March 4, 1989. They're old, they won't"
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance rPrograms of Feature
	(properties
		noun 6
		nsLeft 175
		nsTop 62
		nsRight 188
		nsBottom 87
		sightAngle 40
		approachX 201
		approachY 137
		approachDist 10
		x 181
		y 124
	)

	(method (doVerb theVerb)
		(if (< gDay 5)
			(gMessager say: 6 0 20 0) ; "The date on these reads March 4, 1989. They're old, they won't"
		else
			(switch theVerb
				(1 ; Look
					(if (gCast contains: mitchell)
						(if (not global136)
							(gMessager say: 6 1 16 0) ; "Weather-worn movie programs. They look like they've"
						else
							(gMessager say: 5 2 19 0) ; "What movie are you showing?"
						)
					else
						(gMessager say: 6 0 20 0) ; "The date on these reads March 4, 1989. They're old, they won't"
					)
				)
				(4 ; Do
					(if (gCast contains: mitchell)
						(gCurRoom setScript: reachScript 0 0)
					else
						(gMessager say: 6 0 20 0) ; "The date on these reads March 4, 1989. They're old, they won't"
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance lDoor of Feature
	(properties
		noun 1
		nsLeft 8
		nsTop 20
		nsRight 64
		nsBottom 119
		sightAngle 90
		approachX 54
		approachY 132
		x 37
		y 96
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((timerScript seconds:)
						(gCurRoom setScript: knockScr 0 1)
					)
					((or local1 (gPqFlags test: 101) (< gDay 5))
						(gCurRoom setScript: knockScr)
					)
					((gPqFlags test: 102)
						(if (gEgo inRect: 0 105 121 140)
							(gCurRoom newRoom: 610)
						else
							(gCurRoom setScript: intoTheaterScript 0 1)
						)
					)
					((and (gCast contains: mitchell) (> gDay 4))
						(gMessager say: 5 0 13 0) ; "We... welcome to... to the Third Eye Theater. Ma... may I he... help you?"
					)
					(else
						(gCurRoom setScript: knockScr)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rDoor of Feature
	(properties
		noun 4
		nsLeft 181
		nsTop 29
		nsRight 199
		nsBottom 108
		sightAngle 90
		approachX 192
		approachY 112
		x 189
		y 60
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((or (gPqFlags test: 101) (< gDay 5))
						(gMessager say: 0 4 4 0) ; "The theater is closed, the doors are locked."
					)
					((and (gCast contains: mitchell) (gPqFlags test: 102))
						(gCurRoom setScript: intoTheaterScript 0 0)
					)
					((and (gCast contains: mitchell) (> gDay 4))
						(= local2 1)
						(gCurRoom setScript: sitUpScript)
					)
					(else
						(gMessager say: 0 4 4 0) ; "The theater is closed, the doors are locked."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance careyTalker of Narrator
	(properties
		x 130
		y 10
	)
)

(instance mitchTalker of Narrator
	(properties
		x 10
		y 10
	)
)

(instance rightWindow of Feature
	(properties
		noun 7
		nsLeft 226
		nsTop 24
		nsRight 279
		nsBottom 94
		sightAngle 40
		approachX 239
		approachY 127
		approachDist 10
		x 252
		y 59
	)
)

(instance knockSnd of Sound
	(properties
		number 980
	)
)

(instance knockScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (OneOf state 2 3) (OneOf (altEgo cel:) 6 8 10))
			(knockSnd play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo z: 1000)
				(altEgo
					view: 9009
					setScaler: Scaler 123 90 152 115
					setLoop: 0
					cel: 0
					x: (- (gEgo x:) 3)
					y: (+ (gEgo y:) 1)
					init:
					setCycle: End self
				)
			)
			(3
				(altEgo setCycle: Beg self)
			)
			(4
				(altEgo dispose:)
				(gEgo z: 0)
				(= cycles 2)
			)
			(5
				(cond
					(register
						(gCurRoom newRoom: 610)
					)
					(
						(and
							(== gPrevRoomNum 610)
							(or local1 (gPqFlags test: 101) (< gDay 5))
						)
						(gMessager say: 0 4 4 0 self) ; "The theater is closed, the doors are locked."
					)
					((or local1 (gPqFlags test: 101) (< gDay 5))
						(gMessager say: 0 4 4 0 self) ; "The theater is closed, the doors are locked."
					)
					(else
						(gCurRoom newRoom: 610)
					)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toRight of ExitArrow
	(properties
		nsTop 131
		nsLeft 280
		nsBottom 165
		nsRight 319
		exitDir 2
	)
)

(instance toLeft of ExitArrow
	(properties
		nsTop 143
		nsBottom 165
		nsRight 31
		exitDir 4
	)
)

(instance toStreet of ExitArrow
	(properties
		nsTop 148
		nsLeft 32
		nsBottom 165
		nsRight 279
		exitDir 3
	)
)

