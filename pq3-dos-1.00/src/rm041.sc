;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm041 0
)

(local
	local0
	local1
	local2
	[local3 18] = [48 133 87 116 131 129 309 65 309 72 319 68 319 113 294 100 129 163]
	[local21 40] = [0 0 319 0 319 46 319 57 304 63 291 67 244 83 234 84 209 78 187 85 182 95 164 99 155 107 159 111 133 121 106 113 88 111 66 119 32 109 0 123]
	[local61 10] = [214 81 240 89 224 93 208 95 189 87]
	[local71 10] = [0 142 71 180 69 189 0 189 0 0]
	local81
	local82
	local83
)

(instance rm041 of PQRoom
	(properties
		picture 41
		east -1
		south -1
		west -1
	)

	(method (init)
		(super init:)
		(= global129 3)
		(= global130 9)
		(= global131 25)
		(= global132 0)
		(= global133 100)
		(streetFX init: play:)
		(gLongSong number: 410 flags: 1 loop: -1 play:)
		(LoadMany rsVIEW 246 25 448 446 490)
		(gEgo view: 5 setStep: 3 2 setLoop: -1 normal: 1 posn: 19 148 init:)
		(poly1 points: @local3 size: 9)
		(poly2 points: @local21 size: 20)
		(polyGroceryCart points: @local61 size: 5)
		(polyCar points: @local71 size: 4)
		(self addObstacle: poly1 poly2 polyCar)
		(car init:)
		(warehouse init:)
		(truck init:)
		(pipe init:)
		(trash init:)
		(trashBin init:)
		(light init:)
		(if (== ((gInventory at: 2) owner:) 41) ; handcuff
			(groceryCart setPri: 6 posn: 138 116 init:)
		)
		(if (== gPrevRoomNum 10)
			(newsPaper init:)
			(= global105 16)
			(= global106 30)
			(bagLady view: 449 setCycle: Walk posn: -15 126 init:)
			(HandsOff)
			(gCurRoom setScript: returnToHome)
		)
		(if (IsFlag 4)
			(HandsOn)
			(groceryCart init:)
			(self addObstacle: polyGroceryCart)
			(bagLady
				cycleSpeed: (gEgo cycleSpeed:)
				moveSpeed: (gEgo moveSpeed:)
				ignoreActors: 1
				init:
			)
			(proc0_17 30)
			(bagLady setScript: bagLadyAsleep)
		else
			(newsPaper init:)
		)
	)

	(method (dispose)
		(DisposeScript 939)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $0020)
				(HandsOff)
				(self setScript: walkDownStairs)
			)
			((& (gEgo onControl: 1) $4000)
				(HandsOff)
				(self setScript: walkUpStairs)
			)
		)
		(super doit: &rest)
	)
)

(instance walkDownStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: (- (gEgo x:) 12) (+ (gEgo y:) 11)
					view: 445
					normal: 0
					setLoop: 0
					cel: 0
					setPri: 10
					setCycle: End self
				)
				(= local81 0)
			)
			(1
				(gEgo
					posn: (- (gEgo x:) 13) (gEgo y:)
					view: 5
					normal: 1
					setLoop: 7
					setCycle: Walk
				)
				(= cycles 1)
			)
			(2
				(gEgo
					setMotion:
						PolyPath
						(- (gEgo x:) 28)
						(- (gEgo y:) 3)
						self
				)
			)
			(3
				(gEgo setPri: -1 setLoop: -1)
				(= cycles 1)
			)
			(4
				(if local82
					(self setScript: getInCar self)
				else
					(= cycles 1)
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkUpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Walk setMotion: PolyPath 63 126 self)
			)
			(1
				(gEgo
					posn: (+ (gEgo x:) 9) (+ (gEgo y:) 1)
					view: 445
					normal: 0
					setLoop: 1
					cel: 0
					setPri: 10
					setCycle: End self
				)
				(= local81 1)
			)
			(2
				(gEgo
					posn: (+ (gEgo x:) 13) (- (gEgo y:) 9)
					view: 5
					normal: 1
					setLoop: 4
					setCycle: Walk
				)
				(= cycles 1)
			)
			(3
				(gEgo
					setMotion:
						PolyPath
						(+ (gEgo x:) 22)
						(+ (gEgo y:) 6)
						self
				)
			)
			(4
				(gEgo setLoop: -1 setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance blwalkDownStairs of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bagLady setMotion: PolyPath 88 114 self)
			)
			(1
				(bagLady
					posn: (- (bagLady x:) 13) (+ (bagLady y:) 8)
					view: 448
					setLoop: 5
					cel: 0
					setPri: 9
					setCycle: End self
				)
			)
			(2
				(bagLady
					posn: (+ (bagLady x:) 1) (- (bagLady y:) 1)
					view: 449
					setLoop: 7
					setCycle: Walk
				)
				(= cycles 1)
			)
			(3
				(bagLady
					setMotion:
						PolyPath
						(- (bagLady x:) 35)
						(- (bagLady y:) 2)
						self
				)
			)
			(4
				(bagLady setPri: -1 setLoop: -1)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(bagLady
			cycleSpeed: (gEgo cycleSpeed:)
			moveSpeed: (gEgo moveSpeed:)
		)
		(super doit:)
	)
)

(instance blwalkUpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bagLady setCycle: Walk setMotion: PolyPath 63 126 self)
			)
			(1
				(bagLady
					posn: (+ (bagLady x:) 9) (+ (bagLady y:) 1)
					view: 448
					setLoop: 4
					cel: 0
					setPri: 10
					setCycle: End self
				)
				(= local81 1)
			)
			(2
				(bagLady
					posn: (+ (bagLady x:) 13) (- (bagLady y:) 9)
					view: 449
					setLoop: 4
					setCycle: Walk
				)
				(= cycles 1)
			)
			(3
				(bagLady
					setMotion:
						PolyPath
						(+ (bagLady x:) 22)
						(+ (bagLady y:) 6)
						self
				)
			)
			(4
				(bagLady setLoop: -1 setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance getInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if
					(or
						(== ((gInventory at: 2) owner:) 41) ; handcuff
						(not (gCast contains: bagLady))
					)
					(= cycles 1)
				else
					(Print 41 0) ; "You're determined not to leave with out this witness. She may be your only real lead to who attacked Marie."
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(if local81
					(= local82 1)
					(gEgo setMotion: PolyPath 84 116 self)
				else
					(= state 6)
					(= cycles 1)
				)
			)
			(3
				(gEgo
					posn: (- (gEgo x:) 12) (+ (gEgo y:) 11)
					view: 445
					normal: 0
					setLoop: 0
					cel: 0
					setPri: 10
					setCycle: End self
				)
				(= local81 0)
			)
			(4
				(gEgo
					posn: (- (gEgo x:) 13) (gEgo y:)
					view: 5
					normal: 1
					setLoop: 7
					setCycle: Walk
				)
				(= cycles 1)
			)
			(5
				(gEgo
					setMotion:
						PolyPath
						(- (gEgo x:) 28)
						(- (gEgo y:) 3)
						self
				)
			)
			(6
				(gEgo setPri: -1 setLoop: -1)
				(= cycles 1)
			)
			(7
				(gEgo setMotion: PolyPath 19 155 self)
			)
			(8
				(gLongSong fade:)
				(= seconds 1)
			)
			(9
				(gEgo setScript: 0)
				(= global134 1)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance cuffGroceryCart of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local81)
					(self setScript: walkUpStairs self)
				else
					(= cycles 1)
				)
			)
			(1
				(= local0 4)
				(HandsOff)
				(gEgo setMotion: PolyPath 232 87 self)
			)
			(2
				(Face gEgo groceryCart self)
			)
			(3
				(= local1 1)
				(groceryCart startUpd:)
				(gEgo
					view: 446
					setLoop: 0
					cel: 0
					setMotion: MoveTo 154 112 self
				)
			)
			(4
				(= local1 0)
				(gEgo
					normal: 0
					posn: (- (gEgo x:) 4) (- (gEgo y:) 2)
					view: 447
					cel: 0
					setCycle: End self
				)
				(groceryCart setPri: -1 stopUpd:)
			)
			(5
				(cuffsOnSound init: play:)
				(gEgo put: 2 41) ; handcuff
				(SetScore 140 5)
				(= cycles 5)
			)
			(6
				(NormalEgo 5 1)
				(Print 41 1) ; "You decide to soothe the old gal by securing her cart with your handcuffs."
				(= cycles 1)
			)
			(7
				(self setScript: bagLadyGetsUp self)
			)
			(8
				(= save1 1)
				(insetBagLadyStand init:)
				(Say insetBagLadyStand 41 2) ; "That's the ticket, Sonny Boy! Let's go!"
				(= seconds 8)
				(= local82 0)
			)
			(9
				(insetBagLadyStand dispose:)
				(gEgo setMotion: MoveTo 160 113 self)
			)
			(10
				(Face gEgo car)
				(bagLady setMotion: PolyPath 201 101 self)
				(bagLadyMusic fade:)
				(gLongSong fade:)
			)
			(11
				(HandsOn)
				(ClearFlag 4)
				(= global134 1)
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance bagLadyGetsUp of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bagLady setCycle: End self)
			)
			(1
				(bagLady loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(bagLady
					view: 449
					posn: (+ (bagLady x:) 3) (- (bagLady y:) 4)
					setCycle: SyncWalk
					loop: 2
					cel: 2
				)
				(newsPaper init:)
				(= cycles 10)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance bagLadyPeeks of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bagLady setCycle: CT 4 1 self)
			)
			(1
				(rustleSound dispose:)
				(insetBagLady init:)
				(bagLadyMusic play:)
				(= seconds 1)
			)
			(2
				(= save1 1)
				(Say insetBagLady 41 3) ; "What? Who... Who's that? Whadya want?"
				(= seconds 5)
			)
			(3
				(= local0 2)
				(insetBagLady dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance randomTalkBagLady of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 41 4) ; "You try to convince the bag lady to go with you, but she's adamant."
				(= save1 1)
				(insetBagLady init:)
				(switch (Random 0 2)
					(0
						(Say insetBagLady 41 5) ; "The last time I left my cart alone for two seconds, I had a year's worth of Cosmo stolen!"
					)
					(1
						(Say insetBagLady 41 6) ; "I ain't goin' nowhere without my cart, now. Do you know how tough it is to find one with wheels that don't wobble?"
					)
					(2
						(Say insetBagLady 41 7) ; "You can ask me all you want, Mr. Police Man. Unless ya wanna drag me kickin' an screamin', you ain't gettin' me ta leave my cart unguarded!"
					)
				)
				(= seconds 12)
			)
			(1
				(insetBagLady dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bagLadyAsleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ShowClock 1)
				(= seconds 5)
			)
			(1
				(HandsOn)
				(ShowClock 0)
				(= cycles 1)
			)
			(2 0)
			(3
				(bagLady loop: 2 setCycle: Osc 5 self)
			)
			(4
				(Print 41 8) ; "The pile of newspapers rustles alarmingly."
				(bagLady loop: 0)
				(rustleSound play:)
				(= local0 1)
				(bagLady setScript: bagLadyPeeks)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (== state 2) (& (gEgo onControl: 1) $0010))
			(self cue:)
		)
		(super doit:)
	)
)

(instance remarkBagLady of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(insetBagLady init:)
				(Say insetBagLady 41 9) ; "Who the hell are you? I don't talk to no strangers."
				(= seconds 6)
			)
			(1
				(insetBagLady dispose:)
				(self dispose:)
			)
		)
	)
)

(instance gotoBagLady of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local81)
					(self setScript: walkUpStairs self)
				else
					(= cycles 1)
				)
			)
			(1
				(bagLadyAsleep dispose:)
				(= local0 2)
				(HandsOff)
				(gEgo setMotion: PolyPath 241 90 self)
			)
			(2
				(Face gEgo bagLady self)
			)
			(3
				(bagLady setScript: bagLadyPeeks)
				(self dispose:)
			)
		)
	)
)

(instance identifyWithWallet of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local81)
					(self setScript: walkUpStairs self)
				else
					(= cycles 1)
				)
			)
			(1
				(= local0 3)
				(HandsOff)
				(gEgo setMotion: PolyPath 241 90 self)
			)
			(2
				(Face gEgo bagLady self)
				(SetScore 139 3)
			)
			(3
				(= save1 1)
				(insetEgo init:)
				(Say insetEgo 41 10) ; "Ma'am, I'm Detective Sonny Bonds of the Lytton Police Department."
				(= seconds 10)
			)
			(4
				(= save1 1)
				(insetBagLady init:)
				(insetEgo dispose:)
				(Say insetBagLady 41 11) ; "Yea, so what cha want from me? I ain't done nothin' to nobody!"
				(= seconds 8)
			)
			(5
				(= save1 1)
				(insetBagLady dispose:)
				(insetEgo init:)
				(Say insetEgo 41 12) ; "You called and said you saw something at the Oak Tree Mall last night. I'd like you to come downtown with me and help us out, maybe give us a description."
				(= seconds 15)
			)
			(6
				(= save1 1)
				(insetEgo dispose:)
				(insetBagLady init:)
				(Say insetBagLady 41 13) ; "Ooh! I'd love ta go ridin' in one of them real life squad cars. Okay! Just help me put my stuff in the car."
				(= seconds 10)
			)
			(7
				(= save1 1)
				(insetEgo init:)
				(insetBagLady dispose:)
				(Say insetEgo 41 14) ; "Ma'am, I'm sorry but there's not enough room in the trunk for your cart. You'll have to leave it here."
				(= seconds 10)
			)
			(8
				(= save1 1)
				(insetEgo dispose:)
				(insetBagLady init:)
				(Say insetBagLady 41 15) ; "What?! Leave my STUFF? Ooh, nooo! I can't very well just up and leave my STUFF."
				(= seconds 10)
			)
			(9
				(insetBagLady dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance returnToHome of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 28 144 self)
				(ShowClock 1)
			)
			(1
				(bagLady setMotion: MoveTo 11 129 self)
			)
			(2
				(bagLady setScript: blwalkUpStairs self)
			)
			(3
				(bagLady setMotion: PolyPath 234 77 self)
			)
			(4
				(Face bagLady gEgo self)
			)
			(5
				(ShowClock 0)
				(= save1 1)
				(insetBagLadyStand init:)
				(if (== ((gInventory at: 2) owner:) 41) ; handcuff
					(Say insetBagLadyStand 41 16) ; "Well, bless your heart. My cart is still safe."
				else
					(Say insetBagLadyStand 41 17) ; "Thanks for the sandwich."
				)
				(= seconds 7)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetBagLadyStand dispose:)
				(bagLady setMotion: PolyPath 309 74 self)
			)
			(7
				(SetFlag 90)
				(HandsOn)
				(bagLady dispose:)
				(self dispose:)
			)
		)
	)
)

(instance getCuffs of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local81)
					(self setScript: walkUpStairs self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 154 112 self)
			)
			(2
				(Face gEgo groceryCart)
				(= cycles 4)
			)
			(3
				(gEgo
					normal: 0
					posn: (- (gEgo x:) 4) (- (gEgo y:) 2)
					view: 447
					cel: 0
					setCycle: End self
				)
				(cuffsOnSound init: play:)
				(= local83 1)
			)
			(4
				(NormalEgo 5 1)
				(Print 41 18) ; "You retrieve your cuffs."
				(gEgo get: 2) ; handcuff
				(SetScore 143 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance insetBagLady of View
	(properties
		x 261
		y 167
		view 450
		priority 15
		signal 16401
	)

	(method (dispose)
		(bagLadyFace dispose:)
		(bagLadyEyes setScript: 0 dispose:)
		(super dispose:)
	)

	(method (init)
		(bagLadyFace
			posn: (+ (self x:) 2) (- (self y:) 33)
			setCycle: RandCycle
			init:
		)
		(bagLadyEyes
			posn: (+ (self x:) 2) (- (self y:) 55)
			setScript: bBlinkEyes
			init:
		)
		(self stopUpd:)
		(super init:)
	)
)

(instance bagLadyFace of Prop
	(properties
		view 450
		loop 1
		priority 15
		signal 16401
		cycleSpeed 10
	)
)

(instance bagLadyEyes of Prop
	(properties
		view 450
		loop 2
		priority 15
		signal 16401
	)
)

(instance bBlinkEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(bagLadyEyes cel: 1)
				(= cycles 4)
			)
			(2
				(bagLadyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance insetBagLadyStand of View
	(properties
		x 66
		y 96
		view 246
		priority 14
		signal 16401
	)

	(method (dispose)
		(bagLadyFaceS dispose:)
		(super dispose:)
	)

	(method (init)
		(bagLadyFaceS
			posn: (+ (self x:) 1) (- (self y:) 37)
			setCycle: RandCycle
			init:
		)
		(self stopUpd:)
		(super init:)
	)
)

(instance bagLadyFaceS of Prop
	(properties
		view 246
		loop 1
		priority 15
		signal 16401
		cycleSpeed 10
	)
)

(instance insetEgo of View
	(properties
		x 266
		y 124
		view 25
		priority 14
		signal 16401
	)

	(method (dispose)
		(egoFace dispose:)
		(sonnyShirt dispose:)
		(sonnyEyes setScript: 0 dispose:)
		(super dispose:)
	)

	(method (init)
		(egoFace posn: x y setCycle: RandCycle init:)
		(sonnyShirt posn: (+ (self x:) 3) (+ (self y:) 61) init:)
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
		(self stopUpd:)
		(super init:)
	)
)

(instance egoFace of Prop
	(properties
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 10
	)
)

(instance sonnyShirt of View
	(properties
		description {Sonny}
		view 25
		cel 1
		priority 15
		signal 16401
	)
)

(instance sonnyEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 4)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance bagLady of Actor
	(properties
		x 234
		y 77
		view 448
		signal 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(switch local0
					(0
						(self setScript: gotoBagLady)
					)
					(2
						(Print 41 19) ; "You move to place a hand on the bag lady's arm and she draws away in horror. She obviously hates being touched."
					)
					(3
						(Print 41 20) ; "Manhandling the bag lady is not going to solve anything. She's not likely to help you if she's angry."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(5 ; Talk
				(switch local0
					(0
						(self setScript: gotoBagLady)
					)
					(2
						(gCurRoom setScript: remarkBagLady)
					)
					(3
						(self setScript: randomTalkBagLady)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(2 ; Look
				(switch local0
					(0
						(Print 41 21) ; "The shape of that pile of newspapers looks vaguely familiar."
					)
					(else
						(Print 41 22) ; "As you look closely at the bag lady, you realize that she's not nearly as old as you first thought. The streets have a way of making all of the homeless look old and used up."
						(= local2 1)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(19 ; wallet
						(switch local0
							(2
								(self setScript: identifyWithWallet)
							)
							(0
								(if local2
									(Print 41 23) ; "She's asleep. Why don't you try it when she's awake?"
								else
									(Print 41 24) ; "Showing your badge to a bundle of newspapers is pretty useless."
								)
							)
							(1
								(Print 41 25) ; "She's still waking up, she doesn't see your ID."
							)
							(else
								(Print 41 26) ; "Showing her your badge again doesn't make her any more impressed."
							)
						)
					)
					(2 ; handcuff
						(Print 41 27) ; "You only need handcuffs to restrain a suspect, not a witness."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance newsPaper of View
	(properties
		x 234
		y 77
		view 448
		loop 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 41 28) ; "The pile of grungy newspapers is empty now."
			)
			(3 ; Do
				(Print 41 29) ; "You ought not to disturb the old woman's... uh... bed."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(self setPri: 4 ignoreActors: 1)
	)
)

(instance groceryCart of Prop
	(properties
		x 216
		y 91
		view 446
		loop 1
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch local0
					(0
						(Print 41 30) ; "The rusty shopping cart is loaded down with junk."
					)
					(else
						(if local83
							(Print 41 31) ; "Carla's shopping cart is loaded down with her treasures and memories."
						else
							(Print 41 32) ; "The rusty shopping cart is loaded down with the old woman's treasures and memories."
						)
					)
				)
			)
			(3 ; Do
				(if (== ((gInventory at: 2) owner:) 41) ; handcuff
					(HandsOff)
					(gCurRoom setScript: getCuffs)
				else
					(switch local0
						(3
							(Print 41 33) ; "It wouldn't fit in your car."
						)
						(0
							(if local83
								(Print 41 34) ; "Carla needs her cart more than you do."
							else
								(Print 41 35) ; "The cart probably belongs to a homeless person.  They need that stuff more than you do."
							)
						)
						(else
							(Print 41 36) ; "I think the bag lady would be irritated if you took off with her cart."
						)
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 2) ; handcuff
					(if (== local0 3)
						(bagLady setScript: cuffGroceryCart)
					else
						(Print 41 37) ; "You have no reason to do that right now."
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if local1
			(self
				signal: (| (self signal:) $0010)
				priority: (+ (gEgo priority:) 1)
				x: (- (gEgo x:) 16)
				y: (+ (gEgo y:) 4)
			)
		)
		(super doit:)
	)
)

(instance car of View
	(properties
		y 189
		view 490
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 41 38) ; "You look fondly at your car."
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: getInCar)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance carDoor of Prop ; UNUSED
	(properties
		view 490
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb &rest)
	)
)

(instance warehouse of Feature
	(properties
		x 162
		y 53
		onMeCheck 128
		lookStr {This is the loading docks of a warehouse.}
	)
)

(instance truck of Feature
	(properties
		x 313
		y 63
		onMeCheck 8192
		lookStr {There's a company truck parked here.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 41 39) ; "Use your car if you want to leave."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pipe of Feature
	(properties
		x 136
		y 97
		onMeCheck 4096
		lookStr {There's a large, sturdy water pipe here.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 41 40) ; "What do you want to do with the pipe?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trash of Feature
	(properties
		x 168
		y 87
		onMeCheck 2048
		lookStr {The loading docks is littered with trash.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 41 41) ; "Nice thought, but you don't have time to clean up the place."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trashBin of Feature
	(properties
		x 12
		y 83
		onMeCheck 1024
		lookStr {It's a large trash bin for the warehouse.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 41 42) ; "There's nothing you need in the trash bin. Leave that stuff for the garbage collector."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 159
		y 25
		onMeCheck 512
		lookStr {There's a lamp on the loading docks, probably to discourage break-ins.}
	)
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

(instance polyGroceryCart of Polygon
	(properties
		type PBarredAccess
	)
)

(instance polyCar of Polygon
	(properties
		type PBarredAccess
	)
)

(instance cuffsOnSound of Sound
	(properties
		number 918
	)
)

(instance streetFX of Sound
	(properties
		number 913
		loop -1
	)
)

(instance rustleSound of Sound
	(properties
		number 412
		loop -1
	)
)

(instance bagLadyMusic of Sound
	(properties
		flags 1
		number 411
		loop -1
	)
)

