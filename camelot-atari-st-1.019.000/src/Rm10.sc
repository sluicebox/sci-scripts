;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use n117)
(use eRoom)
(use Interface)
(use Yoyo)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	Rm10 0
	proc10_1 1
	elf 2
	elfWindow 3
)

(synonyms
	(altar housing)
	(sculpture cernnunnos idol)
	(brownie animal spirit brownie creature)
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
	local8
	local9
)

(procedure (proc10_1)
	(gTObj noWidth: 1 tLoop: 2)
	(if (not (elf script:))
		(elf setScript: doJump)
	)
	(Talk &rest)
)

(instance elfWindow of SysWindow
	(properties
		color 7
		back 4
		title {Widdershins}
		brLeft 5
		brBottom 100
		brRight 170
	)
)

(instance doJump of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gTObj tCount:) 0)
			(elf setCel: 0 setCycle: 0)
			(= local9 0)
			(client setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elf setLoop: (if local9 3 else 2) cel: 0 setCycle: End self)
			)
			(1
				(-- state)
				(elf setCycle: Beg self)
			)
		)
	)
)

(instance Rm10 of eRoom
	(properties
		picture 10
	)

	(method (init)
		(Load rsSCRIPT 960)
		(Load rsVIEW 110)
		(Load rsVIEW 79)
		(Load rsSOUND 92)
		(Load rsSCRIPT 204)
		(super init:)
		(if (== gPrevRoomNum 0)
			(SetFlag 20)
			(SetFlag 3)
		)
		(self setRegions: 102) ; forestPerilous
		(proc0_13 32)
		(gAddToPics add: shrine init: doit:)
		(gEgo init:)
		(switch gPrevRoomNum
			(11
				(self enterRoom: 0 133 40 133 0)
				(self muleEnterRoom: 0 145 40 145 0)
			)
			(else
				(self enterRoom: 160 230 160 170 3)
				(self muleEnterRoom: 130 230 130 190 3)
			)
		)
		(if (IsFlag 20)
			(gMuleObj setScript: muleActions)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((or (self goingOut:) (self comingIn:)) 0)
			((IsFlag 39)
				(ClearFlag 39)
				(gEgo setScript: scratchIt)
			)
			(
				(and
					(not local2)
					(not (gEgo inRect: 135 155 185 200))
					(not (gEgo inRect: 0 0 80 189))
				)
				(= local2 1)
				(= local3 1)
				(gEgo setScript: (ScriptID 204 0)) ; ElfStart
			)
			((and local3 (< (gEgo x:) 75) (== (gEgo loop:) 1))
				(= local3 0)
				(gEgo setScript: (ScriptID 204 1) 0 4) ; BoltOfMagic
			)
			((and local3 (> (gEgo y:) 175) (== (gEgo loop:) 2))
				(= local3 0)
				(gEgo setScript: (ScriptID 204 1) 0 5) ; BoltOfMagic
			)
			((> (gEgo y:) 188)
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(gEgo put: 8) ; boar_spear | grain | medallion
					(SetFlag 30)
				)
				(SetFlag 17)
				(= global132 0)
				(self leaveRoom: 103 (gEgo x:) 220)
			)
			((< (gEgo x:) 10)
				(SetFlag 17)
				(ClearFlag 37)
				(= global132 0)
				(self leaveRoom: 11 0 (gEgo y:))
			)
		)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (& (event modifiers:) emSHIFT))
			(cond
				((and (gCast contains: elf) (MouseClaimed elf event))
					(Print 10 0 #at 20 18) ; "Widdershins is a forest sprite. It must inhabit this shrine."
				)
				((OnButton event 176 74 190 102)
					(Print 10 1 #icon 110 0 1) ; "It is an old, bronze statue of Cernunnos and he holds out a cup for offerings."
					(if local2
						(Print 10 2 #icon 110 0 1) ; "Ah! Of course! The idol is bronze. That explains Widdershins's toll of copper or tin."
					)
				)
				((OnButton event 169 67 202 111)
					(Print 10 3 #at 20 18) ; "This shrine contains a bronze statue of the Celtic god, Cernunnos, within a stone housing."
				)
				(
					(or
						(OnButton event 221 72 251 89)
						(OnButton event 85 118 159 140)
						(OnButton event 194 139 209 162)
						(OnButton event 173 151 209 162)
						(OnButton event 204 164 243 183)
					)
					(Print 10 4) ; "'Tis a rock."
				)
				(
					(or
						(OnButton event 47 7 181 36)
						(OnButton event 88 26 131 95)
						(OnButton event 138 35 178 74)
						(OnButton event 180 7 220 36)
						(OnButton event 180 26 210 87)
						(OnButton event 216 34 250 76)
						(OnButton event 207 7 291 19)
						(OnButton event 257 21 308 55)
						(OnButton event 275 55 306 121)
					)
					(Print 10 5) ; "'Tis a tree."
				)
				(
					(or
						(OnButton event 199 92 235 117)
						(OnButton event 207 124 244 164)
					)
					(Print 10 6) ; "'Tis a bush."
				)
			)
		)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((or (Said 'look,talk,ask/man') (Said 'ask//man'))
				(if (or (IsFlag 17) local2)
					(Print 10 7) ; "The forest sprite is not a man."
				else
					(Print 10 8) ; "There is no one here."
				)
			)
			((Said 'look/dinar')
				(if global191
					(Print 10 9) ; "The miserable sprite has turned everything but your copper coins into pebbles!"
				else
					(DoPurse)
				)
			)
			((Said 'look/dirham')
				(if global192
					(Print 10 9) ; "The miserable sprite has turned everything but your copper coins into pebbles!"
				else
					(DoPurse)
				)
			)
			((Said 'look/copper')
				(if (or global192 global191)
					(Print 10 10) ; "Your copper coins are untouched by the spell."
				else
					(DoPurse)
				)
			)
			((Said 'scratch')
				(if (and (IsFlag 37) (not (gEgo script:)))
					(gEgo setScript: scratchIt)
				else
					(event claimed: 0)
				)
			)
			((or (Said 'look,get/pebble') (Said 'ask//pebble'))
				(if (or global191 global192)
					(Print 10 11) ; "I would worry less about the pebbles than about how to get Widdershins to undo his trick."
				else
					(Print 10 12) ; "You have more important things to worry about than pebbles."
				)
			)
			((Said 'ask/brownie')
				(Print 10 13 #at 20 18) ; "Mercifully, he is gone."
			)
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(cond
					((gCast contains: elf)
						(Print 10 14) ; "Widdershins only wants a bit of copper. I would not be stingy, if I were you."
					)
					((IsFlag 17)
						(Print 10 15) ; "Try not to disturb Widdershins again."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<around][/room,forest,forest][/!*]')
							(Said 'ask//room,forest,forest')
						)
						(cond
							((gCast contains: elf)
								(Print 10 16 #at 20 18) ; "The mischievous forest sprite, Widdershins, is perched upon the shrine, waiting for you to pay his toll."
							)
							((IsFlag 17)
								(Print 10 17 #at 20 18) ; "It should look familiar. This is where you entered the forest and there is the little shrine."
								(Print 10 18 #at 20 18) ; "Let us hope Widdershins is asleep."
							)
							(else
								(Print 10 19 #at 20 18) ; "You must pass through the Forest Perilous to reach Glastonbury Tor. The forest is so named because of the many dangers hidden within."
								(Print 10 20 #at 20 18) ; "In this clearing, there is a very old forest shrine."
							)
						)
						(if (not local2)
							(= local2 1)
							(= local3 1)
							(gEgo setScript: (ScriptID 204 0)) ; ElfStart
						)
					)
					((or (Said '/brownie') (Said '//brownie'))
						(if (or (IsFlag 17) local2)
							(Print 10 21 #at 20 18) ; "He has returned to his hiding place inside the shrine."
						else
							(event claimed: 0)
						)
					)
					((Said '<in/cup')
						(Print 10 22) ; "It is empty"
					)
					((Said '/antler')
						(Print 10 23) ; "The statue of Cernunnos has antlers, representing the fertility of the stag."
					)
					((Said '//sculpture,god,underworld')
						(Print 10 24) ; "Cernunnos is an ancient Celtic god of the hunt or sometimes of the underworld."
						(SetScore 298 1 1)
					)
					((or (Said '/altar') (Said '//altar'))
						(Print 10 3 #at 20 18) ; "This shrine contains a bronze statue of the Celtic god, Cernunnos, within a stone housing."
					)
					(
						(or
							(Said '/sculpture,(god<celt)')
							(Said '//sculpture,(god<celt)')
						)
						(Print 10 1 #icon 110 0 1) ; "It is an old, bronze statue of Cernunnos and he holds out a cup for offerings."
						(if local2
							(Print 10 25 #icon 110 0 1) ; "Ah! Of course! The idol is bronze. That explains Widdershins's toll of copper or tin."
						)
					)
					((or (Said '/aluminum') (Said '//aluminum'))
						(Print 10 26) ; "The bronze statue is of the Celtic god, Cernunnos."
					)
					((or (Said '/forester') (Said '//forester'))
						(if (IsFlag 24)
							(Print 10 27) ; "If he passed this way, he left no traces."
							67
							20
							18
						else
							(event claimed: 0)
						)
					)
					((Said 'ask//brownie')
						(Print 10 28 #at 20 18) ; "It is not very powerful, but such sprites are quite mischievous and will play small, but nasty tricks upon those who displease them."
					)
					((Said 'ask//tithe,aluminum,tin')
						(Print 10 29 #at 20 18) ; "The idol is bronze and bronze is an alloy made of copper and tin. Widdershins has become obsessed, I would say, with making bronze."
					)
				)
			)
			((Said 'talk/altar,slab,sculpture')
				(Print 10 30) ; "It does not speak. It does not even hear."
			)
			((Said 'give/tin,aluminum')
				(Print 10 31) ; "You have none to give."
			)
			((or (Said 'drop,give/coin,copper,dirham,dinar') (Said 'pay'))
				(cond
					((not (gEgo has: 3)) ; purse
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((not (gEgo inRect: 100 110 202 140))
						(Print 10 32) ; "Get closer to the front of the shrine."
						(proc0_18)
					)
					((DoPurse)
						(= local7 2)
						(gEgo setScript: moveToShrine)
					)
				)
			)
			((Said 'get/coin,copper,dirham,dinar')
				(cond
					((not (gEgo inRect: 100 110 202 140))
						(Print 10 32) ; "Get closer to the front of the shrine."
						(proc0_18)
					)
					((or local5 local6)
						(= local7 4)
						(gEgo setScript: moveToShrine)
					)
					(else
						(Print 10 33) ; "You will never see that money again."
					)
				)
			)
			((Said 'talk/brownie')
				(Print 10 34) ; "Ah, how pleasant. He has gone away for now."
				67
				20
				18
			)
			((Said 'use/rose,heart,sleeve')
				(Print 10 35) ; "That is of no use here."
				67
				20
				18
			)
			((Said 'get,use,eat,drink/pack,water,food,clothes,blanket')
				(if (!= gPrevRoomNum 11)
					(Print 10 36 #at 20 18) ; "You have only just entered the Forest Perilous. That can wait until later. For now, be on your guard."
				else
					(event claimed: 0)
				)
			)
			((Said 'kill,attack,annihilate/brownie')
				(Print 10 37 #at 20 18) ; "You cannot really harm such an elemental creature with mere force."
				(Print 10 38 #at 20 18) ; "Besides, you would have to catch it first and that is nearly impossible."
			)
			((Said 'capture,grab,appropriate/brownie')
				(Print 10 39 #at 20 18) ; "I could do so with a spell, but only if I were there in person. You will never do so otherwise."
			)
			((Said 'attack,annihilate/altar,sculpture')
				(Print 10 40 #at 20 18) ; "You have not the means to shatter stone or break bronze. Besides, the shrine is holy and not to blame that Widdershins has taken up residence in it."
			)
			((Said 'get,press,tip,knock/altar,sculpture')
				(Print 10 41 #at 20 18) ; "You will find it is too heavy and solidly rooted in the ground."
			)
			((Said 'search/altar,sculpture')
				(if (not (gEgo inRect: 100 110 202 140))
					(Print 10 32) ; "Get closer to the front of the shrine."
					(proc0_18)
				else
					(= local7 3)
					(gEgo setScript: moveToShrine)
				)
			)
			((Said 'use,draw/blade')
				(if (gCast contains: elf)
					(Print 10 42) ; "You cannot harm a sprite with mere steel."
					(= global125 2)
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance muleActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((gEgo script:) 0)
			((gEgo inRect: 81 138 189 200)
				(if (!= state 1)
					(self changeState: 1)
				)
			)
			((gEgo inRect: 115 80 276 133)
				(if (!= state 2)
					(self changeState: 2)
				)
			)
			((and (gEgo inRect: 0 80 80 170) (!= state 3))
				(self changeState: 3)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gMuleObj setMotion: MoveTo 120 175)
			)
			(2
				(gMuleObj setMotion: MoveTo 170 150)
			)
			(3
				(gMuleObj setMotion: MoveTo 30 160)
			)
		)
	)
)

(instance askWidder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTObj talkCue: self)
				(proc10_1 10 43) ; "Copper or tin! Copper or tin! Copper or tin for Widdershins!"
			)
			(1
				(elf setLoop: 2 cel: 0)
				(Print 10 44 #at 20 18 #draw) ; "Single-minded creature, is he not?"
				(= cycles 1)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance scratchIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(if (!= (gEgo loop:) 2)
					(gEgo
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 1) self
					)
				else
					(self cue:)
				)
			)
			(1
				(gSFX number: 19 loop: -1 play:)
				(= local1 (gEgo cycler:))
				(gEgo
					loop: (if (== global116 1) 1 else 0)
					view: 79
					cycler: 0
					setCycle: Yoyo 4 self
				)
			)
			(2
				(gSFX stop:)
				(if (not local8)
					(= local8 1)
					(Print 10 45) ; "The sprite has struck! He has afflicted you with an attack of stinging ants!"
				)
				(= cycles 1)
			)
			(3
				(gSFX number: 19 loop: -1 play:)
				(gEgo setCycle: Yoyo 4 self)
			)
			(4
				(gSFX stop:)
				(gEgo
					view: (if (== global116 1) 9 else 3)
					loop: 2
					ignoreActors: 0
					illegalBits: $8000
					setCycle: local1
				)
				(= local1 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance moveToShrine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(cond
					((gEgo inRect: 166 113 190 119)
						(= cycles 1)
					)
					((< (gEgo x:) 168)
						(gEgo setMotion: MoveTo 168 114 self)
					)
					(else
						(gEgo setMotion: MoveTo 180 114 self)
					)
				)
			)
			(1
				(gEgo illegalBits: $8000)
				(= seconds 2)
			)
			(2
				(switch local7
					(2
						(gSFX number: (proc0_20 21) loop: 1 play:)
						(+= local5 global129)
						(+= local6 global130)
						(= global129 (= global130 0))
						(if global131
							(= global131 0)
							(Print 10 46) ; "By my beard! You no sooner put the copper in the shrine than the sprite made off with it."
							(if (or global191 global192)
								(= gGold global191)
								(= gSilver global192)
								(= global191 (= global192 0))
								(Print 10 47 #at -1 130) ; "Ah, did you feel a tingling? The trick has been undone, but check your purse, if you wish to make sure."
							)
						else
							(= global132 0)
							(Print 10 48) ; "There is no sign of the sprite, yet you know he must stil be about."
							(ClearFlag 37)
						)
						(proc0_18)
						(HandsOn)
						(self dispose:)
					)
					(1
						(if global131
							(= global131 0)
							(proc0_18)
							(= local4 1)
							(gRmMusic number: 92 loop: 1 play:)
							(SetScore 244 0 1)
							(gTObj talkCue: self)
							(Talk 10 49) ; "Copper is mine! Copper divine! Go your way, No trick I will play."
							(if global191
								(= gGold global191)
								(= local0 1)
							)
							(if global192
								(= gSilver global192)
								(= local0 1)
							)
							(= global191 (= global192 0))
							(= local9 1)
							(elf setScript: doJump)
						else
							(proc10_1 10 50) ; "Silver and gold do not pay my toll! Copper or tin is my only whim!"
							(proc0_18)
							(HandsOn)
							(self dispose:)
						)
					)
					(3
						(Print 10 51 #at 20 18) ; "You found nothing, of course."
						(HandsOn)
						(self dispose:)
					)
					(4
						(Print 10 52) ; "Do make up your mind."
						(= global129 local5)
						(= global130 local6)
						(= local5 (= local6 0))
						(proc0_18)
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(3
				(= seconds 1)
			)
			(4
				(elf setLoop: 1 cel: 5 cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(if local0
					(= local0 0)
					(Print 10 47 #at -1 130) ; "Ah, did you feel a tingling? The trick has been undone, but check your purse, if you wish to make sure."
				)
				(elf dispose:)
				(= local3 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance elf of Act
	(properties
		y 74
		x 184
		view 110
		loop 1
		priority 7
		signal 16400
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((or (Said 'look/brownie') (Said 'ask/merlin/brownie'))
				(Print 10 53 #at 20 18) ; "It is a forest sprite. It must inhabit this shrine."
			)
			((Said 'ask/merlin')
				(event claimed: 0)
			)
			((Said 'ask[/brownie]')
				(gEgo setScript: askWidder)
			)
			((or (Said 'drop,give/coin,copper,dirham,dinar') (Said 'pay'))
				(cond
					((not (gEgo has: 3)) ; purse
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((not (gEgo inRect: 100 110 202 140))
						(Print 10 32) ; "Get closer to the front of the shrine."
						(proc0_18)
					)
					((DoPurse)
						(= local7 1)
						(gEgo setScript: moveToShrine)
					)
				)
			)
			(
				(Said
					'give,exit/rose,lodestone,heart,sleeve,pack,water,food,clothes,blanket,blade,shield,charger,ass'
				)
				(proc10_1 10 54) ; "Copper or tin! Keep your useless human stuff. Copper or tin!"
			)
			((Said 'show/coin,copper,dirham,dinar')
				(proc10_1 10 55) ; "Aye, copper! Give me copper!"
			)
			((Said 'get/coin,copper,dirham,dinar')
				(proc10_1 10 56) ; "My toll you pay or a trick I play!"
			)
			((Said 'talk[/brownie]')
				(proc10_1 10 57) ; "Going out or coming in, Copper or tin for Widdershins! You had better heed my whim, Pay the toll of Widdershins! If no copper or no tin, You get a trick from Widdershins!"
			)
			((Said '*/brownie')
				(Print 10 58) ; "Why would you want to do that?"
			)
		)
	)
)

(instance shrine of PV
	(properties
		y 111
		x 188
		view 110
		priority 7
	)
)

