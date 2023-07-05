;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use eRS)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm58 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 38] = [33 160 12 172 28 183 63 171 85 187 117 185 93 171 93 140 59 124 95 105 123 121 125 144 152 127 95 94 53 117 46 111 36 116 41 126 21 140]
	[local46 20] = [33 160 12 172 28 183 63 171 85 187 117 185 93 171 93 140 50 116 21 140]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ (gEgo x:) 11))
	(= temp1 (- (gEgo y:) 30))
	(if (& (gEgo onControl: 0) $0008)
		(= temp2 (- (robot x:) 29))
		(= temp3 (- (robot y:) 15))
	else
		(= temp2 (- (robot x:) 33))
		(= temp3 (- (robot y:) 32))
	)
	(if (< temp1 temp3)
		(= temp1 temp3)
	)
	(Graph grDRAW_LINE temp1 temp0 temp3 temp2 12 15 -1)
	(Graph grUPDATE_BOX 86 0 189 209 1)
)

(instance rm58 of SQRoom
	(properties
		picture 58
		style 3
	)

	(method (init)
		(self setRegions: 703) ; DeltaurRegion
		(= global166 2)
		(LoadMany rsVIEW 158 40 91 460 519 76 67 461)
		(LoadMany rsTEXT 158)
		(LoadMany rsSOUND 524 523)
		(HandsOff)
		(= local1 1)
		(pOpenPoly points: @local8 size: 19)
		(pClosedPoly points: @local46 size: 10)
		(self addObstacle: pClosedPoly)
		(gFeatures
			add: storeRoom shadows counterTop openning
			eachElementDo: #init
		)
		(robot init: setPri: 8)
		(if (not (gEgo has: 12)) ; Pulseray_Laser_Pistol
			(DeltaurRegion timesShownID: 0)
		)
		(switch (DeltaurRegion numGrenades:)
			(1
				(grenade2 init:)
			)
			(2
				(grenade1 init:)
				(grenade2 init:)
			)
		)
		(gEgo posn: 1 189 init:)
		(panel init: stopUpd:)
		(super init: &rest)
		(self setScript: fromGeneratorRoom)
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(Print 58 0) ; "Rows of weapons on the wall tell you that you are in the Deltaur's Weapons Dispensary. There is a service droid behind the weapons counter."
		)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(self setScript: warnEgo)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(<= 68 (gEgo x:) 159)
					(<= 83 (gEgo y:) 119)
					(!= (gEgo priority:) 5)
				)
				(gEgo setPri: 5)
			)
			(
				(and
					(or
						(< (gEgo x:) 68)
						(> (gEgo x:) 159)
						(< (gEgo y:) 83)
						(> (gEgo y:) 119)
					)
					(& (gEgo signal:) $0010)
				)
				(gEgo setPri: -1)
			)
			((and (!= script bugEgo) script) 0)
			((and local1 local0 (not local3))
				(HandsOff)
				(= local3 1)
			)
			((& (gEgo onControl: 0) $0002)
				(self setScript: toGeneratorRoom)
			)
			((& (gEgo onControl: 0) $0010)
				(if (robot script:)
					(robot setScript: 0)
				)
				(self setScript: shootEgo1)
			)
		)
		(super doit:)
	)
)

(instance pOpenPoly of Polygon
	(properties
		type PContainedAccess
	)
)

(instance pClosedPoly of Polygon
	(properties
		type PContainedAccess
	)
)

(instance grenade1 of View
	(properties
		x 117
		y 84
		view 158
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local0
					(rm58 setScript: egoPickUpGrenade)
				else
					(Print 58 1) ; "You can't get that from here."
				)
			)
			(2 ; Look
				(Print 58 2) ; "It looks like a gas grenade."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grenade2 of View
	(properties
		x 125
		y 88
		view 158
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local0
					(rm58 setScript: egoPickUpGrenade)
				else
					(Print 58 1) ; "You can't get that from here."
				)
			)
			(2 ; Look
				(Print 58 2) ; "It looks like a gas grenade."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance panel of Prop
	(properties
		x 58
		y 94
		nsTop 78
		nsLeft 48
		view 158
		loop 1
		priority 4
		signal 16400
		cycleSpeed 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if local0
					(rm58 setScript: egoWalksUnderOut)
				else
					(rm58 setScript: egoWalksUnderIn)
				)
			)
			(4 ; Inventory
				(if (== invItem 12) ; Pulseray_Laser_Pistol
					(gCurRoom setScript: warnEgo)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(2 ; Look
				(Print 58 3) ; "It's a counter panel capable of opening to allow passage behind the counter."
			)
			(11 ; Taste
				(Print 58 4) ; "Naw. Bad idea."
			)
			(12 ; Smell
				(Print 58 4) ; "Naw. Bad idea."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance junk of Actor
	(properties
		view 158
		signal 16384
		cycleSpeed 5
		moveSpeed 3
	)
)

(instance robot of Actor
	(properties
		x 135
		y 164
		yStep 4
		view 460
		loop 4
		cel 4
		cycleSpeed 15
		xStep 8
		moveSpeed 15
	)

	(method (init)
		(super init: &rest)
		(if (== (DeltaurRegion egoStatus:) 1)
			(self view: 460 loop: 4 cel: 4)
		else
			(self view: 461 setLoop: 1 cel: 2 setPri: 8)
		)
	)

	(method (cue)
		(droidWalkSound stop:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 58 5) ; "A robot serves behind the counter. Its appearance is that of a plain and unintelligent droid. But then, looks can be deceiving as in your case."
			)
			(5 ; Talk
				(if (not script)
					(droidWalkSound number: 523 loop: -1 flags: 1 play:)
					(switch
						(if (< (++ local5) 4)
							local5
						else
							(= local5 4)
						)
						(1
							(robotT
								init: ; "You carbon based life forms are soooo annoying. My counterpart at Ulence Flats on Kerona told me about this one pesky humanoid in a grungy blue space suit who just kept pestering him. Oh why does commiting genocide seem such a good idea right now."
									robotBust
									robotMouth
									robotEyes
									158
									0
									0
									1
									self
							)
						)
						(2
							(robotT
								init: ; "Go away, I'm not talking to you."
									robotBust
									robotMouth
									robotEyes
									158
									1
									0
									1
									self
							)
						)
						(3
							(robotT
								init: ; "I'm not talking to you."
									robotBust
									robotMouth
									robotEyes
									158
									2
									0
									1
									self
							)
						)
						(4
							(robotT
								init: ; "I'm still not talking to you."
									robotBust
									robotMouth
									robotEyes
									158
									3
									0
									1
									self
							)
						)
					)
				else
					(Print 58 6) ; "The droid is to busy to chitchat."
				)
			)
			(4 ; Inventory
				(cond
					((not script)
						(switch invItem
							(12 ; Pulseray_Laser_Pistol
								(gCurRoom setScript: warnEgo)
							)
							(19 ; Sarien_ID_Card
								(rm58 setScript: egoShowsCard)
							)
							(0 ; Cartridge
								(Print 58 7) ; "I really have no idea why you feel I'd want to waste my enormous brain power contemplating a common data cartridge. You really are a dim-witted lifeform, aren't you?"
							)
							(else
								(super doVerb: theVerb invItem &rest)
							)
						)
					)
					((== invItem 12) ; Pulseray_Laser_Pistol
						(gCurRoom setScript: warnEgo)
					)
					(else
						(Print 58 8) ; "The droid is too busy."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== view 460)
				cycler
				local1
				(!= local6 cel)
				(or
					(and (<= loop 1) (OneOf cel 0 4))
					(and (>= 3 loop 2) (OneOf cel 3 7))
				)
			)
			(droidStepSound number: 524 loop: 1 play:)
		)
		(= local6 cel)
	)
)

(instance storeRoom of RegionFeature
	(properties
		x 200
		y 54
		description {store room}
		onMeCheck 512
		level 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch (DeltaurRegion numGrenades:)
					(0
						(Print 58 9) ; "This is a storeroom where a great deal of the Deltaur's weaponry is kept. Various other weapons are firmly secured to the exterior of the small structure."
					)
					(1
						(Print 58 10) ; "This is a storeroom where a great deal of the Deltaur's weaponry is kept. Various other weapons are firmly secured to the exterior of the small structure. On the counter, in front of the storeroom, is a loose gas grenade."
					)
					(2
						(Print 58 11) ; "This is a store room where a great deal of the Deltaur's weapons are kept. Various other weapons are firmly secured to the exterior of the small structure. On the counter, in front of the storeroom, are two loose gas grenades."
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 12) ; Pulseray_Laser_Pistol
					(gCurRoom setScript: warnEgo)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance counterTop of RegionFeature
	(properties
		x 133
		y 170
		onMeCheck 1024
		level 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 58 12) ; "That yields no result."
			)
			(2 ; Look
				(Print 58 13) ; "This is a long S-shaped counter top that runs from one end of the armory to the other. At one end there is an opening, probably used to allow access to the other side of the counter."
			)
			(11 ; Taste
				(Print 58 14) ; "It tastes very mica-like."
			)
			(12 ; Smell
				(Print 58 15) ; "It smells like you'd expect a counter to smell."
			)
			(4 ; Inventory
				(if (== invItem 12) ; Pulseray_Laser_Pistol
					(gCurRoom setScript: warnEgo)
				else
					(Print 58 16) ; "That doesn't help."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openning of Feature
	(properties
		x 74
		y 98
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if local0
					(rm58 setScript: egoWalksUnderOut)
				else
					(rm58 setScript: egoWalksUnderIn)
				)
			)
			(4 ; Inventory
				(if (== invItem 12) ; Pulseray_Laser_Pistol
					(gCurRoom setScript: warnEgo)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(2 ; Look
				(Print 58 17) ; "It's a counter panel capable of opening to allow passage behind the counter."
			)
			(11 ; Taste
				(Print 58 18) ; "Funny, no taste."
			)
			(12 ; Smell
				(Print 58 19) ; "It smells void."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance shadows of RegionFeature
	(properties
		onMeCheck 4096
		level 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 58 20) ; "It's just a shadow."
			)
			(2 ; Look
				(Print 58 21) ; "Various pipes, ducts and other innocuous pieces of equipment form pronounced shadows throughout the room."
			)
			(11 ; Taste
				(Print 58 20) ; "It's just a shadow."
			)
			(12 ; Smell
				(Print 58 20) ; "It's just a shadow."
			)
			(4 ; Inventory
				(if (== invItem 12) ; Pulseray_Laser_Pistol
					(gCurRoom setScript: warnEgo)
				else
					(Print 58 22) ; "You can't do anything to or with a shadow."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance robotT of Talker
	(properties
		x 10
		y 7
		nsTop 15
		nsLeft 228
		view 519
	)
)

(instance robotBust of View
	(properties
		view 519
		cel 1
	)
)

(instance robotMouth of Prop
	(properties
		nsTop 44
		nsLeft 19
		view 519
		loop 2
		cycleSpeed 12
	)
)

(instance robotEyes of Prop
	(properties
		nsTop 22
		nsLeft 7
		view 519
		loop 1
		cycleSpeed 30
	)
)

(instance fromGeneratorRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 6 setHeading: 45 setMotion: MoveTo 61 162 self)
			)
			(1
				(if (!= (DeltaurRegion egoStatus:) 1)
					(gCurRoom setScript: shootEgo2)
				else
					(= ticks 18)
				)
			)
			(2
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(robotT init: robotBust robotMouth robotEyes 158 4 0 0 self) ; "Oh... welcome to the Weapons Dispensary, I guess. I've got an IQ of 5000 but they feel I'm only good enough to fetch weapons, like some whimpering puppy dog."
			)
			(3
				(robotT init: robotBust robotMouth robotEyes 158 5 0 1 self) ; "You'll have to show me your ID card so I can scurry off and fetch your weapon. Why they don't just wire me into the ship's systems - so I would know who you are without an ID card - is beyond even my supreme intellect."
			)
			(4
				(droidWalkSound stop:)
				(gCurRoom setScript: bugEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shootEgo1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 90)
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(robot
					show:
					posn: 191 83
					view: 461
					setLoop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 241 118 self
				)
			)
			(1
				(droidWalkSound stop:)
				(junk
					init:
					cycleSpeed: 210
					posn: 239 75
					view: 461
					loop: 3
					setCycle: Fwd
				)
				(robotHead init: setCycle: End)
				(if (& (gEgo onControl: 0) $0008)
					(robot setLoop: 2 cel: 0 setCycle: CT 1 1 self)
				else
					(robot setLoop: 2 cel: 0 setCycle: CT 2 1 self)
				)
			)
			(2
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(robotT init: robotBust robotMouth robotEyes 158 6 0 1 self) ; "Oh dear, you carbon-based life forms can be soooo annoying. Even something with your incredibly low intelligence should know enough not to enter a restricted area. I guess I'll just have to destroy you to prevent you from reproducing more of your kind."
			)
			(3
				(droidWalkSound stop:)
				(= local4 (Graph grSAVE_BOX 86 0 189 209 1))
				(= ticks 18)
			)
			(4
				(gEgo stopUpd:)
				(localproc_0)
				(= seconds 1)
			)
			(5
				(gEgo startUpd:)
				(gSoundEffects number: 312 loop: 1 play:)
				(robot setCycle: End self)
			)
			(6
				(gSoundEffects number: 368 loop: 1 play:)
				(gEgo view: 67 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(Graph grRESTORE_BOX local4)
				(Graph grUPDATE_BOX 86 0 189 209 1)
				(= seconds 5)
			)
			(8
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

(instance shootEgo2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 90 self)
			)
			(1
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(robot setCycle: Rev setMotion: MoveTo 159 150 self)
			)
			(2
				(droidWalkSound stop:)
				(junk
					init:
					posn: (- (robot x:) 1) (- (robot y:) 42)
					cycleSpeed: 210
					view: 461
					loop: 3
					setCycle: Fwd
				)
				(if (& (gEgo onControl: 0) $0008)
					(robot setLoop: 2 cel: 0 setCycle: CT 1 1 self)
				else
					(robot setLoop: 2 cel: 0 setCycle: CT 2 1 self)
				)
			)
			(3
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(robotT init: robotBust robotMouth robotEyes 158 7 0 1 self) ; "Oh dear... another intruder. If it isn't fetching weapons for so-and-so or checking ID cards, its vaporizing bothersome simians."
			)
			(4
				(droidWalkSound stop:)
				(= local4 (Graph grSAVE_BOX 86 0 189 209 1))
				(= ticks 18)
			)
			(5
				(gEgo stopUpd:)
				(localproc_0)
				(= seconds 2)
			)
			(6
				(gSoundEffects number: 312 loop: 1 play:)
				(robot setCycle: End self)
			)
			(7
				(gEgo startUpd:)
				(gSoundEffects number: 368 loop: 1 play:)
				(gEgo view: 67 loop: 2 cel: 0 setCycle: End self)
			)
			(8
				(Graph grRESTORE_BOX local4)
				(Graph grUPDATE_BOX 86 0 189 209 1)
				(= seconds 5)
			)
			(9
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

(instance toGeneratorRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 1 189 self)
			)
			(1
				(gCurRoom newRoom: 64)
			)
		)
	)
)

(instance robotWalksToRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(robot
					setLoop: 2
					cel: 1
					cycleSpeed: 15
					moveSpeed: 15
					setCycle: Walk
					setMotion: MoveTo 241 118 self
				)
			)
			(1
				(robot
					setPri: 7
					setLoop: 3
					cel: 1
					setMotion: MoveTo 191 83 self
				)
			)
			(2
				(= local1 0)
				(droidWalkSound stop:)
				(robot hide:)
				(self dispose:)
			)
		)
	)
)

(instance robotGetWeapon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(self setScript: robotWalksToRoom self)
			)
			(1
				(if local3
					(client setScript: shootEgo1)
				else
					(HandsOn)
					(= seconds 40)
				)
			)
			(2
				(if local0
					(client setScript: shootEgo1)
				else
					(client setScript: robotWalksOut)
				)
				(self dispose:)
			)
		)
	)
)

(instance robotWalksOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(robotGetWeapon seconds: 0)
				(if (gEgo has: 12) ; Pulseray_Laser_Pistol
					(robot setLoop: 5)
				else
					(robot setLoop: 0)
				)
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(robot show: setMotion: MoveTo 241 118 self)
			)
			(1
				(= local1 1)
				(robot
					setPri: 8
					setLoop: (+ (robot loop:) 1)
					setMotion: MoveTo 135 164 self
				)
			)
			(2
				(droidWalkSound stop:)
				(if (or (!= (gEgo x:) 89) (!= (gEgo y:) 161))
					(gEgo setMotion: MoveTo 89 161 self)
				else
					(= ticks 18)
				)
			)
			(3
				(robot setLoop: 4 cel: 0 setCycle: 0)
				(cond
					((gEgo has: 12) ; Pulseray_Laser_Pistol
						(droidWalkSound number: 523 loop: -1 flags: 1 play:)
						(robotT
							init: robotBust robotMouth robotEyes 158 8 0 1 self ; "As my supreme intellect suspected, another obvious organic life form error. Let me say this verrrryyyy sllloooowwwlllly, THERE ARE NO MORE WEAPONS FOR YOU."
						)
						(robot cel: 4)
					)
					((not (gCurRoom script:))
						(client setScript: robotGiveWeapon)
					)
				)
			)
			(4
				(droidWalkSound stop:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dropAnvil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robot setScript: 0)
				(gEgo setScript: 0)
				(HandsOff)
				(if (& (gEgo onControl: 0) $0020)
					(gEgo setMotion: PolyPath 59 141 self)
				else
					(= ticks 18)
				)
			)
			(1
				(gEgo view: 76 cel: 0 loop: 1 cycleSpeed: 2 setCycle: CT 3 1)
				(junk
					init:
					setPri: 15
					posn: (- (gEgo x:) 10) -10
					view: 76
					setLoop: 3
					setCel: 0
					yStep: 12
					cycleSpeed: 2
					moveSpeed: 2
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 27)
						self
				)
			)
			(2
				(gEgo setCel: 4)
				(= ticks 12)
			)
			(3
				(junk dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(= seconds 5)
			)
			(5
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

(instance robotGiveWeapon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo get: 12 view: 40 loop: 5 setCel: 0) ; Pulseray_Laser_Pistol
				(SetScore 1 166)
				(robot cycleSpeed: 6 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gEgo setCel: 2)
				(robot setCel: 3)
				(= ticks 50)
			)
			(2
				(gEgo setCycle: End)
				(robot setCycle: End self)
			)
			(3
				(proc703_1)
				(gEgo loop: 6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoShowsCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 89 161 self)
			)
			(1
				(gEgo view: 91 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(DeltaurRegion
					timesShownID: (+ (DeltaurRegion timesShownID:) 1)
				)
				(if (< (DeltaurRegion timesShownID:) 3)
					(robotT
						init:
							robotBust
							robotMouth
							robotEyes
							158
							(+ 8 (DeltaurRegion timesShownID:))
							0
							1
					)
					(robot setScript: robotGetWeapon)
					(gEgo setCycle: Beg self)
				else
					(robotT
						init: robotBust robotMouth robotEyes 158 11 0 1 robot ; "Oh dear, you again. Actually, looking at your past track record, I'm surprised you didn't take off your boot and start showing me that. I'd better do evolution a favor and prevent you from reproducing. Bye."
					)
					(gCurRoom setScript: dropAnvil)
					(self dispose:)
				)
			)
			(3
				(proc703_1)
				(gEgo loop: 6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoWalksUnderIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 1)
				((gCurRoom obstacles:) delete: pClosedPoly)
				((gCurRoom obstacles:) add: pOpenPoly)
				(gEgo setMotion: PolyPath 63 128 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gSoundEffects number: 539 loop: 1 play:)
				(panel startUpd: setCycle: End self)
			)
			(3
				(if (robot script:)
					(HandsOn)
					(panel stopUpd:)
					(self dispose:)
				else
					(droidWalkSound number: 523 loop: -1 flags: 1 play:)
					(robotT
						init: robotBust robotMouth robotEyes 158 12 0 1 self ; "Oh dear, how inconvenient. Another life form is in a restricted area. How your race manages not to vaporize itself into extinction is beyond me. I guess I'll have to be polite about this. Pardon me for terminating you."
					)
				)
			)
			(4
				(droidWalkSound stop:)
				(panel stopUpd:)
				(gCurRoom setScript: dropAnvil)
				(self dispose:)
			)
		)
	)
)

(instance egoWalksUnderOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 0)
				(gEgo setMotion: PolyPath 63 128 self)
			)
			(1
				(gEgo setPri: -1 setHeading: 45 self)
			)
			(2
				((gCurRoom obstacles:) delete: pOpenPoly)
				((gCurRoom obstacles:) add: pClosedPoly)
				(gSoundEffects number: 540 loop: 1 play:)
				(panel startUpd: setCycle: Beg self)
			)
			(3
				(cond
					((== (robot script:) robotGetWeapon)
						(robot setScript: robotWalksOut)
					)
					((== (robot script:) robotWalksOut)
						(robot setScript: robotGiveWeapon)
					)
				)
				(panel stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance egoPickUpGrenade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo has: 13) ; Grenade
					(Print 58 23) ; "You can carry only one grenade at a time."
					(HandsOn)
					(self dispose:)
				else
					(DeltaurRegion
						numGrenades: (- (DeltaurRegion numGrenades:) 1)
					)
					(switch (DeltaurRegion numGrenades:)
						(1
							(gEgo setMotion: PolyPath 96 98 self)
						)
						(0
							(gEgo setMotion: PolyPath 105 103 self)
						)
						(else
							(Print 58 24) ; "Bad grenade number"
						)
					)
				)
			)
			(1
				(SetScore 1 165)
				(gEgo
					view: 40
					loop: 2
					cycleSpeed: 24
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(2
				(switch (DeltaurRegion numGrenades:)
					(1
						(grenade1 dispose:)
					)
					(0
						(grenade2 dispose:)
					)
				)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo get: 13) ; Grenade
				(proc703_1)
				(gEgo setPri: 5 loop: 6)
				(= ticks 18)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance warnEgo of Script
	(properties)

	(method (dispose)
		(droidWalkSound stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: firePulsar self)
			)
			(1
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(switch (++ local2)
					(1
						(robotT
							init: robotBust robotMouth robotEyes 158 13 0 1 self ; "Allow me to state the obvious. This is an entirely bullet-proof environment, designed to protect us from the acts of imbeciles who fire off rapid-action implements in an enclosed space. Nevertheless, don't do that again."
						)
						(HandsOn)
					)
					(2
						(robotT
							init: robotBust robotMouth robotEyes 158 14 0 1 self ; "Oh my, we are even below organic intellectual levels aren't we? Don't tell me, let me guess, your race evolved from belly button lint. Well, let's get this over with and do evolution a favor."
						)
						(gCurRoom setScript: dropAnvil)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance bugEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 20 30))
			)
			(1
				(droidWalkSound number: 523 loop: -1 flags: 1 play:)
				(robotT
					init:
						robotBust
						robotMouth
						robotEyes
						158
						(+ local7 15)
						0
						1
						self
				)
			)
			(2
				(droidWalkSound stop:)
				(if (< (++ local7) 3)
					(self changeState: 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance firePulsar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face
					gEgo
					((gUser curEvent:) x:)
					((gUser curEvent:) y:)
					self
				)
			)
			(1
				(if (== (DeltaurRegion egoStatus:) 1)
					(if (OneOf (gEgo loop:) 0 4 6 3)
						(gEgo setLoop: 6)
					else
						(gEgo setLoop: 7)
					)
				)
				(gEgo view: 41 cel: 0 setCycle: CT 1 1 self)
			)
			(2
				(gSoundEffects number: 312 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(= register (gEgo priority:))
				(proc703_1)
				(gEgo setPri: register)
				(= ticks 18)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance droidWalkSound of Sound
	(properties)
)

(instance droidStepSound of Sound
	(properties)
)

(instance robotHead of Prop
	(properties
		view 461
		loop 3
		signal 24576
	)

	(method (init)
		(super init: &rest)
		(self
			setPri: (robot priority:)
			posn: (- (robot x:) 1) (- (robot y:) 42)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 58 25) ; "I wouldn't mess with him if I were you."
			)
			(2 ; Look
				(Print 58 26) ; "It's a pretty stupid-looking robot, but, then, looks can be deceiving (except in your case)."
			)
			(11 ; Taste
				(Print 58 27) ; "I don't think it would take kindly to that action."
			)
			(12 ; Smell
				(Print 58 27) ; "I don't think it would take kindly to that action."
			)
			(4 ; Inventory
				(Print 58 27) ; "I don't think it would take kindly to that action."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

