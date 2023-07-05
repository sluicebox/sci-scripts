;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use eRS)
(use Garbage)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm180 0
)

(local
	[local0 12] = [-1 -1 -340 60 15 -20 90 340 105 80 210 -32768]
	[local12 16] = [-1 0 240 -20 15 -20 60 270 77 8192 -1 340 97 -20 83 -32768]
	[local28 20] = [-1 1 -340 105 15 45 120 8192 -1 340 120 -20 75 50 67 8192 -1 340 30 -32768]
)

(instance rm180 of EcoRoom
	(properties
		picture 180
		style 10
		horizon 20
		north 200
		east 120
		walkOffTop 1
	)

	(method (init)
		(NormalEgo)
		(gEgo init: setPri: 7)
		(gFeatures
			add:
				shell
				whale
				leftBackGround
				rightBackGround
				yellowCoral
				columnsAtRight
				redStarFish
				cobbleStone
				moss
			eachElementDo: #init
		)
		(gCast
			add:
				sneaker
				beerCan
				book
				container
				tire
				purse
				fishingPole
				sixPack
				wheel
				windex
			eachElementDo: #init
		)
		(plantLeft setCycle: Fwd init:)
		(plantRight setCycle: Fwd init:)
		(if (not (IsFlag 8))
			(oilOnWhale init: stopUpd:)
		)
		(if
			(and
				(not (gEgo has: 22)) ; hermetShell
				(not (== ((Inv at: 22) owner:) 160)) ; hermetShell
				(IsFlag 8)
			)
			(superflShell init: posn: 141 116)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 0 13 0 13 181 319 180
					yourself:
				)
		)
		(if (== gPrevRoomNum 120)
			(gEgo y: 96)
		)
		(super init:)
		(self setRegions: 51 50) ; bubblesRegion, regionFish
		((ScriptID 50 0) addFish: @local12 @local28 @local0) ; regionFish
		(if (!= (gLongSong number:) 180)
			(gLongSong number: 180 loop: -1 play:)
		)
		(self setRegions: 51) ; bubblesRegion
		(if (== ((Inv at: 17) owner:) 226) ; spine
			(gAddToPics
				add:
					oil0
					oil1
					oil2
					oil3
					oil4
					oil5
					oil6
					oil7
					oil8
					oil9
					oil10
					oil11
					oil12
					oil13
					oil14
				eachElementDo: #init
				doit:
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (> gHowFast 0)
			(Palette palANIMATE 33 43 6)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 347)
					(Narrator init: 97) ; "Adam is swimming in the Royal Gardens of Eluria. The Gardens were clearly once full of beauty but oil and phosphates have left most of the plants dead or dying. At least Adam has cleaned up most of the human litter, though, and it does look better."
				else
					(Narrator init: 6) ; "Adam is swimming in the Royal Gardens of Eluria. The Royal Gardens were clearly once a beautiful place but now oil and garbage litter the area and many of the plants are dead or dying."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (notify)
		(if (== gPrevRoomNum 200)
			(HandsOn)
		else
			(self setScript: enterScript)
		)
		(gEgo ignoreHorizon:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 stop: flags: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 267 87 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance clearOil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 10 270)
				(gEgo setMotion: PolyPath 198 18 self)
			)
			(1
				(= cycles 10)
			)
			(2
				((ScriptID 2 1) init: 1 1 self) ; Adam, "Don't worry, coral. This is fertilizer solution from my Dad's lab. I'm not sure it will help you, but without it you'll die for sure."
			)
			(3
				(gLongSong2 number: 184 loop: -1 flags: 1 play:)
				(gEgo
					setCycle: 0
					view: 181
					loop: 0
					cel: 0
					x: 160
					y: 36
					setPri: 12
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(4
				(Narrator init: 68 self) ; "Adam carefully pours the fertilizer solution over the whale-shaped coral. He puts the empty flask into his garbage bag."
			)
			(5
				(oilOnWhale cycleSpeed: 140 setCycle: CT 5 1 oilOnWhale)
				(gEgo put: 3 0) ; beaker
				(= cycles 1)
			)
			(6
				(NormalEgo)
				(gEgo
					setPri: 7
					setHeading: 90
					posn: 180 40
					ignoreHorizon:
					setMotion:
						DPath
						197
						32
						217
						34
						227
						42
						231
						107
						210
						130
						178
						134
						178
						120
						self
				)
			)
			(7
				(gEgo setHeading: 0 self)
			)
			(8
				(Narrator init: 1 self) ; "The oil begins to dissolve. It's working!"
			)
			(9
				(SetFlag 28)
				(demeter setScript: demeterExitShell self)
			)
			(10
				(demeter view: 182 loop: 1 cel: 0 setPri: 14 setCycle: End self)
			)
			(11
				(gSoundEffects number: 185 loop: 1 flags: 1 play:)
				(= seconds 2)
			)
			(12
				(demeter setPri: 1 setCycle: Beg self)
			)
			(13
				((ScriptID 2 1) init: 2 1 self) ; Adam, "OUCH!"
			)
			(14
				(gEgo setMotion: MoveTo 203 132 self)
			)
			(15
				(gEgo setHeading: 270 self)
			)
			(16
				(Demeter init: 1 1 self) ; "What are you doing to my coral, child?!"
			)
			(17
				(HandsOn)
				(gSoundEffects flags: 0)
				(demeter setScript: demeterDemands)
				(self dispose:)
			)
		)
	)
)

(instance demeterExitShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 32)
				(gSoundEffects number: 603 loop: 1 play:)
				(demeter
					init:
					view: 187
					loop: 0
					cel: 0
					posn: 157 133
					setPri: 3
					setCycle: End self
				)
			)
			(1
				(demeter
					setCycle: 0
					view: 186
					setLoop: 0
					cel: 0
					posn: 154 135
					setCycle: Walk
					setMotion: MoveTo 151 142 self
				)
			)
			(2
				(gSoundEffects stop:)
				(demeter stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance demeterEnterShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 32)
				(gSoundEffects number: 603 loop: 1 play:)
				(demeter
					view: 186
					setLoop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 154 135 self
				)
			)
			(1
				(demeter
					setCycle: 0
					view: 187
					setLoop: 0
					cel: 6
					posn: 157 133
					setCycle: Beg self
				)
			)
			(2
				(gSoundEffects stop:)
				(demeter dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance demeterDemands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(Demeter init: 9 1 self) ; "I asked you what you have done to my coral!"
			)
			(2
				(= seconds 30)
			)
			(3
				(Demeter init: 10 1 self) ; "Well! I thought humans had the power of speech, but I guess I was wrong!"
			)
			(4
				(demeter setScript: demeterEnterShell)
				(self dispose:)
			)
		)
	)
)

(instance talkToDemeter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 2 271)
				(demeterDemands dispose:)
				(= cycles 1)
			)
			(1
				((ScriptID 2 1) init: 3 1 self) ; Adam, "I just put some solution on the coral that will create bacteria to eat up the oil. I only meant to help. I felt so sorry for the poor coral."
			)
			(2
				(Demeter init: 2 1 self) ; "A human? Feeling sympathy for the creatures of the sea?"
			)
			(3
				(Demeter init: 3 1 self) ; "Why... you're right! The oil is dissolving! What is your name then, magic one?"
			)
			(4
				((ScriptID 2 1) init: 4 1 self) ; Adam, "My name is Adam. But it's not magic - just science. Who are you?"
			)
			(5
				(Demeter init: 4 1 self) ; "I'm the Guardian of the Greens, but you can call me Demeter. It is my job to tend the Royal Gardens and insure that the city has plenty of plants to eat. But, as you can see, my garden is all but dead."
			)
			(6
				((ScriptID 2 1) init: 5 1 self) ; Adam, "What will you do when the plants are gone?"
			)
			(7
				(Demeter init: 12 0 self) ; "We shall be forced to leave Eluria... or die here. I'm not sure which is a worse fate."
			)
			(8
				(Demeter say: 5 1 self)
			)
			(9
				((ScriptID 2 1) init: 6 1 self) ; Adam, "Well, I came here with Delphineus. We're going to try to help the city - and maybe find Cetus."
			)
			(10
				(Demeter init: 6 1 self) ; "You would do that, human child? Perhaps that's just what we need - someone who knows the mysteries of man and the poisons he puts in the sea. Here, take this with you."
			)
			(11
				(SetFlag 27)
				(demeter hide:)
				(gEgo
					setCycle: 0
					view: 182
					loop: 0
					cel: 0
					x: 151
					y: 141
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(12
				(demeter show:)
				(NormalEgo 1)
				(gEgo ignoreHorizon: posn: 203 132 setPri: 7)
				(gEgo get: 21) ; healingPotion
				(SetScore 2 274)
				(= cycles 1)
			)
			(13
				((ScriptID 2 1) init: 7 1 self) ; Adam, "What is this?"
			)
			(14
				(= cycles 1)
			)
			(15
				(Demeter init: 7 0 self) ; "It is the last of my healing potion. It has a great power to heal. I used to make it from over thirty rare sea plants, but most of them are extinct now - killed off by poisons. There'll be no more potion."
			)
			(16
				(Demeter init: 13 1 self) ; "The potion does not work on my poor garden. Perhaps you will find a good use for it on your quest to save the city."
			)
			(17
				((ScriptID 2 1) init: 8 1 self) ; Adam, "Thank you for this gift, Demeter."
			)
			(18
				(Demeter init: 8 1 self) ; "Use it wisely, human child. And may Poseidon watch over you."
			)
			(19
				(demeter setScript: demeterEnterShell)
				(= cycles 1)
			)
			(20
				(SetFlag 8)
				(oilOnWhale cel: 6 setCycle: End)
				(superflShell
					init:
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 145 125 self
				)
			)
			(21
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance backAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(demeter setScript: demeterExitShell self)
			)
			(1
				(Demeter init: 11 1 self) ; "Oh, you again. Are you back to hurt my coral again?"
			)
			(2
				(demeter setScript: demeterDemands)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getSuperflShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 2 272)
				(gEgo setPri: 14 setMotion: MoveTo 144 75 self)
			)
			(1
				(= cycles 10)
			)
			(2
				(gEgo
					setCycle: 0
					view: 181
					loop: 1
					cel: 0
					x: 145
					y: 101
					cycleSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(3
				(superflShell dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(NormalEgo 2)
				(= global235 0)
				(gEgo ignoreHorizon: get: 22 posn: 142 109 setPri: 7) ; hermetShell
				(= cycles 12)
			)
			(5
				(Narrator init: 2 self) ; "Adam picks the shell up from the tar. Ick! It's a nice, roomy shell but it won't be much use covered with tar like that."
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwOutDemeter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(Demeter init: 14 1 self) ; "Well! I've never been so insulted in my life! Next you'll be wanting to put me in a pot of water!"
			)
			(2
				((ScriptID 2 1) init: 10 1 self) ; Adam, "Sorry. I didn't mean it."
			)
			(3
				(Demeter init: 15 1 self) ; "I certainly hope not!"
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkOnShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				((ScriptID 2 1) init: 9 1 self) ; Adam, "Hello! Anybody in there?"
			)
			(2
				(if (and (IsFlag 270) (not (IsFlag 27)))
					(gCurRoom setScript: backAgain)
				else
					(Narrator init: 23 self) ; "There is no response from the shell. The occupant, if there is one, is clearly not motivated to come out."
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance demeter of Actor
	(properties
		x 179
		y 121
		approachX 203
		approachY 132
		view 186
		priority 3
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 5 4) ; Look, Talk, Inventory
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 27))
					(Narrator init: 12) ; "A little lobster stands in front of the whale - and she doesn't look happy!"
				else
					(Narrator init: 14) ; "The Guardian of the Greens is a lobster named Demeter. Demeter is a reef lobster and has a multi-colored shell."
				)
			)
			(3 ; Do
				(Narrator init: 13) ; "The lobster wouldn't like being handled. She has her dignity, you know."
			)
			(5 ; Talk
				(gCurRoom setScript: talkToDemeter)
			)
			(10 ; Recycle
				(gCurRoom setScript: throwOutDemeter)
			)
			(4 ; Inventory
				(Demeter init: 16 1) ; "I'm not interested in that, child. I want to know what you have done to my coral!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plantLeft of Prop
	(properties
		x 82
		y 134
		view 180
		signal 16400
		cycleSpeed 14
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 56) ; "The Royal Gardens were once full of splendor but the plants here have fallen prey to dioxin and other poisons in the water. Even the little bits of life that still remain are pale and sickly."
			)
			(3 ; Do
				(Narrator init: 57) ; "Adam can do nothing to help those poor, dying plants except help his father lobby for cleaner water when he gets home."
			)
			(5 ; Talk
				(Narrator init: 62) ; "That's a nice gesture, but the sick plants do not respond."
			)
			(10 ; Recycle
				(Narrator init: 58) ; "The plants are sick and dying, but should be allowed to remain where they are."
			)
			(4 ; Inventory
				(switch invItem
					(21 ; healingPotion
						(Narrator init: 59) ; "There is not enough potion to seriously help those plants."
					)
					(3 ; beaker
						(Narrator init: 75) ; "Those plants are beyond helping with the solution since they're dying from more than just oil. The whale, however, is salvagable."
					)
					(else
						(Narrator init: 57) ; "Adam can do nothing to help those poor, dying plants except help his father lobby for cleaner water when he gets home."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plantRight of Prop
	(properties
		x 222
		y 128
		view 180
		loop 1
		cel 3
		signal 16400
		cycleSpeed 13
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(plantLeft doVerb: theVerb invItem &rest)
	)
)

(instance oilOnWhale of Prop
	(properties
		x 157
		y 46
		approachX 234
		approachY 55
		view 183
		loop 1
		priority 5
		signal 20496
		cycleSpeed 4
	)

	(method (init)
		(if (IsFlag 270)
			(= cel 5)
		)
		(super init: &rest)
		(self approachVerbs: 2 3) ; Look, Do
	)

	(method (doVerb theVerb invItem)
		(whale doVerb: theVerb invItem &rest)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance shell of Feature
	(properties
		x 173
		y 108
		onMeCheck 2
		approachX 206
		approachY 123
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 27))
					(Narrator init: 7) ; "A huge, beautiful shell lies in front of the whale statue."
				else
					(Narrator init: 15) ; "Demeter's house is a huge, heavy shell."
				)
			)
			(3 ; Do
				(cond
					((not (IsFlag 270))
						(Narrator init: 21) ; "Adam hears a nervous clicking inside the shell, but the shell is too heavy to lift."
					)
					((gCast contains: demeter)
						(Narrator init: 16) ; "Adam doesn't want to take the lobster's home. Besides, that shell is much too large to be of much use to Adam."
					)
					((IsFlag 27)
						(Narrator init: 17) ; "Demeter has done all she can for Adam. He decides to leave her to her dreams of greener gardens."
					)
					((and (IsFlag 270) (not (gEgo has: 21))) ; healingPotion
						(Narrator init: 72) ; "Adam can't move the heavy shell. If he wants to the see the lobster again, he should ask her to come out."
					)
					(else
						(gCurRoom setScript: backAgain)
					)
				)
			)
			(4 ; Inventory
				(Narrator init: 73) ; "Adam can't do that with the heavy shell."
			)
			(5 ; Talk
				(cond
					((IsFlag 27)
						(Narrator init: 17) ; "Demeter has done all she can for Adam. He decides to leave her to her dreams of greener gardens."
					)
					((not (gCast contains: demeter))
						(gCurRoom setScript: talkOnShell)
					)
					(else
						(Narrator init: 71) ; "The large shell does not respond."
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 70) ; "The shell is a natural part of the ocean and doesn't need to be thrown away."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance whale of Feature
	(properties
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 270))
					(Narrator store: 9 init: 8) ; "A large statue of a whale made entirely from coral takes a place of honor in the middle of the garden."
				else
					(Narrator store: 19 init: 18) ; "The fertilizer solution is working. The oil and tar on the coral is slowly dissolving in the bacteria the solution has helped create."
				)
			)
			(3 ; Do
				(if (not (IsFlag 270))
					(Narrator init: 10) ; "Adam can't get the oil off the whale with his hands. The coral is too delicate. Scrubbing it would do more damage than good."
				else
					(Narrator init: 78) ; "Adam has already done all he can to help the whale. Besides, that coral is sharp."
				)
			)
			(4 ; Inventory
				(switch invItem
					(3 ; beaker
						(gCurRoom setScript: clearOil)
					)
					(else
						(Narrator init: 11) ; "That won't help get the oil off the coral."
					)
				)
			)
			(5 ; Talk
				(if (not (IsFlag 270))
					((ScriptID 2 1) init: 11 1) ; Adam, "Poor coral. I wish there was something I could do to help."
				else
					((ScriptID 2 1) init: 12 1) ; Adam, "Hope you're feeling better now, coral!"
				)
			)
			(10 ; Recycle
				(Narrator init: 69) ; "The whale topiary is a beautiful, living thing! Adam doesn't want to throw it away!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leftBackGround of Feature
	(properties
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 63) ; "In the distance, more deserted ruins of this once-great city, lie disintegrating in the sea water."
			)
			(3 ; Do
				(Narrator init: 64) ; "There is no reason to visit those old ruins. Adam is already in the only part of the city that's inhabited."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightBackGround of Feature
	(properties
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(leftBackGround doVerb: theVerb &rest)
	)
)

(instance yellowCoral of Feature
	(properties
		onMeCheck 32
	)

	(method (doVerb theVerb invItem)
		(plantLeft doVerb: theVerb invItem &rest)
	)
)

(instance columnsAtRight of Feature
	(properties
		onMeCheck 64
		lookStr 65
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 3 4) ; Do, Inventory
				(Narrator init: 66) ; "There's nothing Adam can do with those particular columns."
			)
			((== theVerb 10) ; Recycle
				(Narrator init: 67) ; "The columns are part of Eluria's natural history and don't need to be thrown away."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance redStarFish of Feature
	(properties
		onMeCheck 128
		lookStr 65
	)
)

(instance cobbleStone of Feature
	(properties
		onMeCheck 256
		lookStr 54
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4 10) ; Do, Inventory, Recycle
			(Narrator init: 55) ; "The cobblestones add a bit of beauty to this poor, dying garden. Adam doesn't want to disturb them."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance moss of Feature
	(properties
		onMeCheck 4096
		lookStr 60
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4) ; Do, Inventory
			(Narrator init: 61) ; "Adam doesn't want to disturb the living plants."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance oil0 of PicView
	(properties
		x 82
		y 100
		sightAngle 90
		view 184
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil1 of PicView
	(properties
		x 232
		y 101
		sightAngle 90
		view 184
		cel 1
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil2 of PicView
	(properties
		x 72
		y 64
		sightAngle 90
		view 184
		cel 2
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil3 of PicView
	(properties
		x 220
		y 59
		sightAngle 90
		view 184
		cel 3
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil4 of PicView
	(properties
		x 34
		y 99
		sightAngle 90
		view 184
		cel 4
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil5 of PicView
	(properties
		x 52
		y 185
		sightAngle 90
		view 184
		cel 5
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil6 of PicView
	(properties
		x 175
		y 121
		sightAngle 90
		onMeCheck 0
		view 184
		cel 6
		priority 4
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil7 of PicView
	(properties
		x 212
		y 111
		sightAngle 90
		view 184
		cel 7
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil8 of PicView
	(properties
		x 262
		y 82
		sightAngle 90
		view 184
		cel 8
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil9 of PicView
	(properties
		x 286
		y 185
		sightAngle 90
		view 184
		cel 9
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil10 of PicView
	(properties
		x 150
		y 102
		sightAngle 90
		view 184
		cel 10
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil11 of PicView
	(properties
		x 218
		y 126
		sightAngle 90
		view 184
		cel 11
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil12 of PicView
	(properties
		x 233
		y 180
		sightAngle 90
		view 184
		cel 12
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil13 of PicView
	(properties
		x 90
		y 141
		sightAngle 90
		view 184
		cel 13
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance oil14 of PicView
	(properties
		x 105
		y 94
		sightAngle 90
		view 184
		cel 14
		priority 1
		signal 20496
	)

	(method (onMe)
		(return 0)
	)
)

(instance sneaker of Garbage
	(properties
		x 177
		y 146
		view 180
		loop 2
		cel 1
		flag 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 33) ; "There's an old brown shoe on the ground. It looks like the nerd variety of polyester plastic shoe."
			)
			(3 ; Do
				(Narrator init: 34) ; "Adam wouldn't wear that kind of shoe if he was on a bed of coals barefoot!"
			)
			(10 ; Recycle
				(Narrator init: 35 self) ; "Adam carefully picks up the brown shoe and does the world a favor by throwing it away."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance beerCan of Garbage
	(properties
		x 176
		y 172
		view 180
		loop 2
		cel 2
		flag 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 36) ; "An old vegetable can has been ditched. Ummm. Broccoli."
			)
			(3 ; Do
				(Narrator init: 37) ; "Adam HATES broccoli!"
			)
			(10 ; Recycle
				(Narrator init: 38 self) ; "With great relief, Adam cans the can of broccoli."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance book of Garbage
	(properties
		x 138
		y 131
		view 180
		loop 2
		cel 3
		flag 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 43) ; "A small sheet of metal lies on the garden grass."
			)
			(3 ; Do
				(Narrator init: 44) ; "The metal sheet does not interest Adam. It's trash."
			)
			(10 ; Recycle
				(Narrator init: 45 self) ; "Adam slowly slips the sheet into the sack."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance container of Garbage
	(properties
		x 57
		y 138
		view 180
		loop 2
		cel 4
		flag 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 48) ; "There's a broken, empty pot littering the Royal Gardens."
			)
			(3 ; Do
				(Narrator init: 49) ; "The broken pot is of no use to a boy like Adam."
			)
			(10 ; Recycle
				(Narrator init: 50 self) ; "Adam decides to be nice and clean up the old pot."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tire of Garbage
	(properties
		x 171
		y 122
		view 180
		loop 2
		cel 5
		priority 5
		signal 16
		flag 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 39) ; "An old tire has sunk to the bottom of the sea. Why a land vehicle's tire is in the ocean, Adam will never know."
			)
			(3 ; Do
				(Narrator init: 46) ; "Adam doesn't need a spare tire. He's trying to lose weight."
			)
			(10 ; Recycle
				(Narrator init: 47 self) ; "Adam wheels the rubber to a permanent parking spot."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance purse of Garbage
	(properties
		x 93
		y 143
		view 180
		loop 2
		cel 6
		flag 11
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 40) ; "Some lady must be looking really hard for her purse, 'cause there's one just lying there."
			)
			(3 ; Do
				(Narrator init: 41) ; "Adam wouldn't be caught dead carrying a purse!"
			)
			(10 ; Recycle
				(Narrator init: 42 self) ; "Adam snatches the purse and bags it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fishingPole of Garbage
	(properties
		x 173
		y 134
		approachX 129
		approachY 128
		view 180
		loop 2
		cel 7
		flag 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 30) ; "There's an old fishing line on the ground. It looks like what 'the one that got away' got away with."
			)
			(3 ; Do
				(Narrator init: 31) ; "Adam doesn't fish, thanks."
			)
			(10 ; Recycle
				(Narrator init: 32 self) ; "Adam reels in the old fishing line."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sixPack of Garbage
	(properties
		x 208
		y 169
		view 180
		loop 2
		cel 8
		flag 13
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 27) ; "An entire six pack of soda has found it's way to the bottom of the sea. Too bad fish don't like carbonated drinks."
			)
			(3 ; Do
				(Narrator init: 28) ; "Adam can't drink underwater. Besides, that's not Adam's cola brand."
			)
			(10 ; Recycle
				(Narrator init: 29 self) ; "Adam slams the soda down... his garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wheel of Garbage
	(properties
		x 117
		y 137
		view 180
		loop 2
		cel 9
		flag 14
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 24) ; "A beat-up, bent-up bicycle wheel lies alone on the garden's floor."
			)
			(3 ; Do
				(Narrator init: 25) ; "A single, beat-up bicycle wheel is hardly useful to Adam at the bottom of the ocean."
			)
			(10 ; Recycle
				(Narrator init: 26 self) ; "Adam rides the wheel into the trash."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance windex of Garbage
	(properties
		x 135
		y 148
		view 180
		loop 2
		cel 10
		flag 15
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 51) ; "That spray bottle is clearly of no use under the sea!"
			)
			(3 ; Do
				(Narrator init: 52) ; "Why would Adam need a spray bottle when he's surrounded by water! He should clean it up though."
			)
			(10 ; Recycle
				(Narrator init: 53 self) ; "Adam puts the spritz on the spray bottle."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance superflShell of Actor
	(properties
		x 146
		y 71
		approachX 142
		approachY 145
		view 183
		loop 2
		priority 4
		signal 20496
		cycleSpeed 7
		illegalBits 0
		moveSpeed 5
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 5 4) ; Look, Talk, Inventory
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 20) ; "A glop of tar has fallen from the coral. Something white is sticking up out of the tar."
			)
			(3 ; Do
				(gCurRoom setScript: getSuperflShell)
			)
			(10 ; Recycle
				(Narrator init: 3) ; "Adam looks at the tar-coated shell and thinks that, though dirty, it's a very nice shell. He decides not to throw it away."
			)
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator init: 76) ; "The shell could use a good cleaning, true, but try picking it up first."
					)
					(else
						(Narrator init: 77) ; "Adam doesn't need to do anything to that shell right now except pick it up."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Demeter of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 185
		loop 3
		viewInPrint 1
		charNum 18
		keepWindow 1
	)

	(method (init)
		(super init: demBust demEyes demMouth &rest)
	)
)

(instance demBust of Prop
	(properties
		view 185
	)
)

(instance demEyes of Prop
	(properties
		nsTop 13
		view 185
		loop 2
		cycleSpeed 30
	)
)

(instance demMouth of Prop
	(properties
		nsTop 18
		nsLeft 13
		view 185
		loop 1
		cycleSpeed 10
	)
)

