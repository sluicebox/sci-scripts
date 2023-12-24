;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Interface)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm180 0
)

(local
	didTell
	didBeast
	didThank
	didHello
	smallTalk
	saveCycler
	saveMover
	honorGain
	enchTime
	invitedToSit
	beenWarned
	seenDrop
	inPit
	inBack
	apologyLevel
	interrupted
	cleanGetAway
	[tmpStr 100]
	[enchGenList 38] = [25 26 27 28 0 1 3 2 4 32 33 34 35 36 24 37 38 24 24 39 24 40 24 41 42 24 43 44 45 24 46 47 48 24 24 24 24 24]
	[enchSpecList 50] = [5 '//plant,tree,compassion,fruit,julanar,pomegranate,(woman,woman<plant,about)' 8 '//blackness' 9 '//nature' 12 '//omen' 13 '//iblis' 14 '//bendaoud' 15 '//contain,capture' 18 '//element<contrary,about' 20 '//manner,judith,etiquette' 22 '//carp,carp,dolphin,aquarium,oasis,sea' 23 '//shelf,book,tapestry,stuff,knack' 49 '//rakeesh,lion' 50 '//paladin,life' 46 '//shema,shameen' 51 '//keapon,(shop<magic,about)' 52 '//water' 53 '//(see<far,about),(see<true,about)' 54 '//tea' 55 '//man' 56 '//ad' 57 '//potion<disenchant' 58 '//enchantment' 6 '//beast,creature[<desert,birdcage,enchant,about]' 7 '//spell' 0 0]
	[shelfMsg 11] = [{some water-based paints.} {a jar of freeze-dried tea (just add water).} {a plate of watery tarts.} {some moisturizing cream.} {some unused bath towels} {two statues of immoral porpoises.} {the sheet music for Handel's "Water Music."} {Waterford Crystal.} {an autographed picture of Captain Nemo.} {a leftover submarine sandwich} {a leftover hero sandwich}]
	[bookShelfMsg 11] = [{"20,000 Leaks Under the Sink."} {"Mussel-Building with Barnacle Jones."} {"Learn to Program in Sea++."} {"Learn to Play 'Go Fish' like a Card Shark."} {"How to Teach Generosity to Shellfish People."} {"New Clear Fishin'."} {"Fear of Swimming."} {"Lure of the Flies."} {"The Tides of Marsh."} {"The Poseidon Adventure."} {"Clam of the Baskervilles."}]
	msgCounter
	bookMsgCounter
	[shelfStr 100]
)

(procedure (AzizaChangeMood whichWay msgType)
	(switch whichWay
		(0
			(++ honorGain)
			(-- gAzizaTemper)
		)
		(1
			(-- honorGain)
			(++ gAzizaTemper)
			(= apologyLevel 1)
		)
		(2
			(-= honorGain 2)
			(= gAzizaTemper 3)
		)
	)
	(if (< gAzizaTemper 0)
		(= gAzizaTemper 0)
	)
	(if (== gAzizaTemper 3)
		(gCurRoom setScript: egoThrownOut 0 msgType)
	)
)

(procedure (Apologize)
	(switch apologyLevel
		(0
			(HighPrint 180 0) ; "There's no need for an apology."
		)
		(1
			(= apologyLevel 0)
			(Say aziza 180 1) ; "That's better."
			(AzizaChangeMood 0 0)
			(return 1)
		)
		(2
			(Say aziza 180 2) ; "It's too late for that now."
		)
	)
	(return 0)
)

(instance rm180 of Rm
	(properties
		picture 180
		style 8
		east 199
	)

	(method (init &tmp [str 20])
		(LoadMany rsVIEW 3 11 180 182 181 183 184 184)
		(LoadMany rsTEXT 182)
		(LoadMany rsSCRIPT 21)
		(LoadMany rsSOUND 180 181 182)
		(SolvePuzzle 614 7)
		(= enchTime gTimeODay)
		(= gNow (+ (* gDay 100) enchTime))
		(= gSpellChecker spellCode)
		(super init:)
		(fishy init: setCycle: Fwd)
		(door init:)
		(InitFeatures tank herBackDoor)
		(InitAddToPics
			tapestry
			teaTable
			shelf
			shelfStuff1
			shelfStuff2
			shelfStuff3
			shelfStuff4
			shelfStuff5
			lilyPad1
			lilyPad2
		)
		(InitFeatures pond)
		(= msgCounter (Random 0 10))
		(= bookMsgCounter (Random 0 10))
		(NormalEgo)
		(tableSound init:)
		(if (== gPrevRoomNum 190)
			(tableSound play:)
			(= inPit 1)
		else
			(gCSound number: 180 loop: -1 priority: 2 playBed:)
		)
		(EgoGait 0 0) ; walking
		(cond
			((== gPrevRoomNum 190)
				(DontMove 1)
				(aziza loop: 6 cel: 0 posn: 66 149 init:)
				(gEgo view: 180 loop: 2 cel: 5 posn: 122 186 init:)
				(azizaMouth x: 68 y: 149 z: 11 cel: 0 setPri: 12 init:)
				(if (== gDay 16)
					(saurus loop: 0 posn: 10 189 setPri: 15 init: stopUpd:)
					(self setScript: afterCeremony)
				)
			)
			((== gDay 16)
				(aziza posn: 80 105 init:)
				(gEgo view: 4 loop: 1 posn: 310 130 init:)
				(SolvePuzzle 613 7)
				(saurus init:)
				(self setScript: enterS)
			)
			(else
				(aziza init:)
				(gEgo view: 4 loop: 1 posn: 310 130 init:)
				(self setScript: enterS)
			)
		)
		(azizaMouth init:)
	)

	(method (dispose)
		(= gEnchLastHere gNow)
		(*= honorGain 25)
		(SkillUsed 14 honorGain) ; honor
		(if (!= gNewRoomNum 190)
			(gCSound fade:)
		)
		(tableSound stop: dispose:)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((gEgo script:))
			((gEgo inRect: 260 120 320 140)
				(self setScript: openTheDoor)
			)
			((& (gEgo onControl: 1) $0800)
				(self setScript: backDoor)
			)
			(
				(and
					(& (gEgo onControl: 1) $2000)
					(> (gEgo y:) 125)
					(not inPit)
				)
				(self setScript: downStairs)
			)
			((and (& (gEgo onControl: 1) $2000) (< (gEgo y:) 126))
				(self setScript: backStairs)
			)
			((and (& (gEgo onControl: 1) $4000) (not seenDrop))
				(= seenDrop 1)
				(HighPrint 180 3) ; "It is actually quite a drop. You would do better to use the steps."
			)
		)
	)

	(method (handleEvent event &tmp [str 10])
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 180 4) ; "The air is humid, and the decor is sea-green. Aziza keeps a tidy house."
			)
			((or (Said '/sorry') (Said 'apologize') (Said 'forgive,forgive'))
				(Apologize)
			)
			((Said 'drink,enjoy,give[/tea]')
				(if (not (gCast contains: teaSet))
					(HighPrint 180 5) ; "It would be nice if there was some tea to drink."
				else
					(HighPrint 180 6) ; "The tea is cool and refreshing."
				)
			)
			((or (Said '/bye') (Said 'bye'))
				(= cleanGetAway 1)
				(gCurRoom setScript: upStairs)
			)
			((Said '(get,get<up),(stand[<up])')
				(if inPit
					(gCurRoom setScript: upStairs)
				else
					(HighPrint 180 7) ; "You're already standing."
				)
			)
			((and (not inPit) (Said 'tell,bargain'))
				(if (not (== gAzizaTemper 3))
					(Say aziza 180 8) ; "Please, you must sit down and relax before we shall speak of what you seek."
				)
			)
			((Said 'thank[/aziza,enchantress,woman,you]')
				(if (not didThank)
					(AzizaChangeMood 0 0)
					(= didThank 1)
				)
				(SayThanks aziza 180 9)
			)
			((or (Said 'greet') (Said 'hello'))
				(if (not didHello)
					(AzizaChangeMood 0 0)
					(= didHello 1)
				)
				(Say aziza 180 10) ; "Welcome. It is good to have a visitor who understands the proper way to enter conversation."
			)
			(
				(or
					(Said 'tell/beast,creature[<desert,birdcage,enchant,about]')
					(Said
						'tell//beast,creature[<desert,birdcage,enchant,about]'
					)
				)
				(= smallTalk 1)
				(if (not didBeast)
					(AzizaChangeMood 0 0)
					(= didBeast 1)
				)
				(if (IsFlag 42) ; fAlScurvaFreed
					(HighPrint 180 11) ; "You tell Aziza about Al Scurva."
					(Say aziza 180 12) ; "Your words are distressing. Ad Avis is a most dangerous Wizard."
				else
					(HighPrint 180 13) ; "You tell Aziza everything you know about the caged beast."
					(Say aziza 180 14) ; "There is some form of magical protection around the cage which prevents me from detecting it. It is clear that a powerful Magic User intends the creature to die. The beast is probably enchanted. You will need a Dispel Potion to find its true form."
				)
			)
			((Said 'tell')
				(= smallTalk 1)
				(if (not didTell)
					(AzizaChangeMood 0 0)
					(= didTell 1)
				)
				(Say aziza 180 15) ; "It is wise of you to have told me that. The more information I have, the better I can judge things."
			)
			(
				(or
					(Said 'kiss,hug')
					(Said 'ask/date,kiss,hug')
					(Said 'ask[/aziza]/date,kiss,hug')
				)
				(Say aziza 180 16) ; "You are most brash, but I will assume that you mean only to flatter me."
			)
			((Said 'kill,attack,grab')
				(AzizaChangeMood 2 0)
			)
		)
	)
)

(instance enterS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 265 130 self)
			)
			(2
				(gEgo setHeading: 0)
				(= cycles 3)
			)
			(3
				(door setCycle: Beg self)
				(gEgo setMotion: MoveTo 245 127)
			)
			(4
				(aziza cycleSpeed: 1 setCycle: CT 5 1)
				(= cycles 15)
			)
			(5
				(aziza setCycle: End self)
			)
			(6
				(aziza cycleSpeed: 0)
				(= invitedToSit 1)
				(cond
					((== gDay 16)
						(gCurRoom setScript: gronkScript)
					)
					((== gDay 15)
						(Say aziza self 180 17 180 18) ; "I wish to speak with you tomorrow about Raseir. I intend to work some magic tonight to gather information about the things you will face. I will let you know at our meeting what I find out."
					)
					((IsFlag 122) ; fGotFruit
						(Say aziza self 180 19 180 20) ; "Thank you for the kindness you have shown Julanar. You are a true Hero for helping her."
					)
					(
						(and
							(>= gDay 11)
							(== gOrigHeroType 1)
							(not [gEgoStats 29]) ; invisibility
						)
						(Say aziza self 180 21) ; "I am disturbed that you are not yet a Wizard. You very much need to pass the tests at the Wizard's Institute of Technocery if you wish to be more than just a Magic User."
					)
					(else
						(Say aziza self 180 20) ; "Come in, sit down, and be welcome."
					)
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance gronkScript of HandsOffScript
	(properties)

	(method (changeState newState &tmp aR aL)
		(switch (= state newState)
			(0
				(if (== gAzizaTemper 3)
					(Say aziza self 180 22) ; "Despite your previous behavior in my presence, you have proven yourself a hero. I wish to discuss some information I have learned about Raseir. Come in, sit down, and we shall speak."
				else
					(Say ; "You have saved the city through your resourcefulness and bravery."
						aziza
						self
						180
						23
						(Format @tmpStr 180 24 @gUserName) ; "You are very much a hero. Welcome to my home, %s. May your deeds be remembered forever."
						180
						25
						180
						26
					)
				)
				(= invitedToSit 1)
			)
			(1
				(aziza cel: 4 setCycle: Beg)
				(gEgo setMotion: MoveTo 100 130)
				(= cycles 6)
			)
			(2
				(door setCycle: End self)
			)
			(3
				(saurus init: setCycle: Walk setMotion: MoveTo 310 130 self)
			)
			(4
				(saurusBod init:)
				(saurus
					view: 182
					loop: 10
					cel: 0
					x: 291
					y: 130
					z: 42
					cycleSpeed: 2
					setCycle: End self
				)
				(aziza loop: 1 cel: 0 setCycle: CT 2 1)
				(gEgo
					view: 182
					loop: 9
					cel: 0
					x: (- (gEgo x:) 8)
					setMotion: 0
					cycleSpeed: 3
					setCycle: CT 1 1
				)
				(= aR (BotWindow brRight:))
				(= aL (BotWindow brLeft:))
				(BotWindow color: 10 back: 0)
				(gMiscSound number: 291 loop: 1 play:)
				(Print ; "Grrrrrooooooonnnnnk!"
					180
					27
					#font
					gUserFont
					#title
					{Roget The Saurus:}
					#window
					BotWindow
					#width
					(- aR (+ aL 16))
					#dispose
				)
			)
			(5
				(gEgo setCycle: End)
				(saurus setCycle: Beg)
				(aziza setCycle: CT 4 1)
				(= cycles 30)
			)
			(6
				(cls)
				(saurus view: 11 loop: 1 x: 310 y: 130 z: 0)
				(saurusBod dispose:)
				(aziza setCycle: CT 6 1 self)
			)
			(7
				(azizaMouth hide:)
				(Say aziza self 180 28) ; "Welcome, stranger. I shall be honored to have you for a guest."
			)
			(8
				(= aR (BotWindow brRight:))
				(= aL (BotWindow brLeft:))
				(BotWindow color: 10 back: 0)
				(Print ; "Gronkety gronk? (Perhaps he has a Saurus Throatus?)"
					180
					29
					#font
					gUserFont
					#title
					{Roget The Saurus:}
					#window
					BotWindow
					#width
					(- aR (+ aL 16))
					#dispose
				)
				(= seconds 5)
			)
			(9
				(cls)
				(aziza setCycle: End self)
			)
			(10
				(azizaMouth show:)
				(Say aziza self 180 30) ; "Come in, we shall all sit and see what we shall see."
			)
			(11
				(= gCloseUpSubject -1)
				(gCurRoom newRoom: 190)
			)
		)
	)
)

(instance afterCeremony of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(Say aziza self 180 31 (Format @tmpStr 180 32 @gUserName)) ; "You must take the caravan to Raseir. I will keep the Emir with me for safe-keeping, while you find the means to restore him to his rightful shape.", "We all are hoping for your success, Hero, and eagerly await the pleasure of your return. Farewell, %s."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo use: 50) ; Saurus
				(gCurRoom newRoom: 199)
			)
		)
	)
)

(instance egoThrownOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(if (<= 6 (aziza loop:) 7)
						(aziza loop: 8 setCycle: End)
					)
					(azizaMouth hide:)
					(Say aziza self 180 33) ; "It is very dishonorable of you to try to cast a spell in my home. It would be wise for you to leave at this time."
				else
					(Say aziza self 180 34) ; "I will not tolerate such rudeness!"
				)
			)
			(1
				(= [gEgoStats 17] 0) ; stamina
				(sparkle
					posn: (gEgo x:) (gEgo y:)
					z: (if (== (gEgo view:) 180) 18 else 36)
					init:
					setCycle: End self
				)
			)
			(2
				(sparkle dispose:)
				(gEgo hide:)
				(= cycles 4)
			)
			(3
				(gCurRoom newRoom: 199)
			)
		)
	)
)

(instance backDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(if (not beenWarned)
					(Say aziza self 180 35) ; "It is not polite of you to go where you are not invited. If you wish to speak with me, then come sit down. Otherwise, you are free to leave."
					(= invitedToSit 1)
				else
					(AzizaChangeMood 2 0)
				)
			)
			(1
				(Face gEgo aziza 0 self)
			)
			(2
				(gEgo setMotion: MoveTo 84 100 self)
				(= beenWarned 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance teaTalk of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'no')
				(AzizaChangeMood 1 0)
				(if (== gAzizaTemper 3)
					(self dispose:)
				else
					(Say aziza self 180 36) ; "Very well, if such is your choice. What is it that you wish to know?"
					(self changeState: 5)
				)
			)
			((Said 'yes,drink')
				(AzizaChangeMood 0 0)
				(self cue:)
			)
			((Said 'look,look')
				(event claimed: 0)
			)
			((or (Said '/sorry') (Said 'apologize') (Said 'forgive,forgive'))
				(if (Apologize)
					(self changeState: 0)
				)
			)
			((== (event type:) evSAID)
				(++ interrupted)
				(AzizaChangeMood interrupted 0)
				(event claimed: 1)
				(if (== gAzizaTemper 3)
					(self dispose:)
				else
					(= state -1)
					(Say aziza self 180 37) ; "I believe I asked you a question, young man."
				)
			)
		)
		(event claimed:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not interrupted)
					(Say aziza 180 38) ; "Shall we share tea?"
				)
				(SetFlag 41) ; fOfferedTea
			)
			(1
				(DontTalk 1)
				(aziza loop: 6 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(gMiscSound number: 17 loop: 1 play:)
				(teaSet init: cycleSpeed: 1 setCycle: End self)
			)
			(3
				(aziza cel: 0)
				(teaSet loop: 4 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(HighPrint 180 39) ; "The tea is cool and refreshing. You find yourself relaxing as you drink and listen to the sound of flowing water."
				(Say aziza self 180 40) ; "Now that we have shared tea, what is it for which you have come?"
			)
			(5
				(DontTalk 0)
				(self dispose:)
			)
		)
	)
)

(instance openTheDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 292 140 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(door setCycle: End self)
			)
			(3
				(gEgo
					view: 0
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 8) self
				)
			)
			(4
				(gEgo setMotion: MoveTo 330 (gEgo y:))
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance aCloserLook of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((>= 4 register 0)
						(Say aziza self 180 41) ; "Perhaps it would be well to show you as well as to tell you about such things."
					)
					((and (== register 5) (IsFlag 43)) ; fDidPlant
						(Say aziza self 180 42) ; "You did that already, remember?"
					)
					((and (== register 5) (IsFlag 44)) ; fHeardPlant
						(Say aziza self 180 43) ; "You must give her the gifts of Water, Earth, and a hug."
					)
					((== register 5)
						(Say aziza self 180 44) ; "That is indeed a sad tale. Let me show you of that which we speak."
					)
				)
			)
			(1
				(= gCloseUpSubject register)
				(gCurRoom newRoom: 190)
			)
		)
	)
)

(instance aziza of Talker
	(properties
		x 69
		y 150
		description {the Enchantress Aziza}
		lookStr {Aziza's beauty in no way masks her intensity, purposefulness, and the aura of power around her.  It is good when in her presence to be on your best behavior.}
		view 182
		loop 2
		illegalBits 0
		tLoop -1
		talkSpeed 1
		myName '//aziza,enchantress,woman,girl'
		title {Aziza:}
		color 13
		back 0
		msgFile 182
	)

	(method (atSpec which)
		(return [enchSpecList which])
	)

	(method (atGen which)
		(return [enchGenList which])
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sat')
				(if (== (gEgo view:) 180)
					(HighPrint 180 45) ; "You already are."
				else
					(Say aziza 180 46) ; "Yes, come sit at my table."
				)
			)
		)
	)

	(method (messages)
		(switch loop
			(1
				(azizaMouth x: (+ x 2) y: y z: 40)
			)
			(2
				(azizaMouth x: (- x 2) y: y z: 40)
			)
			(6
				(azizaMouth x: (+ x 2) y: y z: 11)
			)
		)
		(super messages: &rest)
		(azizaMouth setCycle: Fwd)
	)

	(method (endTalk)
		(super endTalk: &rest)
		(azizaMouth setCycle: 0 setCel: 0)
	)

	(method (showText what)
		(= smallTalk 1)
		(cond
			((and invitedToSit (not (== (gEgo view:) 180)))
				(AzizaChangeMood 1 0)
				(if (not (== gAzizaTemper 3))
					(Say self 180 8) ; "Please, you must sit down and relax before we shall speak of what you seek."
				)
			)
			((and (== (gEgo view:) 180) (not (IsFlag 41)) (== gEnchLastHere 0)) ; fOfferedTea
				(AzizaChangeMood 1 0)
				(if (not (== gAzizaTemper 3))
					(Say self 180 47) ; "First we shall enjoy our tea before we speak."
				)
			)
			((== what 6)
				(if (IsFlag 42) ; fAlScurvaFreed
					(Say self 180 48) ; "You could not have forgotten already?"
				else
					(Say self 180 49) ; "Since the beast is protected from my true sight, then it is probably not what it seems. You will need a dispel potion to find its true form."
				)
			)
			((== what 7)
				(= what 33)
				(super showText: 33 &rest)
			)
			((== what 15)
				(self caller: self showMany: 15 17)
			)
			((== what 18)
				(self caller: self showMany: 18 19)
			)
			((>= 5 what 0)
				(gCurRoom setScript: aCloserLook 0 what)
			)
			(else
				(super showText: what &rest)
			)
		)
	)
)

(instance azizaMouth of Prop
	(properties
		view 182
		cel 1
		signal 16384
		cycleSpeed 1
	)

	(method (doit)
		(if
			(and
				(== cel 0)
				(not
					(or
						(and (== (aziza loop:) 1) (== (aziza cel:) 10))
						(and (== (aziza loop:) 2) (== (aziza cel:) 8))
						(and (== (aziza loop:) 6) (== (aziza cel:) 0))
					)
				)
			)
			(self cel: 1)
		)
		(super doit:)
	)
)

(instance saurus of Actor
	(properties
		x 340
		y 130
		noun '/saurii'
		description {your saurus}
		lookStr {The saurus seems curious and excited for some reason.}
		view 11
		loop 1
		cel 6
		signal 16384
		illegalBits 0
	)
)

(instance fishy of Prop
	(properties
		x 127
		y 36
		noun '/carp,carp'
		description {the fish in the tank}
		view 180
		loop 1
		priority 14
		signal 16
	)

	(method (doit)
		(if (Random 0 1)
			(super doit:)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (Said 'capture/carp,carp')
			(HighPrint 180 50) ; "No bait. Sorry."
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 180 51) ; "It has to be the biggest bunch of carp you've ever seen."
			)
			(6
				(HighPrint 180 52) ; "Hmm. If you only had some chips..."
			)
			(7
				(HighPrint 180 50) ; "No bait. Sorry."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance saurusBod of View
	(properties
		x 310
		y 130
		view 182
		loop 11
		priority 512
		signal 16
	)
)

(instance door of Prop
	(properties
		x 287
		y 97
		noun '/door'
		description {the front door}
		lookStr {It's the front door.  It's how you got in here.}
		view 180
		loop 3
		priority 7
		signal 16
	)
)

(instance tank of Feature
	(properties
		x 127
		y 27
		noun '/tank,aquarium'
		nsTop 17
		nsLeft 113
		nsBottom 37
		nsRight 142
		description {Aziza's fishtank}
		lookStr {Aziza had many more fishtanks during the Age of Aquariums.}
	)
)

(instance sparkle of Prop
	(properties
		shiftClick 0
		view 183
		priority 15
		signal 16
	)
)

(instance teaSet of Prop
	(properties
		x 67
		y 159
		noun '/tea,(set<tea)'
		description {Aziza's tea set}
		lookStr {It's a most polite tea set.}
		view 182
		loop 5
		priority 15
		signal 16
	)

	(method (init)
		(gCast addToFront: self)
		(super init:)
	)
)

(instance downStairs of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DontMove 1)
		(aziza setScript: teaTalk)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 95)
					(gEgo setMotion: MoveTo 105 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					view: 181
					loop: 0
					cel: 0
					y: (+ (gEgo y:) 14)
					setCycle: End self
				)
			)
			(2
				(gEgo y: (+ (gEgo y:) 14) setCycle: End self)
			)
			(3
				(gEgo view: 0 setCycle: Walk setMotion: MoveTo 122 191 self)
			)
			(4
				(gEgo heading: 180 setHeading: 315 self)
			)
			(5
				(gEgo
					view: 180
					loop: 2
					cel: 0
					posn: (- (gEgo x:) 4) (- (gEgo y:) 3)
					setCycle: End
				)
				(aziza setLoop: 3 setCycle: Walk setMotion: MoveTo 67 162 self)
			)
			(6
				(aziza setLoop: 7 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(7
				(tableSound play:)
				(aziza setLoop: 6 cel: 0 y: (- (aziza y:) 12))
				(= inPit 1)
				(self dispose:)
			)
		)
	)
)

(instance upStairs of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DontMove 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tableSound stop:)
				(if (aziza script:)
					((aziza script:) dispose:)
				)
				(if cleanGetAway
					(AzizaChangeMood 0 0)
					(if smallTalk
						(Say aziza self 180 53) ; "It has been a pleasure conversing with you. Perhaps we shall share tea again sometime."
					else
						(Say aziza self 180 54) ; "It has been a pleasure. I'm sorry we didn't converse at greater length."
					)
				else
					(AzizaChangeMood 1 0)
					(Say aziza self 180 55) ; "It is more polite to ask your leave by saying "Farewell" before you leave the table."
				)
			)
			(1
				(if inPit
					(gEgo setCycle: Beg self)
				else
					(self changeState: 6)
				)
			)
			(2
				(gEgo
					view: 0
					posn: (+ (gEgo x:) 4) (+ (gEgo y:) 3)
					setCycle: Walk
					heading: 315
					setLoop: 7
					setMotion: MoveTo 106 155 self
				)
			)
			(3
				(gEgo
					setPri: -1
					view: 181
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gEgo y: (- (gEgo y:) 14) setCycle: End self)
			)
			(5
				(NormalEgo)
				(gEgo y: (- (gEgo y:) 14) setHeading: 225 self)
			)
			(6
				(SolvePuzzle 677 3 3)
				(gCurRoom newRoom: 199)
			)
		)
	)
)

(instance backStairs of HandsOffScript
	(properties)

	(method (init)
		(= saveCycler (gEgo cycler:))
		(gEgo cycler: 0)
		(= saveMover (gEgo mover:))
		(gEgo mover: 0)
		(super init: &rest)
	)

	(method (dispose)
		(gEgo
			view: 0
			loop: (if inBack 2 else 3)
			y:
				(if inBack
					(gEgo y:)
				else
					(- (gEgo y:) 14)
				)
			setCycle: saveCycler
			setMotion: saveMover
		)
		(= inBack (== inBack 0))
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 181
					loop: (if inBack 0 else 1)
					cel: 0
					y:
						(if inBack
							(+ (gEgo y:) 14)
						else
							(gEgo y:)
						)
					setCycle: End self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance herBackDoor of Feature
	(properties
		x 76
		y 51
		noun '/door[<back,bedroom,aziza,bed]'
		nsTop 22
		nsLeft 51
		nsBottom 81
		nsRight 101
		description {the door to Aziza's chambers}
		lookStr {The door at the far end of the room looks like it would lead to an inner chamber.}
	)
)

(instance teaTable of PicView
	(properties
		x 78
		y 189
		noun '/table'
		description {Aziza's table}
		lookStr {Every good Enchantress has a tea table to encourage polite conversation.}
		view 184
		signal 16384
	)
)

(instance tapestry of PicView
	(properties
		x 167
		y 106
		noun '/tapestry,hang,painting'
		description {Aziza's tapestry}
		lookStr {The tapestry is very old and very green.  The pattern appears to be abstract, but it resembles the waves in the ocean.}
		view 184
		loop 2
		priority 6
		signal 16400
	)
)

(instance shelf of PicView
	(properties
		x 128
		y 101
		noun '/shelf'
		description {a shelf full of odd things}
		view 184
		loop 1
		priority 5
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint (Format @shelfStr 180 56 [shelfMsg msgCounter])) ; "There are all sorts of odds and ends on the shelves. For instance, you see %s"
			(if (> (++ msgCounter) 10)
				(= msgCounter 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shelfStuff1 of PicView
	(properties
		x 223
		y 22
		noun '/shelf'
		description {a shelf full of odd things}
		view 184
		cel 3
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(switch (Random 0 3)
				(0
					(HighPrint 180 57) ; "You see a jar of freeze-dried water."
				)
				(1
					(HighPrint 180 58) ; "You see a vial of saline solution."
				)
				(2
					(HighPrint 180 59) ; "You see a can of wetting solution."
				)
				(3
					(HighPrint 180 60) ; "You see a bottle of Eau de Anchovy."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shelfStuff2 of PicView
	(properties
		x 224
		y 39
		noun '/shelf'
		description {a shelf full of odd things}
		view 184
		cel 4
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(switch (Random 0 3)
				(0
					(HighPrint 180 61) ; "You see a Klein bottle."
				)
				(1
					(HighPrint 180 62) ; "You see a bug in a bottle."
				)
				(2
					(HighPrint 180 63) ; "You see a 10-speed Oysterizer."
				)
				(3
					(HighPrint 180 64) ; "Amazing! Somebody actually built a computer in a bottle. How do they do that?"
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shelfStuff3 of PicView
	(properties
		x 227
		y 58
		noun '/shelf'
		description {a shelf full of odd things}
		view 184
		cel 5
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(switch (Random 0 3)
				(0
					(HighPrint 180 65) ; "You see a note in a bottle. Fanmail from some flounder?"
				)
				(1
					(HighPrint 180 66) ; "You see a bottle of butter-flavored syrup."
				)
				(2
					(HighPrint 180 67) ; "You see a squirt bottle."
				)
				(3
					(HighPrint 180 68) ; "You see a Deluxe Donut Dunker."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shelfStuff4 of PicView
	(properties
		x 230
		y 74
		noun '/shelf'
		description {a shelf full of odd things}
		view 184
		cel 7
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(switch (Random 0 2)
				(0
					(HighPrint 180 69) ; "You see some moisturizing shampoo."
				)
				(1
					(HighPrint 180 70) ; "You see a purposeless porpoise."
				)
				(2
					(HighPrint 180 71) ; "You see a gratuitous goblet."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shelfStuff5 of PicView
	(properties
		x 224
		y 89
		noun '/shelf'
		description {a shelf full of odd things}
		view 184
		cel 6
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (<= bookMsgCounter 4)
				(HighPrint
					(Format @shelfStr 180 72 (+ bookMsgCounter 1) [bookShelfMsg bookMsgCounter]) ; "Through the mildew, you are able to recognize some of the book titles. For instance, Aziza owns Volume %d of the Tide-Life Self-Kelp Series: %s"
				)
			else
				(HighPrint (Format @shelfStr 180 73 [bookShelfMsg bookMsgCounter])) ; "Through the mildew, you are able to recognize some of the book titles. For instance, Aziza owns %s"
			)
			(if (> (++ bookMsgCounter) 10)
				(= bookMsgCounter 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lilyPad1 of PicView
	(properties
		x 260
		y 186
		noun '/lily'
		description {the lily pad}
		lookStr {Lily pads float in Aziza's indoor pond.}
		view 184
		loop 3
		priority 15
		signal 16
	)
)

(instance lilyPad2 of PicView
	(properties
		x 295
		y 184
		noun '/lily'
		description {the lily pad}
		lookStr {Lily pads float in Aziza's indoor pond.}
		view 184
		loop 3
		priority 15
		signal 16
	)
)

(instance pond of Feature
	(properties
		x 273
		y 181
		noun '/oasis,water'
		nsTop 173
		nsLeft 229
		nsBottom 189
		nsRight 318
		description {the pond}
		lookStr {Aziza keeps an indoor pond.}
	)
)

(instance tableSound of Sound
	(properties
		number 181
		priority 5
		loop -1
	)
)

(instance spellCode of Code
	(properties)

	(method (doit)
		(AzizaChangeMood 2 1)
		(return 0)
	)
)

