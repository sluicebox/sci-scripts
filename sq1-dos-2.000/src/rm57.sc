;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use RangeOsc)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm57 0
	helmet 1
)

(local
	[local0 60] = [319 172 287 169 257 153 306 138 271 124 256 129 223 134 178 115 134 128 117 115 166 96 142 85 135 88 137 93 130 96 114 94 107 97 129 108 85 121 56 110 52 118 40 116 27 120 148 184 173 184 220 168 258 189 0 189 0 0 319 0]
	[local60 56] = [319 172 287 169 257 153 306 138 271 124 256 129 226 135 153 107 158 93 142 85 135 88 137 93 130 96 114 94 107 97 129 108 85 121 56 110 52 118 40 116 27 120 148 184 173 184 220 168 258 189 0 189 0 0 319 0]
	[local116 50] = [319 172 287 169 257 153 306 138 271 124 256 129 223 134 178 115 134 128 117 115 165 107 161 92 142 85 135 88 137 93 52 118 40 116 27 120 148 184 173 184 220 168 258 189 0 189 0 0 319 0]
	[local166 46] = [319 172 287 169 257 153 306 138 271 124 256 129 226 135 153 107 158 93 142 85 135 88 137 93 62 116 52 118 40 116 27 120 148 184 173 184 220 168 258 189 0 189 0 0 319 0]
	local212
	local213
)

(instance rm57 of Rm
	(properties
		lookStr {This room is similar to the storage room, with a large machine installed in one bulkhead.}
		picture 57
		east 66
	)

	(method (init)
		(SetFlag 62)
		(self setRegions: 703) ; DeltaurRegion
		(HandsOff)
		(= global166 2)
		(LoadMany rsVIEW 37 36 157 417 85 418 39 1 61 2)
		(LoadMany rsSOUND 403 514 513 506 508 528 529 536 538)
		(sarien init:)
		(vent init:)
		(washerDoor init:)
		(switch gPrevRoomNum
			(55
				(gEgo view: 37 loop: 1 posn: 111 118)
			)
			(54
				(SetFlag 29)
				(ClearFlag 34)
				(SetFlag 35)
				(Load rsSOUND 403)
				(trunk init: hide: ignoreActors: 1 stopUpd:)
				(gEgo posn: (trunk x:) (trunk y:))
			)
			(else
				(gEgo posn: 270 177)
			)
		)
		(super init:)
		(if (!= (gLongSong number:) 538)
			(gLongSong number: 538 loop: -1 play:)
		)
		(gFeatures
			add: ventShaft shadows floor2 floor3 floor4 washerFeature
			eachElementDo: #init
			doit:
		)
		(gEgo init: hide:)
		(if (IsFlag 29)
			(openPoly points: @local0 size: 31)
			(closedPoly points: @local60 size: 28)
		else
			(openPoly points: @local116 size: 25)
			(closedPoly points: @local166 size: 23)
		)
		(if (== (DeltaurRegion egoStatus:) 0)
			(LoadMany rsVIEW 479 417 48)
		)
		(if (!= (DeltaurRegion egoStatus:) 0)
			(scraps init:)
		else
			(helmet
				init:
				setScript: killEgoTimeOut
				setPri: (- (washerDoor priority:) 1)
			)
		)
		(if (IsFlag 69)
			(self addObstacle: openPoly)
		else
			(self addObstacle: closedPoly)
		)
		(switch gPrevRoomNum
			(55
				(gEgo show:)
				(gCurRoom setScript: climbOutOfVent)
			)
			(54
				(gCurRoom setScript: egoClimbOutTrunk)
			)
			(else
				(gEgo show:)
				(gCurRoom setScript: walkInRoom)
			)
		)
	)

	(method (doit)
		(cond
			(script 0)
			(local212
				(self setScript: (ScriptID 157 0)) ; killEgo
			)
			((& (gEgo onControl: 0) $0002)
				(self setScript: walkOutRoom)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance openPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance closedPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance trunk of Prop
	(properties
		x 104
		y 115
		lookStr {On the floor sits the trunk you rode here in.}
		view 154
		loop 1
		cycleSpeed 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 57 0) ; "It's served its purpose already."
			)
			(2 ; Look
				(Print 57 1) ; "On the floor sits the trunk you rode here in."
			)
			(11 ; Taste
				(Print 57 2) ; "You don't need to mess with the trunk now."
			)
			(12 ; Smell
				(Print 57 2) ; "You don't need to mess with the trunk now."
			)
			(4 ; Inventory
				(Print 57 2) ; "You don't need to mess with the trunk now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vent of Prop
	(properties
		x 92
		y 49
		lookStr {This is the protruding terminus of the vent shaft by which you entered.}
		view 154
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 37)
			(self setCel: (self lastCel:))
		)
		(self stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 37)
					(Print 57 3) ; "The vent grill is open. Its pattern, however, is permanently engraved upon your memory and your foot."
				else
					(Print 57 4) ; "This is another vent grill."
				)
			)
			(4 ; Inventory
				(if (== invItem 4) ; Knife
					(cond
						((!= (DeltaurRegion egoStatus:) 0)
							(Print 57 5) ; "You don't need to bother with the vent now."
						)
						((not (IsFlag 29))
							(gCurRoom setScript: cantReachIt)
						)
						((not (not (vent cel:)))
							(Print 57 6) ; "The vent is already open."
						)
						(else
							(gCurRoom setScript: egoTestVent)
						)
					)
				else
					(super doVerb: theVerb invItem)
				)
			)
			(3 ; Do
				(cond
					((!= (DeltaurRegion egoStatus:) 0)
						(Print 57 5) ; "You don't need to bother with the vent now."
					)
					((not (IsFlag 29))
						(gCurRoom setScript: cantReachIt)
					)
					((not (vent cel:))
						(gCurRoom setScript: egoTestVent)
					)
					(else
						(Print 57 6) ; "The vent is already open."
					)
				)
			)
			(11 ; Taste
				(Print 57 7) ; "Ahh! You've apparently acquired a taste for dust. I'll bet you're going to miss it when the game is over."
			)
			(12 ; Smell
				(Print 57 8) ; "It only makes you sneeze."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance washerDoor of Prop
	(properties
		x 176
		y 82
		lookStr {Behind the glass door of the machine, you can see a helmet that has been carelessly left inside after the dry cycle.}
		view 157
		loop 1
		priority 8
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 69)
			(washerDoor setCel: (washerDoor lastCel:))
		)
		(washerDoor stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== (DeltaurRegion egoStatus:) 0)
					(Print 57 9) ; "Behind the glass door of the machine, you can see a load of dirty Sarien uniform components."
				else
					(Print 57 10) ; "In the machine area are your old duds. Good thing you got rid of them. You'd be awfully conspicuous in them."
				)
			)
			(3 ; Do
				(cond
					((not (IsFlag 69))
						(gCurRoom setScript: openWasherDoor)
					)
					((== (DeltaurRegion egoStatus:) 0)
						(gCurRoom setScript: getInWasher)
					)
					(else
						(Print 57 11) ; "No way would you consider repeating the experience."
					)
				)
			)
			(11 ; Taste
				(Print 57 12) ; "See the nose message."
			)
			(12 ; Smell
				(Print 57 13) ; "You're doing it again - clicking cursors on things to get funny messages. Stop that - this is a serious game!"
			)
			(4 ; Inventory
				(Print 57 14) ; "That proves unfulfilling."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance scraps of View
	(properties
		x 191
		y 118
		nsTop 100
		nsBottom 135
		approachX 180
		approachY 119
		view 157
		loop 2
		signal 16384
	)

	(method (init)
		(= cel (if (gEgo has: 19) 1 else 0)) ; Sarien_ID_Card
		(super init: &rest)
		(self approachVerbs: 3 2 11 12) ; Do, Look, Taste, Smell
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (scraps cel:)
					(Print 57 15) ; "You don't need those. When, or should I say if, you get home, you can buy some new ones."
				else
					(gCurRoom setScript: getId)
				)
			)
			(2 ; Look
				(if (scraps cel:)
					(Print 57 16) ; "Old fabris softener sheets rest on the floor here."
				else
					(Print 57 17) ; "Old fabris softener sheets rest on the floor here. Hey! There's an ID card there also."
				)
			)
			(11 ; Taste
				(Print 57 18) ; "Your tongue is now wrinkle and static free."
			)
			(12 ; Smell
				(Print 57 19) ; "They smell spring fresh."
			)
			(4 ; Inventory
				(Print 57 20) ; "That of no use."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sarien of Actor
	(properties
		x 278
		y 181
		view 417
		loop 1
		cycleSpeed 3
		moveSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self stopUpd: hide: ignoreActors: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 57 21) ; "You can't do that from in here."
			)
			(2 ; Look
				(if (== (sarien view:) 418)
					(Print 57 22) ; "Now, this is truly unpleasant. You're definitely seeing more than you want to. Check out those incredibly ugly boxers!"
				else
					(Print 57 23) ; "Uh, oh! It's one of those Sarien dudes you saw on the Arcada monitors. You might be in deep stuff now."
				)
			)
			(11 ; Taste
				(Print 57 21) ; "You can't do that from in here."
			)
			(12 ; Smell
				(Print 57 21) ; "You can't do that from in here."
			)
			(4 ; Inventory
				(Print 57 21) ; "You can't do that from in here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance helmet of Actor
	(properties
		x 210
		y 94
		lookStr {helmet}
		view 157
		loop 3
		signal 16384
		cycleSpeed 6
		moveSpeed 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((not (IsFlag 69))
						(gCurRoom setScript: openWasherDoor)
					)
					((== (DeltaurRegion egoStatus:) 0)
						(gCurRoom setScript: getInWasher)
					)
					(else
						(Print 57 24) ; "There's no need to go through that again!"
					)
				)
			)
			(2 ; Look
				(Print 57 25) ; "Another helmet sits in the washer."
			)
			(11 ; Taste
				(Print 57 26) ; "Ugh! It tastes like detergent."
			)
			(12 ; Smell
				(Print 57 27) ; "You see a hint of scaley dandruff."
			)
			(4 ; Inventory
				(Print 57 28) ; "That's not helpful."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ventShaft of RegionFeature
	(properties
		description {vent shaft}
		onMeCheck 8192
		lookStr {A large vent shaft protrudes from the left wall of the laundry room.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 57 29) ; "You can't do anything to it."
			)
			(2 ; Look
				(Print 57 30) ; "A large vent shaft protrudes from the left wall of the laundry room."
			)
			(11 ; Taste
				(Print 57 31) ; "That's not a good idea."
			)
			(12 ; Smell
				(Print 57 31) ; "That's not a good idea."
			)
			(4 ; Inventory
				(Print 57 31) ; "That's not a good idea."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shadows of RegionFeature
	(properties
		description {shadows}
		onMeCheck 4096
		lookStr {Various pipes, ducts and other innocuous pieces of equipment form pronounced shadows throughout the room.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 57 32) ; "It's just a shadow."
			)
			(2 ; Look
				(Print 57 33) ; "Various pipes, ducts and other innocuous pieces of equipment form pronounced shadows throughout the room."
			)
			(11 ; Taste
				(Print 57 32) ; "It's just a shadow."
			)
			(12 ; Smell
				(Print 57 32) ; "It's just a shadow."
			)
			(4 ; Inventory
				(Print 57 32) ; "It's just a shadow."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor2 of RegionFeature
	(properties
		description {storage room}
		onMeCheck 16
		lookStr {This room is similar to the storage room, with a large machine installed in one bulkhead.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 57 34) ; "The floor's nice and shiny. Even if it wasn't, you don't have the spare to work on it."
			)
			(2 ; Look
				(Print 57 35) ; "The floor's nice and shiny."
			)
			(11 ; Taste
				(Print 57 36) ; "Just what you thought - waxey build-up. You'd be ashamed if you were in charge of this floor."
			)
			(12 ; Smell
				(Print 57 37) ; "It smells waxey."
			)
			(4 ; Inventory
				(Print 57 38) ; "No result is forthcoming."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor3 of RegionFeature
	(properties
		description {storage room}
		onMeCheck 32
		lookStr {This room is similar to the storage room, with a large machine installed in one bulkhead.}
		level 2
	)

	(method (doVerb theVerb)
		(floor2 doVerb: theVerb)
	)
)

(instance floor4 of RegionFeature
	(properties
		description {storage room}
		onMeCheck 64
		lookStr {This room is similar to the storage room, with a large machine installed in one bulkhead.}
		level 2
	)

	(method (doVerb theVerb)
		(floor2 doVerb: theVerb)
	)
)

(instance washerFeature of RegionFeature
	(properties
		description {washing machine}
		onMeCheck 16384
		lookStr {This is almost certainly a cheap Sarien knock-off of the genuine Cleanse-O-Matic Rinse 'n Dip used to launder the crew uniforms aboard the Arcada.}
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((not (IsFlag 69))
						(gCurRoom setScript: openWasherDoor)
					)
					((== (DeltaurRegion egoStatus:) 0)
						(gCurRoom setScript: getInWasher)
					)
					(else
						(Print 57 24) ; "There's no need to go through that again!"
					)
				)
			)
			(2 ; Look
				(Print 57 39) ; "This is almost certainly a cheap Sarien knock-off of the genuine Cleanse-O-Matic Rinse 'n Dip used to launder the crew uniforms aboard the Arcada."
			)
			(11 ; Taste
				(Print 57 40) ; "Quit goofing off and do something useful!"
			)
			(12 ; Smell
				(Print 57 41) ; "A faint miasma of Hijax liquid detergent hovers in the air near the machine."
			)
			(4 ; Inventory
				(Print 57 42) ; "That's of no help."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoClimbOutTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(trunk
					startUpd:
					show:
					view: 36
					loop: 1
					x: 103
					cycleSpeed: 6
					cel: 12
				)
				(= ticks 18)
			)
			(1
				(gSoundEffects number: 513 loop: 1 play:)
				(trunk setCycle: Beg self)
			)
			(2
				(trunk loop: 0 x: (- (trunk x:) 1) cel: 4 setCycle: Beg self)
			)
			(3
				(trunk x: 104 loop: 5 cel: 2 setCycle: Beg self)
			)
			(4
				(gSoundEffects number: 514 loop: 1 play:)
				(trunk view: 154 loop: 1 stopUpd: cel: 0)
				(vent stopUpd:)
				(gEgo show:)
				(proc703_1)
				(gEgo setHeading: 0 self)
			)
			(5
				(gSoundEffects number: 536 loop: 1 flags: 1 play:)
				(gEgo setHeading: 180 self)
			)
			(6
				(gEgo setHeading: 0 self)
			)
			(7
				(gEgo setHeading: 180 self)
			)
			(8
				(gEgo
					view: 32
					setLoop: 2
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 110 126 self
				)
			)
			(9
				(proc703_1)
				(gEgo setHeading: 180 self)
			)
			(10
				(gEgo setHeading: 0 self)
			)
			(11
				(gEgo setHeading: 90 self)
			)
			(12
				(gEgo
					view: 32
					setLoop: 0
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 146 130 self
				)
			)
			(13
				(proc703_1)
				(gEgo setHeading: 180 self)
			)
			(14
				(gEgo setHeading: 0 self)
			)
			(15
				(gEgo setHeading: 270 self)
			)
			(16
				(gEgo
					view: 32
					setLoop: 1
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 134 148 self
				)
			)
			(17
				(gEgo
					view: 32
					cycleSpeed: 18
					setLoop: 4
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(18
				(gSoundEffects number: 403 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(19
				(Print 57 43) ; "Whoa... what a ride!"
				(gEgo
					view: 32
					setLoop: 5
					posn: 112 158
					cel: 0
					setCycle: End self
				)
			)
			(20
				(gEgo view: 32 setLoop: 6 cel: 0 setCycle: End self)
			)
			(21
				(gSoundEffects fade: flags: 0)
				(gLongSong number: 538 loop: -1 play: 30 fade: 127 25 10 0)
				(proc703_1)
				(gEgo loop: 4)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getId of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 85 loop: 0 cel: 0 get: 19 setCycle: CT 4 1 self) ; Sarien_ID_Card
			)
			(2
				(scraps setCel: 1)
				(SetScore 2 175)
				(= ticks 18)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(proc703_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getInWasher of Script
	(properties)

	(method (doit)
		(super doit:)
		(if register
			(if (and (> register 1) (not (helmet mover:)))
				(helmet
					setMotion:
						DPath
						185
						94
						201
						76
						223
						103
						202
						106
						189
						71
						181
						92
						210
						81
						223
						99
				)
			)
			(if (!= local213 (gEgo cel:))
				(= local213 (gEgo cel:))
				(gSoundEffects number: 506 loop: 1 play: 127)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local212 0)
				(helmet setScript: 0)
				(HandsOff)
				(= register 0)
				(gEgo setMotion: PolyPath 185 127 self)
			)
			(1
				(gEgo setMotion: MoveTo 191 118 self)
			)
			(2
				(gEgo view: 39 loop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(3
				(gEgo setPri: 6 setCycle: End self)
				(helmet setPri: 6)
			)
			(4
				(washerDoor setCycle: Beg self)
			)
			(5
				(gSoundEffects number: 528 loop: 1 play:)
				(= seconds 3)
			)
			(6
				(Print 57 44) ; "Uh, oh! You hear someone coming."
				(sarien
					show:
					startUpd:
					x: 278
					y: 181
					view: 417
					loop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 196 141 self
				)
			)
			(7
				(sarien
					view: 418
					loop: 0
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
			)
			(8
				(gSoundEffects number: 529 loop: 1 play:)
				(sarien loop: 1 cel: 0 setCycle: CT 2 1)
				(washerDoor cel: 0 setCel: 1)
				(= ticks 18)
			)
			(9
				(sarien setCycle: CT 5 1 self)
			)
			(10
				(washerDoor setCycle: Beg)
				(= seconds 2)
			)
			(11
				(sarien setCycle: End self)
				(gSoundEffects number: 528 loop: 1 play:)
			)
			(12
				(= register 1)
				(gEgo
					loop: 2
					view: 39
					cycleSpeed: 30
					x: 210
					y: 97
					setCycle: Fwd
				)
				(sarien
					setLoop: 2
					x: 210
					y: 144
					cycleSpeed: 3
					cel: 5
					setCycle: Fwd
					setMotion: MoveTo 283 184 self
				)
			)
			(13
				(sarien dispose:)
				(= seconds 3)
			)
			(14
				(gEgo cycleSpeed: 7 setCycle: Fwd)
				(= seconds 3)
			)
			(15
				(helmet
					setStep: 10 6
					moveSpeed: 1
					setPri: 5
					setLoop: 3
					cycleSpeed: 0
					setCycle: Fwd
					setMotion:
						DPath
						185
						94
						201
						76
						223
						103
						202
						106
						189
						71
						181
						92
						210
						81
						223
						99
				)
				(= register 2)
				(gEgo cycleSpeed: 1 setCycle: Fwd)
				(= seconds 6)
			)
			(16
				(helmet dispose:)
				(= register 1)
				(gEgo cycleSpeed: 7 setCycle: Fwd)
				(= seconds 4)
			)
			(17
				(gEgo cycleSpeed: 30 setCycle: Fwd)
				(= seconds 3)
			)
			(18
				(= register 0)
				(gEgo setCycle: 0)
				(= seconds 2)
			)
			(19
				(gEgo
					x: 191
					y: 118
					cycleSpeed: 6
					loop: 3
					cel: 0
					setPri: 6
					setCycle: 0
				)
				(gSoundEffects number: 528 loop: 1 play:)
				(washerDoor setCycle: End self)
			)
			(20
				(gEgo setCel: 1)
				(= cycles (gEgo cycleSpeed:))
			)
			(21
				(gEgo setPri: -1 setCycle: End self)
			)
			(22
				(gEgo loop: 4 cel: 0 setCycle: End self)
				(SetScore 5 164)
			)
			(23
				(Print 57 45) ; "Darn static cling! Hey, look at that! By the most amazing stroke of luck, you've traded in your extremely conspicuous Xenon space suit for a Sarien officer's uniform complete with helmet."
				(SetFlag 65)
				(if (gEgo has: 0) ; Cartridge
					(Print 57 46) ; "Searching the pockets of your newly found disguise, you find the number of possessions you were packing has been greatly reduced. In fact, lost in that limbo void to where socks and baseballs disappear is everything but the data cartridge."
				else
					(Print 57 47) ; "Searching the pockets of your newly found disguise, you find the number of possessions you were packing has been greatly reduced. In fact, everything was lost in that limbo void to where socks and baseballs disappear except one lucky buckazoid."
				)
				(for ((= temp0 1)) (< temp0 19) ((++ temp0))
					(gEgo put: temp0)
				)
				(gEgo get: 19) ; Sarien_ID_Card
				(gEgo put: 19 57) ; Sarien_ID_Card
				(if (not (gEgo has: 0)) ; Cartridge
					(gEgo get: 10) ; buckazoid
					(= gBuckazoidCount 1)
				)
				(scraps init:)
				(DeltaurRegion egoStatus: 1)
				(proc703_1)
				(gEgo loop: 4)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openWasherDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 69)
				(gEgo setMotion: PolyPath 192 140 self)
			)
			(1
				(gEgo
					view: 39
					loop: 0
					cel: 0
					x: 192
					y: 141
					setCycle: CT 5 1 self
				)
			)
			(2
				(gSoundEffects number: 529 loop: 1 play:)
				(gEgo setCycle: End)
				(washerDoor startUpd: cel: 0 setCycle: End self)
			)
			(3
				(proc703_1)
				(gEgo loop: 6 setHeading: 45)
				((gCurRoom obstacles:) delete: closedPoly)
				((gCurRoom obstacles:) add: openPoly)
				(washerDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkInRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 7 ignoreActors: 1 setMotion: MoveTo 230 158 self)
			)
			(1
				(gEgo ignoreActors: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkOutRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: MoveTo 270 177 self)
			)
			(1
				(gCurRoom newRoom: 66)
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
				(vent setCycle: End self)
			)
			(1
				(vent stopUpd:)
				(HandsOn)
				(client cue:)
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
				(gEgo view: 37 loop: 1 x: 111 y: 118)
				(if (not (IsFlag 37))
					(self setScript: openVentScript)
				else
					(self cue:)
				)
				(SetFlag 37)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
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
				(Print 57 48) ; "It sounds like someone is approaching this room!"
				(= seconds 20)
			)
			(2
				(Print 57 49) ; "You hear footsteps approaching. You only have seconds to do something!"
				(= seconds 10)
			)
			(3
				(= local212 1)
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
				(trunk ignoreActors: 1)
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
				(gEgo setMotion: MoveTo 104 115 self)
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
				(gEgo loop: 4 x: 97 y: 96 cel: 5)
				(= register 0)
				(= ticks 18)
			)
			(4
				(gEgo setCycle: RangeOsc 5 5 6 self)
			)
			(5
				(Print 57 50) ; "This vent is shut tight. You don't think anything short of kicking it from the other side could get it open."
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
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(2
				(gEgo setCycle: RangeOsc 3 1 2 self)
			)
			(3
				(Print 57 51) ; "You can't seem to reach the vent from here"
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

