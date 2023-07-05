;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use eRS)
(use RangeOsc)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Grooper)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm54 0
)

(local
	local0
	[local1 8] = [121 132 161 120 189 133 150 146]
	[local9 54] = [265 189 0 189 0 0 319 0 319 189 129 96 126 95 116 93 105 96 115 101 104 105 90 101 79 104 91 110 77 115 60 109 52 112 63 119 36 125 78 149 50 159 76 174 108 161 137 177 175 179 222 165 260 188]
	[local63 36] = [84 147 50 159 73 175 108 160 131 176 174 178 221 162 268 189 0 189 0 1 319 1 319 189 129 95 110 100 132 110 91 121 74 113 38 121]
)

(instance rm54 of SQRoom
	(properties
		picture 54
	)

	(method (init)
		(self setRegions: 703) ; DeltaurRegion
		(HandsOff)
		(= global166 2)
		(LoadMany rsVIEW 154 37 39 51 36 1 61 2)
		(LoadMany rsSOUND 514 526 512 513 515 538)
		(gEgo init:)
		(vent init:)
		(roomWithTrunkForwardPoly points: @local9 size: 27)
		(trunkPoly points: @local1 size: 4)
		(roomWithTrunkBackPoly points: @local63 size: 18)
		(if (or (IsFlag 62) (IsFlag 29))
			(self addObstacle: roomWithTrunkForwardPoly)
		else
			(trunk init: ignoreActors: 1)
			(if (not (IsFlag 35))
				(self addObstacle: trunkPoly roomWithTrunkForwardPoly)
			else
				(self addObstacle: roomWithTrunkBackPoly)
			)
		)
		(if (== (DeltaurRegion egoStatus:) 0)
			(guard init: setScript: killEgoTimeOut)
			(LoadMany rsVIEW 479 66 417 48)
		)
		(switch gPrevRoomNum
			(61
				(gEgo posn: 267 177)
			)
			(55
				(gEgo view: 37 loop: 1 posn: 111 118)
			)
			(else
				(gEgo posn: 69 170)
			)
		)
		(super init:)
		(if (!= (gLongSong number:) 538)
			(gLongSong number: 538 loop: -1 play:)
		)
		(gFeatures
			add: ventShaft shadows floor1 airLock floor2 floor3 vaults
			eachElementDo: #init
		)
		(switch gPrevRoomNum
			(61
				(gEgo posn: 267 177)
				(self setScript: fromHall)
			)
			(55
				(self setScript: climbOutOfVent)
			)
			(else
				(gEgo posn: 69 170)
				(self setScript: fromAirlock)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(if (or (IsFlag 29) (== (DeltaurRegion egoStatus:) 1))
				(Print 54 0) ; "You are in some sort of storage room."
			else
				(Print 54 1) ; "You are in some sort of storage room. A large trunk occupies the center of the room. Perhaps one of the little Sariens is away at Enemy Eviscerating Training Camp."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((or (self script:) (gEgo script:)) 0)
			(local0
				(self setScript: killEgo)
			)
			((& (gEgo onControl: 0) $0002)
				(self setScript: toHall)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 57)
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance trunkPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance roomWithTrunkForwardPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance roomWithTrunkBackPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance vent of Prop
	(properties
		x 92
		y 49
		view 154
		cycleSpeed 12
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 36)
			(self setCel: (self lastCel:))
		)
		(self stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if cel
					(Print 54 2) ; "The vent grill is now open."
				else
					(Print 54 3) ; "An air shaft protrudes from the wall above your head. It's covered by a vent grill."
				)
			)
			(4 ; Inventory
				(if (== invItem 4) ; Knife
					(cond
						(
							(and
								(or (IsFlag 29) (IsFlag 62))
								(== (DeltaurRegion egoStatus:) 0)
							)
							(gCurRoom setScript: cantReachIt)
						)
						((or (IsFlag 29) (IsFlag 62))
							(Print 54 4) ; "You can't reach the vent and besides, you don't need to climb through the vent now that you have a Sarien uniform on."
						)
						((not (not (vent cel:)))
							(Print 54 5) ; "The vent is already open."
						)
						((IsFlag 34)
							(Print 54 6) ; "Standing in the open trunk won't give you any height advantage."
						)
						((not (IsFlag 35))
							(gCurRoom setScript: cantReachIt)
						)
						(else
							(gCurRoom setScript: climbInVent)
						)
					)
				else
					(super doVerb: theVerb invItem)
				)
			)
			(3 ; Do
				(cond
					(
						(and
							(or (IsFlag 29) (IsFlag 62))
							(== (DeltaurRegion egoStatus:) 0)
						)
						(gCurRoom setScript: cantReachIt)
					)
					((or (IsFlag 29) (IsFlag 62))
						(Print 54 4) ; "You can't reach the vent and besides, you don't need to climb through the vent now that you have a Sarien uniform on."
					)
					((IsFlag 34)
						(Print 54 6) ; "Standing in the open trunk won't give you any height advantage."
					)
					((not (IsFlag 35))
						(gCurRoom setScript: cantReachIt)
					)
					((not (vent cel:))
						(gCurRoom setScript: egoTestVent)
					)
					(else
						(gCurRoom setScript: climbInVent)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance trunk of Prop
	(properties
		view 154
		loop 1
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 29)
			(ClearFlag 34)
		)
		(if (IsFlag 34)
			(self cel: (self lastCel:))
		)
		(if (IsFlag 35)
			(= x 104)
			(= y 115)
		else
			(= x 162)
			(= y 138)
		)
	)

	(method (doVerb theVerb invItem)
		(if (not (IsFlag 29))
			(switch theVerb
				(4 ; Inventory
					(if (== invItem 4) ; Knife
						(if (IsFlag 34)
							(gCurRoom setScript: closeTrunkScript)
						else
							(gCurRoom setScript: openTrunkScript)
						)
					else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(3 ; Do
					(cond
						((IsFlag 34)
							(gCurRoom setScript: egoClimbInTrunk)
						)
						((not (IsFlag 35))
							(gCurRoom setScript: pushTheTrunkScript)
						)
						(else
							(Print 54 7) ; "It's already moved."
						)
					)
				)
				(2 ; Look
					(if cel
						(Print 54 8) ; "The trunk on the floor appears to be open. It looks big enough to hold a body."
					else
						(Print 54 9) ; "The trunk is unremarkable in every way."
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		else
			(Print 54 10) ; "You don't need to mess with the trunk now."
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance guard of Actor
	(properties
		x 327
		y 223
		view 417
		cycleSpeed 3
		xStep 4
		moveSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self hide: setCycle: Walk setLoop: Grooper)
	)
)

(instance fromAirlock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc703_1)
				(= ticks 18)
			)
			(1
				(gEgo setMotion: MoveTo 98 153 self)
			)
			(2
				(SetScore 1 160)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fromHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc703_1)
				(= ticks 18)
			)
			(1
				(gEgo ignoreActors: 1 loop: 7 setMotion: MoveTo 227 160 self)
			)
			(2
				(gEgo ignoreActors: 0)
				(SetScore 1 160)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard setScript: 0)
				(= local0 0)
				(gEgo ignoreActors: 1 setMotion: MoveTo 267 177 self)
			)
			(1
				(gCurRoom newRoom: 61)
			)
		)
	)
)

(instance egoClimbInTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 35)
				(ClearFlag 34)
				(guard setScript: 0)
				(= local0 0)
				(if
					(and
						(== (gEgo x:) (trunk x:))
						(== (gEgo y:) (trunk y:))
					)
					(self changeState: 2)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (trunk x:) 6)
							(+ (trunk y:) 4)
							self
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo (trunk x:) (+ (trunk y:) 1) self)
			)
			(2
				(gLongSong fade: 0 5 30 1)
				(SetScore 3 163)
				(trunk startUpd: hide:)
				(gEgo
					view: 36
					loop: 1
					cycleSpeed: 12
					cel: 0
					y: (trunk y:)
					setCycle: End self
				)
			)
			(3
				(gSoundEffects number: 514 loop: 1 play:)
				(vent hide:)
				(gCurRoom drawPic: 99 7)
				(gLongSong2 number: 507 loop: 1 play: 0 fade: 127 5 30 0)
				(gEgo
					view: 51
					loop: 0
					x: (- (trunk x:) 1)
					cel: 0
					setPri: 15
					setStep: (* (gEgo xStep:) 3) (* (gEgo yStep:) 3)
					setCycle: Fwd
					setMotion: MoveTo 104 115 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 232 184 self)
			)
			(5
				(if (== (gEgo x:) 232)
					(gEgo setMotion: MoveTo 300 (- (gEgo y:) 40) self)
				else
					(gEgo setMotion: MoveTo 232 (- (gEgo y:) 40) self)
				)
			)
			(6
				(if (> (gEgo y:) 29)
					(-= state 2)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 50 23 self)
				)
			)
			(7
				(gEgo setMotion: JumpTo 153 188 self)
			)
			(8
				(gSoundEffects number: 526 loop: 1 play:)
				(gEgo setMotion: JumpTo 308 103 self)
			)
			(9
				(gSoundEffects play:)
				(gEgo setMotion: JumpTo 86 183 self)
			)
			(10
				(gSoundEffects play:)
				(gEgo setMotion: JumpTo 22 137 self)
			)
			(11
				(gSoundEffects play:)
				(gEgo setMotion: JumpTo 111 185 self)
			)
			(12
				(gSoundEffects play:)
				(gEgo setMotion: JumpTo 188 185 self)
			)
			(13
				(gSoundEffects play:)
				(gEgo setMotion: MoveTo 178 176 self)
			)
			(14
				(gEgo setMotion: MoveTo 289 141 self)
			)
			(15
				(gEgo setMotion: MoveTo 124 148 self)
			)
			(16
				(gEgo setMotion: MoveTo 222 110 self)
			)
			(17
				(gEgo setMotion: MoveTo 104 115 self)
			)
			(18
				(proc703_1)
				(gEgo
					loop: 7
					setStep: (/ (gEgo xStep:) 2) (/ (gEgo yStep:) 2)
				)
				(HandsOn)
				(gLongSong play: 0 fade: 127 25 10 0)
				(gLongSong2 fade:)
				(gCurRoom newRoom: 57)
			)
		)
	)
)

(instance climbInVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 36)
				(guard setScript: 0)
				(= local0 0)
				(HandsOff)
				(if
					(and
						(== (gEgo x:) (trunk x:))
						(== (gEgo y:) (trunk y:))
					)
					(self changeState: 2)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (trunk x:) 6)
							(+ (trunk y:) 4)
							self
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo (trunk x:) (+ (trunk y:) 1) self)
			)
			(2
				(gEgo
					setPri: (+ (trunk priority:) 1)
					view: 36
					y: (trunk y:)
					loop: 3
					cycleSpeed: 12
					cel: 0
					setCycle: End self
				)
			)
			(3
				(if (not (vent cel:))
					(self setScript: fiddleWithVent self)
				else
					(= ticks 18)
				)
			)
			(4
				(trunk startUpd: setPri: 2)
				(gEgo
					view: 37
					x: 97
					y: 96
					loop: 0
					cel: 0
					setPri: -1
					setCycle: End self
				)
			)
			(5
				(gEgo hide:)
				(= ticks 18)
			)
			(6
				(gCurRoom newRoom: 55)
				(self dispose:)
			)
		)
	)
)

(instance fiddleWithVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					cycleSpeed: 12
					loop: 4
					x: 97
					y: 96
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gSoundEffects number: 512 loop: 1 play:)
				(vent setCel: 1)
				(gEgo setCycle: CT 6 1)
				(= cycles (gEgo cycleSpeed:))
			)
			(2
				(vent setCel: 2)
				(gEgo setCel: 7)
				(= cycles (gEgo cycleSpeed:))
			)
			(3
				(vent setCel: 3)
				(gEgo setCel: 8)
				(= cycles (gEgo cycleSpeed:))
			)
			(4
				(vent setCel: 4)
				(= cycles (gEgo cycleSpeed:))
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance egoTestVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						(== (gEgo x:) (trunk x:))
						(== (gEgo y:) (trunk y:))
					)
					(self changeState: 2)
				else
					(gEgo setMotion: PolyPath 110 117 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 104 116 self)
			)
			(2
				(gEgo
					setPri: (+ (trunk priority:) 1)
					view: 36
					cycleSpeed: 12
					loop: 3
					y: (trunk y:)
					cel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(3
				(trunk show:)
				(gEgo loop: 4 x: 97 y: 96 cel: 5)
				(= register 0)
				(self cue:)
			)
			(4
				(gEgo setCycle: RangeOsc 5 5 6 self)
			)
			(5
				(Print 54 11) ; "Your hands by themselves are incapable of opening it."
				(gEgo
					posn: (trunk x:) (trunk y:)
					loop: 3
					setCel: 4
					setPri: -1
				)
				(self cue:)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(proc703_1)
				(gEgo loop: 7)
				(trunk show:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openVentScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(vent cycleSpeed: 12 setCycle: End self)
			)
			(1
				(HandsOn)
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance closeVentScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(vent setCycle: Beg self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openTrunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 34)
				(if
					(and
						(== (gEgo x:) (trunk x:))
						(== (gEgo y:) (trunk y:))
					)
					(self changeState: 2)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (trunk x:) 6)
							(+ (trunk y:) 4)
							self
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo (trunk x:) (+ (trunk y:) 1) self)
			)
			(2
				(trunk startUpd: hide:)
				(gSoundEffects number: 513 loop: 1 play:)
				(gEgo
					view: 36
					cycleSpeed: 12
					loop: 5
					y: (trunk y:)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo x: (- (trunk x:) 1) loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(trunk show: cel: 1 stopUpd:)
				(proc703_1)
				(gEgo x: (trunk x:) loop: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeTrunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 34)
				(if
					(and
						(== (gEgo x:) (trunk x:))
						(== (gEgo y:) (trunk y:))
					)
					(self changeState: 2)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (trunk x:) 6)
							(+ (trunk y:) 4)
							self
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo (trunk x:) (+ (trunk y:) 1) self)
			)
			(2
				(gSoundEffects number: 514 loop: 1 play:)
				(trunk startUpd: hide:)
				(gEgo
					view: 36
					setLoop: 0
					x: (- (trunk x:) 1)
					y: (trunk y:)
					cycleSpeed: 12
					cel: 4
					setCycle: Beg self
				)
			)
			(3
				(gEgo setLoop: 5 x: (trunk x:) cel: 2 setCycle: Beg self)
			)
			(4
				(trunk show: cel: 0 stopUpd:)
				(proc703_1)
				(gEgo loop: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pushTheTrunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 35)
				(if
					(and
						(== (gEgo x:) (trunk x:))
						(== (gEgo y:) (trunk y:))
					)
					(self changeState: 1)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (trunk x:) 3)
							(+ (trunk y:) 1)
							self
					)
				)
			)
			(1
				((gCurRoom obstacles:)
					delete: roomWithTrunkForwardPoly trunkPoly
				)
				(trunk startUpd: hide:)
				(gSoundEffects number: 515 loop: 1 play: hold: 1)
				(gEgo
					view: 36
					setLoop: 2
					x: (+ (trunk x:) 1)
					y: (trunk y:)
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 104 115 self
				)
			)
			(2
				(gSoundEffects stop: hold: 0)
				((gCurRoom obstacles:) add: roomWithTrunkBackPoly)
				(trunk x: 104 y: 115 show: stopUpd:)
				(proc703_1)
				(gEgo loop: 7)
				(= ticks 18)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cantReachIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 104 115 self)
			)
			(1
				(= register 3)
				(gEgo
					view: 36
					cel: 0
					loop: 4
					cycleSpeed: 9
					setCycle: CT 2 1 self
				)
			)
			(2
				(gEgo setCycle: RangeOsc 3 1 2 self)
			)
			(3
				(Print 54 12) ; "You feel a fresh breeze coming through the grill of the vent. If you were a lot taller, you could touch the grill itself."
				(gEgo setCycle: Beg self)
			)
			(4
				(proc703_1)
				(gEgo loop: 7)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbOutOfVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 36)
				(gEgo view: 37 loop: 1 cycleSpeed: 12 x: 111 y: 118)
				(if (not (IsFlag 36))
					(self setScript: openVentScript)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(SetScore 1 160)
				(HandsOn)
				(proc703_1)
				(gEgo loop: 2)
				(self dispose:)
			)
		)
	)
)

(instance killEgoTimeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(Print 54 13) ; "It sounds like someone (or something) is approaching."
				(= seconds 20)
			)
			(2
				(Print 54 14) ; "You hear footsteps approaching and they're getting close. You might only have seconds to do something!"
				(= seconds 10)
			)
			(3
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance killEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard show: setMotion: MoveTo 270 175 self)
			)
			(1
				(Face gEgo guard self)
			)
			(2
				(cond
					((& (gEgo onControl: 0) $0008)
						(guard setLoop: 1)
					)
					((& (gEgo onControl: 0) $0010)
						(guard setLoop: 3)
					)
					(else
						(guard setLoop: 5)
					)
				)
				(guard view: 415 cel: 0 setCycle: End self)
			)
			(3
				(gEgo
					view: 48
					setLoop: 1
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
			)
			(4
				(EgoDead 945 0 0 54 15) ; "Bingo! He got you. You might consider not being around when these guys are shooting. Those things hurt."
				(self dispose:)
			)
		)
	)
)

(instance ventShaft of RegionFeature
	(properties
		x 72
		y 42
		description {vent shaft}
		onMeCheck 8192
		lookStr {A large vent shaft protrudes from the left wall of the storage room.}
		level 2
	)
)

(instance shadows of RegionFeature
	(properties
		description {shadows}
		onMeCheck 4096
		lookStr {Various pipes, ducts and other innocuous pieces of equipment form pronounced shadows throughout the room.}
		level 2
	)
)

(instance airLock of RegionFeature
	(properties
		description {airlock}
		onMeCheck 2048
		lookStr {That is the way back to the airlock, which is completely sealed and inaccessable to you.}
		level 2
	)
)

(instance vaults of RegionFeature
	(properties
		x 190
		y 81
		description {storage vault}
		onMeCheck 16384
		lookStr {Two enormous storage vaults take up one whole wall of the room.}
		level 2
	)
)

(instance floor1 of RegionFeature
	(properties
		description {storage room}
		sightAngle 0
		onMeCheck 8
		level 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gCurRoom doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance floor2 of RegionFeature
	(properties
		description {storage room}
		sightAngle 0
		onMeCheck 16
		level 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gCurRoom doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance floor3 of RegionFeature
	(properties
		description {storage room}
		sightAngle 0
		onMeCheck 32
		level 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(gCurRoom doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

