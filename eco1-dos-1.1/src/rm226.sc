;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 226)
(include sci.sh)
(use Main)
(use enterScript)
(use n804)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use ForwardCounter)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm226 0
)

(local
	local0
	local1
)

(instance rm226 of ApartmentRoom
	(properties
		lookStr 28
		picture 220
		style -32761
		east 200
		south 200
	)

	(method (init)
		(= global250 3)
		(= global251 1)
		(= global229 7)
		(super init: &rest)
		(if (not (IsFlag 48))
			(lionFish init: setPri: 2 setCycle: Fwd)
			(waft1 setCycle: Fwd init:)
			(waft2 setCycle: Fwd init:)
		)
		(if (not (IsFlag 53))
			(bleach init: setPri: 0)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 -10 319 -10 319 179 283 171 275 111 306 62 293 28 225 10 120 15 37 51 33 112 65 147 191 165 239 189 0 189
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(gAddToPics
			add: painting wndow couch table plant1 plant2 plant3 plant4
			eachElementDo: #init
			doit:
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 53))
					(Narrator init: 3 0 0 28 store: 29) ; "Adam is swimming in the apartment of a lionfish named Olympia. The apartment is cleverly decorated with discarded pieces of human trash. Olympia should get a reward for recycling!"
				else
					(Narrator init: 3 0 0 28) ; "Adam is swimming in the apartment of a lionfish named Olympia. The apartment is cleverly decorated with discarded pieces of human trash. Olympia should get a reward for recycling!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (notify)
		(HandsOn)
	)
)

(instance discardBleach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 183 96 self)
			)
			(1
				(= cycles 10)
			)
			(2
				(gEgo
					setCycle: 0
					view: 232
					loop: 3
					cel: 0
					x: 139
					y: 101
					cycleSpeed: 14
					setCycle: CT 5 1 self
				)
			)
			(3
				(SetScore 5 302)
				(SetFlag 53)
				(bleach dispose:)
				(gEgo cel: 6 setCycle: End self)
			)
			(4
				(NormalEgo 0)
				(gEgo posn: 160 95 setHeading: 135 self)
			)
			(5
				(Narrator init: 3 0 0 7 self) ; "Adam picks up the bleach bottle and stores it away in his garbage bag. That stops new bleach from leaking into the water, but the apartment is still full of the stuff."
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bleachNotGone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (Clone waft1))
				(= local1 (Clone waft2))
				(waft1 setCycle: Fwd)
				(waft2 setCycle: Fwd)
				(local0 init: setLoop: 2 cel: 0 cycleSpeed: 12 setCycle: Fwd)
				(local1 init: setLoop: 3 cel: 0 cycleSpeed: 11 setCycle: Fwd)
				(= seconds 7)
			)
			(1
				(Narrator init: 3 0 0 96 self) ; "The room is still cloudy. Adam will have to find the source of the white stuff first and remove it."
			)
			(2
				(local0 setCycle: End self)
				(local1 setCycle: End)
			)
			(3
				(gEgo setScript: 0)
				(local0 setCycle: 0 dispose:)
				(local1 setCycle: 0 dispose:)
				(= cycles 2)
			)
			(4
				(= local0 (= local1 0))
				(NormalEgo 0)
				(gEgo posn: 237 50)
				(= cycles 12)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance usePump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 237 50 self)
			)
			(1
				(= cycles 10)
			)
			(2
				(waft1 setCycle: 0)
				(waft2 setCycle: 0)
				(= cycles 1)
			)
			(3
				(if (not (IsFlag 53))
					(Narrator init: 3 0 0 104 self) ; "Adam uses the water pump to try to cycle the contaminated water out of the window."
				else
					(= cycles 1)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo
					setCycle: 0
					view: 232
					loop: 4
					cel: 0
					x: 258
					y: 57
					cycleSpeed: 9
					setScript: egoPump
				)
				(if (not (IsFlag 53))
					(gCurRoom setScript: bleachNotGone)
				else
					(= cycles 1)
				)
			)
			(6
				(= local0 (Clone waft1))
				(= local1 (Clone waft2))
				(waft1 setCycle: Fwd)
				(waft2 setCycle: Fwd)
				(local0
					init:
					setLoop: 2
					cel: 0
					cycleSpeed: 10
					setCycle: ForwardCounter 5 self
				)
				(local1 init: setLoop: 3 cel: 0 cycleSpeed: 10 setCycle: Fwd)
			)
			(7
				(local0 setCycle: 0 dispose:)
				(local1 setCycle: 0 dispose:)
				(waft1 setLoop: 2 cel: 0 cycleSpeed: 7 setCycle: End waft1)
				(waft2 setLoop: 3 cel: 0 cycleSpeed: 6 setCycle: End waft2)
			)
			(8
				(SetScore 5 303)
				(NormalEgo 0)
				(gEgo setScript: 0 posn: 237 50)
				(= cycles 1)
			)
			(9
				(Narrator init: 3 0 0 8 self) ; "Adam uses the water pump to cycle the old, contaminated water out into the much bigger area of the open sea. The room slowly clears of bleach."
			)
			(10
				(gEgo setHeading: 225 self)
			)
			(11
				(gLongSong number: 206 loop: -1 play:)
				(lionFish
					view: 233
					loop: 4
					cel: 0
					x: 100
					y: 98
					cycleSpeed: 13
					setCycle: End self
				)
			)
			(12
				(lionFish setLoop: 1 cel: 0 cycleSpeed: 9 setCycle: Fwd)
				(= seconds 3)
			)
			(13
				(Olympia init: 1 0 0 1 1 self) ; "Oh my! What happened here?"
			)
			(14
				((ScriptID 2 1) init: 2 0 0 30 0 self) ; Adam, "You used a bottle of bleach for your table and the bleach knocked you out. I'm afraid bleach is one of those man-made dangers you'll have to watch out for."
			)
			(15
				((ScriptID 2 1) init: 2 0 0 36 1 self) ; Adam, "How are you feeling now?"
			)
			(16
				(Olympia init: 1 0 0 2 1 self) ; "I... I'm fine - just a little woozy. My name's Olympia. Who are you?"
			)
			(17
				((ScriptID 2 1) nsLeft: 20 nsTop: 136 init: 2 0 0 31 1 self) ; Adam, "I'm Adam. I'm here to tell citizens about a meeting in the Council Chambers. The Mayor's asked everybody to come."
			)
			(18
				(Olympia init: 1 0 0 3 1 self) ; "A meeting? You mean with other fish? I... I don't know. I'm pretty shy, I'm afraid. I don't like crowds."
			)
			(19
				((ScriptID 2 1) init: 2 0 0 32 1 self) ; Adam, "Why not?"
			)
			(20
				(Olympia init: 1 0 0 4 1 self) ; "Well, it's my spines, you see. They're quite poisonous. I can't help it, you know, but there it is. I'm always afraid that others will be afraid of me - or that somehow accidentally..."
			)
			(21
				((ScriptID 2 1) init: 2 0 0 33 0 self) ; Adam, "But you can't just hide in your room! Everyone needs friends... Listen to me - I sound just like my Dad! I guess he's right after all."
			)
			(22
				((ScriptID 2 1) init: 2 0 0 37 1 self) ; Adam, "Anyway, I think you're really nice and I think your spines are cool."
			)
			(23
				(Olympia init: 1 0 0 5 1 self) ; "You... like my spines? I never thought anyone would LIKE my spines. Well... maybe I COULD go."
			)
			(24
				((ScriptID 2 1) nsLeft: 20 nsTop: 136 init: 2 0 0 34 1 self) ; Adam, "It is important, I think. Maybe your spines could help the other citizens."
			)
			(25
				(lionFish
					view: 233
					loop: 5
					cel: 0
					x: 100
					y: 98
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(26
				(Olympia init: 1 0 0 6 1 self) ; "If you truly like my spines, perhaps you'll accept a small gift for saving my life. This locket contains one of my baby spines. It's quite potent, though. Be careful how you use it."
			)
			(27
				(gEgo setMotion: PolyPath 212 99 self)
			)
			(28
				(gEgo setHeading: 315)
				(lionFish
					view: 233
					loop: 6
					cel: 0
					x: 194
					y: 91
					cycleSpeed: 10
					setCycle: CT 10 1 self
				)
			)
			(29
				(= cycles 10)
			)
			(30
				(SetScore 2 304)
				(gEgo get: 17) ; spine
				(lionFish setCycle: End)
				(gEgo
					setCycle: 0
					view: 233
					loop: 7
					cel: 0
					x: 194
					y: 91
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(31
				(NormalEgo 1)
				(gEgo posn: 210 96)
				((ScriptID 2 1) init: 2 0 0 35 1 self) ; Adam, "Wow! A lionfish spine! Neat! Thanks, Olympia!"
			)
			(32
				(Olympia init: 1 0 0 7 1 self) ; "Goodbye, Adam. May you be free from stings as long as you live."
			)
			(33
				(gEgo setHeading: 180 self)
			)
			(34
				(= cycles 12)
			)
			(35
				(lionFish
					view: 245
					setLoop: 2
					posn: 179 78
					setPri: 15
					setCycle: Fwd
					setMotion: MoveTo 275 172 self
				)
			)
			(36
				(lionFish
					view: 245
					setLoop: 0
					posn: 275 172
					setCycle: Fwd
					setMotion: MoveTo 333 175 self
				)
			)
			(37
				(lionFish dispose:)
				(SetFlag 48)
				(= cycles 1)
			)
			(38
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoPump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSoundEffects number: 213 loop: 1 play:)
				(= state -1)
				(gEgo setCycle: End self)
			)
		)
	)
)

(instance lionFish of Actor
	(properties
		x 100
		y 98
		approachX 153
		approachY 96
		view 233
		loop 3
		signal 16384
		cycleSpeed 18
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 2 5) ; Inventory, Look, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 81) ; "A beautiful lionfish floats stunned and unconscious in the water."
			)
			(3 ; Do
				(Narrator init: 3 0 0 89) ; "Adam can't touch the lionfish! Lionfish spines are very poisonous!"
			)
			(5 ; Talk
				(Narrator init: 3 0 0 82) ; "The lionfish is unconscious. She can't talk to Adam now."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 93) ; "The lionfish is unconscious, not dead."
			)
			(4 ; Inventory
				(if (== invItem 21) ; healingPotion
					(Narrator init: 3 0 0 101) ; "There's an easier way to help the lionfish than using Adam's precious store of healing potion."
				else
					(Narrator init: 3 0 0 95) ; "That won't help the lionfish recover."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance painting of PicView
	(properties
		x 83
		y 80
		view 232
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 32) ; "The lionfish has a painting on one wall. Perhaps she scavenged it from human trash or perhaps it was painted by an artist friend."
			)
			(3 ; Do
				(Narrator init: 3 0 0 31) ; "Adam doesn't want to take the lionfish's art!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 94) ; "The lionfish's belongings may not be much, but they're hardly trash."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 99) ; "Adam doesn't want to mess with the lionfish's stuff."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wndow of PicView
	(properties
		x 247
		y 60
		view 232
		cel 1
		priority 0
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(not (gCurRoom script:))
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
				(== (gTheIconBar curInvIcon:) (Inv at: 16)) ; waterPump
				(== ((Inv at: 17) owner:) 226) ; spine
				(not (self onMe: event))
			)
			(Narrator init: 3 0 0 97) ; "That's a good idea, but Adam needs to pump the contaminated water OUT of the room somehow."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 87) ; "This apartment has a window to the outside."
			)
			(3 ; Do
				(if (gEgo has: 17) ; spine
					(Narrator init: 3 0 0 98) ; "Adam doesn't need to mess with the window any more."
				else
					(Narrator init: 3 0 0 90) ; "The window is already open, but the water doesn't seem to be cycling out of the lionfish's apartment very quickly."
				)
			)
			(4 ; Inventory
				(switch invItem
					(16 ; waterPump
						(if (not (gEgo has: 17)) ; spine
							(gCurRoom setScript: usePump)
						else
							(Narrator init: 3 0 0 98) ; "Adam doesn't need to mess with the window any more."
						)
					)
					(else
						(Narrator init: 4 0 0 5) ; "That doesn't work on the window."
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 102) ; "Adam can't throw the window away!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance couch of PicView
	(properties
		x 95
		y 97
		z -32
		view 232
		loop 1
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 83) ; "The couch is made out of shell, Grecian marble, and old tires."
			)
			(3 ; Do
				(Narrator init: 3 0 0 30) ; "Adam could never lug that couch around, even if he wanted to!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 94) ; "The lionfish's belongings may not be much, but they're hardly trash."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 99) ; "Adam doesn't want to mess with the lionfish's stuff."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance table of PicView
	(properties
		x 122
		y 139
		view 232
		loop 1
		cel 1
		priority 0
		signal 20496
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 84) ; "The lionfish likes to fix up her apartment with objects she finds. She's used some old bottles to make the table legs."
			)
			(3 ; Do
				(Narrator init: 3 0 0 33) ; "The table doesn't need to be moved."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 94) ; "The lionfish's belongings may not be much, but they're hardly trash."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 99) ; "Adam doesn't want to mess with the lionfish's stuff."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant1 of PicView
	(properties
		x 296
		y 127
		view 232
		loop 2
		cel 1
		priority 12
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 11) ; "Sea vegetation decorates the apartment like potted plants."
			)
			(3 ; Do
				(Narrator init: 3 0 0 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 94) ; "The lionfish's belongings may not be much, but they're hardly trash."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 99) ; "Adam doesn't want to mess with the lionfish's stuff."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant2 of PicView
	(properties
		x 234
		y 96
		view 232
		loop 2
		cel 2
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(plant1 doVerb: theVerb invItem &rest)
	)
)

(instance plant3 of PicView
	(properties
		x 303
		y 183
		view 232
		loop 2
		cel 3
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(plant1 doVerb: theVerb invItem &rest)
	)
)

(instance plant4 of PicView
	(properties
		x 172
		y 186
		view 232
		loop 2
		priority 15
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(plant1 doVerb: theVerb invItem &rest)
	)
)

(instance bleach of View
	(properties
		x 159
		y 140
		z 24
		approachX 212
		approachY 110
		view 232
		loop 1
		cel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 3 2 10) ; Inventory, Do, Look, Recycle
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 85) ; "Oh, no! A bottle of chlorine bleach! Tropical fish collectors use bleach to stun fish so that they can catch them easily. The lionfish must have found the bottle up on the reef."
			)
			(3 ; Do
				(Narrator init: 3 0 0 88) ; "Good idea! Try using the garbage bag."
			)
			(10 ; Recycle
				(gCurRoom setScript: discardBleach)
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 103) ; "The best thing to do with that bleach bottle is just throw it away."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance waft1 of Prop
	(properties
		x 120
		y 133
		lookStr 29
		view 247
		signal 16400
		detailLevel 1
	)

	(method (cue)
		(usePump cue:)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 3 0 0 92) ; "The garbage bag can't help get rid of that milky stuff in the water."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waft2 of Prop
	(properties
		x 275
		y 136
		lookStr 29
		view 247
		signal 16400
		detailLevel 1
	)

	(method (cue)
		(self dispose:)
	)
)

(instance Olympia of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 242
		viewInPrint 1
		charNum 14
		keepWindow 1
	)

	(method (init)
		(super init: oBust oEyes oMouth &rest)
	)
)

(instance oBust of Prop
	(properties
		view 242
		cel 1
	)
)

(instance oEyes of Prop
	(properties
		nsTop 7
		nsLeft 16
		view 242
		loop 2
		cycleSpeed 30
	)
)

(instance oMouth of Prop
	(properties
		nsTop 11
		nsLeft 24
		view 242
		loop 1
		cycleSpeed 10
	)
)

