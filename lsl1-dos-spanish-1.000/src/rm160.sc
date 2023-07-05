;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Language)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm160 0
)

(local
	lookedInTrash
	clickX
	clickY
	[FALLPATH 13] = [4 0 129 72 4 1 126 116 4 2 127 135 -32768]
	[DIE_PATH 37] = [0 0 197 66 0 1 201 68 0 2 206 74 0 3 194 77 0 4 192 75 0 5 196 70 1 0 223 67 1 1 217 71 1 2 224 71 -32768]
)

(procedure (FallAndDie)
	(HandsOff)
	(Print 160 63) ; "Smart move, Larry!"
	(sFallDie start: 3)
	(gEgo normal: 0 y: 66 view: 164 cycleSpeed: (+ gLarrySpeed 6) setScript: 0)
	(gTheMusic2 stop:)
	(gCurRoom setScript: sFallDie)
)

(instance rm160 of LLRoom
	(properties
		picture 160
		west 100
	)

	(method (init)
		(LoadMany rsSOUND 160 161 163 164 165)
		(LoadMany rsVIEW 160 161 162 164 812)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(if (!= gPrevRoomNum 150)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 62 171 58 162 41 162 30 136 58 0 319 0 319 189 0 189 0 186 254 186 225 160 191 160 197 171
						yourself:
					)
			)
		)
		(gEgo init: actions: egoActions)
		(gEHead actions: egoActions)
		(switch gPrevRoomNum
			(100
				(gEgo y: 167)
			)
			(110
				(HandsOff)
				(gEgo hide: normal: 0)
				(self style: 7 setScript: sComeTo)
			)
			(150
				(NormalEgo 2)
				(gEgo x: 162 y: 62 illegalBits: -32768)
			)
			(else
				(gEgo x: 160 y: 160)
			)
		)
		(super init:)
		(if
			(or
				(!= (gTheMusic2 number:) 800)
				(and
					(== (gTheMusic2 number:) 800)
					(or (== (gTheMusic2 signal:) -1) (< (gTheMusic2 vol:) 127))
				)
			)
			(gTheMusic2 number: 800 loop: -1 flags: 1 play: 127)
		)
		(cond
			((and (IsFlag 0) (ObjInRoom 15))
				(bottle init:)
			)
			((and (gEgo has: 16) (gEgo has: 14)) ; ribbon, hammer
				(Load rsSOUND 167)
			)
		)
		(eastWindow setCel: (and (IsFlag 0) 4) init:)
		(hotelSign cycleSpeed: 30 init: setCycle: Fwd)
		(if (IsFlag 16)
			(hookerWindow init:)
		)
		(binF init:)
		(balconyF init:)
		(hookerWindowF init:)
		(hotelSignF init:)
		(eastWindowF init:)
		(fenceF init:)
		(if (!= gPrevRoomNum 150)
			(fenceF approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
			(binF approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		)
		(lidF init:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((SteppedOn gEgo 2)
				(gCurRoom newRoom: 100)
			)
			((SteppedOn gEgo 4)
				(HandsOff)
				(gCurRoom setScript: sFall)
			)
			((gEgo mover:)
				(gEgo setScript: 0)
				(cond
					((== (gEgo view:) 161)
						(HandsOff)
						(binF approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
						(gCurRoom setScript: sClimbOut)
					)
					((and (== (gEgo view:) 162) (> (gEgo loop:) 1))
						(HandsOff)
						(gCurRoom setScript: sClimbBack)
					)
					((and (== (gEgo view:) 162) (== (gEgo loop:) 1))
						(HandsOff)
						(gCurRoom setScript: sUntieRailing)
					)
					((and (== (gEgo view:) 162) (== (gEgo loop:) 0))
						(HandsOff)
						(gCurRoom setScript: sUnTie)
					)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== ((gInventory at: 15) owner:) 160) ; pills
					(Print 160 0) ; "It's a nice little alley, with a trash bin, two windows, a fire escape, a fence, and whoa, look there! There's something sitting in that window to the right!"
				else
					(Print 160 1) ; "It's a nice little alley, with a trash bin, two windows, a fire escape and a fence."
				)
			)
			(4 ; Inventory
				(switch invItem
					(16 ; ribbon
						(Print 160 2) ; "It's not long enough to reach anywhere, but you might want to use it for safety purposes."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(class egoActions of Code
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(16 ; ribbon
						(cond
							((== (gEgo view:) 162)
								(Print 160 3) ; "You're already all tied up!"
							)
							((< (gEgo y:) 100)
								(HandsOff)
								(gCurRoom setScript: sTie)
							)
						)
					)
					(11 ; pocketKnife
						(cond
							(
								(and
									(== (gEgo view:) 162)
									(> (gEgo loop:) 1)
								)
								(FallAndDie)
							)
							(
								(and
									(== (gEgo view:) 162)
									(== (gEgo loop:) 1)
								)
								(HandsOff)
								(gCurRoom setScript: sUntieRailing)
								(return 1)
							)
							(
								(and
									(== (gEgo view:) 162)
									(== (gEgo loop:) 0)
								)
								(HandsOff)
								(gCurRoom setScript: sUnTie)
								(return 1)
							)
						)
					)
				)
			)
			(3 ; Do
				(if (and (== (gEgo view:) 162) (== (gEgo loop:) 0))
					(HandsOff)
					(gCurRoom setScript: sUnTie)
					(return 1)
				)
			)
		)
	)
)

(instance sFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed: (+ gLarrySpeed gHowFast)
					normal: 0
					view: 164
					setLoop: 4
					setCel: 0
					setCycle: MCyc @FALLPATH self
					illegalBits: 0
					setPri: (gEgo priority:)
				)
				(gTheMusic3 number: 160 setVol: 127 play:)
			)
			(1
				(gEgo hide: setPri: -1)
				(gTheMusic3 number: 161 play:)
				(gCurRoom
					setScript: sComeTo
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 62 171 58 162 41 162 30 136 58 0 319 0 319 189 0 189 0 186 254 186 225 160 191 160 197 171
							yourself:
						)
				)
			)
		)
	)
)

(instance sToHooker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 162 62 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gTheMusic2 fade:)
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance sUntieRailing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo setLoop: 0 setCel: 255)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sUnTie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					view: 800
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 174 67 self
				)
			)
			(2
				(gTheMusic fade:)
				(NormalEgo 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sClimbOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= clickX ((User curEvent:) x:))
				(= clickY ((User curEvent:) y:))
				(gEgo view: 161 setLoop: 1 setCel: 1 hide:)
				(= cycles 1)
			)
			(1
				(gEgo egoSpeed: (* 2 gLarrySpeed) show: setCycle: Beg self)
				(gTheMusic3 number: 161 play:)
			)
			(2
				(gEgo view: 161 z: 0 setLoop: 0 setCel: 3 setCycle: Beg self)
			)
			(3
				(gTheMusic3 number: 163 play:)
				(binF approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
				(gEgo normal: 1)
				(NormalEgo 3)
				(HandsOn)
				(if
					(and
						(IsObject (CueObj client:))
						((CueObj client:) approachX:)
						(!= (CueObj client:) binF)
					)
					(gEgo
						setMotion:
							PolyPath
							((CueObj client:) approachX:)
							(+ (gEgo z:) ((CueObj client:) approachY:))
							CueObj
					)
				else
					(gEgo setMotion: PolyPath clickX clickY)
				)
				(self dispose:)
			)
		)
	)
)

(instance sComeTo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Print 160 4) ; "Hey! Where are you?"
				(= seconds 3)
			)
			(2
				(Print 160 5) ; "After a careful analysis of your surroundings, you conclude you are at the bottom of a pile of garbage!"
				(= seconds 3)
			)
			(3
				(gEgo
					show:
					view: 161
					loop: 1
					cel: 2
					x: 117
					y: 171
					z: 34
					yStep: 2
					cycleSpeed: (+ gLarrySpeed 4)
					setCycle: Beg self
					setPri: -1
				)
			)
			(4
				(Print 160 6) ; "YUCK!!"
				(binF approachVerbs: 0)
				(fenceF approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sJumpIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 160 7) ; "Willing to do anything to further tonight's goal, you dive into the dirty dumpster."
				(binF approachVerbs: 0)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: (* gLarrySpeed 2)
					setCycle: CT 2 1 self
				)
			)
			(2
				(gTheMusic3 number: 161 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo z: 34 setLoop: 1 setCel: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetHammer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: setCel: 0 setLoop: 1 setCycle: End self)
			)
			(1
				(gEgo get: 14) ; hammer
				(Points 67 3)
				(= cycles 10)
			)
			(2
				(Print 160 8) ; "Digging past innumerable limp celery stalks from this morning's bloody marys, you find Lefty's hammer, wipe it off as much as you can, and stuff it into your pants pocket."
				(gEgo loop: 1 cel: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sTie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 185 61 self)
			)
			(1
				(Print 160 9) ; "You carefully tie the ribbon from your "nuptial bed" around your waist."
				(gEgo
					view: 162
					setLoop: 0
					setCel: 0
					cycleSpeed: (+ gLarrySpeed 6)
					setCycle: End self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sTieToRail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(Print 160 10) ; "You carefully tie the ribbon from your "nuptial bed" around the railing."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sJumpRail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic number: 165 loop: -1 vol: 127 flags: 1 play:)
				(gEgo
					egoSpeed:
					setLoop: 2
					setCel: 0
					posn: 198 64
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 3 setCel: 0 posn: 226 60 setCycle: End self)
			)
			(2
				(Print 160 11) ; "With the coy pink ribbon rather insecurely holding you to the railing, you can reach all the way over to the window."
				(if (ObjInRoom 15)
					(Print 160 12) ; "NOW, of all times, you notice the window's locked!"
				)
				(gEgo setScript: sWiggle)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sClimbBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed:
					setScript: 0
					posn: 230 63
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo posn: 197 63 setLoop: 6 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo x: 185 y: 61 setLoop: 1 setCel: 255)
				(gTheMusic fade:)
				(= cycles 1)
			)
			(3
				(Print 160 13) ; "Whew! You're glad to be back to the relative safety of the fire escape!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sSmashWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 160 14) ; "Subtly, you smash the window with your left-handed hammer in your right hand. Your fears were unfounded; it seems to work either way. Your future as a second-story man now seems quite plausible!"
				(gEgo
					egoSpeed:
					setScript: 0
					setLoop: 4
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gTheMusic3 number: 167 play:)
				(eastWindow setCycle: End eastWindow)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo setLoop: 3 setCel: 255)
				(= cycles 1)
			)
			(3
				(gEgo setScript: sWiggle)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFallDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: MoveTo 187 66 self)
			)
			(1
				(gEgo
					normal: 0
					view: 164
					setLoop: 0
					setCel: 0
					egoSpeed: (+ 1 gLarrySpeed)
					setCycle: MCyc @DIE_PATH self
				)
			)
			(2
				(Print 160 15) ; "You lean far out over the railing before remembering that agility is yet another of your short suits!"
				(= cycles 1)
			)
			(3
				(gTheMusic loop: 1 setVol: 127 number: 160 play:)
				(gEgo
					setLoop: 2
					setCel: 0
					x: 222
					setStep: 3 6
					setCycle: End self
					setMotion: MoveTo (gEgo x:) 145 self
				)
			)
			(4)
			(5
				(gTheMusic number: 164 play:)
				(gEgo
					setLoop: 3
					setCel: 0
					cycleSpeed: gLarrySpeed
					x: 219
					y: 167
					setCycle: End self
				)
			)
			(6
				(= seconds 3)
			)
			(7
				(Print 160 16) ; "Hey, guys!! He's screwed up again! Dump this body down the tubes, and get him another one!"
				(= seconds 3)
			)
			(8
				(gTheMusic2 number: 192 setLoop: -1 flags: 1 play:)
				(gTheMusic3 number: 191 setLoop: 1 setVol: 127 flags: 1 play:)
				(gEgo
					view: 812
					setLoop: 1
					setCel: 0
					cycleSpeed: (* gLarrySpeed 2)
					setCycle: End self
				)
			)
			(9
				(gCurRoom newRoom: 190)
			)
		)
	)
)

(instance sGetPills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo get: 15) ; pills
				(Points 73 8)
				(= cycles 1)
			)
			(1
				(Print 160 17) ; "You got 'em! But what in the heck are they?"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sWiggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(gEgo egoSpeed: setLoop: 7 setCycle: Fwd)
				(= seconds (Random 1 2))
			)
			(2
				(gEgo setLoop: 3 setCel: 255 setCycle: 0)
				(self init:)
			)
		)
	)
)

(instance eastWindow of Prop
	(properties
		x 259
		y 39
		description {the east window}
		view 160
		loop 3
	)

	(method (cue)
		(super cue:)
		(bottle init:)
	)

	(method (doVerb theVerb invItem)
		(eastWindowF doVerb: theVerb invItem)
	)
)

(instance hotelSign of Prop
	(properties
		x 15
		y 100
		z 100
		description {the hotel sign}
		sightAngle 40
		view 160
		loop 1
		priority 10
		signal 16
	)

	(method (cue)
		(super cue:)
		(Print 160 18) ; "There is an old neon sign hanging on the wall that says "Hotel"..."
		(Print 160 19) ; "...approximately."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) (self x:) (self y:))
						self
				)
			)
			(3 ; Do
				(Print 160 20) ; "That's all you need: electricity coursing through your hand!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bottle of View
	(properties
		view 160
		priority 12
		signal 16
	)

	(method (init)
		(super init:)
		(self x: (eastWindow x:))
		(self y: (eastWindow y:))
	)
)

(instance hookerWindow of View
	(properties
		x 174
		y 23
		description {the west window}
		sightAngle 40
		view 160
		loop 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(hookerWindowF doVerb: theVerb invItem)
	)
)

(instance binF of Feature
	(properties
		x 122
		y 149
		nsTop 131
		nsLeft 74
		nsBottom 168
		nsRight 170
		description {the dumpster}
		sightAngle 40
		approachX 117
		approachY 171
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== (gEgo view:) 161)
					(if (not (gEgo has: 14)) ; hammer
						(= lookedInTrash 1)
						(Print 160 21) ; "Amidst assorted, odoriferous refuse from Lefty's clientele, you discover Lefty's old, left-handed hammer lying in the bottom of the dumpster, covered with trash."
					else
						(Print 160 22) ; "There's nothing else here worth describing, let alone taking."
					)
				else
					(Print 160 23) ; "Unfortunately, you can't see much from out here."
				)
			)
			(3 ; Do
				(cond
					((< (gEgo y:) 100)
						(Print 160 24) ; "You reconsider after noticing the trash bin is behind where you would fall!"
					)
					((not (== (gEgo view:) 161))
						(HandsOff)
						(gCurRoom setScript: sJumpIn)
					)
					((gEgo has: 14) ; hammer
						(Print 160 22) ; "There's nothing else here worth describing, let alone taking."
					)
					((not lookedInTrash)
						(= lookedInTrash 1)
						(Print 160 21) ; "Amidst assorted, odoriferous refuse from Lefty's clientele, you discover Lefty's old, left-handed hammer lying in the bottom of the dumpster, covered with trash."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sGetHammer)
					)
				)
			)
			(4 ; Inventory
				(if (< (gEgo y:) 100)
					(Print 160 25) ; "You'd never hit the dumpster from here. You can't even hit the barn side of a broad!"
				else
					(switch invItem
						(14 ; hammer
							(Print 160 26) ; "That's not the sort of banging you were hoping for tonight!"
						)
						(1 ; breathSpray
							(Print 160 27) ; "Now the dumpster smells like garbage in the North Woods!"
						)
						(0 ; wallet
							(Print 160 28) ; "As much as you love money, you can't bear the thought of throwing it away!"
						)
						(8 ; lubber
							(gEgo put: invItem 0)
							(if (IsFlag 43)
								(ClearFlag 43)
								(Points 87 1)
								(Print 160 29) ; "Good idea, you properly dispose of your "lubber." You're mother would be proud."
							else
								(Print 160 30) ; ""I'll probably never use one of these things anyway," you shout, tossing it into the dumpster."
								(gEgo put: invItem 0)
							)
						)
						(else
							(if (IsObject (Inv at: invItem))
								(gEgo put: invItem 0)
								(if 1
									(= global314
										(Memory
											memALLOC_CRIT
											(StrLen
												((Inv at: invItem) description:)
											)
										)
									)
									(= global323
										(Memory
											memALLOC_CRIT
											(StrLen
												((Inv at: invItem) description:)
											)
										)
									)
									(StrSplitInTwo
										global314
										global323
										((Inv at: invItem) description:)
									)
									(Printf 160 31 global314 global323) ; "Believing %s will be of no further use, you toss it into the dumpster, never to be seen again!"
									(Memory memFREE global314)
									(Memory memFREE global323)
								)
							else
								(Print 160 32) ; "You cleverly take nothing, and throw nothing away."
							)
						)
					)
				)
			)
			(11 ; Taste/Smell
				(Print 160 6) ; "YUCK!!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance balconyF of Feature
	(properties
		x 147
		y 77
		z 17
		nsTop 46
		nsLeft 94
		nsBottom 80
		nsRight 201
		description {the fire escape}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(if (and (< (gEgo y:) 100) (== theVerb 2)) ; Look
			(Print 160 33) ; "You are on a fire escape. A rusty ladder is at one end. To the right of the fire escape another window waits, just barely out of your reach."
		else
			(switch theVerb
				(2 ; Look
					(Print 160 34) ; "A rickety fire escape, complete with safety ladder, is loosely attached to the building. A mild yellow glow comes from the window behind it."
				)
				(3 ; Do
					(cond
						((and (== (gEgo view:) 162) (> (gEgo loop:) 1))
							(HandsOff)
							(gEgo setScript: 0)
							(gCurRoom setScript: sClimbBack)
						)
						((and (== (gEgo view:) 162) (== (gEgo loop:) 1))
							(HandsOff)
							(gCurRoom setScript: sUntieRailing)
						)
						((< (gEgo y:) 100)
							(Print 160 35) ; "Try moving to the west end of the fire escape."
						)
						(else
							(Print 160 36) ; "There's no way to reach the ladder from down here. It's only accessible from above."
						)
					)
				)
				(4 ; Inventory
					(switch invItem
						(16 ; ribbon
							(cond
								(
									(and
										(== (gEgo view:) 162)
										(== (gEgo loop:) 1)
									)
									(Print 160 37) ; "You already ARE tied to the railing."
								)
								(
									(and
										(== (gEgo view:) 162)
										(== (gEgo loop:) 0)
									)
									(HandsOff)
									(gCurRoom setScript: sTieToRail)
								)
								(
									(and
										(== (gEgo view:) 162)
										(> (gEgo loop:) 1)
									)
									(Print 160 38) ; "You'll be better off if you leave the ribbon exactly where it is."
								)
								((< (gEgo y:) 100)
									(Print 160 39) ; "Good idea. But first, tie the ribbon to yourself."
								)
								(else
									(Print 160 40) ; "It's not long enough to reach from here."
									(Print 160 41 #at -1 140) ; "(Of course, you've heard THAT line before!)"
								)
							)
						)
						(11 ; pocketKnife
							(cond
								(
									(and
										(== (gEgo view:) 162)
										(== (gEgo loop:) 0)
									)
									(HandsOff)
									(gCurRoom setScript: sUnTie)
								)
								(
									(and
										(== (gEgo view:) 162)
										(== (gEgo loop:) 1)
									)
									(HandsOff)
									(gCurRoom setScript: sUntieRailing)
								)
								(
									(and
										(== (gEgo view:) 162)
										(> (gEgo loop:) 1)
									)
									(FallAndDie)
								)
								(else
									(super doVerb: theVerb invItem &rest)
								)
							)
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance hookerWindowF of Feature
	(properties
		x 162
		y 50
		nsTop 1
		nsLeft 142
		nsBottom 43
		nsRight 183
		description {the west window}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (< (gEgo y:) 100)
					(Print 160 42) ; "Looking inside the left window, you see the room you just left."
				else
					(Print 160 43) ; "There are two windows high above you. The left window near the fire escape has a dim yellow glow; the other window is dark. There may be something on the sill of the dark window, but you can't quite make it out from way down here."
				)
			)
			(3 ; Do
				(if (< (gEgo y:) 100)
					(if
						(or
							(and
								(== (gEgo view:) 162)
								(== (gEgo loop:) 1)
							)
							(and (== (gEgo view:) 162) (> (gEgo loop:) 1))
							(and
								(== (gEgo view:) 162)
								(== (gEgo loop:) 0)
							)
						)
						(Print 160 44) ; "You're currently all tied up!"
					else
						(HandsOff)
						(gCurRoom setScript: sToHooker)
					)
				else
					(Print 160 45) ; "There's just no way to reach the windows from here. They're only accessible from above."
				)
			)
			(4 ; Inventory
				(switch invItem
					(14 ; hammer
						(if (< (gEgo y:) 100)
							(Print 160 46) ; "The window is already open. There's no use in breaking it!"
						else
							(Print 160 47) ; "There's no use throwing the hammer up there."
							(Print 160 48 #at -1 140) ; "(Besides, you probably just miss the window any way!)"
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hotelSignF of Feature
	(properties
		x 19
		y 157
		z 121
		nsTop 1
		nsBottom 72
		nsRight 39
		description {the hotel sign}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(hotelSign doVerb: theVerb invItem)
	)
)

(instance eastWindowF of Feature
	(properties
		x 264
		y 157
		z 131
		nsTop 6
		nsLeft 244
		nsBottom 47
		nsRight 284
		description {the east window}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (< (gEgo y:) 100)
					(if (ObjInRoom 15)
						(if (and (== (gEgo view:) 162) (> (gEgo loop:) 1))
							(Print 160 49) ; "Looking at the dark window, you notice a bottle of pills sitting on the window ledge."
						else
							(Print 160 50) ; "There may be something in the east window, but from here, you're not sure."
						)
					else
						(Print 160 51) ; "You broke it, didn't you?"
					)
				else
					(hookerWindowF doVerb: theVerb invItem)
				)
			)
			(3 ; Do
				(cond
					((not (< (gEgo y:) 100))
						(Print 160 52) ; "There's no way to reach the window from here."
					)
					((or (!= (gEgo view:) 162) (== (gEgo loop:) 0))
						(HandsOff)
						(gCurRoom setScript: sFallDie)
					)
					((== (gEgo loop:) 1)
						(HandsOff)
						(gCurRoom setScript: sJumpRail)
					)
					((not (IsFlag 0))
						(Print 160 53) ; "You consider sticking your hand through a solid glass window, but realize that if you did, you wouldn't be able to play the violin."
						(Print 160 54 #at -1 140) ; "(Of course, you can't play the violin now, but you get the idea.)"
					)
					((!= ((gInventory at: 15) owner:) 160) ; pills
						(Print 160 55) ; "You already took the pills. Why go through all this again?"
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sGetPills)
						(bottle z: 1000 dispose:)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(14 ; hammer
						(if (and (== (gEgo view:) 162) (> (gEgo loop:) 1))
							(if (IsFlag 0)
								(Print 160 56) ; "You already smashed the window. Why do it again?"
							else
								(SetFlag 0)
								(HandsOff)
								(gCurRoom setScript: sSmashWindow)
							)
						else
							(Print 160 57) ; "You might try reaching over to the window first."
						)
					)
					(11 ; pocketKnife
						(Print 160 58) ; "You could never pry that window open with your pocket knife."
					)
					(4 ; ring
						(Print 160 59) ; "That's an idea; it's just not a good idea!"
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fenceF of Feature
	(properties
		x 275
		y 143
		nsTop 104
		nsLeft 233
		nsBottom 182
		nsRight 318
		description {the fence}
		sightAngle 40
		approachX 237
		approachY 172
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 160 60) ; "You see alleys stretching off to infinity."
			)
			(3 ; Do
				(Print 160 61) ; "The fence is much too tall for you to climb over."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lidF of Feature
	(properties
		x 124
		y 160
		z 45
		nsTop 101
		nsLeft 84
		nsBottom 130
		nsRight 165
		description {the lid}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 160 62) ; "Unfortunately the lid on the trash bin just will not close."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

