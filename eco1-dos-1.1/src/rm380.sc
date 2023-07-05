;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use eRS)
(use Smopper)
(use n819)
(use PAvoider)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Grooper)
(use Jump)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm380 0
	junk 1
	fish 2
	dolphin 3
	tFrisbee 4
	proc380_5 5
	bugEgoScript 6
	fJump 7
	proc380_8 8
	dolphinSwimAbout 11
)

(local
	local0
	local1 = 3
	local2
	local3
	local4
	local5
	local6
	[local7 2]
	local9 = -1
	[local10 69] = [13 14 32 0 3 6 -34 1 3 -8 -34 2 2 17 -31 3 2 -16 -31 2 5 25 -25 3 5 -25 -25 7 3 -20 -30 8 3 20 -30 1 2 -3 -7 0 2 3 -7 3 5 -3 -13 4 5 3 -13 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	[local79 26] = [65 126 78 120 99 112 110 116 112 122 101 128 92 136 78 146 70 153 52 159 40 155 48 143 54 134]
)

(procedure (localproc_0)
	(if (and (== (dolphin view:) 394) (== (dolphin loop:) 0))
		(dolphin cel: 5)
	)
	(dolphin
		posn:
			[local79 (* (dolphin cel:) 2)]
			[local79 (+ (* (dolphin cel:) 2) 1)]
	)
)

(procedure (proc380_5 param1)
	(if argc
		(dolphin loop: param1)
	)
	(dolphin
		view: 392
		cycleSpeed: global249
		setCycle: Smopper 378
		setLoop: -1
		setLoop: Grooper
		setStep: 2 2
		illegalBits: 0
		moveSpeed: 3
		setAvoider: PAvoider
		z: 0
	)
)

(procedure (proc380_8)
	(gEgo
		z: 0
		loop: 2
		setLoop: Grooper
		setLoop: -1
		setPri: 2
		setMotion: 0
		illegalBits: 0
		ignoreActors: 0
		ignoreHorizon: 1
		view: 379
		setCycle: Walk
		setStep: 2 2
		moveSpeed: (+ (gGame egoMoveSpeed:) 10)
		cycleSpeed: 15
	)
)

(instance rm380 of EcoRoom
	(properties
		lookStr 1
		picture 380
		style 9
		north 400
	)

	(method (notify)
		(if (IsFlag 70)
			(Narrator posn: 140 20 init: 5 0 0 134) ; "Adam isn't going diving right now."
		else
			(Narrator posn: 140 20 init: 5 0 0 133) ; "Adam doesn't need that to go in the pool."
		)
	)

	(method (init &tmp temp0)
		(LoadMany rsVIEW 378 379 380 396 381 382 394 395 383 386 390 397 391 392)
		(= global250 5)
		(= global251 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 4 83 14 81 33 76 57 75 83 73 103 76 116 82 136 87 159 93 190 103 220 113 260 127 275 122 263 114 228 103 179 88 179 82 123 64 107 62 101 58 34 58 4 68
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 312 112 259 137 319 158 319 115
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 6 109 4 139 53 175 138 141 172 163 211 146 191 137 176 143 151 132 194 123 102 98 69 89 35 95
					yourself:
				)
		)
		(gFeatures
			add:
				bucket
				ladder
				panel
				fishNet
				cabinet
				cages
				boats
				garageDoor
				net
				wall
				lowerWall
				mat
				dock
				water
				safeArea
				pool
				poolFloor
				safeFood
				blackBoard
				starFish
			eachElementDo: #init
		)
		(= global249 42)
		(gEgo posn: 73 71)
		(super init: &rest)
		(= temp0
			(cond
				((< global247 4) 380)
				((< global247 9) 381)
				((< global247 15) 383)
				(else 384)
			)
		)
		(gLongSong number: temp0 loop: -1 play:)
		(if (<= global247 1)
			(dolphin setScript: fromLab)
		else
			(self setScript: fromLab)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			((or script (gEgo script:)) 0)
			((& (= temp0 (gEgo onControl: 0)) $0020)
				(self setScript: bounceFromSafeArea)
			)
			((>= (gEgo x:) 315)
				(self setScript: warnEgo)
			)
			((and (IsFlag 113) (>= (gEgo y:) 150))
				(self setScript: bounceFromDel)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance warnEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator posn: 140 20 init: 6 0 0 36 self) ; "There's no use going out there unless Adam has someone to swim with."
			)
			(1
				(gEgo setMotion: MoveTo 298 134 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bounceFromDel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator posn: 140 20 init: 5 0 0 122 self) ; "The dolphin wants Adam to find something new to do!"
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 140 self)
			)
			(2
				(HandsOn)
				(proc380_8)
				(self dispose:)
			)
		)
	)
)

(instance bounceFromSafeArea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 1) init: 2 0 0 41 1 self) ; Adam, "Whoa, I'd better not go in there. That's his 'human free' area and I don't want to tread on his turf."
			)
			(1
				(gEgo setMotion: MoveTo 134 129 self)
			)
			(2
				(HandsOn)
				(proc380_8)
				(self dispose:)
			)
		)
	)
)

(instance scareIntoSafeArea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global247 0)
				(dolphin
					setScript: 0
					setCycle: 0
					setMotion: PolyPath 183 143 self
				)
			)
			(1
				(dolphin setHeading: 45 self)
			)
			(2
				(dolphin
					view: 382
					loop: 3
					cel: 4
					setPri: 14
					posn: 156 165
					setCycle: CT 6 1 self
				)
			)
			(3
				(dolphinLever setCycle: End self)
			)
			(4
				(dolphin setCycle: End self)
				(insideGate startUpd: setCycle: Beg self)
				(gSoundEffects number: 394 loop: 1 play:)
			)
			(5
				(gSoundEffects stop:)
				(labDoor setScript: 0)
				(insideGate stopUpd:)
				0
			)
			(6
				(dolphin loop: 0 cycleSpeed: 36 setCycle: Fwd)
				(= seconds 4)
			)
			(7
				(gCast eachElementDo: #hide)
				(gCurRoom style: 10 drawPic: 901)
				(= seconds 3)
			)
			(8
				(gTheIconBar enable: 7)
				(if (== gPrevRoomNum 400)
					(= gCurRoomNum 360)
				else
					(= gCurRoomNum 361)
				)
				(self dispose:)
			)
		)
	)
)

(instance pickUpFrisbee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(tFrisbee approachX:)
						(tFrisbee approachY:)
						self
				)
			)
			(1
				(gEgo
					view: 383
					get: 6 ; frisbee
					loop: (if (< (gEgo x:) (tFrisbee x:)) 9 else 10)
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(tFrisbee hide: approachVerbs:)
				(gEgo setCycle: End self)
			)
			(3
				(tFrisbee stopUpd:)
				(NormalEgo 2)
				(HandsOn)
				(proc0_5 6)
				(gGame setCursor: ((Inv at: 6) cursor:)) ; frisbee
				(self dispose:)
			)
		)
	)
)

(instance getFrisbee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 122)
				(gEgo setMotion: PolyPath 137 72 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo
					view: 383
					loop: 2
					cel: 0
					cycleSpeed: 8
					setCycle: CT 1 1 self
				)
			)
			(3
				(Narrator posn: 140 20 init: 5 0 0 87 self) ; "Adam takes the green frisbee."
			)
			(4
				(tFrisbee startUpd: hide:)
				(SetScore 2 222)
				(gEgo get: 6 setCycle: End self) ; frisbee
			)
			(5
				(tFrisbee
					nsLeft: (- (tFrisbee nsLeft:) 5)
					nsRight: (+ (tFrisbee nsRight:) 5)
					nsTop: (- (tFrisbee nsTop:) 5)
					nsBottom: (+ (tFrisbee nsBottom:) 5)
					stopUpd:
				)
				(NormalEgo 5)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbInPool of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 87 80 self)
			)
			(1
				(gEgo setMotion: MoveTo 84 83 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(if (< global247 6)
					(gLongSong number: 380 play:)
				)
				(gTheIconBar disable: 7)
				(gEgo
					view: 381
					loop: 0
					cel: 0
					cycleSpeed: 15
					setCycle: CT 6 1 self
				)
			)
			(4
				(gSoundEffects number: 392 loop: 1 play:)
				(gEgo cel: 7 setCycle: End self)
			)
			(5
				(if (>= global247 6)
					(SetScore 5 238)
					(Narrator posn: 140 20 init: 5 0 0 121 self) ; "Moving slowly and carefully, Adam climbs into the pool. He can feel the dolphin's delight at having some company."
					(labDoor setScript: 0)
				else
					(= ticks 3)
				)
			)
			(6
				(gEgo
					setLoop: 4
					cel: 0
					posn: 74 95
					cycleSpeed: 15
					setCycle: Fwd
					setPri: 3
					setMotion: MoveTo 69 100 self
				)
			)
			(7
				(SetFlag 113)
				(localproc_0)
				(proc380_5)
				(proc380_8)
				(dolphin setScript: 0 setAvoider: PAvoider)
				(cond
					((== global247 6)
						(self setScript: (ScriptID 59 0) self) ; delphClickEgo
					)
					((> global247 6)
						(= cycles 3)
					)
					((< global247 6)
						(self setScript: scareIntoSafeArea)
					)
				)
			)
			(8
				(HandsOn)
				(gTheIconBar enable: 7)
				(= global247 11)
				(labDoor setScript: (ScriptID 127 0) 0 916) ; delSpeakScript
				(gEgo cycleSpeed: 15 moveSpeed: 15)
				(self dispose:)
			)
		)
	)
)

(instance climbOutPool of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gCurRoom)
					(HandsOff)
				)
				(gEgo setMotion: PolyPath 69 100 self)
			)
			(1
				(gEgo
					view: 381
					loop: 0
					cel: 12
					posn: 84 83
					setPri: -1
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(2
				(NormalEgo 6)
				(gEgo setMotion: MoveTo 94 73 self)
			)
			(3
				(dolphin setMotion: MoveTo 78 120 self)
			)
			(4
				(gEgo setHeading: 225 self)
			)
			(5
				(if (== client gCurRoom)
					(HandsOn)
				)
				(= global248 1)
				(dolphin setPri: 6 setCycle: 0 setScript: dolphinSwimAbout)
				(ClearFlag 113)
				(self dispose:)
			)
		)
	)
)

(instance climbOutToThrowFrisbee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator posn: 140 20 init: 5 0 0 112 self) ; "The water's a little too deep to get leverage, so Adam climbs out of the pool first."
			)
			(1
				(self setScript: climbOutPool self)
			)
			(2
				(= seconds 3)
			)
			(3
				(self setScript: (ScriptID 61 0) self) ; egoThrowFrisbee
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pullLever of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 10 237)
				(dolphin setScript: 0)
				(gEgo setMotion: PolyPath 204 107 self)
			)
			(1
				(SetFlag 72)
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo
					view: 381
					loop: 5
					cel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(3
				(SetScore 10 237)
				(gEgo setCycle: End)
				(outsideGateLever startUpd: cycleSpeed: 8 setCycle: End self)
			)
			(4
				(NormalEgo 4)
				(gSoundEffects number: 399 loop: 1 play:)
				(outsideGate setCycle: Beg self)
			)
			(5
				(Face gEgo dolphin self)
			)
			(6
				(gSoundEffects stop:)
				(outsideGate stopUpd:)
				(Face dolphin gEgo self)
			)
			(7
				(Face gEgo dolphin self)
			)
			(8
				((ScriptID 2 1) init: 2 0 0 8 1 self) ; Adam, "There, I've opened the hatch. Dad said you were almost ready anyway, so I know he wouldn't mind."
			)
			(9
				((ScriptID 2 0) init: 1 0 0 15 1 self) ; Delphineus, "I guess this is it. I'd say to thank your Dad, but he'd think you were nuts."
			)
			(10
				((ScriptID 2 1) init: 2 0 0 9 1 self) ; Adam, "My Dad might surprise you. Are you sure you have to go?"
			)
			(11
				((ScriptID 2 0) init: 1 0 0 16 1 self) ; Delphineus, "Cetus is my king, Adam. If he needs my help, I can't fail him. But I won't forget you."
			)
			(12
				((ScriptID 2 1) init: 2 0 0 10 1 self) ; Adam, "I won't forget you either, Delphineus. Good luck..."
			)
			(13
				(dolphin setMotion: MoveTo 121 120 self)
			)
			(14
				(Face gEgo dolphin self)
			)
			(15
				(Narrator posn: 140 20 init: 5 0 0 115 self) ; "Adam watches sadly as Delphineus swims out to sea."
			)
			(16
				(dolphin setCycle: 0 setMotion: MoveTo 216 165 self)
			)
			(17
				(Face gEgo dolphin self)
			)
			(18
				(gEgo view: 381 loop: 8 cel: 0 cycleSpeed: 20 setCycle: Fwd)
				(dolphin
					view: 395
					loop: 0
					cel: 0
					setPri: 14
					posn: 277 189
					setCycle: End self
				)
			)
			(19
				(dolphin dispose:)
				(= seconds 3)
			)
			(20
				(gCurRoom newRoom: 381)
				(self dispose:)
			)
		)
	)
)

(instance getFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 101 66 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(switch global247
					(4
						(SetScore 2 224)
					)
					(5
						(SetScore 2 225)
					)
				)
				(gEgo
					get: 7 ; mackeral
					view: 381
					loop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(3
				(gSoundEffects number: 388 loop: 1 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(4
				(Narrator posn: 140 20 init: 5 0 0 88 self) ; "Adam picks up a mackerel."
			)
			(5
				(NormalEgo 90)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fromLab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init:)
				(outsideGate init: stopUpd:)
				(dolphinLever init: stopUpd:)
				(labDoor init: stopUpd:)
				(dockDoor init: stopUpd:)
				(outsideGateLever init: stopUpd:)
				(tFrisbee init:)
				(insideGate init: stopUpd:)
				(NormalEgo 2)
				(ClearFlag 113)
				(ClearFlag 70)
				(ClearFlag 111)
				(ClearFlag 112)
				(cond
					((<= global247 1)
						(self setScript: fromLabStateSick self)
					)
					((<= 2 global247 14)
						(HandsOn)
						(self setScript: fromLabStateSwimAbout self)
					)
					((<= 15 global247 17)
						(HandsOn)
						(self setScript: fromLabStateReadyToLeave self)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance fromLabStateReadyToLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin init: posn: 177 119)
				(proc380_5 0)
				(dolphin setPri: 6 setScript: bugEgoScript)
				(= cycles 1)
			)
			(1
				(labDoor startUpd: setCycle: Beg self)
			)
			(2
				(gSoundEffects number: 902 loop: 1 play:)
				(labDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fromLabStateSwimAbout of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin
					view: 382
					init:
					approachVerbs:
					cycleSpeed: 8
					posn: 63 137
					setPri: 6
					setScript: dolphinSwimAbout
				)
				(= cycles 1)
			)
			(1
				(cond
					((== gPrevRoomNum 360)
						(Narrator posn: 140 20 init: 5 0 0 57 self) ; "Adam has startled the dolphin. He'll have to build up trust all over again."
					)
					((== gPrevRoomNum 361)
						((ScriptID 2 1) init: 2 0 0 53 1 self) ; Adam, "I'm scaring him! Maybe I'd better look at the blackboard directions!"
					)
					(else
						(= ticks 3)
					)
				)
			)
			(2
				(labDoor startUpd: setCycle: Beg self)
				(gSoundEffects number: 902 loop: 1 play:)
			)
			(3
				(labDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fromLabStateSick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin
					view: 382
					loop: 0
					cel: 0
					posn: 145 163
					setPri: 14
					cycleSpeed: global249
					init:
					setCycle: Fwd
				)
				(cond
					((== gPrevRoomNum 400)
						(Narrator posn: 140 20 init: 5 0 0 7 self) ; "The dolphin brought in by the fisherman is swimming in slow circles. The vet says that it has 'Capture Stress Syndrome.'"
					)
					((== gPrevRoomNum 360)
						(= global247 1)
						(Narrator posn: 140 20 init: 5 0 0 57 self) ; "Adam has startled the dolphin. He'll have to build up trust all over again."
					)
					(else
						(= global247 1)
						((ScriptID 2 1) init: 2 0 0 53 1 self) ; Adam, "I'm scaring him! Maybe I'd better look at the blackboard directions!"
					)
				)
			)
			(1
				(gSoundEffects number: 902 loop: 1 play:)
				(labDoor startUpd: setCycle: Beg self)
			)
			(2
				(labDoor stopUpd:)
				(= seconds 4)
			)
			(3
				(HandsOn)
				(dolphin setCycle: End self)
			)
			(4
				(dolphin loop: 5 cel: 2 posn: 145 163 setCycle: CT 6 1 self)
			)
			(5
				(dolphin setPri: 6 setCycle: End self)
			)
			(6
				(= global248 6)
				(dolphin
					approachVerbs:
					cycleSpeed: 8
					setScript: dolphinSwimAbout
				)
				(self dispose:)
			)
		)
	)
)

(instance toLab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 53 63 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo view: 380 loop: 6 cel: 0 setCycle: CT 1 1 self)
				(gSoundEffects number: 901 loop: 1 play:)
				(labDoor startUpd: setCel: 1)
			)
			(3
				(gEgo setCel: 2)
				(labDoor setCel: 2)
				(= cycles 1)
			)
			(4
				(labDoor setCycle: End)
				(NormalEgo 6)
				(gEgo setMotion: MoveTo 73 61 self)
			)
			(5
				(labDoor stopUpd:)
				(gEgo setMotion: MoveTo 73 41 self)
			)
			(6
				(gCurRoom newRoom: 400)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwFishBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(dolphin setCycle: CT 3 1 self)
			)
			(1
				(dolphin setCel: 0)
				(gSoundEffects number: 396 loop: 1 play:)
				(fish
					posn: 99 93
					init:
					setLoop: 3
					setCycle: Fwd
					setPri: 3
					setMotion: JumpTo 115 45 self
				)
			)
			(2
				(gSoundEffects number: 389 loop: 1 play:)
				(fish loop: 6 cel: 0 setCycle: End self)
			)
			(3
				(fish setLoop: 3 cel: 0 dispose:)
				(= seconds 2)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 45 1 self) ; Adam, "Well! I guess he's done!"
			)
			(5
				(if local1
					(-- local1)
					(= ticks 3)
				else
					(Narrator posn: 140 20 init: 5 0 0 38 self) ; "The dolphin looks like he's ready for company."
				)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dolphinSwimAbout of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(= seconds 0)
				(dolphin setCycle: 0)
			)
			(1
				(dolphin
					view: 382
					loop: 0
					setMotion: 0
					setCel: global248
					posn: 63 137
					z: 0
					cycleSpeed: global249
				)
				(if (>= global248 5)
					(= state -1)
					(= global248 0)
					(dolphin setCycle: End self)
				else
					(dolphin setCycle: CT 5 1 self)
				)
			)
			(2
				(cond
					((<= 4 global247 10)
						(dolphin
							view: 394
							loop: 0
							cel: 0
							z: 50
							setCycle: 0
							posn: (+ (dolphin x:) 45) (+ (dolphin y:) 41)
						)
						(if (not local3)
							(= seconds 2)
						else
							(= seconds 8)
						)
					)
					((<= 11 global247 14)
						(if (not (= local5 (mod (++ local5) 4)))
							(if (or (!= local6 44) (!= global247 11))
								(= local6 44)
							else
								(= local6 45)
							)
							(Narrator posn: 140 20 init: 5 0 0 local6 self)
						else
							(= ticks 3)
						)
					)
					(else
						(= ticks 3)
					)
				)
			)
			(3
				(if (and (not local3) (<= 4 global247 5))
					(Narrator posn: 140 20 init: 5 0 0 74 self) ; "The dolphin eyes the bucket by the door."
					(= local3 1)
				else
					(= ticks 3)
				)
			)
			(4
				(if (and (< 4 global247 6) (not local2))
					(= local2 1)
					(Narrator posn: 140 20 init: 5 0 0 36 self) ; "The dolphin is a little more energetic, but he still looks hungry."
				else
					(= ticks 3)
				)
			)
			(5
				(= global248 0)
				(dolphin
					view: 382
					loop: 0
					setCel: 5
					z: 0
					posn: 63 137
					setCycle: End self
				)
				(= state -1)
			)
		)
	)
)

(instance throwFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(= register
						(and (== (dolphin view:) 394) (== (dolphin loop:) 0))
					)
					(dolphin setScript: 0)
				)
				(gEgo setMotion: PolyPath 130 77 self)
			)
			(1
				(gEgo put: 7 setHeading: 180 self) ; mackeral
			)
			(2
				(gEgo
					view: 381
					loop: 2
					cel: 0
					cycleSpeed: 8
					setCycle: CT 5 1 self
				)
			)
			(3
				(fish
					init:
					loop: 3
					posn: 145 93
					setPri: 3
					setCycle: Fwd
					setMotion: JumpTo 98 127 self
				)
				(gEgo setCycle: End)
			)
			(4
				(gSoundEffects number: 389 loop: 1 play:)
				(NormalEgo 2)
				(fish loop: 6 cel: 0 setCycle: End self)
			)
			(5
				(fish dispose:)
				(if register
					(if (OneOf global247 4 5)
						(self setScript: eatFish self)
					else
						(self setScript: throwFishBack self)
					)
				else
					(= ticks 3)
				)
			)
			(6
				(cond
					(register
						(= global248 5)
						(dolphin setScript: dolphinSwimAbout)
						(switch global247
							(4
								(= global247 5)
								(Narrator posn: 140 20 init: 5 0 0 35 self) ; "The dolphin chows down on the mackerel!"
							)
							(5
								(= global247 6)
								((ScriptID 2 1) init: 2 0 0 37 1 self) ; Adam, "Yes! He swallowed another one!"
							)
							(else
								(= ticks 3)
							)
						)
					)
					((== global247 2)
						(Narrator posn: 140 20 init: 5 0 0 73 self) ; "He's waiting to see what Adam will say. He's not interested in that now."
					)
					((< global247 4)
						(Narrator posn: 140 20 init: 5 0 0 39 self) ; "The dolphin doesn't want to eat. He's too depressed and lonely."
					)
					((<= 6 global247 10)
						(Narrator posn: 140 20 init: 5 0 0 34 self) ; "Good thought, Adam, but he's more lonely than hungry right now."
					)
					((<= 4 global247 5)
						(Narrator posn: 140 20 init: 5 0 0 97 self) ; "Good idea, but Adam should wait till the dolphin is paying attention."
					)
					(else
						(Narrator posn: 140 20 init: 5 0 0 98 self) ; "The dolphin is no longer in the mood for sushi."
					)
				)
			)
			(7
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eatFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin
					cycleSpeed: (- (dolphin cycleSpeed:) 10)
					setCycle: CT 2 1 self
				)
			)
			(1
				(gSoundEffects number: 396 loop: 1 play:)
				(dolphin setCycle: CT 7 1 self)
			)
			(2
				(gSoundEffects number: 397 loop: 1 play:)
				(dolphin cel: 8 setCycle: End self)
			)
			(3
				(switch global247
					(4
						(SetScore 2 229)
					)
					(5
						(SetScore 2 230)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance bugEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(dolphin setMotion: MoveTo 177 119 self)
			)
			(1
				(dolphin setHeading: 90 self)
			)
			(2
				(HandsOn)
				(gTheIconBar enable: 7)
				(= cycles 1)
			)
			(3
				(= seconds 10)
			)
			(4
				(-= state 2)
				(if (not (gCurRoom script:))
					((ScriptID 2 0) ; Delphineus
						init:
							1
							0
							0
							[local10 (= local9 (mod (++ local9) 3))]
							1
							self
					)
				else
					(= ticks 3)
				)
			)
		)
	)
)

(instance inDockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 70)
				(gEgo setMotion: PolyPath 272 131 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 380 setLoop: 7 cel: 0 setCycle: CT 1 1 self)
				(gSoundEffects number: 901 loop: 1 play:)
				(dockDoor startUpd: setCel: 1)
			)
			(3
				(gEgo setCel: 2)
				(dockDoor setCel: 2)
				(= cycles 1)
			)
			(4
				(NormalEgo 3)
				(dockDoor setCycle: End self)
			)
			(5
				(gEgo setLoop: -1 setMotion: MoveTo 289 130 self)
			)
			(6
				(gEgo setPri: -1 setMotion: MoveTo 236 110 self)
			)
			(7
				(dockDoor setCycle: Beg self)
			)
			(8
				(gSoundEffects number: 902 loop: 1 play:)
				(dockDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance outDockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 271 138 self)
			)
			(1
				(SetFlag 70)
				(gSoundEffects number: 901 loop: 1 play:)
				(dockDoor startUpd: setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 307 136 self)
			)
			(3
				(Narrator posn: 140 20 init: 5 0 0 99 self) ; "Adam shouldn't leave just yet. The dolphin needs his help."
			)
			(4
				(gEgo setPri: 11)
				(dockDoor setCycle: Beg self)
			)
			(5
				(gSoundEffects number: 902 loop: 1 play:)
				(dockDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance junk of Prop
	(properties
		x 151
		y 119
		view 396
		loop 2
		priority 15
		signal 16400
	)
)

(instance outsideGate of Prop
	(properties
		x 245
		y 174
		lookStr 23
		view 396
		loop 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= cel (self lastCel:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(Narrator posn: 140 20 init: 5 0 0 26) ; "Adam can't reach the hatch from here. Anyway, it doesn't open from the outside."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dolphinLever of Prop
	(properties
		x 217
		y 145
		lookStr 55
		view 380
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blackBoard of Feature
	(properties
		x 140
		y 37
		nsTop 2
		nsLeft 130
		nsBottom 49
		nsRight 196
		sightAngle 45
		onMeCheck 16384
		approachX 135
		approachY 74
	)

	(method (doVerb theVerb)
		(cond
			(
				(and
					(not (IsFlag 113))
					(not (IsFlag 111))
					(not (IsFlag 70))
				)
				(switch theVerb
					(2 ; Look
						(gCurRoom setScript: (ScriptID 69 0) 0 -1) ; lookAtBlackBoard
					)
					(3 ; Do
						(gCurRoom setScript: (ScriptID 69 0) 0 -1) ; lookAtBlackBoard
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			((IsFlag 113)
				(if (== global247 10)
					(Narrator posn: 140 20 init: 5 0 0 92) ; "The dolphin wants to give Adam a ride!"
				else
					(Narrator posn: 140 20 init: 5 0 0 61) ; "Adam doesn't need to use that while he's in the pool with the dolphin."
				)
			)
			((IsFlag 111)
				(Narrator posn: 140 20 init: 5 0 0 117) ; "Adam's too busy right now to do that."
			)
			((IsFlag 70)
				(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
			)
		)
	)
)

(instance safeFood of Feature
	(properties
		x 201
		y 127
		nsTop 117
		nsLeft 186
		nsBottom 135
		nsRight 221
		sightAngle 45
		onMeCheck 8192
		lookStr 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(Narrator posn: 140 20 init: 5 0 0 58) ; "That's the dolphin's food. No one else should touch it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance labDoor of Prop
	(properties
		x 90
		y 56
		approachX 61
		approachY 62
		lookStr 21
		view 380
		signal 16384
		cycleSpeed 0
	)

	(method (init)
		(super init: &rest)
		(if (!= gPrevRoomNum 320)
			(self setCel: (self lastCel:))
		)
		(self setScript: (ScriptID 127 0) 0 (+ 916 (* (<= global247 6) 2))) ; delSpeakScript
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2) ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(
				(and
					(not (IsFlag 113))
					(not (IsFlag 111))
					(not (IsFlag 70))
				)
				(switch theVerb
					(2 ; Look
						(Narrator posn: 140 20 init: 5 0 0 lookStr)
					)
					(3 ; Do
						(gCurRoom setScript: toLab)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			((IsFlag 113)
				(if (== global247 10)
					(Narrator posn: 140 20 init: 5 0 0 92) ; "The dolphin wants to give Adam a ride!"
				else
					(Narrator posn: 140 20 init: 5 0 0 61) ; "Adam doesn't need to use that while he's in the pool with the dolphin."
				)
			)
			((IsFlag 111)
				(Narrator posn: 140 20 init: 5 0 0 117) ; "Adam's too busy right now to do that."
			)
			((IsFlag 70)
				(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
			)
		)
	)
)

(instance dockDoor of Prop
	(properties
		x 292
		y 128
		z 60
		approachX 271
		approachY 138
		lookStr 22
		view 380
		loop 2
		priority 9
		signal 16400
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(self onMe: event)
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_CONTROL
							KEY_F1
							KEY_F2
							KEY_F5
							KEY_F7
							KEY_F9
						)
					)
					(not (IsFlag 113))
				)
				(event claimed: 1)
				(self doVerb: 3)
			else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2) ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			((and (not (IsFlag 113)) (not (IsFlag 111)))
				(switch theVerb
					(3 ; Do
						(if (IsFlag 70)
							(gCurRoom setScript: inDockDoor)
						else
							(gCurRoom setScript: outDockDoor)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			((IsFlag 113)
				(if (== global247 10)
					(Narrator posn: 140 20 init: 5 0 0 92) ; "The dolphin wants to give Adam a ride!"
				else
					(Narrator posn: 140 20 init: 5 0 0 61) ; "Adam doesn't need to use that while he's in the pool with the dolphin."
				)
			)
			((IsFlag 111)
				(Narrator posn: 140 20 init: 5 0 0 117) ; "Adam's too busy right now to do that."
			)
		)
	)
)

(instance outsideGateLever of Prop
	(properties
		x 212
		y 116
		approachX 204
		approachY 107
		view 380
		loop 3
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (outsideGate cel:)
					(Narrator posn: 140 20 init: 5 0 0 19) ; "The lever opens and closes the hatch. It is currently in the closed position."
				else
					(Narrator posn: 140 20 init: 5 0 0 71) ; "The lever is in the open position."
				)
			)
			(4 ; Inventory
				(Narrator posn: 140 20 init: 5 0 0 132) ; "The lever for the hatch is operated by hand. It's not necessary to use anything on the lever."
			)
			(3 ; Do
				(cond
					((not (outsideGate cel:))
						(Narrator posn: 140 20 init: 5 0 0 59) ; "The hatch is already open."
					)
					(
						(and
							(not (IsFlag 113))
							(not (IsFlag 111))
							(not (IsFlag 70))
							(>= global247 15)
						)
						(gCurRoom setScript: pullLever)
					)
					((IsFlag 113)
						(if (== global247 10)
							(Narrator posn: 140 20 init: 5 0 0 92) ; "The dolphin wants to give Adam a ride!"
						else
							(Narrator posn: 140 20 init: 5 0 0 61) ; "Adam doesn't need to use that while he's in the pool with the dolphin."
						)
					)
					((IsFlag 70)
						(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
					)
					((IsFlag 111)
						(Narrator posn: 140 20 init: 5 0 0 117) ; "Adam's too busy right now to do that."
					)
					((< global247 15)
						(Narrator posn: 140 20 init: 5 0 0 20) ; "The injured dolphin isn't ready to return to the wild just yet."
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

(instance tFrisbee of Actor
	(properties
		x 151
		y 65
		z 20
		approachX 137
		approachY 72
		lookStr 53
		yStep 3
		view 380
		loop 5
		signal 16384
		xStep 4
		moveSpeed 5
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= nsLeft temp0 nsRight) (<= nsTop temp1 nsBottom)))
	)

	(method (init)
		(super init: &rest)
		(cond
			((or (== ((gInventory at: 6) owner:) 360) (gEgo has: 6)) ; frisbee, frisbee
				(self hide: stopUpd:)
			)
			((IsFlag 122)
				(self
					posn: global120 global121
					z: 100
					approachX: global122
					approachY: global123
					view: 380
					loop: 5
					cel: 0
					setPri: 1
					show:
					stopUpd:
				)
			)
			(else
				(self show: stopUpd:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(if (and (not (IsFlag 113)) (not (IsFlag 70)))
			(switch theVerb
				(2 ; Look
					(if (IsFlag 122)
						(Narrator posn: 140 20 init: 5 0 0 96) ; "A green frisbee sits on the floor. Maybe Adam should practice catching!"
					else
						(Narrator posn: 140 20 init: 5 0 0 lookStr)
					)
				)
				(3 ; Do
					(if (== view 380)
						(if (and (== x 151) (== y 65))
							(gCurRoom setScript: getFrisbee)
						else
							(gCurRoom setScript: pickUpFrisbee)
						)
					else
						(SetFlag 112)
						(HandsOff)
						(switch global247
							(12
								(SetScore 1 243)
							)
							(13
								(SetScore 1 244)
							)
							(14
								(SetScore 1 245)
							)
							(16
								(SetScore 1 246)
							)
						)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance fish of Actor
	(properties
		view 381
		loop 3
		signal 16384
	)
)

(instance insideGate of Prop
	(properties
		x 144
		y 242
		z 100
		lookStr 54
		view 396
		cel 8
		signal 16384
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(Narrator posn: 140 20 init: 5 0 0 54) ; "A gate that can be operated by the animal under treatment protects the 'human-free' side of the pool."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bucket of Feature
	(properties
		x 104
		y 55
		sightAngle 45
		onMeCheck 4
		approachX 104
		approachY 66
		lookStr 38
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2) ; Look
				((ScriptID 2 1) init: 2 0 0 lookStr 1) ; Adam
			)
			(
				(and
					(not (IsFlag 113))
					(not (IsFlag 111))
					(not (IsFlag 70))
				)
				(switch theVerb
					(3 ; Do
						(if (not (gEgo has: 7)) ; mackeral
							(gCurRoom setScript: getFish)
						else
							((ScriptID 2 1) init: 2 0 0 39 1) ; Adam, "Yuk! Carrying one of those slimy, gross things is enough."
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			((IsFlag 113)
				(if (== global247 10)
					(Narrator posn: 140 20 init: 5 0 0 92) ; "The dolphin wants to give Adam a ride!"
				else
					(Narrator posn: 140 20 init: 5 0 0 61) ; "Adam doesn't need to use that while he's in the pool with the dolphin."
				)
			)
			((IsFlag 111)
				(Narrator posn: 140 20 init: 5 0 0 117) ; "Adam's too busy right now to do that."
			)
			((IsFlag 70)
				(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
			)
		)
	)
)

(instance ladder of Feature
	(properties
		sightAngle 45
		onMeCheck 2
		approachX 87
		approachY 80
		lookStr 18
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(if (!= (dolphin script:) fromLab)
					(cond
						((IsFlag 70)
							(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
						)
						((IsFlag 111)
							(Narrator posn: 140 20 init: 5 0 0 102) ; "The water's too deep for Adam to catch the frisbee in the pool."
						)
						((not (IsFlag 113))
							(if (< global247 8)
								(gCurRoom setScript: climbInPool)
							else
								(Narrator posn: 140 20 init: 5 0 0 101) ; "Getting in the pool again won't help."
							)
						)
						((IsFlag 113)
							(if (== global247 10)
								(Narrator posn: 140 20 init: 5 0 0 106) ; "The dolphin's offering a ride to Adam!"
							else
								(gCurRoom setScript: climbOutPool)
							)
						)
					)
				else
					(Narrator posn: 140 20 init: 5 0 0 103) ; "Getting in the pool right now is not a good idea."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance starFish of Feature
	(properties
		x 234
		y 165
		nsTop 156
		nsLeft 204
		nsBottom 176
		nsRight 255
		sightAngle 45
		onMeCheck 256
		approachX 317
		approachY 136
		lookStr 56
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance panel of Feature
	(properties
		x 6
		y 46
		nsTop 36
		nsBottom 68
		nsRight 20
		sightAngle 45
		onMeCheck 16384
		approachX 10
		approachY 69
		lookStr 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(if local4
					(Narrator posn: 140 20 init: 5 0 0 14) ; "The water level is fine the way it is."
				else
					(++ local4)
					(Narrator posn: 140 20 init: 5 0 0 13) ; "The water is now pretty deep since the dolphin is swimming on its own."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fishNet of Feature
	(properties
		x 29
		y 16
		nsTop 2
		nsLeft 21
		nsBottom 60
		nsRight 37
		sightAngle 45
		onMeCheck 16384
		approachX 27
		approachY 66
		lookStr 15
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(if (IsFlag 72)
					(Narrator posn: 140 20 init: 5 0 0 17) ; "The pool doesn't need cleaning."
				else
					(Narrator posn: 140 20 init: 5 0 0 16) ; "The net would frighten the dolphin."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		x 152
		y 52
		nsTop 39
		nsLeft 130
		nsBottom 76
		nsRight 186
		sightAngle 45
		onMeCheck 8192
		approachX 135
		approachY 74
		lookStr 62
	)

	(method (doVerb theVerb invItem)
		(cond
			(
				(and
					(not (IsFlag 113))
					(not (IsFlag 111))
					(not (IsFlag 70))
				)
				(switch theVerb
					(3 ; Do
						(if (gEgo has: 8) ; scubaGear
							(Narrator posn: 140 20 init: 5 0 0 60) ; "There's nothing more in the cabinet."
						else
							(gCurRoom setScript: (ScriptID 67 0)) ; lookAtCabinet
						)
					)
					(2 ; Look
						(Narrator posn: 140 20 init: 5 0 0 lookStr)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			((IsFlag 113)
				(if (== global247 10)
					(Narrator posn: 140 20 init: 5 0 0 92) ; "The dolphin wants to give Adam a ride!"
				else
					(Narrator posn: 140 20 init: 5 0 0 61) ; "Adam doesn't need to use that while he's in the pool with the dolphin."
				)
			)
			((IsFlag 111)
				(Narrator posn: 140 20 init: 5 0 0 117) ; "Adam's too busy right now to do that."
			)
			((IsFlag 70)
				(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
			)
		)
	)
)

(instance cages of Feature
	(properties
		x 218
		y 74
		nsTop 78
		nsLeft 188
		nsBottom 102
		nsRight 235
		sightAngle 45
		onMeCheck 16384
		approachX 201
		approachY 99
	)

	(method (doVerb theVerb invItem)
		(cond
			(
				(and
					(not (IsFlag 113))
					(not (IsFlag 111))
					(not (IsFlag 70))
				)
				(switch theVerb
					(2 ; Look
						(gCurRoom setScript: (ScriptID 69 1) 0 -1) ; lookAtCage
					)
					(3 ; Do
						(gCurRoom setScript: (ScriptID 69 1) 0 -1) ; lookAtCage
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			((IsFlag 113)
				(if (== global247 10)
					(Narrator posn: 140 20 init: 5 0 0 92) ; "The dolphin wants to give Adam a ride!"
				else
					(Narrator posn: 140 20 init: 5 0 0 61) ; "Adam doesn't need to use that while he's in the pool with the dolphin."
				)
			)
			((IsFlag 111)
				(Narrator posn: 140 20 init: 5 0 0 117) ; "Adam's too busy right now to do that."
			)
			((IsFlag 70)
				(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
			)
		)
	)
)

(instance boats of Feature
	(properties
		x 228
		y 59
		nsTop 13
		nsLeft 191
		nsBottom 103
		nsRight 279
		sightAngle 45
		onMeCheck 8192
		approachX 201
		approachY 99
		lookStr 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(Narrator posn: 140 20 init: 5 0 0 2) ; "The Lab uses the speedboats as little as possible. The gasoline really hurts the reef."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance garageDoor of Feature
	(properties
		x 228
		y 59
		nsLeft 209
		nsBottom 48
		nsRight 294
		sightAngle 45
		onMeCheck 4096
		approachX 201
		approachY 99
		lookStr 63
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(Narrator posn: 140 20 init: 5 0 0 86) ; "The gates are far too heavy for Adam to lift."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance net of Feature
	(properties
		x 127
		y 149
		nsTop 104
		nsLeft 39
		nsBottom 189
		nsRight 205
		sightAngle 45
		onMeCheck 4096
		approachX 176
		approachY 93
		lookStr 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 222
		y 119
		nsLeft 125
		nsBottom 189
		nsRight 319
		sightAngle 45
		onMeCheck 2048
		approachX 227
		approachY 107
		lookStr 65
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lowerWall of Feature
	(properties
		x 229
		y 110
		nsTop 149
		nsLeft 177
		nsBottom 149
		nsRight 265
		sightAngle 45
		onMeCheck 1024
		approachX 227
		approachY 107
		lookStr 66
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mat of Feature
	(properties
		x 297
		y 119
		nsTop 117
		nsLeft 274
		nsBottom 138
		nsRight 317
		sightAngle 45
		onMeCheck 16384
		approachX 313
		approachY 133
		lookStr 67
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(self onMe: event)
					(not (event modifiers:))
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_CONTROL
							KEY_F1
							KEY_F2
							KEY_F5
							KEY_F7
							KEY_F9
						)
					)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(if (not (IsFlag 70))
					(if (not (IsFlag 113))
						(event claimed: 1)
						(dockDoor doVerb: 3)
					else
						(event claimed: 1)
						(ladder doVerb: 3)
					)
				else
					(super handleEvent: event &rest)
				)
			else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poolFloor of Feature
	(properties
		x 104
		y 55
		sightAngle 45
		onMeCheck 64
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(self onMe: event)
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_CONTROL
							KEY_F1
							KEY_F2
							KEY_F5
							KEY_F7
							KEY_F9
						)
					)
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(cond
					((IsFlag 70)
						(event claimed: 1)
						(dockDoor doVerb: 3)
					)
					((IsFlag 113)
						(event claimed: 1)
						(ladder doVerb: 3)
					)
					(else
						(super handleEvent: event &rest)
					)
				)
			else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb)
		(gCurRoom doVerb: &rest)
	)
)

(instance dock of Feature
	(properties
		x 315
		y 119
		nsTop 109
		nsLeft 248
		nsBottom 169
		nsRight 319
		sightAngle 45
		onMeCheck 4096
		approachX 315
		approachY 139
		lookStr 25
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(self onMe: event)
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_CONTROL
							KEY_F1
							KEY_F2
							KEY_F5
							KEY_F7
							KEY_F9
						)
					)
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(if (not (IsFlag 70))
					(if (not (IsFlag 113))
						(event claimed: 1)
						(dockDoor doVerb: 3)
					else
						(event claimed: 1)
						(ladder doVerb: 3)
					)
				else
					(super handleEvent: event &rest)
				)
			else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(Narrator posn: 140 20 init: 5 0 0 27) ; "The docks are in good repair."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance water of Feature
	(properties
		x 298
		y 180
		nsTop 150
		nsLeft 266
		nsBottom 189
		nsRight 319
		sightAngle 45
		onMeCheck 16384
		approachX 313
		approachY 133
		lookStr 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(3 ; Do
				(Narrator posn: 140 20 init: 5 0 0 30) ; "Adam's not allowed to swim alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance safeArea of Feature
	(properties
		x 158
		y 159
		nsTop 120
		nsLeft 62
		nsBottom 189
		nsRight 227
		sightAngle 45
		onMeCheck 512
		approachX 228
		approachY 109
		lookStr 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dolphin of Actor
	(properties
		x 160
		y 100
		view 390
		signal 16384
	)

	(method (setHeading param1)
		(if (!= heading param1)
			(super setHeading: param1 &rest)
		else
			(return heading)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Recycle
				(if (== global247 1)
					(Narrator posn: 140 20 init: 5 0 0 131) ; "That bag is for garbage and the dolphin is hardly trash!"
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(3 ; Do
				(cond
					((IsFlag 70)
						(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
					)
					((== global247 10)
						((ScriptID 59 0) cue:) ; delphClickEgo
					)
					((and (<= 11 global247 14) (IsFlag 113))
						(Narrator posn: 140 20 init: 5 0 0 93) ; "The dolphin doesn't want to pull Adam again. He's looking for new amusement."
					)
					((>= global247 15)
						(Narrator posn: 140 20 init: 5 0 0 46) ; "Petting Delphineus won't help. He needs to go home."
					)
					((<= global247 6)
						(ladder doVerb: 3)
					)
					(else
						(Narrator posn: 140 20 init: 5 0 0 126) ; "Adam can't reach the dolphin from here."
					)
				)
			)
			(2 ; Look
				(switch global247
					(1
						(Narrator posn: 140 20 init: 5 0 0 8) ; "The dolphin appears depressed and lonely."
					)
					(2
						(Narrator posn: 140 20 init: 5 0 0 31) ; "The dolphin keeps swimming, but Adam has the feeling he's listening."
					)
					(3
						(Narrator posn: 140 20 init: 5 0 0 32) ; "The dolphin is definitely listening."
					)
					(4
						(Narrator posn: 140 20 init: 5 0 0 72) ; "The dolphin is paying attention now. He looks more energetic, maybe even a little hungry."
					)
					(5
						(Narrator posn: 140 20 init: 5 0 0 105) ; "The dolphin still looks hungry."
					)
					(6
						(if (= local0 (not local0))
							(Narrator posn: 140 20 init: 5 0 0 38) ; "The dolphin looks like he's ready for company."
						else
							(Narrator posn: 140 20 init: 5 0 0 41) ; "The dolphin seems to want Adam to get closer."
						)
					)
					(9
						(Narrator posn: 140 20 init: 5 0 0 78) ; "The dolphin is still. He's waiting to see if Adam accepts his invitation."
					)
					(11
						(Narrator posn: 140 20 init: 5 0 0 122) ; "The dolphin wants Adam to find something new to do!"
					)
					(12
						(Narrator posn: 140 20 init: 5 0 0 107) ; "Adam cups his hand and the dolphin swims up under it and pulls Adam into a whirling, swooping ride around the pool."
					)
					(13
						(Narrator posn: 140 20 init: 5 0 0 108) ; "The dolphin really loves the frisbee game and wants to play more."
					)
					(14
						(Narrator posn: 140 20 init: 5 0 0 109) ; "The dolphin wants another toss!"
					)
					(10
						(Narrator posn: 140 20 init: 5 0 0 78) ; "The dolphin is still. He's waiting to see if Adam accepts his invitation."
					)
					(15
						(Narrator posn: 140 20 init: 5 0 0 81) ; "The dolphin is staring intently at the lever by the side of the pool"
					)
					(16
						(Narrator posn: 140 20 init: 5 0 0 81) ; "The dolphin is staring intently at the lever by the side of the pool"
					)
					(17
						(Narrator posn: 140 20 init: 5 0 0 81) ; "The dolphin is staring intently at the lever by the side of the pool"
					)
				)
			)
			(4 ; Inventory
				(cond
					((and (not (IsFlag 113)) (not (IsFlag 70)))
						(switch invItem
							(7 ; mackeral
								(if (< global247 15)
									(gCurRoom setScript: throwFish)
								else
									((ScriptID 2 0) init: 1 0 0 24 1) ; Delphineus, "Ah, no way, man. No time to eat now! I've got to get going!"
								)
							)
							(6 ; frisbee
								(cond
									((<= 11 global247 16)
										(switch global247
											(11
												(gCurRoom
													setScript: (ScriptID 61 0) ; egoThrowFrisbee
												)
											)
											(12
												(gCurRoom
													setScript: (ScriptID 61 0) ; egoThrowFrisbee
												)
											)
											(13
												(gCurRoom
													setScript: (ScriptID 61 0) ; egoThrowFrisbee
												)
											)
											(14
												(gCurRoom
													setScript: (ScriptID 61 1) ; gotIt
												)
											)
											(15
												(gCurRoom
													setScript: (ScriptID 61 0) ; egoThrowFrisbee
												)
											)
											(16
												(gCurRoom
													setScript: (ScriptID 62 0) ; flyDolphin
												)
											)
											(17
												((ScriptID 2 0) init: 1 0 0 32) ; Delphineus, "Adam, I need to go home now!"
											)
											(else
												(if (<= 11 global247)
													(Narrator
														posn: 140 20
														init: 5 0 0 75 ; "The dolphin is too weak to play yet."
													)
												else
													(Narrator
														posn: 140 20
														init: 5 0 0 40 ; "The dolphin's not in a playful mood right now."
													)
												)
											)
										)
									)
									((IsFlag 113)
										(Narrator posn: 140 20 init: 5 0 0 112) ; "The water's a little too deep to get leverage, so Adam climbs out of the pool first."
									)
									((== global247 1)
										(Narrator posn: 140 20 init: 5 0 0 40) ; "The dolphin's not in a playful mood right now."
									)
									((== global247 2)
										(Narrator posn: 140 20 init: 5 0 0 73) ; "He's waiting to see what Adam will say. He's not interested in that now."
									)
									((< global247 4)
										(Narrator posn: 140 20 init: 5 0 0 75) ; "The dolphin is too weak to play yet."
									)
									((< global247 6)
										(Narrator posn: 140 20 init: 5 0 0 40) ; "The dolphin's not in a playful mood right now."
									)
									((== global247 6)
										(Narrator posn: 140 20 init: 5 0 0 76) ; "The dolphin isn't interested in playing yet. He seems to want Adam to come closer."
									)
									((== global247 17)
										((ScriptID 2 0) init: 1 0 0 36 1 0 380) ; Delphineus, "C'mon Adam. I gotta go. I can't play now!"
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
					((IsFlag 113)
						(cond
							((== global247 10)
								(Narrator posn: 140 20 init: 5 0 0 92) ; "The dolphin wants to give Adam a ride!"
							)
							((== invItem 6) ; frisbee
								(gCurRoom setScript: climbOutToThrowFrisbee)
							)
							(else
								(Narrator posn: 140 20 init: 5 0 0 61) ; "Adam doesn't need to use that while he's in the pool with the dolphin."
							)
						)
					)
					((IsFlag 70)
						(Narrator posn: 140 20 init: 5 0 0 69) ; "Adam must go inside to do that."
					)
					((IsFlag 111)
						(Narrator posn: 140 20 init: 5 0 0 117) ; "Adam's too busy right now to do that."
					)
				)
			)
			(5 ; Talk
				(cond
					((IsFlag 70)
						(Narrator posn: 140 20 init: 5 0 0 128) ; "Adam needs to get closer to communicate with the dolphin."
					)
					((== global247 1)
						(SetScore 2 226)
						(= global247 2)
						(= cycleSpeed (-= global249 4))
						(if (== gPrevRoomNum 400)
							((ScriptID 2 1) init: 2 0 0 42 1) ; Adam, "Hi, hey, you're swimming better than yesterday."
						else
							((ScriptID 2 1) init: 3 0 0 16 1) ; Adam, "Sorry I scared you! I'll take it easy this time."
						)
					)
					((== global247 2)
						(SetScore 2 227)
						(if (== gPrevRoomNum 400)
							((ScriptID 2 1) init: 2 0 0 43 1) ; Adam, "You'll feel better in no time at all and we can take you home."
						else
							((ScriptID 2 1) init: 3 0 0 17 1) ; Adam, "It's just... I want to make friends with you so bad that I get impatient."
						)
						(= global247 3)
						(= cycleSpeed (-= global249 4))
					)
					((== global247 3)
						(SetScore 2 228)
						(= global247 4)
						(= cycleSpeed (-= global249 5))
						(gCurRoom setScript: (ScriptID 59 1)) ; talk1
					)
					((< global247 4)
						(Narrator posn: 140 20 init: 5 0 0 72) ; "The dolphin is paying attention now. He looks more energetic, maybe even a little hungry."
					)
					((< global247 11)
						(Narrator posn: 140 20 init: 5 0 0 95) ; "The dolphin has decided to make friends. He's waiting for Adam to take the next step."
					)
					((== global247 11)
						((ScriptID 2 1) init: 2 0 0 52 1) ; Adam, "I'm trying to figure out what you want next."
					)
					((<= 12 global247 14)
						(Narrator posn: 140 20 init: 5 0 0 119) ; "The dolphin seems to be saying "Do it again!""
					)
					(else
						((ScriptID 2 0) init: 4 0 0 25 1) ; Delphineus, "Adam, I know there's a way to open the hatch, but I don't know what it is."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pool of Feature
	(properties
		x 67
		y 10
		nsTop 83
		nsBottom 189
		nsRight 188
		sightAngle 45
		onMeCheck 256
		approachX 62
		approachY 66
		lookStr 5
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(if
				(and
					(not (gCurRoom script:))
					(!= (event type:) evVERB)
					(self onMe: event)
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_CONTROL
							KEY_F1
							KEY_F2
							KEY_F5
							KEY_F7
							KEY_F9
						)
					)
					(not (IsFlag 113))
					(not (IsFlag 70))
				)
				(event claimed: 1)
				(ladder doVerb: 3)
			else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4 ; Inventory
				(dolphin doVerb: 4 &rest)
			)
			(5 ; Talk
				(dolphin doVerb: 5 &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fJump of JumpTo
	(properties)

	(method (init)
		(self completed: 0 gx: 0 gy: 1 xStep: 1 yStep: 1)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 2])
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(super doit: &rest)
		)
	)
)

