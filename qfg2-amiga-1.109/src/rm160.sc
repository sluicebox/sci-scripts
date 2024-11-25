;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Stage)
(use Interface)
(use Feature)
(use LoadMany)
(use Timer)
(use Avoid)
(use Extra)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	rm160 0
	uhura 1
	rakeesh 2
	uhuraBody 3
	rakeeshBody 4
	responseTimer 5
)

(local
	seenQuarters
	uhuraResponse
	guildAction
	initPosition
	babyTimer
	babyTalk
	babyMessage
	oneKick
	oldEgoBits
	[GuildList 33] = [0 1 0 0 1 2 5 0 0 0 2 0 3 3 4 0 2 0 3 0 2 0 0 4 1 5 2 5 2 5 2 6 4]
	[uhuraGenList 38] = [1 31 32 33 34 35 36 37 38 39 40 41 42 0 43 44 45 0 46 0 47 48 49 50 51 52 0 0 0 53 54 55 56 0 0 0 0 0]
	[uhuraSpecList 60] = [2 '//labor' 3 '//note' 4 '//book,log,logbook' 5 '//plaque,emblem,logo,crest,(bulletin,sign,board<eof)' 6 '//spear,bow,arrow,quiver' 7 '//simba,baby,baby' 8 '//home' 9 '//scorpion' 10 '//bandit' 11 '//ghoul' 12 '//jackal,jackal,(man<jackal)' 13 '//dinosaur,(saurii<terror)' 14 '//griffin' 15 '//dad' 16 '//errand,bulletin,sign,board[<errand,about]' 17 '//rakeesh,lion' 18 '//paladin' 19 '//leg,bandage,injury' 20 '//eof,(order[<eternal,fighter,about])' 21 '//wizard,(user<magic),mage' 22 '//afreet' 23 '//attar,apothecary' 24 '//keapon,(clerk<magic),keapon' 25 '//issur,armorer,armorer' 26 '//prize,service' 27 '//blade,soulforge,(forge<soul)' 28 '//hero,adventurer' 29 '//moose' 30 '//train,practice,attack,battle' 0 0]
	[rakeeshGenList 38] = [46 47 48 49 50 51 52 53 54 55 56 57 59 45 60 61 62 45 63 64 65 66 67 68 69 70 71 80 74 75 76 77 78 45 45 45 45 45]
	[rakeeshSpecList 64] = [0 '//nature' 2 '//flame' 5 '//attack,battle' 6 '//leg,bandage,injury' 8 '//demon' 10 '//kingdom' 12 '//wizard' 14 '//choice' 15 '//people,lion' 16 '//tarna' 17 '//power,fighter' 19 '//will,soul' 20 '//philosopher' 21 '//forge,soulforge[<soul,about]' 23 '//paladin' 27 '//blade[<flaming,about]' 28 '//guildmaster' 30 '//simba,baby,baby' 32 '//magic<dark' 34 '//adventurer,adventure,adventuring' 35 '//ask' 36 '//hero' 37 '//ghoul' 38 '//dinosaur,(saurii<terror)' 39 '//griffin' 40 '//bandit' 41 '//(man<jackal),jackal' 42 '//scorpion' 43 '//poison,pill,cure,tail' 44 '//moose' 79 '//book,log,logbook' 0 0]
)

(instance rm160 of Stage
	(properties
		picture 160
		south 320
		bottomFromX 160
		bottomExit 2
		bottomToX 160
	)

	(method (init &tmp [str 20] event)
		(LoadMany rsVIEW 0 160 162 168)
		(Load rsTEXT 162 168)
		(= guildAction [GuildList (- (* gDay 2) 1)])
		(= initPosition [GuildList (* gDay 2)])
		(= gNow (+ (* gDay 100) gTimeODay))
		(uhura init:)
		(switch initPosition
			(0
				(uhuraBody loop: 4 x: 67 y: 125 init:)
			)
			(1
				(uhuraBody loop: 2 x: 143 y: 119 init:)
				(rakeesh init:)
				(rakeeshHead init:)
				(rakeeshBody init:)
				(rakeeshTail init:)
				(simba init: setCycle: Fwd (= babyTimer 50))
			)
			(2
				(uhuraBody loop: 3 x: 220 y: 157 init:)
			)
			(3
				(uhuraBody loop: 4 x: 218 y: 118 init:)
			)
			(4
				(uhuraBody loop: 2 x: 67 y: 125 init:)
				(rakeesh init:)
				(rakeeshHead init:)
				(rakeeshBody init:)
				(rakeeshTail init:)
				(simba init: setCycle: Fwd (= babyTimer 50))
			)
			(5
				(uhuraBody loop: 2 x: 218 y: 118 init:)
			)
		)
		(switch gPrevRoomNum
			(161
				(= inOut 3)
			)
			(170 ; rmPractice
				(gEgo x: 220 y: 145 loop: 1)
				(= inOut 3)
			)
			(else
				(= gPrevRoomNum 320)
			)
		)
		(if (gCast contains: rakeesh)
			(gEgo illegalBits: (| (gEgo illegalBits:) $2000))
			(if (gCast contains: simba)
				(gEgo illegalBits: (| (gEgo illegalBits:) $1000))
			)
		)
		(if (== gPrevRoomNum 170) ; rmPractice
			(self style: 17)
		else
			(self style: 6)
		)
		(cond
			((== gPrevRoomNum 170)) ; rmPractice
			((== gPrevRoomNum 161))
			((== gDay (/ gGuildLastHere 100))
				(if (== guildAction 2)
					(= entranceScript (ScriptID 163 1)) ; enterS
				else
					(= entranceScript (ScriptID 163 0)) ; welcomeS
				)
			)
			((and (== guildAction 3) (not (IsFlag 610)))
				(= entranceScript (ScriptID 163 2)) ; enterAward
			)
			(
				(and
					(== guildAction 5)
					(== gOrigHeroType 0)
					(< (/ gGuildLastHere 100) gDay)
				)
				(= entranceScript (ScriptID 163 3)) ; enterEOF
			)
			((== guildAction 4)
				(if (and (== gOrigHeroType 0) (> gElementalState 5))
					(= entranceScript (ScriptID 163 5)) ; enterHelpDone
				else
					(= entranceScript (ScriptID 163 4)) ; enterHelpNeeded
				)
			)
			((== guildAction 6)
				(= entranceScript (ScriptID 163 6)) ; enterCongrats
			)
			((== guildAction 2)
				(= entranceScript (ScriptID 163 1)) ; enterS
			)
			(else
				(= entranceScript (ScriptID 163 0)) ; welcomeS
			)
		)
		(gEgo init:)
		(super init:)
		(InitFeatures leftDoor rightDoor quill fez spears tusks)
		(InitAddToPics
			moose
			pillow1
			pillow2
			questBoard
			table
			EOFBoard
			book
			shield
			bow
		)
		(SetFlag 127) ; f160
		(while ((= event (Event new:)) type:)
			(event dispose:)
		)
		(event dispose:)
	)

	(method (dispose)
		(if (gTimers contains: responseTimer)
			(= uhuraResponse 1)
			(responseTimer cue:)
		)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(= gRoomExitDir 2)
		(= gGuildLastHere gNow)
		(DisposeScript 163)
		(super dispose:)
	)

	(method (doit &tmp [str 20])
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl: 1) $0002)
				(gCurRoom newRoom: 170) ; rmPractice
			)
			((and (gEgo inRect: 33 110 65 135) (not seenQuarters))
				(= seenQuarters 1)
				(gEgo setMotion: 0)
				(Face gEgo uhuraBody)
				(Say uhura 160 0) ; "That be my place to stay. I think you shall not go there."
			)
			((and (gEgo inRect: 225 117 260 130) (not (IsFlag 176))) ; fSeenPractice
				(SetFlag 176) ; fSeenPractice
				(gEgo setMotion: 0)
				(Face gEgo uhuraBody)
				(Say uhura 160 1 160 2) ; "That will be the place to see just how good a fighter you are. I get tired of not using spear and shield for so long a while. Maybe you and I will go check out skills there."
			)
		)
	)

	(method (handleEvent event &tmp [str 42])
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/hall[<club,fighter]')
				)
				(HighPrint 160 3) ; "This Guild Hall is more colorful and primitive than others that you have seen. As is the custom, artifacts are displayed on the walls, notices are posted on the Quest Board, and the emblem of the Eternal Order of Fighters is prominent."
			)
			((Said 'practice')
				(Face gEgo uhuraBody)
				(Say uhura 160 4) ; "The open doorway leads to an area where we may practice."
			)
			((Said 'get,get/note')
				(if
					(and
						(== guildAction 5)
						(== gOrigHeroType 0)
						(< (/ gGuildLastHere 100) gDay)
					)
					(HighPrint 160 5) ; "Uhura has already given you the note."
				else
					(event claimed: 0)
				)
			)
			((Said 'get,get,get,borrow/blade,(forge<soul),soulforge')
				(cond
					((not (gCast contains: rakeesh))
						(HighPrint 160 6) ; "You don't see any spare swords lying around."
					)
					((and (== gDay 12) (== gElementalState 5) (== gOrigHeroType 0))
						(if (IsFlag 72) ; fRakeeshSword
							(Say rakeesh 160 7) ; "You have my sword, Hero."
						else
							(SetFlag 72) ; fRakeeshSword
							(rakeeshBody setScript: egoTakesSword)
						)
					)
					(else
						(Say rakeesh 160 8) ; "I will keep my sword, thank you."
					)
				)
			)
			(
				(Said
					'give,hand,offer,replace/blade,(forge<soul),soulforge[/guildmaster,woman]'
				)
				(if (gEgo has: 31) ; Soulforge
					(SolvePuzzle 676 5 3)
					(gEgo setScript: egoGivesSword)
				else
					(DontHave)
				)
			)
			((Said 'read/log,logbook,(book[<log])')
				(cond
					((not (gEgo inRect: 260 130 310 140))
						(HighPrint 160 9) ; "Step over to the book if you wish to read it."
					)
					((IsFlag 139) ; fBookSigned
						(HighPrint (Format @str 160 10 @gUserName)) ; "The last entry is "%s, Hero of Spielburg.""
					)
					(else
						(HighPrint 160 11) ; "The log is for the most part written in a language you can't read."
					)
				)
			)
			(
				(or
					(Said 'sign/log,logbook,(book[<log])')
					(Said 'write,sign/identity')
				)
				(cond
					((not (gEgo inRect: 260 130 310 140))
						(HighPrint 160 12) ; "Step over to the book if you wish to sign it."
					)
					((IsFlag 139) ; fBookSigned
						(HighPrint 160 13) ; "You have already signed it."
					)
					(else
						(SetFlag 139) ; fBookSigned
						(SolvePuzzle 611 3)
						(HighPrint 160 14) ; "You sign your name in the book."
					)
				)
			)
			((Said 'kiss/guildmaster,woman,(master<club)')
				(HighPrint 160 15) ; "You would probably anger her if you tried, and you don't want to see her mad."
			)
			((Said 'attack/guildmaster,woman,master,guildmaster')
				(gCurRoom newRoom: 170) ; rmPractice
			)
			((Said 'join/eof,order')
				(cond
					((gCast contains: rakeesh)
						(Say rakeesh 160 16) ; "One does not just join the Eternal Order of Fighters, nor is this the place if you could."
					)
					((gCast contains: uhura)
						(Say uhura 160 16) ; "One does not just join the Eternal Order of Fighters, nor is this the place if you could."
					)
					(else
						(HighPrint 160 16) ; "One does not just join the Eternal Order of Fighters, nor is this the place if you could."
					)
				)
			)
		)
	)
)

(instance egoTakesSword of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& (gEgo onControl: 1) $4000)
					(gEgo
						illegalBits: $b000
						setAvoider: Avoid
						setMotion: MoveTo 178 174 self
					)
				else
					(self cue:)
				)
			)
			(1
				(Face gEgo rakeesh)
				(Say rakeesh self 160 17) ; "You will need the magic of a flaming sword to defeat the Earth Elemental."
			)
			(2
				(rakeesh x: 198 z: 36)
				(rakeeshHead hide:)
				(rakeeshTail hide:)
				(rakeeshBody loop: 6 cel: 0 cycleSpeed: 1 setCycle: End self)
				(if (not (simba loop:))
					(simba setCycle: CT 0 1)
				else
					(simba setScript: babyResumes)
					(= babyTimer -1)
				)
			)
			(3
				(Say rakeesh self 160 18) ; "Permit me to loan you my sword, "Soulforge.""
			)
			(4
				(rakeeshBody loop: 7 cel: 0 setCycle: CT 7 1 self)
			)
			(5
				(rakeeshBody cel: 8)
				(flame init: setCycle: Fwd)
				(= cycles 15)
			)
			(6
				(flame dispose:)
				(rakeeshBody setCycle: End self)
			)
			(7
				(rakeesh x: 200)
				(Say rakeesh self 160 19 160 20 160 21) ; "When you are in battle against the Elemental, the flame of the sword will aid you."
			)
			(8
				(if (or (!= (gEgo x:) 178) (!= (gEgo y:) 174))
					(gEgo setMotion: MoveTo 178 174 self)
				else
					(self cue:)
				)
			)
			(9
				(gEgo view: 168 loop: 8 cel: 0 setCycle: CT 2 1 self)
			)
			(10
				(SolvePuzzle 661 7 0)
				(gEgo setCycle: End self get: 31 setAvoider: 0) ; Soulforge
				(rakeeshBody loop: 5)
				(rakeesh x: 199)
			)
			(11
				(NormalEgo)
				(Face gEgo rakeesh)
				(self dispose:)
			)
		)
	)
)

(instance egoGivesSword of HandsOffScript
	(properties)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(= theX (+ (uhuraBody x:) 7))
				(= theY (+ (uhuraBody y:) 11))
				(gEgo setMotion: MoveTo theX theY self)
			)
			(1
				(if (== uhuraResponse 0)
					(Say uhura self 160 22) ; "Good sword, good fight. There are many be proud of you."
				else
					(Say uhura self 160 23) ; "That was better."
				)
			)
			(2
				(gEgo use: 31) ; Soulforge
				(responseTimer dispose:)
				(self dispose:)
			)
		)
	)
)

(instance babyTurns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if babyMessage
					(HighPrint 160 24 80 {Hero}) ; "Goo goo ga ga goo."
				)
				(simba setCycle: Beg self)
			)
			(1
				(simba loop: 10 setCycle: CT 3 1 self)
			)
			(2
				(if babyMessage
					(= babyMessage 0)
					(Print 160 25 #title {Baby Simba} #at -1 25 #window babyWindow) ; "Poltergeists make up the principle types of spontaneous material manifestations."
					(= babyTimer 5)
				else
					(if (and (not (rakeesh cycler:)) (== (++ babyTalk) 4))
						(= babyTalk 0)
						(Print ; "Goo goo, Maa Fhimt."
							160
							26
							#time
							5
							#title
							{Baby Simba}
							#at
							220
							50
							#window
							babyWindow
							#dispose
						)
					)
					(simba loop: 11 setCycle: Fwd)
					(= babyTimer 50)
				)
				(self dispose:)
			)
		)
	)
)

(instance babyResumes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(simba loop: 10 cel: 3 setCycle: Beg self)
			)
			(1
				(simba loop: 0)
				(= babyTimer (Random 200 400))
				(client setScript: playWithTail)
			)
		)
	)
)

(instance rakeeshLooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rakeeshHead setCycle: End self)
			)
			(1
				(= cycles 15)
			)
			(2
				(rakeeshHead setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance playWithTail of Script
	(properties)

	(method (doit)
		(if
			(and
				(== (rakeeshTail cel:) 6)
				(!= (simba loop:) 10)
				(not (rakeesh cycler:))
				(not (rakeeshHead cel:))
			)
			(simba setCycle: Beg)
			(if (Random 0 1)
				(rakeeshHead setScript: rakeeshLooks)
			)
		)
		(super doit:)
	)
)

(instance babyToss of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= babyTimer 0)
				(simba loop: 10 cel: 0 setCycle: End)
				(gEgo
					view: 22
					loop: 0
					cel: 0
					illegalBits: 0
					posn: (+ (gEgo x:) 3) (+ (gEgo y:) 8)
					setCycle: End
				)
				(= cycles 20)
			)
			(1
				(simba loop: 11 setCycle: Fwd)
				(HighPrint 160 27 80 {Baby Simba} 35 babyWindow 103) ; "Watch it buddy! I'm not getting hazardous duty pay on this gig, so don't mess with me. They don't pay me enough to put up with a lowlife like you. Cheeeeeezzzz!!"
				(= seconds 6)
			)
			(2
				(simba loop: 10 cel: 3 setCycle: Beg)
				(gEgo loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(cls)
				(= babyTimer 50)
				(NormalEgo)
				(gEgo loop: 3)
				(self dispose:)
			)
		)
	)
)

(instance uhura of Talker
	(properties
		z 31
		description {the warrior Uhura}
		view 162
		signal 16400
		illegalBits 0
		talkSpeed 1
		myName '//guildmaster,woman,girl,fighter,instructor'
		title {Uhura:}
		color 14
		back 0
		msgFile 162
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (<= 3 (uhuraBody loop:) 4)
				(HighPrint 160 28) ; "The warrior woman cradles baby Simba in her arms."
			else
				(HighPrint 160 29) ; "The warrior woman stands tall and proud."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (atSpec which)
		(return [uhuraSpecList which])
	)

	(method (atGen which)
		(return [uhuraGenList which])
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'tell/guildmaster,woman/(spielburg,bandit)[<about]')
				(Say self 160 30) ; "Maybe you find work for Hero here, too."
				(TrySkill 13) ; communication
			)
			((or (Said 'give/bouquet') (Said 'give//bouquet'))
				(GiveFlowers self 160 31)
			)
			((Said 'thank')
				(SayThanks self 160 32)
			)
			((or (Said 'hello,greet') (Said '/hello,greet'))
				(Say self 160 33) ; "Maybe today you and I get in some more practice at fighting.  It will be good to feel the spear in my hand again."
			)
			(
				(and
					(OneOf (uhuraBody loop:) 3 4)
					(Said 'look,look/baby,simba,baby')
				)
				(Say self (self msgFile:) 7)
			)
		)
	)

	(method (showText what)
		(if (== what 39)
			(SolvePuzzle 659 3 0)
		)
		(super showText: what &rest)
	)

	(method (messages &tmp xPosn yPosn uX uY uPri uLoop)
		(= uX (uhuraBody x:))
		(= uY (uhuraBody y:))
		(= uPri (uhuraBody priority:))
		(cond
			((== (= uLoop (uhuraBody loop:)) 2)
				(= xPosn (- uX 3))
				(= yPosn (- uY 11))
			)
			((== uLoop 3)
				(= xPosn (- uX 2))
				(= yPosn (+ uY 3))
			)
			(else
				(= xPosn uX)
				(= yPosn (- uY 11))
			)
		)
		(self posn: xPosn yPosn setPri: uPri)
		(super messages: &rest)
	)

	(method (endTalk)
		(super endTalk:)
		(self setPri: 0)
	)
)

(instance uhuraBody of View
	(properties
		noun '/guildmaster,woman,girl,fighter,instructor'
		description {the warrior Uhura}
		view 162
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (<= 3 (uhuraBody loop:) 4)
				(HighPrint 160 28) ; "The warrior woman cradles baby Simba in her arms."
			else
				(HighPrint 160 29) ; "The warrior woman stands tall and proud."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rakeesh of Talker
	(properties
		x 199
		y 161
		z 27
		description {the Liontaur Rakeesh}
		lookStr {The leonine creature before you looks ferocious and kindly at the same time.}
		view 168
		loop 4
		priority 13
		signal 16400
		illegalBits 0
		tLoop 4
		talkSpeed 1
		myName '//rakeesh,lion,fighter,man'
		title {Rakeesh:}
		color 11
		back 0
		msgFile 168
	)

	(method (doit)
		(cond
			((not babyTimer))
			((-- babyTimer))
			((not (simba loop:))
				(simba setScript: babyTurns)
			)
			(else
				(simba setScript: babyResumes)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'thank[/rakeesh]')
				(if (and (IsFlag 72) (not (IsFlag 186))) ; fRakeeshSword, fSwordThanks
					(SetFlag 186) ; fSwordThanks
					(SkillUsed 14 50) ; honor
				)
				(SayThanks rakeesh 160 34)
			)
			((or (Said 'hello,greet[/rakeesh]') (Said '/hello,greet'))
				(Say self 160 35) ; "It is good to see you, young Hero. A nice day to be adventuring."
			)
			((Said 'give,replace,refuse/purse,alm,prize')
				(cond
					((SetFlag 158) ; fRefusedReward
						(HighPrint 160 36) ; "You've already returned the reward."
					)
					((or (not (IsFlag 610)) (IsFlag 600))
						(Say self 160 37) ; "My thanks, but I have no need for gifts."
					)
					(else
						(gEgo use: 2 50) ; Dinar
						(SkillUsed 14 50) ; honor
						(Say self 160 38) ; "You show great honor. May your deeds continue to shine!"
					)
				)
			)
		)
	)

	(method (showText what)
		(cond
			(
				(and
					(== what 27)
					(not (IsFlag 72)) ; fRakeeshSword
					(== gOrigHeroType 0)
					(== gDay 12)
					(== gElementalState 5)
				)
				(SetFlag 72) ; fRakeeshSword
				(rakeeshBody setScript: egoTakesSword)
			)
			((and (== what 5) (<= 5 gElementalState 6))
				(= what 3)
				(self showMany: 3 4)
			)
			(else
				(switch what
					(78
						(Say self msgFile 78 msgFile 35)
					)
					(0
						(self showMany: what 1)
					)
					(6
						(self showMany: what 7)
					)
					(8
						(self showMany: what 9)
					)
					(10
						(self showMany: what 11)
					)
					(12
						(self showMany: what 13)
					)
					(17
						(self showMany: what 18)
					)
					(21
						(self showMany: what 22)
					)
					(23
						(SolvePuzzle 660 3 0)
						(self showMany: what 26)
					)
					(28
						(self showMany: what 29)
					)
					(32
						(self showMany: what 33)
					)
					(57
						(self showMany: what 58)
					)
					(72
						(self showMany: what 73)
					)
					(else
						(super showText: what)
					)
				)
			)
		)
	)

	(method (atSpec which)
		(return [rakeeshSpecList which])
	)

	(method (atGen which)
		(return [rakeeshGenList which])
	)

	(method (messages)
		(if (& (gEgo onControl: 1) $0800)
			(gEgo setPri: 14)
		)
		(if (rakeeshHead script:)
			(rakeeshHead cel: 0 setScript: 0)
		)
		(super messages: &rest)
	)

	(method (endTalk)
		(self setCel: 0)
		(gEgo setPri: -1)
		(super endTalk: &rest)
	)
)

(instance rakeeshHead of Prop
	(properties
		x 200
		y 164
		z 30
		noun '/rakeesh,lion,fighter'
		description {the Liontaur Rakeesh}
		lookStr {The leonine creature before you looks ferocious and kindly at the same time.}
		view 168
		loop 3
	)
)

(instance rakeeshBody of Prop
	(properties
		x 200
		y 161
		noun '/rakeesh,lion,fighter'
		description {the Liontaur Rakeesh}
		lookStr {The leonine creature before you looks ferocious and kindly at the same time.}
		view 168
		loop 1
	)
)

(instance rakeeshTail of Extra
	(properties
		x 226
		y 144
		noun '/tail'
		description {the Liontaur's tail}
		view 168
		loop 2
		priority 12
		signal 16400
		cycleType 1
		hesitation 20
		minPause 40
		maxPause 80
		minCycles 1
		maxCycles 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (gCast contains: simba)
				(HighPrint 160 39) ; "Imagine! Such a warrior's tail used as a playtoy for a baby!"
			else
				(HighPrint 160 40) ; "Rakeesh relaxes but his tail stays ever alert."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance simba of Actor
	(properties
		x 235
		y 168
		noun '/baby,simba'
		description {the baby Simba}
		view 168
		loop 11
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and (< (rakeeshBody loop:) 5) (gCast contains: rakeesh))
					(HighPrint 160 41) ; "The baby fearlessly plays with the Liontaur's tail."
				else
					(HighPrint 160 42) ; "The kid's hangin' loose."
				)
			)
			(9
				(if (not (IsFlag 71)) ; fBabyMessage
					(SetFlag 71) ; fBabyMessage
					(= babyMessage 1)
					(simba setScript: babyTurns)
				else
					(HighPrint 160 43) ; "Don't bother. He only tries to show off."
				)
			)
			(7
				(HighPrint 160 44) ; "Rakeesh wouldn't appreciate it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'ask/simba,baby')
				(if (not (IsFlag 71)) ; fBabyMessage
					(SetFlag 71) ; fBabyMessage
					(= babyMessage 1)
					(simba setScript: babyTurns)
				else
					(HighPrint 160 43) ; "Don't bother. He only tries to show off."
				)
			)
			((Said 'hit/baby,simba')
				(cond
					((and (gEgo inRect: 220 170 250 175) (not oneKick))
						(= oneKick 1)
						(simba setScript: babyToss)
					)
					(oneKick
						(HighPrint 160 45) ; "Hero types don't do that sort of thing more than once."
					)
					(else
						(HighPrint 160 46) ; "Hero types don't do that sort of thing."
					)
				)
			)
			((Said 'get,get,get/baby')
				(HighPrint 160 47) ; "Uhura would have your head off before you got 10 feet. Besides, there is no baby market in Shapeir."
			)
		)
	)
)

(instance responseTimer of Timer
	(properties)

	(method (cue)
		(switch (++ uhuraResponse)
			(1
				(Face gEgo uhuraBody)
				(Say uhura 160 48) ; "Maybe you do not hear so good. I be thinking you give me back Rakeesh's sword, or maybe I be getting plenty mad."
				(StartTimer self 15)
			)
			(2
				(gEgo use: 31) ; Soulforge
				(CantBePaladin)
				(SetFlag 157) ; fUhuraMad
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance moose of PicView
	(properties
		x 288
		y 90
		noun '/moose'
		description {the moose}
		lookStr {It's the head of the rare Southern Moose.__You can tell by the hat.}
		view 160
		priority 9
		signal 16
	)
)

(instance pillow1 of PicView
	(properties
		x 46
		y 168
		noun '/cushion'
		description {a plump purple pillow}
		lookStr {The pillow looks like it would be a comfortable place to sit, if you had time.}
		view 160
		cel 2
		priority 0
		signal 16400
	)
)

(instance pillow2 of PicView
	(properties
		x 37
		y 156
		noun '/cushion'
		description {a plump cushion}
		lookStr {The pillow looks like a comfortable place to sit.}
		view 160
		cel 1
		priority 0
		signal 16400
	)
)

(instance questBoard of PicView
	(properties
		x 106
		y 84
		noun '/errand,bulletin,sign,board[<errand]'
		description {the quest board}
		view 160
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'read/bulletin,sign,board[<errand]')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (gEgo inRect: 64 110 137 130)
				(gCurRoom newRoom: 161)
			else
				(HighPrint 160 49) ; "The standard Guild Hall Quest Board has an assortment of notices posted, but you must move closer in order to read them."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance table of PicView
	(properties
		x 184
		y 115
		noun '/table,barstool'
		description {a short solid table}
		lookStr {The table looks solid enough.}
		view 160
		loop 1
		cel 3
	)
)

(instance EOFBoard of PicView
	(properties
		x 192
		y 87
		noun '/errand,bulletin,sign,board,plaque,emblem,logo,crest[<eof]'
		description {the emblem of the EOF}
		lookStr {The emblem of the Eternal Order of Fighters is proudly displayed on the wall.}
		view 160
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'read>') (Said noun))
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (gEgo inRect: 155 110 231 130)
				(HighPrint 160 50) ; "If you got real guts and don't know the meaning of fear; If you got real muscles and don't take guff from no one; If you got a real weapon and know how to use it; then maybe you are good enough to join the Eternal Order of Fighters."
				(HighPrint 160 51) ; "We pick only the best to join and we'll be watching you, so don't just be good, be great! Be a member of EOF! Eternal Order of Fighters The Guts, The Glory, The Greatest!"
			else
				(HighPrint 160 52) ; "There is some writing on the EOF plaque on the wall, but you are not close enough to read it."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance book of PicView
	(properties
		x 291
		y 113
		noun '/book,log,logbook'
		description {an open registration book}
		lookStr {The book is for visiting adventurers to sign.}
		view 160
		loop 1
		cel 2
		priority 9
		signal 16
	)
)

(instance shield of PicView
	(properties
		x 241
		y 55
		noun '/shield'
		description {the shield of Uhura}
		lookStr {The shield has been in Uhura's family for many generations.}
		view 160
		loop 2
		priority 9
		signal 16
	)
)

(instance bow of PicView
	(properties
		x 41
		y 55
		noun '/bow,quiver'
		description {the mighty bow of Uhura}
		lookStr {The bow and quiver on the wall are for times of war.}
		view 160
		loop 2
		cel 1
	)
)

(instance babyWindow of SysWindow
	(properties
		color 5
		back 14
	)
)

(instance flame of Prop
	(properties
		x 182
		y 161
		z 50
		view 168
		loop 12
		signal 16384
	)
)

(instance fez of Feature
	(properties
		x 287
		y 147
		z 92
		noun '/fez,hat[<moose,green]'
		nsTop 50
		nsLeft 283
		nsBottom 60
		nsRight 292
		description {the moose's fez}
		lookStr {I have trouble remembering names, but I never forget a fez.}
	)
)

(instance rightDoor of Feature
	(properties
		x 243
		y 91
		noun '/door'
		nsTop 62
		nsLeft 229
		nsBottom 120
		nsRight 257
		description {the door to the practice arena}
		lookStr {The door leads to fighters' practice arena.}
	)
)

(instance leftDoor of Feature
	(properties
		x 44
		y 94
		noun '/door'
		nsTop 64
		nsLeft 33
		nsBottom 125
		nsRight 55
		description {the door to Uhura's private quarters}
		lookStr {The door leads to Uhura's private quarters.}
	)
)

(instance quill of Feature
	(properties
		x 293
		y 95
		noun '/pen,feather'
		nsTop 88
		nsLeft 290
		nsBottom 102
		nsRight 297
		description {the quill pen that goes with the book}
		lookStr {The quill pen used with the registration book is fashioned from the largest chicken feather you've ever seen.}
	)
)

(instance tusks of Feature
	(properties
		x 111
		y 21
		noun '/tusk[<elephant]'
		nsTop 7
		nsLeft 85
		nsBottom 36
		nsRight 196
		description {a pair of hephalump tusks}
		lookStr {The tusks could only have come from a rather large specimen of "Hephalumpis Poohrobinus."}
	)
)

(instance spears of Feature
	(properties
		x 156
		y 83
		noun '/spear'
		nsTop 58
		nsLeft 147
		nsBottom 109
		nsRight 165
		description {Uhura's spears}
		lookStr {Uhura prefers very heavy spears for their greater impact.}
	)
)

