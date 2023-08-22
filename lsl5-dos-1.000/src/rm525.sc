;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 525)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm525 0
)

(local
	clickX
	clickY
)

(instance rm525 of LLRoom
	(properties
		picture 525
		east 530
		south 510
	)

	(method (init)
		(LoadMany rsVIEW 525 527 510 526)
		(Load rsSOUND 526)
		(gEgo normalize:)
		(daDoor init: approachVerbs: 3) ; Do
		(door init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 235 189 252 166 229 155 193 166 166 155 122 170 114 164 96 177 64 189 0 189
					yourself:
				)
		)
		(switch gPrevRoomNum
			(520
				(gEgo posn: 210 161 init:)
				(if (> ((Inv at: 14) state:) 1) ; Membership_Tape
					(HandsOff)
					(gCurRoom setScript: sToHollerith)
				else
					(HandsOn)
				)
			)
			(east
				(HandsOn)
				(gEgo posn: 238 162 setHeading: 270 edgeHit: EDGE_NONE)
			)
			(else
				(= gLarryLoc 1)
				(gEgo posn: 146 237 setHeading: 45 get: 14 init:) ; Membership_Tape
				(gCurRoom setScript: sEnter)
			)
		)
		(super init:)
		(fatLady init: setScript: sFatLadyEating)
		(tapeReader init: approachVerbs: 3 4) ; Do, Inventory
		(cactus init:)
		(tables init:)
		(SprattFamilyTable init:)
		(larryTable init: approachVerbs: 3) ; Do
		(baldMan init:)
		(man1 init:)
		(man2 init:)
		(man3 init:)
		(woman1 init:)
		(gAddToPics doit:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 530)
			(gTheMusic fade:)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			(
				(and
					(== (gEgo view:) 526)
					(gEgo mover:)
					(User canControl:)
					(User canInput:)
				)
				(= clickX ((User curEvent:) x:))
				(= clickY ((User curEvent:) y:))
				(HandsOff)
				(gCurRoom setScript: sStandUp)
			)
			((StepOn gEgo 4)
				(HandsOff)
				(self setScript: sExitSouth)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (!= (gEgo view:) 526)
					(TPrint 525 0) ; "At last you are inside the "Hard Disk Cafe's" cafe. But where in the world is YOUR seat?"
				else
					(TPrint 525 1) ; "You could sit like this and watch people all day. In fact, you may have to, as there seems to be an extreme shortage of waiters in this place. No wonder there's no crowd!"
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance sToHollerith of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 123)
			)
			(1
				(gEgo
					setMotion: PolyPath (door approachX:) (door approachY:) self
				)
			)
			(2
				((gCurRoom obstacles:) dispose:)
				(= cycles 2)
			)
			(3
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 117 167 117 179 98 179 98 167
							yourself:
						)
				)
				(door locked: 0 doVerb: 3)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 196 185 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sMichelle of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(michelle setCycle: Fwd setMotion: MoveTo 190 191 self)
			)
			(1
				(Points 3)
				(TPrint 525 2) ; "Look, Larry! There she is!! It's your "target" for New York City: Michelle Milken."
				(michelle setMotion: MoveTo 216 163 self)
			)
			(2
				(michelle setLoop: 1 posn: 207 162 setCel: 0 setCycle: End self)
			)
			(3
				(screen init: setCycle: Fwd)
				(= seconds (Random 3 6))
			)
			(4
				(michelle setCycle: Beg self illegalBits: 0 ignoreActors: 1)
			)
			(5
				(screen dispose:)
				(michelle
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 242 164 self
				)
			)
			(6
				(door setCycle: End self)
			)
			(7
				(michelle setMotion: MoveTo 308 144 self)
			)
			(8
				(door setCycle: Beg self)
			)
			(9
				(door stopUpd:)
				(michelle dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFatLadyEating of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(fatLady setCel: 0)
				(if (not (Random 0 2))
					(= seconds (Random 2 6))
				else
					(= cycles 1)
				)
			)
			(1
				(fatLady setCycle: End self)
			)
			(2
				(slobSound play:)
				(self init:)
			)
		)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo view: 526 setLoop: 0 setCycle: End self)
			)
			(1
				(if (IsFlag 2)
					(HandsOn)
				else
					(SetFlag 2)
					(User canInput: 1)
					(gTheIconBar enable: 1 3)
					(gTheIconBar curIcon: (gTheIconBar at: 1))
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
					(michelle init: setScript: sMichelle)
				)
				(self dispose:)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(HandsOn)
				(gEgo normalize:)
				(if (!= (CueObj client:) larryTable)
					(if
						(and
							((CueObj client:) approachX:)
							(!= ((gTheIconBar curIcon:) cursor:) 0)
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
				)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 80)
						(+ (gEgo y:) 50)
						self
				)
			)
			(1
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance door of Door
	(properties
		x 264
		y 165
		description {the door}
		sightAngle 90
		approachX 231
		approachY 164
		view 525
		priority 3
		signal 16400
		entranceTo 530
		locked 1
		openSnd 0
		closeSnd 0
		moveToX 292
		moveToY 154
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 2)
					(TPrint 525 3) ; "You know it's possible to get in there, but how will you? Michelle used that paper tape reader."
				else
					(TPrint 525 4) ; "You wonder what lies behind "The Magenta Door.""
				)
			)
			(3 ; Do
				(if locked
					(TPrint 525 5) ; "This door operates by means of a Membership Tape inserted and read by that machine to the left."
				else
					(super doVerb: 3)
				)
			)
			(5 ; Talk
				(Say gEgo 525 6) ; "Hello. Is there anyone inside?"
			)
			(4 ; Inventory
				(switch invItem
					(14 ; Membership_Tape
						(TPrint 525 7) ; "Insert your tape into the machine just to the left of this door."
					)
					(7 ; AeroDork_Gold_Card
						(TPrint 525 8) ; "You might try using that on the maitre d'."
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

(instance michelle of Actor
	(properties
		x 128
		y 247
		description {Michelle Milken}
		lookStr {It's her, Larry! Watch her carefully; perhaps you could follow her!}
		view 527
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Say gEgo 525 9) ; "Yoo hoo, Michelle!" you cry, fumbling to find the words that would stop a knockout like this one. "Wait! I've just got to meet you!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fatLady of Prop
	(properties
		x 39
		y 146
		description {the fat lady}
		sightAngle 40
		lookStr {You presume she's the one who sings when it's over.}
		view 525
		loop 7
		priority 1
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 525 10) ; ""Getchur hans off'n my grub!" screams the woman."
			)
			(5 ; Talk
				(Say gEgo 525 11) ; "Excuse me, madam," you say, "do you have any idea how to enter the other room?"
				(TPrint 525 12) ; ""Glub, glub, glub," is her only sound."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 192
		y 132
		description {the monitor}
		sightAngle 40
		view 510
		loop 2
		priority 15
		signal 18448
	)
)

(instance man1 of PicView
	(properties
		x 159
		y 70
		description {the bald man}
		sightAngle 90
		lookStr {That's one of the few people in this huge cafe.}
		view 525
		loop 5
		priority 4
		signal 26640
	)
)

(instance man2 of PicView
	(properties
		x 73
		y 70
		description {the lonely man}
		sightAngle 90
		lookStr {That's one of the few people in this huge cafe.}
		view 525
		loop 5
		cel 1
		priority 4
		signal 26640
	)
)

(instance man3 of PicView
	(properties
		x 116
		y 86
		description {the lonely man}
		sightAngle 90
		lookStr {That's one of the few people in this huge cafe.}
		view 525
		loop 6
		priority 4
		signal 26640
	)
)

(instance woman1 of PicView
	(properties
		x 21
		y 92
		description {the lonely woman}
		sightAngle 90
		lookStr {That's one of the few people in this huge cafe.}
		view 525
		loop 6
		cel 1
		priority 5
		signal 26640
	)
)

(instance baldMan of PicView
	(properties
		x 62
		y 161
		description {Jack}
		sightAngle 90
		view 525
		loop 2
		priority 4
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 525 13) ; "An extremely skinny man is eating with an extremely not-very-skinny woman!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance SprattFamilyTable of Feature
	(properties
		x 52
		y 160
		nsTop 143
		nsLeft 14
		nsBottom 177
		nsRight 90
		description {their table}
		sightAngle 40
		lookStr {This table seems to be occupied. Extremely occupied!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 525 14) ; "You can't sit there. You weren't assigned to that table."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance larryTable of Feature
	(properties
		x 133
		y 148
		nsTop 124
		nsLeft 90
		nsBottom 162
		nsRight 170
		description {your table}
		sightAngle 40
		approachX 114
		approachY 163
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch ((Inv at: 14) state:) ; Membership_Tape
					(1
						(TPrint 525 15) ; "Look! How convenient! A small sign on the table reads, "Track 45, Sector 4F." This is your table, Larry!"
					)
					(else
						(TPrint 525 16) ; "You no longer have to sit at this table, Larry. You are now a "SuperUser!""
						(TPrint 525 17 67 -1 185) ; "(Whatever that means!)"
					)
				)
			)
			(3 ; Do
				(if (and (User canInput:) (User canControl:))
					(HandsOff)
					(gCurRoom setScript: sSitDown)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tables of Feature
	(properties
		x 102
		y 57
		nsBottom 115
		nsRight 204
		description {the tables}
		sightAngle 40
		lookStr {What a huge cafe to have so few customers.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 525 18) ; "You can't get to those tables."
			)
			(5 ; Talk
				(TPrint 525 19) ; "You voice echoes throughout the nearly empty "Hard Disk Cafe.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cactus of Feature
	(properties
		x 294
		y 162
		nsTop 137
		nsLeft 271
		nsBottom 188
		nsRight 318
		description {the cactus}
		sightAngle 40
		lookStr {Insert your favorite cactus and "prick" joke here.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say gEgo 525 20) ; "OUCH!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tapeReader of Feature
	(properties
		x 195
		y 142
		nsTop 120
		nsLeft 176
		nsBottom 158
		nsRight 215
		description {the tape reader}
		sightAngle 40
		approachX 210
		approachY 161
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 525 21) ; "This is identical to the reader you used to enter this room."
			)
			(3 ; Do
				(if (and (User canInput:) (User canControl:))
					(HandsOff)
					(gCurRoom newRoom: 520)
				)
			)
			(4 ; Inventory
				(switch invItem
					(14 ; Membership_Tape
						(self doVerb: 3)
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

(instance daDoor of Feature
	(properties
		x 246
		y 125
		nsTop 92
		nsLeft 227
		nsBottom 159
		nsRight 266
		description {the door}
		sightAngle 40
		onMeCheck 2
		approachX 231
		approachY 164
	)

	(method (doVerb theVerb invItem)
		(door doVerb: theVerb invItem)
	)
)

(instance slobSound of Sound
	(properties
		flags 1
		number 526
	)
)

