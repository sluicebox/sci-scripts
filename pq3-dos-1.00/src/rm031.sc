;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use n882)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm031 0
)

(local
	local0
	local1
	local2
	[local3 12] = [73 173 82 158 114 161 122 170 116 179 106 181]
	[local15 18] = [181 180 189 160 174 145 180 137 201 136 218 99 272 110 239 189 206 189]
	[local33 18] = [0 0 319 0 319 38 319 108 305 105 291 42 288 36 109 23 0 127]
	[local51 12] = [0 143 112 27 288 43 290 48 113 32 0 153]
)

(instance rm031 of PQRoom
	(properties
		picture 31
		east -1
		south -1
	)

	(method (init)
		(poly1 points: @local3 size: 6)
		(poly2 points: @local15 size: 9)
		(poly3 points: @local33 size: 9)
		(poly4 points: @local51 size: 6)
		(polyList0 add: poly1 poly2 poly3)
		(polyList1 add: poly1 poly2 poly3 poly4)
		(self obstacles: polyList0)
		(if (== ((gInventory at: 32) owner:) 30) ; bronzeStar
			(star approachVerbs: 3 init:) ; Do
		)
		(phone init:)
		(keyShop init:)
		(armyShop init:)
		(lamp init:)
		(marieStall init:)
		(otherStores init:)
		(sidewalk init:)
		(gLongSong number: 913 loop: -1 vol: 80 init: play:)
		(LoadMany rsVIEW 384 5)
		(switch gPrevRoomNum
			(54
				(gEgo
					normal: 0
					view: 361
					loop: 4
					posn: 73 56
					setStep: 2 2
					init:
				)
				(self obstacles: polyList1)
				(SetFlag 196)
			)
			(else
				(HandsOff)
				(gEgo
					normal: 0
					view: 383
					loop: 7
					posn: 243 161
					cel: 11
					setPri: 10
					init:
				)
				(self setScript: exitCar)
				(if (>= global110 10)
					(patWalkToBooth start: 6)
					(pat view: 384 posn: 297 40)
				)
				(pat setScript: patWalkToBooth init:)
			)
		)
		(carDoor init:)
		(theCar init:)
		(ScriptID 882)
		(super init:)
		(blacktop init:)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp2 (gEgo onControl: 0))
		(if
			(and
				(not (gEgo inRect: 54 71 58 75))
				(gCast contains: zakInset)
			)
			(zakInset dispose:)
		)
		(cond
			(script 0)
			(
				(and
					(IsObject (gEgo mover:))
					((gEgo mover:) isKindOf: PolyPath)
					(== (gEgo view:) 361)
					(= temp0 ((gEgo mover:) finalX:))
					(= temp1 ((gEgo mover:) finalY:))
					(not (sidewalk onMe: temp0 temp1))
					(not (otherStores onMe: temp0 temp1))
					(not (phone onMe: temp0 temp1))
					(not (armyShop onMe: temp0 temp1))
					(not (keyShop onMe: temp0 temp1))
					(not (& (OnControl CONTROL temp0 temp1) $1000))
				)
				(self obstacles: polyList0)
				(gEgo setMotion: MoveTo temp0 temp1)
			)
			((& temp2 $0008)
				(HandsOff)
				(self obstacles: polyList0)
				(self setScript: goSouthEast)
			)
			((& temp2 $0800)
				(HandsOff)
				(self obstacles: polyList0)
				(self setScript: goSouth)
			)
			((& temp2 $0004)
				(HandsOff)
				(self obstacles: polyList0)
				(self setScript: goNorth)
			)
			((or (& temp2 $0002) (& temp2 $0200))
				(HandsOff)
				(self obstacles: polyList0)
				(self setScript: goEast)
			)
			((or (& temp2 $0010) (& temp2 $0080))
				(HandsOff)
				(self obstacles: polyList0)
				(self setScript: goWest)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(polyList0 dispose:)
		(polyList1 dispose:)
		(DisposeScript 882)
		(super dispose:)
	)
)

(instance patWalkToBooth of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (or (== state 3) (== state 4) (== state 5)) (pat isBlocked:))
			(gEgo x: (- (gEgo x:) 2) ignoreActors: 1)
			(pat x: (+ (pat x:) 2) ignoreActors: 1)
		)
		(if (and (>= state 10) (pat isBlocked:))
			(gEgo x: (- (gEgo x:) 2) ignoreActors: 1)
			(pat x: (+ (pat x:) 2) ignoreActors: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(ShowClock 1)
				(if (OneOf gDay 3 4 5)
					(= global105 17)
					(= global106 0)
				else
					(= global105 16)
					(= global106 0)
				)
			)
			(2
				(pat setCycle: Walk setMotion: MoveTo 206 100 self)
			)
			(3
				(pat
					view: 384
					loop: 2
					cel: 0
					setMotion: MoveTo 238 38 self
					setCycle: End self
				)
			)
			(4
				(ShowClock 0)
				(pat setLoop: 3 cel: 0 setCycle: End self)
			)
			(5 0)
			(6
				(pat
					setLoop: 4
					xStep: 2
					setCycle: Walk
					setMotion: MoveTo 297 40 self
				)
			)
			(7
				(pat ignoreActors: 1 setLoop: 6 cel: 0 setCycle: End self)
				(= local2 1)
			)
			(8
				(= seconds 60)
			)
			(9
				(= local2 0)
				(pat ignoreActors: 0 setCycle: Beg self)
			)
			(10
				(pat setLoop: 5 setCycle: Walk setMotion: MoveTo 238 38 self)
			)
			(11
				(pat
					setLoop: 0
					xStep: 3
					setMotion: MoveTo 206 105
					setCycle: End self
				)
			)
			(12
				(pat setLoop: 0 setLoop: 1 setCycle: End self)
			)
			(13
				(pat
					view: 20
					setLoop: -1
					setCycle: Walk
					cel: 7
					ignoreActors: 0
					setMotion: MoveTo 191 145 self
				)
			)
			(14
				(pat ignoreActors: 1)
				(SetFlag 196)
			)
		)
	)
)

(instance exitCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(carOpenSnd play:)
				(carDoor setCycle: End self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					normal: 1
					view: 5
					setCycle: Walk
					posn: 247 160
					setMotion: MoveTo 260 152 self
				)
			)
			(4
				(carDoor setCycle: Beg self)
			)
			(5
				(carCloseSnd play:)
				(= seconds 2)
			)
			(6
				(HandsOn)
				(gEgo cycleSpeed: (gEgo moveSpeed:) setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance enterCar of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (not (self script:)))
			(cond
				((& (gEgo onControl: 0) $0008)
					(self setScript: goSouthEast self)
				)
				((& (gEgo onControl: 0) $0800)
					(self setScript: goSouth self)
				)
				(
					(or
						(& (gEgo onControl: 0) $0002)
						(& (gEgo onControl: 0) $0200)
					)
					(self setScript: goEast self)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 361)
					(gCurRoom obstacles: polyList0)
				)
				(= cycles 5)
			)
			(1
				(if (== (gEgo view:) 361)
					(gEgo setMotion: PolyPath 260 152)
				else
					(= cycles 1)
				)
			)
			(2
				(HandsOff)
				(gEgo
					normal: 1
					view: 5
					setCycle: Walk
					setMotion: PolyPath 260 152 self
				)
			)
			(3
				(carOpenSnd play:)
				(carDoor setCycle: End self)
			)
			(4
				(gEgo
					normal: 0
					view: 383
					posn: 243 161
					cel: 0
					loop: 7
					setPri: 10
					setCycle: End self
				)
			)
			(5
				(carDoor setCycle: Beg self)
				(gLongSong fade:)
			)
			(6
				(carCloseSnd play:)
				(= global110 10)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance goNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (- (gEgo y:) 60))
				(gEgo
					normal: 0
					view: 360
					setLoop: 0
					cel: 0
					setCycle: End self
					setMotion: PolyPath (gEgo x:) register
				)
			)
			(1
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 361
					setLoop: 3
					setCycle: Walk
					setMotion: PolyPath (gEgo x:) register self
				)
			)
			(3
				(gEgo setMotion: 0 setLoop: -1)
				(gCurRoom obstacles: polyList1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (- (gEgo x:) 75))
				(gEgo
					normal: 0
					view: 360
					setLoop: 5
					cel: 0
					setCycle: End self
					setMotion: PolyPath register (- (gEgo y:) 25) self
				)
			)
			(1
				(gEgo view: 361 setLoop: 7)
				(if (not (gEgo cycler:))
					(gEgo setCycle: Walk)
				)
			)
			(2
				(gEgo setLoop: -1)
				(gCurRoom obstacles: polyList1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (+ (gEgo x:) 75))
				(gEgo
					normal: 0
					view: 360
					setLoop: 4
					cel: 0
					setCycle: End self
					setMotion: PolyPath register (+ (gEgo y:) 25) self
				)
			)
			(1
				(gEgo normal: 1 view: 5 setLoop: 4 setCycle: Walk)
				((gEgo head:) doit:)
			)
			(2
				(gEgo normal: 1 view: 5 setLoop: -1 setCycle: Walk)
				((gEgo head:) doit:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (+ (gEgo y:) 60))
				(gEgo
					normal: 0
					view: 360
					setLoop: 2
					cel: 0
					setCycle: End self
					setMotion: PolyPath (+ (gEgo x:) 5) register self
				)
			)
			(1
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					normal: 1
					view: 5
					setLoop: 2
					setCycle: Walk
					setMotion: PolyPath (+ (gEgo x:) 5) register self
				)
				((gEgo head:) doit:)
			)
			(3
				(gEgo normal: 1 view: 5 setLoop: -1 setCycle: Walk)
				((gEgo head:) doit:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goSouthEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					view: 360
					setLoop: 4
					cel: 0
					setCycle: End self
					setMotion: PolyPath 147 87
				)
			)
			(1
				(gEgo
					normal: 1
					view: 5
					setLoop: 4
					setCycle: Walk
					setMotion: PolyPath 147 87 self
				)
				((gEgo head:) doit:)
			)
			(2
				(gEgo normal: 1 view: 5 setLoop: -1 setCycle: Walk)
				((gEgo head:) doit:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goToArmy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 5)
					(gEgo setMotion: PolyPath 126 82 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== (gEgo view:) 5)
					(self setScript: goWest self)
				else
					(= cycles 1)
				)
			)
			(2
				(HandsOff)
				(gEgo setMotion: PolyPath 73 56 self)
				(gLongSong fade:)
			)
			(3
				(gCurRoom newRoom: 54)
				(self dispose:)
			)
		)
	)
)

(instance talkKeyScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 5)
					(gEgo setMotion: PolyPath 122 105 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== (gEgo view:) 5)
					(self setScript: goWest self)
				else
					(= cycles 1)
				)
			)
			(2
				(HandsOff)
				(gEgo setMotion: PolyPath 56 73 self)
			)
			(3
				(= save1 1)
				((gEgo head:) view: 361)
				(UnLoad 128 5)
				(zakInset init:)
				(zakMouth setCycle: RandCycle init:)
				(Say zakHead 31 0) ; "What can I do for you?"
				(= seconds 3)
			)
			(4
				(= save1 1)
				(Say zakHead 31 1) ; "Need a key made?"
				(= seconds 3)
			)
			(5
				(= save1 1)
				(Say zakHead 31 2) ; "I make keys for big locks, small locks, clocks, cars, tanks and banks. What do you need fella?"
				(= seconds 7)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(zakMouth dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getKeyScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(zakInset init:)
				(zakMouth setCycle: RandCycle init:)
				(cond
					((proc882_2 8)
						(Say zakHead 31 3) ; "What, you want another one? You got a family of ten moving in or what?"
						(= seconds 4)
					)
					((proc882_2 1)
						(Say zakHead 31 4) ; "Ah yes! No problem with this little jewel. I'll have a copy in a second."
						(= local0 1)
					)
					(else
						(Say zakHead 31 5) ; "Sorry, but this key says "Do Not Duplicate.""
						(= seconds 6)
					)
				)
				(= seconds 5)
			)
			(1
				(zakMouth dispose:)
				(if (or (proc882_2 1) (proc882_2 8))
					(zakHead cel: 1 forceUpd:)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(self setScript: moveHands self)
				else
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(zakInset dispose:)
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(zakHead cel: 0 forceUpd:)
				(= save1 1)
				(zakMouth setCycle: RandCycle init:)
				(Say zakHead 31 6) ; "Here you are fella, that'll be two fifty."
				(= seconds 5)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(zakMouth dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance payTheMan of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> ((gInventory at: 19) state:) 0) ; wallet
					(Print 31 7) ; "You give Zak his two dollars and fifty cents."
				)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(zakMouth setCycle: RandCycle init:)
				(if (> ((gInventory at: 19) state:) 0) ; wallet
					(Say zakHead 31 8) ; "Thanks buddy... Another day another two dollars and fifty cents."
					((gInventory at: 19) state: (- ((gInventory at: 19) state:) 1)) ; wallet, wallet
					(proc882_0 8)
					(SetScore 148 5)
					(= global105 17)
					(= global106 0)
				else
					(Say zakHead 31 9) ; "You what? No money? Do I look like an idiot to you? Get outta my shop!"
				)
				(= seconds 5)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(zakMouth dispose:)
				(zakInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cantDupeScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				((gEgo head:) view: 361)
				(UnLoad 128 5)
				(zakInset init:)
				(zakMouth setCycle: RandCycle init:)
				(if register
					(Say zakHead 31 10) ; "Sorry, this key says 'Do Not Duplicate' on it."
				else
					(Say zakHead 31 11) ; "What do you want me to do with that? I'm a KEY maker, for crying out loud."
				)
				(= seconds 7)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(zakMouth dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance moveHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(makeKeySnd play:)
				(zakHand posn: 47 159 setMotion: MoveTo 49 153 self init:)
				(= local1 0)
			)
			(1
				(zakHand moveSpeed: 5 setMotion: MoveTo 47 153 self)
			)
			(2
				(zakHand setMotion: MoveTo 51 153 self)
				(if (< local1 4)
					(= state 0)
					(++ local1)
				)
			)
			(3
				(zakHand setMotion: MoveTo 47 159 self)
				(makeKeySnd stop:)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance keyShop of Feature
	(properties
		onMeCheck 16384
		lookStr {That's the shop of "Zak" the keymaker.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: talkKeyScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance armyShop of Feature
	(properties
		onMeCheck 8192
		lookStr {That's the Army Recruiter's office.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: goToArmy)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance zakInset of Prop
	(properties
		x 47
		y 85
		description {Zak}
		lookStr {It's Zak the keymaker.}
		view 379
		priority 13
		signal 16401
	)

	(method (init)
		(super init:)
		(zakHead posn: (self x:) (self y:) init:)
		(zakTool posn: (+ (self x:) 1) (+ (self y:) 77) init:)
		(zakCover init:)
		(self stopUpd:)
	)

	(method (dispose)
		(super dispose:)
		(zakMouth dispose:)
		(zakCover dispose:)
		(zakTool dispose:)
		(zakHead dispose:)
		(zakHand dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(3 ; theKeys
						(HandsOff)
						(gCurRoom setScript: getKeyScript)
					)
					(19 ; wallet
						(if local0
							(HandsOff)
							(gCurRoom setScript: payTheMan)
						else
							(Print 31 12) ; "Just giving away money, Sonny?"
						)
					)
					(13 ; gunKey
						(HandsOff)
						(gCurRoom setScript: cantDupeScript 0 1)
					)
					(else
						(HandsOff)
						(gCurRoom setScript: cantDupeScript 0 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance zakHead of Prop
	(properties
		description {Zak}
		view 379
		loop 1
		priority 15
		signal 16401
	)
)

(instance zakHand of Actor
	(properties
		description {Zak}
		view 379
		loop 2
		priority 14
		signal 22545
		xStep 1
		moveSpeed 2
	)
)

(instance zakMouth of Prop
	(properties
		x 47
		y 85
		description {Zak}
		view 379
		loop 3
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance zakTool of Prop
	(properties
		description {Zak}
		view 379
		cel 1
		priority 15
		signal 16401
	)
)

(instance zakCover of Prop
	(properties
		x 107
		y 160
		description {Zak}
		view 379
		cel 2
		priority 15
		signal 16401
	)
)

(instance sonnyInset of Prop ; UNUSED
	(properties
		x 47
		y 182
		description {Sonny}
		view 26
		priority 15
		signal 16401
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(sonnyMouth
			posn: (+ (self x:) 1) (self y:) 36
			setCycle: RandCycle
			init:
		)
		(sonnyEyes
			posn: (self x:) (+ (self y:) 20)
			z: 20
			setScript: sonnyEyesScript
			init:
		)
	)

	(method (dispose)
		(super dispose:)
		(sonnyEyes setScript: 0 dispose:)
		(sonnyMouth dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 26
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyEyes of Prop
	(properties
		description {Sonny}
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance sonnyEyesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 5)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance phone of Feature
	(properties
		x 300
		y 21
		nsTop 15
		nsLeft 298
		nsBottom 27
		nsRight 309
		lookStr {It's a public telephone.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 31 13) ; "You don't have the correct change."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		x 67
		y 120
		onMeCheck 4992
		lookStr {It's a very LARGE streetlamp.}
	)
)

(instance marieStall of Feature
	(properties
		x 149
		y 139
		onMeCheck 1024
		lookStr {Marie's car was parked here during her attack.}
	)
)

(instance blacktop of Feature
	(properties
		lookStr {The parking lot blacktop.}
	)

	(method (init)
		(super init:)
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			($0044 ; direction | evKEYBOARD
				(if (== (gEgo view:) 361)
					(gCurRoom obstacles: polyList0)
				)
				((User alterEgo:) handleEvent: event)
			)
		)
	)
)

(instance otherStores of Feature
	(properties
		onMeCheck 64
		lookStr {Some of the mall's stores are undergoing renovation.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 31 14) ; "That store is closed."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sidewalk of Feature
	(properties
		x 107
		y 24
		onMeCheck 4128
		lookStr {Sidewalks connect the store fronts.}
	)
)

(instance pat of Actor
	(properties
		x 196
		y 145
		description {Zak}
		view 20
		loop 3
		signal 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if local2
					(Print 31 15) ; "Morales is making a phone call."
				else
					(Print 31 16) ; "That's Officer Pat Morales, your partner."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theCar of View
	(properties
		x 238
		y 158
		lookStr {You look fondly at your car.}
		view 383
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: enterCar)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carDoor of Prop
	(properties
		x 238
		y 158
		lookStr {You look fondly at your car.}
		view 383
		loop 1
		priority 11
		signal 16401
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: enterCar)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carOpenSnd of Sound
	(properties
		number 900
	)
)

(instance carCloseSnd of Sound
	(properties
		number 901
	)
)

(instance makeKeySnd of Sound
	(properties
		number 961
		loop -1
	)
)

(instance polyList0 of List
	(properties)
)

(instance polyList1 of List
	(properties)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties)
)

(instance star of Prop
	(properties
		x 167
		y 165
		approachX 171
		approachY 167
		lookStr {You spot an object laying on the ground.}
		view 378
		loop 2
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 31 17) ; "You retrieve the bronze star."
				(gEgo get: 32) ; bronzeStar
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

