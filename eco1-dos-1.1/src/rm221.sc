;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use enterScript)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm221 0
)

(instance rm221 of ApartmentRoom
	(properties
		lookStr 110
		picture 220
		style -32761
		east 200
		south 200
	)

	(method (init)
		(= global250 3)
		(= global251 1)
		(= global229 6)
		(LoadMany rsVIEW 221 223 802 222)
		(self setRegions: 51) ; bubblesRegion
		(if (IsFlag 47)
			(self setScript: fallIn)
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 175 419 175 254 134 304 89 301 28 227 12 119 12 35 52 36 114 65 150 170 170 288 189 288 259 -100 259 -100 -70 419 -70
					yourself:
				)
		)
		(gFeatures
			add: table paintcan palet urchns roundStatue
			eachElementDo: #init
		)
		(gAddToPics
			add:
				redSeaweed
				fishStatue
				stackedPaintings
				easel
				painting
				purplePlant
				redPlant
			eachElementDo: #init
			doit:
		)
		(if (IsFlag 92)
			(plasticBaggie cel: 4 posn: 165 112 init:)
		)
		(if (not (IsFlag 52))
			(blowFish setCycle: Fwd init:)
		)
		(if (and (not (== ((Inv at: 15) owner:) 222)) (not (gEgo has: 15))) ; urchins, urchins
			(narUrchin setCycle: Fwd init:)
		)
	)

	(method (notify)
		(HandsOn)
	)
)

(instance fallIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 47)
				(gEgo setCycle: 0 setLoop: 0 cel: 3 posn: 308 133 setPri: 13)
				(= cycles 3)
			)
			(1
				(gSoundEffects number: 208 loop: 1 play:)
				(gEgo setCycle: 0 view: 221)
				(= cycles 1)
			)
			(2
				(gEgo cel: 0 posn: 309 122)
				(= cycles 1)
			)
			(3
				(gEgo cel: 1 posn: 287 115)
				(= cycles 2)
			)
			(4
				(gEgo cel: 2 posn: 275 119)
				(= cycles 2)
			)
			(5
				(gEgo cel: 3 posn: 263 131)
				(= cycles 4)
			)
			(6
				(gEgo cel: 0 posn: 260 122)
				(= cycles 6)
			)
			(7
				(gEgo cel: 1 posn: 239 117 setPri: 10)
				(= cycles 9)
			)
			(8
				(gEgo cel: 2 posn: 223 132)
				(= cycles 9)
			)
			(9
				(gEgo
					setCycle: 0
					setLoop: 1
					cel: 0
					posn: 194 135
					setPri: 12
					cycleSpeed: 15
				)
				(= cycles 15)
			)
			(10
				(gSoundEffects number: 209 loop: 1 play:)
				(gEgo cel: 1 setCycle: CT 3 1 self)
			)
			(11
				(gSoundEffects number: 209 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(12
				(NormalEgo)
				(gEgo posn: 173 122)
				(= cycles 1)
			)
			(13
				(gLongSong number: 201 loop: -1 play:)
				(Narrator init: 3 0 0 111 self) ; "Adam's landed in the little blowfish's apartment - and landed HARD!"
			)
			(14
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance unwrapNarci of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 180 91 self)
			)
			(1
				(= cycles 10)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 221
					loop: 2
					cel: 0
					x: 162
					y: 69
					cycleSpeed: 22
					setCycle: CT 2 1 self
				)
			)
			(4
				(Narrator init: 3 0 0 118 self) ; "Adam very carefully unwraps the plastic and frees the frightened blowfish."
			)
			(5
				(blowFish hide:)
				(gEgo
					view: 221
					loop: 2
					cel: 2
					x: 162
					y: 69
					cycleSpeed: 18
					setCycle: CT 6 1 self
				)
			)
			(6
				(SetScore 10 281)
				(blowFish view: 223 loop: 5 cel: 0 x: 143 y: 62 show:)
				(NormalEgo)
				(gEgo posn: 149 92)
				(= cycles 1)
			)
			(7
				(gEgo setMotion: DPath 170 85 186 75 self)
				(plasticBaggie
					view: 221
					setLoop: 3
					cel: 0
					posn: 186 86
					init:
					setCycle: Fwd
					setMotion: MoveTo 185 112 self
				)
				(blowFish cycleSpeed: 3 setCycle: End self)
			)
			(8 0)
			(9 0)
			(10
				(gEgo setHeading: 270 self)
			)
			(11
				(plasticBaggie
					view: 221
					loop: 3
					cel: 4
					posn: 185 112
					setCycle: 0
					stopUpd:
				)
				(SetFlag 92)
				(= cycles 3)
			)
			(12
				((ScriptID 2 1) init: 1 0 0 2 1 self) ; Adam, "Are you okay?"
			)
			(13
				(Narcissus init: 2 0 0 1 1 self) ; "But of course! I, Narcissus, cannot be distressed by mere mortal danger, mais non! I did not even see the jellyfish that attacked me until eet hit."
			)
			(14
				((ScriptID 2 1) init: 1 0 0 3 1 self) ; Adam, "It wasn't a jellyfish, it was a plastic baggie. A human product, I'm afraid."
			)
			(15
				(Narcissus init: 2 0 0 2 1 self) ; "A baggie? Plastique? How can I avoid what I cannot see? But who are you? And why are you so ugly - if you pardon my French?"
			)
			(16
				((ScriptID 2 1) init: 1 0 0 4 1 self) ; Adam, "I'm Adam, and I'm a human boy. Haven't you ever seen a human before?"
			)
			(17
				(Narcissus init: 2 0 0 3 1 self) ; "But of course! I am not le bebe, I have known many humans quite intimately <gulp>!"
			)
			(18
				(blowFish
					view: 250
					loop: 0
					cel: 0
					posn: 132 80
					setPri: 14
					cycleSpeed: 15
					setCycle: Fwd
				)
				(gEgo
					setCycle: 0
					view: 805
					setLoop: gStopGroop
					cel: 0
					xStep: 1
					moveSpeed: 8
					cycleSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 160 75 self
				)
			)
			(19
				(= seconds 2)
			)
			(20
				((ScriptID 2 1) init: 1 0 0 5 1 self) ; Adam, "You're an artist, right? Is this your painting?"
			)
			(21
				(Narcissus init: 2 0 0 4 1 self) ; "Ah! My latest masterpiece! The negative space gives a certain je ne sais quoi to this amusing lettle waterscape, don't you agree?"
			)
			(22
				((ScriptID 2 1) init: 1 0 0 6 1 self) ; Adam, "It's very nice."
			)
			(23
				(Narcissus init: 2 0 0 5 1 self) ; "Well, eet's fini now. I had a terrible time with eet. Those sea urchins will not seet still! They have no appreciation for l'artiste!"
			)
			(24
				(gEgo xStep: 2 moveSpeed: 7 setMotion: MoveTo 186 75 self)
			)
			(25
				(gEgo setHeading: 270 self)
			)
			(26
				(Narcissus init: 2 0 0 6 1 self) ; "Since you have saved my life, mon ami, why don't you take zees petite sea urchins. Eet is a humble gift, perhaps, but then having the pleasure of meeting me more than compensates, n'est-ce pas?"
			)
			(27
				(blowFish
					view: 223
					loop: 7
					cel: 0
					x: 107
					y: 75
					cycleSpeed: 12
					setCycle: CT 8 1 self
				)
			)
			(28
				(narUrchin dispose:)
				(blowFish setCycle: End self)
			)
			(29
				(gEgo hide:)
				(blowFish
					view: 223
					loop: 6
					cel: 0
					x: 174
					y: 66
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(30
				(= cycles 3)
			)
			(31
				(SetScore 2 283)
				(NormalEgo)
				(gEgo posn: 187 70 get: 15 show:) ; urchins
				(blowFish
					view: 250
					loop: 0
					cel: 0
					posn: 132 80
					setPri: 14
					setCycle: Walk
				)
				(= cycles 12)
			)
			(32
				((ScriptID 2 1) init: 1 0 0 7 1 self) ; Adam, "Thanks, Narcissus. Oh, and now that you're okay, the Mayor would like to see you in the Council Chambers for a meeting."
			)
			(33
				(Narcissus init: 2 0 0 7 1 self) ; "Zee Mayor? But of course he wants me there! Say no more, er, um, `Boy'. I go now! Bonne chance, mon ami!"
			)
			(34
				(gEgo setHeading: 180 self)
			)
			(35
				(= cycles 12)
			)
			(36
				(blowFish setMotion: DPath 239 156 330 192 self)
			)
			(37
				(SetFlag 52)
				(blowFish dispose:)
				(= cycles 1)
			)
			(38
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getBaggie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 92)
				(gEgo setMotion: MoveTo 149 74 self)
			)
			(1
				(= cycles 12)
			)
			(2
				(gEgo
					setCycle: 0
					view: 221
					loop: 4
					cel: 0
					posn: 151 88
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
			)
			(3
				(plasticBaggie dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(SetScore 5 282)
				(NormalEgo)
				(gEgo posn: 178 76)
				(= cycles 1)
			)
			(5
				(Narrator init: 3 0 0 3 self) ; "Adam picks up the plastic baggie and puts it in his garbage bag so that it won't be able to trap any other sea creatures."
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtUrchns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 3 0 0 39 self) ; "There's an interesting little shell table next to the easel. It holds the blowfish's painting subjects."
			)
			(1
				(if (gCast contains: narUrchin)
					(Narrator init: 3 0 0 128 self) ; "There are sea urchins on the table. Sea urchins are useful for eating algae."
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance blowFish of Actor
	(properties
		x 160
		y 57
		yStep 3
		view 223
		loop 8
		signal 20480
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 34) ; "The little blowfish has panicked and inflated. Blowfish inflate to `scare off' their enemies, but the plastic bag doesn't seem impressed. He's suffocating because the plastic won't let water flow over his gills."
			)
			(3 ; Do
				(gCurRoom setScript: unwrapNarci)
			)
			(5 ; Talk
				(Narrator init: 3 0 0 35) ; "The little blowfish is too upset to be calmed down by a stranger like Adam. Talking won't help."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 116) ; "The blowfish does not find your garbage bag suggestion amusing."
			)
			(4 ; Inventory
				(switch invItem
					(21 ; healingPotion
						(Narrator init: 3 0 0 112) ; "The blowfish isn't sick, he's trapped in a plastic bag. The healing potion can't help him."
					)
					(12 ; trident
						(Narrator init: 3 0 0 120) ; "Don't stick the blowfish! There's an easier way to remove that baggie."
					)
					(else
						(Narrator init: 3 0 0 113) ; "That won't help the poor blowfish!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plasticBaggie of Actor
	(properties
		x 186
		y 86
		view 221
		loop 3
		cel 4
		priority 1
		signal 20497
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 40) ; "The plastic baggie that trapped Narcissus is lying on the floor."
			)
			(3 ; Do
				(Narrator init: 3 0 0 41) ; "Good idea! Try the garbage bag."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 127) ; "Just trash the thing."
			)
			(10 ; Recycle
				(gCurRoom setScript: getBaggie)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance narUrchin of Prop
	(properties
		x 88
		y 101
		view 223
		loop 10
		priority 10
		signal 20496
		cycleSpeed 45
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 39) ; "There's an interesting little shell table next to the easel. It holds the blowfish's painting subjects."
			)
			(3 ; Do
				(Narrator init: 3 0 0 107) ; "If the little blowfish wants Adam to have a sea urchin, he'll give him one."
			)
			(5 ; Talk
				(Narrator init: 3 0 0 114) ; "The sea urchins don't talk."
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 117) ; "Don't throw the blowfish's things away!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance roundStatue of Feature
	(properties
		x 280
		y 143
		z 24
		nsTop 107
		nsLeft 270
		nsBottom 132
		nsRight 291
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 124) ; "That statue looks like brain coral. Talk about working from nature!"
			)
			(3 ; Do
				(Narrator init: 3 0 0 125) ; "The brain coral statue may appeal to a fish, but it's a little strange for Adam's tastes."
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(5 ; Talk
				(Narrator init: 3 0 0 126) ; "If the art doesn't 'speak' to Adam already, it never will!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 115) ; "The blowfish may not be the greatest artist under the sea, but his work deserves more respect than that!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance urchns of Feature
	(properties
		x 78
		y 135
		z 30
		sightAngle 90
	)

	(method (onMe param1)
		(return
			(or
				(InRect 73 90 84 100 param1)
				(InRect 68 101 93 106 param1)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: lookAtUrchns)
			)
			(3 ; Do
				(if (IsFlag 281)
					(Narrator init: 3 0 0 108) ; "Adam already has the sea urchins."
				else
					(Narrator init: 3 0 0 107) ; "If the little blowfish wants Adam to have a sea urchin, he'll give him one."
				)
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 117) ; "Don't throw the blowfish's things away!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 82
		y 157
		z 30
		nsTop 107
		nsLeft 69
		nsBottom 127
		nsRight 95
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: lookAtUrchns)
			)
			(3 ; Do
				(Narrator init: 3 0 0 106) ; "The table doesn't interest Adam."
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 117) ; "Don't throw the blowfish's things away!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance paintcan of Feature
	(properties
		x 143
		y 93
		nsTop 88
		nsLeft 139
		nsBottom 99
		nsRight 148
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 128) ; "There are sea urchins on the table. Sea urchins are useful for eating algae."
			)
			(3 ; Do
				(Narrator init: 3 0 0 101) ; "The can of supplies belongs to the blowfish."
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 117) ; "Don't throw the blowfish's things away!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance palet of Feature
	(properties
		x 115
		y 103
		nsTop 95
		nsLeft 105
		nsBottom 112
		nsRight 126
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 96) ; "There's a painting palate lying on the floor. It looks as though the little blowfish has just finished a painting."
			)
			(3 ; Do
				(Narrator init: 3 0 0 97) ; "The blowfish might not appreciate losing his paint palate!"
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 117) ; "Don't throw the blowfish's things away!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance redSeaweed of PicView
	(properties
		x 257
		y 190
		view 222
		loop 1
		priority 15
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
				(Narrator init: 3 0 0 117) ; "Don't throw the blowfish's things away!"
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fishStatue of PicView
	(properties
		x 255
		y 102
		view 222
		loop 1
		cel 1
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 37) ; "That's quite a statue! Apparently, this fish has a certain fascination with himself."
			)
			(3 ; Do
				(Narrator init: 3 0 0 104) ; "That statue is very nice, but only a blowfish would be interested enough in the subject matter to truly appreciate it."
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(5 ; Talk
				(Narrator init: 3 0 0 126) ; "If the art doesn't 'speak' to Adam already, it never will!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 115) ; "The blowfish may not be the greatest artist under the sea, but his work deserves more respect than that!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stackedPaintings of PicView
	(properties
		x 286
		y 137
		view 222
		loop 1
		cel 2
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 38) ; "Hmmm. The paintings against the wall seem to all feature blowfish."
			)
			(3 ; Do
				(Narrator init: 3 0 0 105) ; "Adam may not know art, but he knows what he likes! He'd rather leave those paintings here."
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(5 ; Talk
				(Narrator init: 3 0 0 126) ; "If the art doesn't 'speak' to Adam already, it never will!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 115) ; "The blowfish may not be the greatest artist under the sea, but his work deserves more respect than that!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance easel of PicView
	(properties
		x 109
		y 72
		z -56
		view 222
		loop 2
		priority 0
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
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
				(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
				(== (gTheIconBar curInvIcon:) (Inv at: 15)) ; urchins
			)
			(Narrator init: 3 0 0 119) ; "There's no need to use the sea urchins here."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 36) ; "On the easel is a `waterscape' featuring an undersea mountain and various forms of sea life, including the sea urchins on the nearby table."
			)
			(3 ; Do
				(Narrator init: 3 0 0 103) ; "The painting and easel belong to the blowfish."
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(5 ; Talk
				(Narrator init: 3 0 0 126) ; "If the art doesn't 'speak' to Adam already, it never will!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 115) ; "The blowfish may not be the greatest artist under the sea, but his work deserves more respect than that!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance painting of PicView
	(properties
		x 78
		y 73
		view 222
		loop 2
		cel 1
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 98) ; "The blowfish displays one of his paintings on the wall."
			)
			(3 ; Do
				(Narrator init: 3 0 0 99) ; "Adam may not know art, but he knows what he likes! He'd rather leave that painting here."
			)
			(4 ; Inventory
				(if (IsFlag 281)
					(Narrator init: 3 0 0 122) ; "Adam doesn't need to mess with the blowfish's stuff."
				else
					(Narrator init: 3 0 0 121) ; "That won't help rescue the blowfish."
				)
			)
			(5 ; Talk
				(Narrator init: 3 0 0 126) ; "If the art doesn't 'speak' to Adam already, it never will!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 115) ; "The blowfish may not be the greatest artist under the sea, but his work deserves more respect than that!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance purplePlant of PicView
	(properties
		x 135
		y 160
		view 222
		priority 15
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(redSeaweed doVerb: theVerb invItem &rest)
	)
)

(instance redPlant of PicView
	(properties
		x 35
		y 87
		view 222
		cel 1
		priority 0
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(redSeaweed doVerb: theVerb invItem &rest)
	)
)

(instance Narcissus of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 236
		viewInPrint 1
		charNum 11
		keepWindow 1
	)

	(method (init)
		(super init: nBust nEyes nMouth &rest)
	)
)

(instance nBust of Prop
	(properties
		view 236
		cel 1
	)
)

(instance nEyes of Prop
	(properties
		nsTop 3
		nsLeft 21
		view 236
		loop 2
		cycleSpeed 30
	)
)

(instance nMouth of Prop
	(properties
		nsTop 11
		nsLeft 22
		view 236
		loop 1
		cycleSpeed 10
	)
)

