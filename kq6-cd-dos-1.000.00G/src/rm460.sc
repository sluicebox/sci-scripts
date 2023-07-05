;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm460 0
)

(local
	[local0 9]
	[local9 7] = [300 120 207 260 70 5 140]
	[local16 7] = [11 11 41 23 23 23 23]
	[local23 7] = [0 4 2 4 2 2 0]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		((= [local0 temp0] (aBee new:))
			x: [local9 temp0]
			y: [local16 temp0]
			z: [local23 temp0]
			init:
		)
	)
)

(instance myConv of Conversation
	(properties)
)

(instance wormOut of Sound
	(properties
		number 462
	)
)

(instance wormIn of Sound
	(properties
		number 463
	)
)

(instance rm460 of KQ6Room
	(properties
		noun 3
		picture 460
	)

	(method (init)
		(gGame handsOn:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 141 42 187 92 187 130 176 164 183 189 177 228 185 317 150 317 123 243 123 229 129 199 113 193 119 170 117 172 108 255 111 305 109 298 104 269 103 258 106 242 106 232 100 194 98 178 94 162 95 155 106 125 106 104 113 69 112 44 114 15 106 19 103 89 103 90 100 0 97 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 181 132 181 136 175 142 144 143 115 140 108 134 117 129 174 129
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 308 138 302 142 291 139 286 139 282 152 267 152 265 144 259 139 243 138 240 135 247 126 304 126
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 256 149 246 157 204 157 197 151 201 143 249 143
					yourself:
				)
		)
		(super init: &rest)
		(localproc_0)
		(widow init:)
		(Lock rsMESSAGE modNum 0)
		(if (== gPrevRoomNum 461) ; blackWidowInset
			(gEgo posn: 74 182 loop: 2 setScale: Scaler 100 40 135 0 init:)
			(cond
				(((ScriptID 40 0) spiderBit:) ; rWonder
					(gEgo posn: 65 187)
					(gCurRoom setScript: widowKillsAlex 0 801)
				)
				(((ScriptID 40 0) parchmentBit:) ; rWonder
					(gEgo posn: 65 187)
					(gCurRoom setScript: widowKillsAlex 0 802)
				)
				(((ScriptID 40 0) gotParchment:) ; rWonder
					(gEgo posn: 59 172)
					((ScriptID 40 0) gotParchment: 0) ; rWonder
					(gCurRoom setScript: lookAtParchment)
				)
				(else
					(gEgo posn: 68 176)
					(gGlobalSound2 fade: 0 10 10)
					(gGlobalSound
						number: 460
						setLoop: -1
						setVol: 0
						play:
						fade: 127 10 10
					)
				)
			)
		else
			(gCurRoom setScript: egoEnters)
			(gGlobalSound number: 460 setLoop: -1 play:)
		)
		(if (not (IsFlag 136))
			(scrapOfPaper init: stopUpd:)
		)
		(gFeatures
			add:
				bookWormBookPile
				otherBookPiles
				oxymoronBookPile
				dipthongBookPile
				cBrownBookPile
				cLGreyBookPile
				cLBlueBookPile
				web
			eachElementDo: #init
		)
	)

	(method (doit)
		(cond
			((gCurRoom script:))
			((gEgo inRect: 29 177 112 189)
				(gCurRoom setScript: widowKillsAlex 0 3)
			)
			((gEgo edgeHit:)
				(gGlobalSound fade: 0 10 10)
				(gCurRoom setScript: egoExits)
			)
		)
		(super doit:)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 1 135
					setScale: Scaler 100 40 135 0
					init:
					setMotion: PolyPath 16 135 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self
				)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 450)
			)
		)
	)
)

(instance bookworm of Prop
	(properties
		x 140
		y 139
		z 40
		noun 4
		view 463
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(94 ; participle
				(self setScript: 0)
				(gGame handsOff:)
				(participle4U start: 5)
				(gCurRoom setScript: participle4U)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(5 ; Do
				(super doVerb: theVerb &rest)
			)
			(else
				(gGame handsOff:)
				(self setScript: inventOnWorm 0 theVerb)
			)
		)
	)
)

(class ScriptFeature of Feature
	(properties
		script 0
	)

	(method (init)
		(self approachVerbs: 1) ; Look
		(super init: &rest)
	)

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((bookworm script:)
						(gMessager say: 5 5 19 1) ; "Alexander has already gained Bookworm's attention, and Bookworm has not invited him to take a book."
					)
					((== ((gInventory at: 29) owner:) gCurRoomNum) ; participle
						(gMessager say: 5 5 6 1) ; "Alexander doesn't need anything more from Bookworm or his friends."
					)
					(else
						(gCurRoom setScript: rummage 0 self)
					)
				)
			)
			(2 ; Talk
				(cond
					((bookworm script:)
						(gMessager say: 5 5 19 1) ; "Alexander has already gained Bookworm's attention, and Bookworm has not invited him to take a book."
					)
					((== ((gInventory at: 29) owner:) gCurRoomNum) ; participle
						(gMessager say: 5 5 6 1) ; "Alexander doesn't need anything more from Bookworm or his friends."
					)
					((not (IsFlag 40))
						(gMessager say: 5 2 7 1) ; "Alexander should read the books if he wants to get information from them."
					)
					((IsFlag 7)
						(gCurRoom setScript: callBooks 0 0)
					)
					(else
						(SetFlag 60)
						(gCurRoom setScript: callBooks 0 1)
					)
				)
			)
			(94 ; participle
				(gGame handsOff:)
				(gCurRoom setScript: participle4U)
			)
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(else
				(self setScript: inventOnBooks 0 theVerb)
			)
		)
	)
)

(instance bookWormBookPile of ScriptFeature
	(properties
		x 138
		y 135
		noun 5
		onMeCheck 8
		approachX 115
		approachY 146
	)
)

(instance otherBookPiles of ScriptFeature
	(properties
		x 298
		y 115
		noun 5
		onMeCheck 4
		approachX 268
		approachY 131
	)
)

(instance cBrownBookPile of ScriptFeature
	(properties
		x 188
		y 116
		noun 5
		onMeCheck 64
		approachX 186
		approachY 123
	)
)

(instance cLGreyBookPile of ScriptFeature
	(properties
		x 230
		y 153
		noun 5
		onMeCheck 128
		approachX 233
		approachY 163
	)
)

(instance cLBlueBookPile of ScriptFeature
	(properties
		x 275
		y 147
		noun 5
		onMeCheck 512
		approachX 249
		approachY 141
	)
)

(instance oxymoronBookPile of ScriptFeature
	(properties
		x 84
		y 107
		noun 5
		onMeCheck 2
		approachX 66
		approachY 120
	)
)

(instance dipthongBookPile of ScriptFeature
	(properties
		x 223
		y 114
		noun 5
		onMeCheck 32
		approachX 208
		approachY 127
	)
)

(instance rummage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(1
				(if (== register bookWormBookPile)
					(gEgo
						view: 461
						normal: 0
						posn: (+ (register approachX:) 2) (register approachY:)
						setLoop: 4
						cel: 0
						cycleSpeed: 6
						setCycle: End self
					)
				else
					(gEgo
						view: 467
						setLoop: (if (== register cLBlueBookPile) 1 else 0)
						cel: 0
						normal: 0
						posn:
							(- (register approachX:) 2)
							(+ (register approachY:) 1)
						cycleSpeed: 6
						setCycle: End self
					)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					posn: (- (gEgo x:) 2) (gEgo y:)
					reset: (if (== register cLBlueBookPile) 0 else 6)
				)
				(= cycles 8)
			)
			(4
				(cond
					((not (IsFlag 7))
						(gCurRoom setScript: handsOffTheGoods 0 register)
					)
					((not (IsFlag 61))
						(gCurRoom setScript: askForParti 0 register)
					)
					((== ((gInventory at: 36) owner:) gCurRoomNum) ; riddleBook
						(gCurRoom setScript: anythingYet 0 register)
					)
					(else
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance handsOffTheGoods of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 40)
				(if (== register bookWormBookPile)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 107 142 self)
				)
				(wormOut play:)
				(bookworm init: setCycle: End)
			)
			(1
				(if (!= register bookWormBookPile)
					(gEgo setHeading: 45)
				)
				(= cycles 10)
			)
			(2
				(bookworm setLoop: 4 cel: 0 setCycle: End self)
			)
			(3
				(bookworm setLoop: 5 cel: 14)
				(= cycles 8)
			)
			(4
				(myConv add: -1 5 5 3 1 add: -1 5 5 3 2 init: self) ; "Hey! Hands off the goods there, son.", "Oh, sorry."
			)
			(5
				(wormIn play:)
				(bookworm setLoop: 5 cel: 14 setCycle: Beg self)
			)
			(6
				(gGame handsOn:)
				(bookworm dispose:)
				(LoadMany 0 1044 1046 1045 1007)
				(self dispose:)
			)
		)
	)
)

(instance askForParti of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 40)
				(SetFlag 61)
				(cond
					((== register callBooks)
						(wormOut play:)
						(bookworm init: setCycle: End self)
						(self cue:)
					)
					((== register bookWormBookPile)
						(wormOut play:)
						(bookworm init: setCycle: End self)
						(self cue:)
					)
					(else
						(wormOut play:)
						(bookworm init: setCycle: End self)
						(gEgo setMotion: PolyPath 107 142 self)
					)
				)
			)
			(1)
			(2
				(if (!= register bookWormBookPile)
					(gEgo setHeading: 45)
				)
				(= cycles 10)
			)
			(3
				(bookworm setLoop: 4 cel: 0 setCycle: End self)
			)
			(4
				(myConv
					add: -1 5 5 4 1 ; "What do you think YOU'RE doing?"
					add: -1 5 5 4 2 ; "I'm sorry. I didn't realize these books had an owner. I'm in need of a rare book."
					add: -1 5 5 4 3 ; "Hmph! No owner! ALL books have owners, my good man. And THIS book owner--Bookworm to you--wouldn't part with one of his books for anything!"
					add: -1 5 5 4 4 ; "Isn't there something I can do for you to pay for the book?"
					add: -1 5 5 4 5 ; "Hmm. Let's see. Do you have an itinerant clause?"
					init: self
				)
			)
			(5
				(bookworm setLoop: 2 cel: 0 setCycle: End self)
			)
			(6
				(bookworm cel: 0)
				(= cycles 4)
			)
			(7
				(gMessager say: 5 5 4 6 self) ; "No. No clauses at all, I'm afraid."
			)
			(8
				(oxymoron init:)
				(self setScript: oxyOut self)
			)
			(9
				(gMessager say: 5 5 4 7 self) ; "As an exception, you always should!"
			)
			(10
				(self setScript: oxyIn self)
			)
			(11
				(dipthong init:)
				(self setScript: dipthOut self)
			)
			(12
				(gMessager say: 5 5 4 8 self) ; "(IN AWE) AAoooUU!"
			)
			(13
				(self setScript: dipthIn self)
			)
			(14
				(myConv add: -1 5 5 4 9 add: -1 5 5 4 10 init: self) ; "Don't mind Oxymoron and Diphthong. They're fairly limited grammatical principles, you know.", "Hmm, let's see. A marsh pig that does taxes?"
			)
			(15
				(bookworm setLoop: 2 cel: 0 setCycle: End self)
			)
			(16
				(bookworm cel: 0)
				(= seconds 3)
			)
			(17
				(myConv add: -1 5 5 4 11 add: -1 5 5 4 12 init: self) ; "(BLUSHING) Uh, no. I'm afraid not.", "A dangling participle?"
			)
			(18
				(if (gEgo has: 29) ; participle
					(gGame handsOff:)
					(participle4U start: 5)
					(gCurRoom setScript: participle4U)
				else
					(bookworm setLoop: 2 cel: 0 setCycle: End self)
				)
			)
			(19
				(bookworm cel: 0)
				(= cycles 4)
			)
			(20
				(myConv add: -1 5 5 4 13 add: -1 5 5 4 14 init: self) ; "I'm fresh out.", "A purple fiddlewacker?"
			)
			(21
				(bookworm setLoop: 2 cel: 0 setCycle: End self)
			)
			(22
				(bookworm cel: 0)
				(= cycles 4)
			)
			(23
				(myConv add: -1 5 5 4 15 add: -1 5 5 4 16 init: self) ; "No.... I don't think so. Sorry.", "An idiosyncrasy, perhaps?"
			)
			(24
				(bookworm setLoop: 2 cel: 0 setCycle: End self)
			)
			(25
				(bookworm cel: 0)
				(= cycles 4)
			)
			(26
				(myConv add: -1 5 5 4 17 add: -1 5 5 4 18 init: self) ; "'Fraid not.", "Hah! Then what good are you?!"
			)
			(27
				(wormIn play:)
				(bookworm setLoop: 5 cel: 14 setCycle: Beg self)
			)
			(28
				(gGame handsOn:)
				(bookworm dispose:)
				(LoadMany 0 1044 1046 1045 1007)
				(self dispose:)
			)
		)
	)
)

(instance anythingYet of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((== register callBooks)
						(wormOut play:)
						(bookworm init: setCycle: End self)
						(self cue:)
					)
					((== register bookWormBookPile)
						(wormOut play:)
						(bookworm init: setCycle: End self)
						(self cue:)
					)
					(else
						(wormOut play:)
						(bookworm init: setCycle: End self)
						(gEgo setMotion: PolyPath 107 142 self)
					)
				)
			)
			(1)
			(2
				(if (!= register bookWormBookPile)
					(gEgo setHeading: 45)
				)
				(= cycles 10)
			)
			(3
				(gMessager say: 5 5 5 1 self) ; "Do you have anything interesting yet?"
			)
			(4
				(bookworm setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(bookworm cel: 0)
				(= cycles 4)
			)
			(6
				(if (IsFlag 120)
					(= temp0 (Random 1 5))
					(gMessager say: 5 5 18 temp0 self)
				else
					(SetFlag 120)
					(self setScript: stupidOxyScript self)
				)
			)
			(7
				(bookworm setLoop: 2 cel: 0 setCycle: End self)
			)
			(8
				(bookworm cel: 0)
				(= cycles 3)
			)
			(9
				(gMessager say: 5 5 5 4 self) ; "Uh...let me see what I have."
			)
			(10
				(gGame handsOn:)
				(bookworm setScript: waitForAnswer)
				(self dispose:)
			)
		)
	)
)

(instance stupidOxyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oxymoron init:)
				(self setScript: oxyOut self)
			)
			(1
				(gMessager say: 5 5 5 2 self) ; "A regular abnormality?"
			)
			(2
				(self setScript: oxyIn self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance waitForAnswer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bookworm stopUpd:)
				(= seconds 10)
			)
			(1
				(gGame handsOff:)
				(gEgo
					normal: 0
					view: 461
					setLoop: 3
					cel: 0
					normal: 0
					setCycle: End self
				)
			)
			(2
				(gEgo reset: 6)
				(= cycles 8)
			)
			(3
				(gMessager say: 1 0 2 1 self) ; "Well, I hardly expected you to have anything useful! Good day!"
			)
			(4
				(wormIn play:)
				(bookworm setLoop: 5 cel: 14 setCycle: Beg self)
			)
			(5
				(bookworm dispose:)
				(LoadMany 0 1044 1046 1045 1007)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance callBooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 107 142 self)
			)
			(1
				(gEgo setHeading: 90)
				(= cycles 10)
			)
			(2
				(if (IsFlag 61)
					(gMessager say: 5 2 5 1 self) ; "(CALLING OUT) Are you there, most venerable Bookworm?"
				else
					(gMessager say: 5 2 8 1 self) ; "(CALLING OUT) Hello? Is anyone there in the books?"
				)
			)
			(3
				(cond
					((== register 1)
						(gCurRoom setScript: talkGoAway)
					)
					((IsFlag 61)
						(gCurRoom setScript: anythingYet 0 self)
					)
					((IsFlag 7)
						(gCurRoom setScript: askForParti 0 self)
					)
				)
			)
		)
	)
)

(instance talkGoAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wormOut play:)
				(bookworm init: setCycle: End self)
			)
			(1
				(gMessager say: 5 2 8 2 self) ; "NO! There's no one here!"
			)
			(2
				(wormIn play:)
				(bookworm setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(bookworm dispose:)
				(self dispose:)
			)
		)
	)
)

(instance inventOnBooks of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(client approachX:)
						(client approachY:)
						self
				)
			)
			(1
				(= temp0
					(GetAngle (gEgo x:) (gEgo y:) (client x:) (client y:))
				)
				(gEgo setHeading: temp0 self)
			)
			(2
				(gMessager say: 5 0 0 1 self) ; "There's no reason to use that on a pile of books."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance inventOnWorm of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (OneOf register 25 12 66 85 34)
					(gMessager say: 4 register 0 0 self)
				else
					(gMessager say: 4 0 0 0 self) ; "Would you take this in exchange for a rare book?"
				)
			)
			(1
				(wormIn play:)
				(bookworm setLoop: 5 setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(bookworm dispose:)
				(self dispose:)
			)
		)
	)
)

(instance parti of Actor
	(properties
		x 124
		y 136
		view 468
		priority 11
		signal 16400
		cycleSpeed 8
	)
)

(instance participle4U of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 98 134 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gMessager say: 5 94 0 1 self) ; "Hello, Bookworm? I have something you might be interested in!"
			)
			(3
				(wormOut play:)
				(bookworm init: setCycle: End self)
			)
			(4
				(gMessager say: 5 94 0 2 self) ; "Well, what is it this time?"
			)
			(5
				(gGame handsOff:)
				(gMessager say: 4 94 0 1 self) ; "I found this little fellow lost on another island."
			)
			(6
				(gEgo
					normal: 0
					view: 468
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					posn: 96 136
					setPri: 12
					setCycle: End self
				)
			)
			(7
				(parti init:)
				(bookworm setLoop: 3 cel: 0 setCycle: End self)
			)
			(8
				(gEgo posn: 98 134 reset: 0)
				(bookworm setLoop: 5 cel: 14)
				(= cycles 8)
			)
			(9
				(myConv
					add: -1 4 94 0 2 ; "Coming home, I am now TO!"
					add: -1 4 94 0 3 ; "(TO DANGLING PARTICIPLE) THERE you are, you naughty boy! I TOLD you not to leave the island!"
					add: -1 4 94 0 4 ; "Glad I am, seeing you too!"
					init: self
				)
			)
			(10
				(oxymoron init:)
				(self setScript: oxyOut self)
			)
			(11
				(gMessager say: 4 94 0 5 self) ; "A most solemn celebration!"
			)
			(12
				(self setScript: oxyIn self)
			)
			(13
				(dipthong init:)
				(self setScript: dipthOut self)
			)
			(14
				(gMessager say: 4 94 0 6 self) ; "(VERY EXCITED) GooEEEoo!"
			)
			(15
				(self setScript: dipthIn self)
			)
			(16
				(parti setCycle: End self)
			)
			(17
				(myConv
					add: -1 4 94 0 7 ; "(TO ALEXANDER) So, you found my dangling participle! I suppose I'll have to give you something. Let's see now, was it a rare book you wanted?"
					add: -1 4 94 0 8 ; "Yes, sir."
					add: -1 4 94 0 9 ; "Well, then none of THESE will do. They've been sitting in the sun far too long and must be well-cooked by now."
					init: self
				)
			)
			(18
				(parti dispose:)
				(wormIn play:)
				(bookworm setLoop: 5 cel: 14 setCycle: Beg self)
			)
			(19
				(wormOut play:)
				(bookworm init: setLoop: 1 cel: 0 setCycle: End self)
				(gEgo posn: 98 134 reset: 6 setMotion: PolyPath 109 154 self)
			)
			(20
				(gEgo setHeading: 45)
				(= cycles 6)
			)
			(21)
			(22
				(gMessager say: 4 94 0 10 self) ; "THIS one is far more rare. A delicious little tidbit."
			)
			(23
				(gEgo
					normal: 0
					view: 461
					setLoop: 4
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(24
				(gGame givePoints: 2)
				(wormIn play:)
				(bookworm setLoop: 5 setCycle: Beg self)
				(gEgo cycleSpeed: 1 setCycle: Beg)
			)
			(25
				(bookworm dispose:)
				(gMessager say: 4 94 0 11 self) ; "Uh, thanks."
			)
			(26
				(gGame handsOn:)
				(gEgo posn: 109 154 get: 36 put: 29 gCurRoomNum reset: 6) ; riddleBook, participle
				(LoadMany 0 1044 1046 1045 1007)
				(self dispose:)
			)
		)
	)
)

(instance widow of Prop
	(properties
		x 70
		y 189
		z 35
		noun 11
		approachX 68
		approachY 176
		view 460
		loop 5
		priority 15
		signal 16400
		cycleSpeed 3
	)

	(method (init)
		(self approachVerbs: 1 2) ; Look, Talk
		(if (== gPrevRoomNum 461) ; blackWidowInset
			(self cel: 12)
		else
			(self cel: 0)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: widowKillsAlex 0 803)
			)
			(1 ; Look
				(gCurRoom newRoom: 461) ; blackWidowInset
			)
			(2 ; Talk
				(gCurRoom newRoom: 461) ; blackWidowInset
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance web of Feature
	(properties
		x 69
		y 189
		noun 8
		onMeCheck 16
		approachX 68
		approachY 176
	)

	(method (init)
		(self approachVerbs: 1 2) ; Look, Talk
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom newRoom: 461) ; blackWidowInset
			)
			(5 ; Do
				(gCurRoom setScript: widowKillsAlex 0 804)
			)
			(2 ; Talk
				(gCurRoom newRoom: 461) ; blackWidowInset
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scrapOfPaper of View
	(properties
		x 92
		y 147
		noun 8
		approachX 68
		approachY 176
		view 460
		priority 15
		signal 16400
	)

	(method (init)
		(self approachVerbs: 1 0) ; Look
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom newRoom: 461) ; blackWidowInset
			)
			(5 ; Do
				(gCurRoom setScript: widowKillsAlex 0 804)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance loveInset of View
	(properties
		x 65
		y 189
		z 94
		view 462
		loop 4
		priority 15
		signal 16400
	)
)

(instance lookAtParchment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 12 5 12 1 self) ; "Alexander snatches the scrap of parchment, curious to see what's written on it."
			)
			(2
				(gEgo
					view: 462
					setLoop: 7
					cel: 0
					normal: 0
					cycleSpeed: 8
					posn: 61 174
					setCycle: CT 1 1 self
				)
			)
			(3
				(gGlobalSound4 number: 468 setLoop: 1 play:)
				(scrapOfPaper dispose:)
				(gEgo setCycle: End self)
				(SetFlag 136)
			)
			(4
				(loveInset init:)
				(= seconds 6)
			)
			(5
				(loveInset dispose:)
				(gGame givePoints: 2)
				(gGlobalSound2 fade: 0 10 10 self)
				(gGlobalSound
					number: 460
					setLoop: -1
					setVol: 0
					play:
					fade: 127 10 10
				)
				(gEgo
					setLoop: 3
					cel: 0
					cycleSpeed: 6
					posn: 58 173
					setCycle: End self
				)
			)
			(6 0)
			(7
				(gMessager say: 12 5 12 2 self) ; "The wind blows the scrap of paper from Alexander's hand. But, he remembers what it said well enough."
			)
			(8
				(gEgo posn: 59 172 reset: 2)
				(gGame handsOn:)
				(SetFlag 57)
				(self dispose:)
			)
		)
	)
)

(instance widowKillsAlex of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(801
						(+= state 2)
						(self cue:)
					)
					(802
						(+= state 2)
						(self cue:)
					)
					(803
						(gMessager say: 11 5 0 1 self) ; "Alexander reaches out to touch the black widow."
					)
					(804
						(gMessager say: 8 5 0 1 self) ; "Alexander investigates the intricate spider's web in the corner...."
					)
					(3
						(self cue:)
					)
				)
			)
			(1
				(gEgo setMotion: PolyPath 68 176 self)
			)
			(2
				(gEgo setMotion: MoveTo 65 187 self)
			)
			(3
				(if (== register 3)
					(gEgo
						view: 462
						setLoop: 0
						cel: 0
						normal: 0
						cycleSpeed: 8
						posn: 70 189
						setCycle: CT 8 1 self
					)
				else
					(gEgo
						view: 462
						setLoop: 5
						cel: 0
						normal: 0
						cycleSpeed: 8
						posn: 65 189
						setCycle: End self
					)
				)
				(widow setCycle: End self)
			)
			(4)
			(5
				(widow setLoop: 6 cel: 0 posn: 68 162 z: 0)
				(= cycles 3)
			)
			(6
				(switch register
					(801
						(gMessager say: 9 5 0 2 self) ; "Ah! How sweet the matrimony! I knew you'd change your mind!"
					)
					(802
						(gMessager say: 12 5 11 2 self) ; "After my goods, are you? What a greedy little man you are!"
					)
					(803
						(gMessager say: 11 5 0 2 self) ; "That's right! GO with your feelings! GET closer to me!"
					)
					(804
						(gMessager say: 8 5 0 2 self) ; "The spider who lives there is NOT amused!"
					)
					(3
						(gMessager say: 8 3 0 1 self) ; "Oh, no! A black widow spider's web!"
					)
				)
			)
			(7
				(switch register
					(801
						(gMessager say: 9 5 0 3 self) ; "Alexander feels the sharp prick of the black widow's teeth, then a strange, burning sensation."
					)
					(802
						(gMessager say: 12 5 11 3 self) ; "Alexander feels the sharp prick of the black widow's teeth, then a strange, burning sensation."
					)
					(803
						(gMessager say: 11 5 0 3 self) ; "Alexander feels the tiny pin prick of the spider's bite and the slow burning of her poison."
					)
					(804
						(gMessager say: 8 5 0 3 self) ; "Alexander feels the tiny pin prick of the spider's bite and the slow burning of her poison."
					)
					(3
						(gMessager say: 8 5 0 3 self) ; "Alexander feels the tiny pin prick of the spider's bite and the slow burning of her poison."
					)
				)
			)
			(8
				(if (== register 3)
					(gEgo view: 462 setLoop: 1 cel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(9
				(gGlobalSound2 stop:)
				(gGlobalSound number: 466 setLoop: 1 play: self)
				(if (== register 3)
					(gEgo view: 462 setLoop: 2 cel: 0 setCycle: End self)
				else
					(gEgo
						view: 462
						setLoop: 6
						cel: 0
						posn: 63 187
						setCycle: End self
					)
				)
				(widow setCycle: End self)
			)
			(10)
			(11)
			(12
				(switch register
					(801
						(gMessager say: 9 5 0 4 self) ; "Ah! A widow AGAIN!"
					)
					(802
						(gMessager say: 12 5 11 4 self) ; "That's what you get for preferring that old scrap of paper to me!"
					)
					(803
						(gMessager say: 11 5 0 4 self) ; "Thanks for the memories!"
					)
					(else
						(self cue:)
					)
				)
			)
			(13
				(gGame handsOn:)
				((ScriptID 40 0) spiderBit: 0) ; rWonder
				((ScriptID 40 0) parchmentBit: 0) ; rWonder
				(if (== register 3)
					(EgoDead 4) ; "Well, walked right into that one!"
				else
					(EgoDead 3) ; "Why do you think they call her a WIDOW?"
				)
			)
		)
	)
)

(instance aBee of Actor
	(properties
		noun 14
		view 460
		loop 11
		signal 26624
	)

	(method (init)
		(beeLine start: z)
		(self setStep: 12 10 setPri: 14 setScript: (beeLine new:))
		(super init:)
	)
)

(instance beeLine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setCycle: Fwd
					setMotion: MoveTo (Random 5 50) (Random 5 60) self
				)
			)
			(1
				(client
					setLoop: 13
					cel: 0
					posn: (+ (client x:) 6) (client y:)
					setCycle: End self
				)
			)
			(2
				(client
					setLoop: 12
					setCycle: Fwd
					posn: (- (client x:) 9) (+ (client y:) 14)
				)
				(= ticks 2)
			)
			(3
				(client setMotion: MoveTo (Random 260 310) (Random 5 60) self)
			)
			(4
				(client
					setLoop: 14
					cel: 0
					posn: (- (client x:) 6) (client y:)
					setCycle: End self
				)
			)
			(5
				(client
					setLoop: 11
					posn: (+ (client x:) 12) (+ (client y:) 14)
					setCycle: Fwd
				)
				(= ticks 2)
			)
			(6
				(client setMotion: MoveTo (Random 5 50) (Random 5 60) self)
			)
			(7
				(-= state 6)
				(self cue:)
			)
		)
	)
)

(instance dipthong of Prop
	(properties
		x 234
		y 45
		noun 6
		view 460
		loop 8
		priority 14
		signal 16400
	)
)

(instance oxymoron of Prop
	(properties
		x 279
		y 57
		noun 7
		view 460
		loop 7
		priority 14
		signal 16400
	)
)

(instance oxyOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oxymoron init: setCycle: CT 4 1 self)
			)
			(1
				(oxyBook init:)
				(oxymoron cel: 5 posn: 284 34)
				(= cycles 3)
			)
			(2
				(oxymoron cel: 6 posn: 281 23)
				(= cycles 3)
			)
			(3
				(oxymoron cel: 7 posn: 280 23)
				(gGlobalSound4 number: 464 setLoop: 1 play:)
				(= cycles 3)
			)
			(4
				(oxymoron stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance dipthOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dipthong init: setCycle: CT 4 1 self)
			)
			(1
				(dipBook init:)
				(dipthong cel: 5 posn: 238 20)
				(= cycles 3)
			)
			(2
				(dipthong cel: 6 posn: 234 13)
				(= cycles 3)
			)
			(3
				(dipthong cel: 7 posn: 235 14)
				(= cycles 3)
				(gGlobalSound4 number: 464 setLoop: 1 play: self)
			)
			(4
				(dipthong stopUpd:)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance oxyIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oxymoron cel: 6 posn: 281 23)
				(= cycles 3)
			)
			(1
				(oxymoron cel: 5 posn: 284 34)
				(= cycles 3)
			)
			(2
				(oxyBook dispose:)
				(oxymoron posn: 279 57 setCycle: Beg self)
			)
			(3
				(oxymoron dispose:)
				(self dispose:)
			)
		)
	)
)

(instance dipthIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dipthong cel: 6 posn: 234 13)
				(= cycles 3)
			)
			(1
				(dipthong cel: 5 posn: 238 20)
				(= cycles 3)
			)
			(2
				(dipBook dispose:)
				(dipthong posn: 234 45 setCycle: Beg self)
			)
			(3
				(dipthong dispose:)
				(self dispose:)
			)
		)
	)
)

(instance oxyBook of View
	(properties
		x 285
		y 71
		noun 7
		view 460
		loop 9
		cel 2
		priority 13
		signal 16400
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)
)

(instance dipBook of Prop
	(properties
		x 240
		y 52
		noun 6
		view 460
		loop 10
		cel 2
		priority 13
		signal 16400
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)
)

