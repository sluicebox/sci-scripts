;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use DCIcon)
(use Motion)
(use Game)
(use Inventory)
(use Menu)
(use Actor)
(use System)

(public
	rm420 0
)

(synonyms
	(man guard man man man bouncer)
	(woman woman dale cheri)
)

(local
	[string 166]
	[string2 22]
	pageNum
	passNum
	[passNumbers 27] = [0 0 0 741 0 -9725 30004 0 0 18608 25695 -32695 993 0 0 9170 0 0 -16422 -31742 0 0 -11054 -3033 0 0 0]
)

(procedure (PrintMD v l c)
	(Print
		@string
		#at
		-1
		10
		#title
		{the Maitre d' says}
		#mode
		1
		#icon
		v
		l
		c
	)
	(= string 0)
)

(instance rm420 of Rm
	(properties
		picture 420
		east 415
	)

	(method (init)
		(Load rsSOUND 11)
		(if (gEgo has: 7) ; Land_Deed
			(Load rsVIEW 7)
		)
		(super init:)
		(gAddToPics
			add: atpPoster1
			add: atpPoster2
			add: atpPhone
			add: atpPodium
			doit:
		)
		(aRope init:)
		(aDoor init:)
		(NormalEgo)
		(gEgo observeControl: 16384 8192 init:)
		(self setScript: RoomScript)
		(if (or (== gPrevRoomNum 430) (== gPrevRoomNum 431) (== gShowroomState 0))
			(aMaitreD view: 422 setPri: 5 setLoop: 2 init:)
		)
		(if (< gShowroomState 3)
			(aManager init:)
			(= gSomeObject aDoor)
		)
		(if (or (== gShowroomState 1) (== gShowroomState 2) (== gShowroomState 3))
			(aCherri init:)
			(= gSomeObject aDoor)
		)
		(cond
			((== gPrevRoomNum 440)
				(if (== gEgoState 18)
					(= gEgoState 0)
				)
				(TheMenuBar draw:)
				(SL enable:)
				(gEgo loop: 0 posn: 44 142)
			)
			((== gPrevRoomNum 435)
				(= gEgoState 0)
				(gEgo
					loop: gPrevLoop
					posn:
						(if gPrevRoomX gPrevRoomX else 99)
						(if gPrevRoomY gPrevRoomY else 124)
				)
				(aCherri init:)
			)
			((== gPrevRoomNum 430)
				(RoomScript changeState: 1)
			)
			((== gPrevRoomNum 431)
				(self style: 7)
				(RoomScript changeState: 1)
			)
			((> (gEgo y:) 130)
				(gEgo posn: 317 188 loop: 1)
			)
			(else
				(gEgo loop: 1 posn: 309 163)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== gSomeObject aDoor)
			(= gSomeObject 0)
			(DisposeScript 421)
			(DisposeScript 422)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look/art,art')
				(Print 420 0) ; "The posters on the wall are advertising the current showroom headliner, the lovely exotic dancer, Ms. Cherri Tart!"
			)
			((or (Said 'make/call') (Said 'call') (Said 'use/call'))
				(if (== gShowroomState 2)
					(Print 420 1) ; "It's in use, Larry!"
				else
					(Print 420 2) ; "This telephone is only usable by those with correct change!"
				)
			)
			((Said '/alter')
				(Print 420 3) ; "There is none."
			)
			((Said 'unbolt/door')
				(Print 420 4) ; "You have no key to fit this door. Have you tried knocking?"
			)
			((Said 'open/door')
				(cond
					((not (& (gEgo onControl:) $0008))
						(NotClose) ; "You're not close enough."
					)
					((== gEgoState 11)
						(self changeState: 6)
					)
					(else
						(Print 420 5) ; "You would, but it's locked."
					)
				)
			)
			((and (== gEgoState 11) (Said '/cloth,cloth'))
				(Print 420 6) ; "Where did you leave your clothes?"
			)
			((Said 'knock')
				(cond
					((== gEgoState 11)
						(Print 420 7) ; "Why not just go on in? It appears to be open."
					)
					((or (TestFlag 35) (>= gShowroomState 6))
						(Print 420 8) ; "You have no further business backstage!"
					)
					((not (& (gEgo onControl:) $0008))
						(NotClose) ; "You're not close enough."
					)
					((== gShowroomState 1)
						(Print 420 9) ; "As you begin to knock, you hear something backstage."
					)
					(else
						(self changeState: 12)
					)
				)
			)
			((Said 'look<in/bolt,(hole<key),door')
				(if (not (& (gEgo onControl:) $0008))
					(NotClose) ; "You're not close enough."
				else
					(Print 420 10) ; "It looks black in there."
				)
			)
			((Said 'look,look/awning,door')
				(if (not (& (gEgo onControl:) $0008))
					(NotClose) ; "You're not close enough."
				else
					(Print 420 11) ; "A tiny sign on the door reads, "Stage Door -- Authorized Personnel Only""
				)
			)
			((Said 'board/backstage')
				(Print 420 12) ; "There IS a way."
			)
			((Said '/hemp')
				(Print 420 13) ; "The rope is there to keep out all those without a ticket."
			)
			((Said 'look>')
				(cond
					((Said '/lectern')
						(if (== gShowroomState 2)
							(Print 420 14) ; "The showroom's maitre d' waits for additional customers."
						else
							(Print 420 15) ; "The podium is made of rosewood and plastic laminates."
						)
					)
					((Said '/backstage')
						(Print 420 16) ; "Through the doorway lies the casino's showroom. You could see it better from the inside."
					)
					((Said '/wall')
						(Print 420 0) ; "The posters on the wall are advertising the current showroom headliner, the lovely exotic dancer, Ms. Cherri Tart!"
						(Print 420 17) ; "There is a public telephone on the wall between the stage door and the showroom entrance."
					)
					((Said '/call')
						(if (== gShowroomState 2)
							(Print 420 18) ; "A gorgeous showgirl is talking on the -- wait a minute! It's Cherri, the tart, er, uh, dancer from the showroom!"
						else
							(Print 420 17) ; "There is a public telephone on the wall between the stage door and the showroom entrance."
						)
					)
					((Said '[/area]')
						(Print
							(Format ; "The outer lobby of the Casino's Showroom is basically empty, except for %s."
								@string
								420
								19
								(cond
									((== gShowroomState 2) {a gorgeous woman in a dressing gown})
									((gCast contains: aMaitreD) {a man standing behind a podium})
									(else {you})
								)
							)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(TheMenuBar draw:)
				(SL enable:)
				(aRope setCel: 255 stopUpd:)
				(aMaitreD view: 422 posn: 125 109 setPri: 5 init:)
				(NormalEgo 2)
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					posn: 150 94
					setMotion: MoveTo 150 114 self
				)
			)
			(2
				(gEgo stopUpd:)
				(aRope setCycle: Beg)
				(aMaitreD
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 172 105 self
				)
			)
			(3
				(aMaitreD setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(aMaitreD setCel: 0 stopUpd:)
				(aRope stopUpd:)
				(NormalEgo)
				(gEgo observeControl: 16384 8192)
				(if (== gPrevRoomNum 430)
					(Print 420 20) ; "What a show, eh, buddy?" slurps the maitre d'. "And how about that Cherri Tart?"
				else
					(Print 420 21) ; "The maitre d' wisecracks, "You seem to have been a big hit with the audience! Five hundred one-dollar bills ain't bad... for your first night!""
					(= seconds 2)
				)
			)
			(5
				(Print 420 22) ; "You think, "Just imagine: I got to have all that fun and make money, too!""
				(Print 420 23 #at -1 144) ; "(Why, that was even better than being a programmer for Sierra On-Line!)"
			)
			(6
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 44 140 self
				)
			)
			(7
				(aDoor setCycle: End self)
				(gEgo setLoop: 1)
			)
			(8
				(gEgo setMotion: MoveTo -3 140 self)
			)
			(9
				(aDoor setCycle: Beg self)
			)
			(10
				(gSoundFX number: 11 loop: 1 play:)
				(= cycles 12)
			)
			(11
				(gCurRoom newRoom: 440)
			)
			(12
				(HandsOff)
				(aCherri setScript: 0)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 50 143 self
				)
			)
			(13
				(gEgo loop: 1)
				(= cycles 11)
			)
			(14
				(if (== gShowroomState 4)
					(Print 420 24) ; "Daring to defy the "Authorized Personnel Only" sign on the stage door, you softly knock one, two, three times. You hope Cherri is true to her word!"
					(= seconds 3)
				else
					(= cycles (= seconds 0))
					((aManager script:) cue:)
					(self dispose:)
				)
			)
			(15
				(Print 420 25) ; "A small voice whispers through the door..."
				(Print 420 26) ; "Larry?"
				(Print 420 27) ; "Is that you?"
				(= seconds 3)
			)
			(16
				(Print 420 28) ; "You think to yourself, "Thank heavens, it's Cherri!""
				(Print 420 29) ; "You whisper through the door, "Yes, Cherri, it's me, Larry; Larry Laffer!""
				(= seconds 3)
			)
			(17
				(Print 420 30) ; "Oh, Larry, I've been waiting for your return! Did you get the deed?"
				(if (gEgo has: 7) ; Land_Deed
					(= state 19)
				)
				(= seconds 3)
			)
			(18
				(Print 420 31) ; "Uh, no, ah, er," you stammer, "I don't have it."
				(= seconds 3)
			)
			(19
				(Print 420 32) ; "Well, when you do find it, come back," says Cherri. "But don't take too long, ok? I've got another show to do tonight."
				(Print 420 33) ; ""Ok, I'll try," you conclude."
				(NormalEgo)
				(gEgo observeControl: 16384 8192)
			)
			(20
				(Print 420 34 #icon 7 0 0) ; "I've got it right here, sweetheart," you respond, "and I think you know just how much I'd like to give it to you! This is your big chance! Now you can give up show business and move to your own little place out in the country."
				(PutInRoom 7)
				(gGame changeScore: 25)
				(= seconds 3)
			)
			(21
				(Print 420 35 #at 10 5 #width 290) ; "Oh, Larry! 640 acres of virgin Nontoonyt rain forest, perfectly suited for slash burning and typical agricultural pillage. You've just made me the happiest woman on Earth! Come on backstage and allow me to properly express my appreciation."
				(= seconds 3)
			)
			(22
				(aDoor setCycle: End self)
			)
			(23
				(aDoor stopUpd:)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(24
				(aDoor setCycle: Beg self)
			)
			(25
				(gSoundFX number: 11 loop: 1 play:)
				(cls)
				(Print 420 36) ; "Heh, heh, heh," you chuckle. "It looks like I'm gonna get a little something for Kalalau's worthless farmland after all!"
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance aMaitreD of Act
	(properties
		y 105
		x 172
		view 422
		loop 2
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setScript: MaitreDScript ignoreActors: stopUpd:)
	)
)

(instance MaitreDScript of Script
	(properties)

	(method (handleEvent event &tmp theObj)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((or (Said 'ask/pass') (Said 'ask/about/pass'))
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 420 37) ; "He'll never hear you from here."
					)
					(else
						(Print 420 38) ; ""So where can I get one of those free passes?" you ask the maitre d'."
						(Format @string 420 39) ; "Did you look in the box that held your disks?"
						(self changeState: 4)
					)
				)
			)
			((and (not gEgoIsPatti) (Said '/entertainer'))
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 420 37) ; "He'll never hear you from here."
					)
					(else
						(Print 420 40) ; "Do know where I could find Passionate Patti's piano bar?"
						(Format @string 420 41) ; "Certainly. You took a wrong turn at the top of the staircase. Go right instead of left."
						(self changeState: 4)
					)
				)
			)
			(
				(or
					(Said '/casino,gambling')
					(Said 'gamble')
					(Said '//casino,gambling')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 420 37) ; "He'll never hear you from here."
					)
					(else
						(Print 420 42) ; "What kind of place is this?" you ask the maitre d'. "How does a guy do any gambling around this casino?"
						(Format @string 420 43) ; "If you knew how Natives, Inc. has set the odds here, you wouldn't ask!"
						(self changeState: 4)
					)
				)
			)
			(
				(or
					(Said 'board/backstage')
					(Said 'ask/show')
					(Said 'ask//show')
					(Said 'look/show')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 420 37) ; "He'll never hear you from here."
					)
					((>= gShowroomState 5)
						(Print 420 44) ; "You've done quite enough in that room, fella!"
					)
					((>= gShowroomState 1)
						(Print 420 45) ; "Just couldn't get enough that first time, eh?"
					)
					(else
						(Format @string 420 46) ; "The maitre d' responds, "If you would like to see tonight's show you'll have to have a ticket. Of course, some of the local tourist magazines contain free passes. If you have no ticket, you might try one of those.""
						(self changeState: 4)
					)
				)
			)
			((Said 'bracelet,use,give,show/pass,book')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 420 47) ; "He'll never see it from here."
					)
					((>= gShowroomState 5)
						(Print 420 44) ; "You've done quite enough in that room, fella!"
					)
					((>= gShowroomState 1)
						(Print 420 45) ; "Just couldn't get enough that first time, eh?"
					)
					(else
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said 'bracelet,give,show/buck,500,bill')
					(Said 'buy,tip/man')
					(Said 'bracelet,give,show/man/buck,500,bill')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (gEgo has: 6)) ; A_Twenty_Dollar_Bill
						(Print 420 48) ; "You're broke."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 420 47) ; "He'll never see it from here."
					)
					((>= gShowroomState 5)
						(Print 420 49) ; "Thanks anyway, fella!"
					)
					(else
						(self changeState: 6)
					)
				)
			)
			((Said 'talk/man')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 420 50) ; "No one is near you."
					)
					((>= gShowroomState 5)
						(Print 420 44) ; "You've done quite enough in that room, fella!"
					)
					((>= gShowroomState 1)
						(Print 420 45) ; "Just couldn't get enough that first time, eh?"
					)
					(else
						(Printf 420 51 gLaffer) ; ""Hello, sir" you say to the maitre d'. %s"
						(Print 420 52) ; "Could you give me some information about the show inside?"
						(Format @string 420 46) ; "The maitre d' responds, "If you would like to see tonight's show you'll have to have a ticket. Of course, some of the local tourist magazines contain free passes. If you have no ticket, you might try one of those.""
						(self changeState: 4)
					)
				)
			)
			((Said 'look/man')
				(Print 420 53) ; "The maitre d' looks like he would be the life of the party..."
				(Print 420 54 #at -1 144) ; "(...if the party was an morticians' convention!)"
			)
			((Said 'give>')
				(= theObj (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((not (& (gEgo onControl:) $0010))
						(NotClose) ; "You're not close enough."
					)
					((Said '[/!*]')
						(Print 420 55) ; "What did you want to give him?"
					)
					((not theObj)
						(Print 420 56) ; "It's not yours to give."
					)
					((not (theObj ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					((== theObj (gInventory at: 2)) ; Ginsu_Knife
						(Print 420 57) ; "Hey!" shouts the maitre d'. "Put that knife away before I call security!!"
					)
					((== theObj (gInventory at: 4)) ; Native_Grass
						(Print 420 58) ; ""Get those weeds out of here!" shouts the maitre d'."
					)
					((== theObj (gInventory at: 3)) ; Granadilla_Wood
						(Print 420 59) ; "Isn't that precious?" he snarls. "A hunk of wood. Indeed!"
					)
					((== theObj (gInventory at: 11)) ; some_Orchids
						(Print 420 60) ; "No, I'm not going to be your date for the prom!"
					)
					((== theObj (gInventory at: 1)) ; Credit_Card
						(Print 420 61) ; "I'm sorry, sir, but we don't accept credit cards here. Especially not from deadbeats!"
					)
					(else
						(Print 420 62) ; "The maitre d' replies, "And just exactly what am I supposed to do with that?""
					)
				)
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState &tmp [theLine 5])
		(ShowState self newState 2 2)
		(switch (= state newState)
			(0)
			(1
				(Ok) ; "O.K."
				(HandsOff)
				(Print 420 63) ; "You say, "Excuse me, sir, but I'd like to see tonight's show. I have my copy of `Nontoonyt Tonight' right here.""
				(aMaitreD setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(while (== 0 [passNumbers pageNum])
					(= pageNum (Random 1 24))
				)
				(Format @string 420 64 pageNum) ; "Oh, really? Well, for tonight's show I am allowed to accept free passes only from our ad on page %d. What is the number of the pass on that page?"
				(PrintMD 422 3 0)
				(= theLine 0)
				(GetInput @theLine 7 {My pass number is:})
				(if (!= (= passNum (ReadNumber @theLine)) [passNumbers pageNum])
					(= state 12)
				)
				(if gDebugging
					(Printf 420 65 passNum [passNumbers pageNum] pageNum) ; "You typed %d; I wanted %d from page %d."
				)
				(Format @string 420 66) ; "Let me look through this list of passes and numbers..."
				(PrintMD 422 3 0)
				(= seconds 3)
			)
			(3
				(aMaitreD setCel: 0 stopUpd:)
				(SetFlag 46)
				(if (not (TestFlag 47))
					(Format @string 420 67) ; "Well, well. Very good, sir," says the maitre d', his tone and mannerisms changing entirely. "But, I must have made a mistake. It appears there are no more seats available for this show! I'm so, so sorry. But, perhaps something will open up later."
					(handIcon view: 422 loop: 4)
					(Print
						@string
						#at
						-1
						10
						#title
						{the Maitre d' says}
						#mode
						1
						#icon
						handIcon
					)
					(= string 0)
					(HandsOn)
				else
					(Format @string 420 68) ; "Say," he exclaims, "I remember you. Why look here; I must have overlooked this seat right here in the front of the house. Please, walk this way!"
					(PrintMD 422 3 6)
					(self changeState: 8)
				)
			)
			(4
				(HandsOff)
				(aMaitreD setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(aMaitreD setCel: 0 stopUpd:)
				(if (not string)
					(Format @string 420 69) ; "Yes? May I help you sir?"
				)
				(PrintMD 422 3 0)
				(HandsOn)
			)
			(6
				(HandsOff)
				(aMaitreD setLoop: 2 setCycle: Fwd)
				(= cycles 0)
				(= seconds 3)
			)
			(7
				(aMaitreD setCel: 0 stopUpd:)
				(cond
					((== ((Inv at: 6) view:) 24) ; A_Twenty_Dollar_Bill
						(Print 420 70) ; "I don't want your stupid one-dollar bills!"
						(PrintMD 422 3 0)
					)
					((not (TestFlag 46))
						(Format @string 420 71) ; "Why thank you very much, sir! I'll try to keep your generosity in mind. Unfortunately, you must have a ticket or one of the casino's complimentary passes in order to gain admittance here. Do you have such a pass? If so, now is the time to show it to me."
						(PrintMD 422 3 0)
						(PutInRoom 6)
						(gGame changeScore: 50)
						(SetFlag 47)
						(HandsOn)
					)
					(else
						(HandsOff)
						(Format @string 420 72) ; "Why, thank you very much, sir, Well, well, look at this! I seem to have found a nice, front row seat available here. Allow me to show you to your seat!"
						(PrintMD 422 3 1)
						(PutInRoom 6)
						(SetFlag 47)
						(gGame changeScore: 50)
						(= seconds 2)
					)
				)
			)
			(8
				(aMaitreD
					illegalBits: 0
					ignoreActors: 1
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 162 105 self
				)
			)
			(9
				(aMaitreD setMotion: MoveTo 125 109 self)
				(aRope cycleSpeed: 1 setCycle: End)
			)
			(10
				(aRope stopUpd:)
				(aMaitreD setLoop: 2 setCel: 0 stopUpd:)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 149 114 self
				)
			)
			(11
				(gEgo setMotion: MoveTo 149 94 self)
			)
			(12
				(gCurRoom newRoom: 430)
			)
			(13
				(aMaitreD setCel: 0 stopUpd:)
				(Format @string 420 73) ; "I'm sorry, sir, but that's not the right number. Next time, obtain a proper pass in advance! Wait right there while I summon security and have you arrested for attempting to pass a counterfeit showroom pass."
				(PrintMD 422 3 0)
				(= seconds 2)
			)
			(14
				(Format @string 420 74) ; "By the way, have you saved your game recently?"
				(PrintMD 422 3 0)
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 56
					register: (Format @string 420 75) ; "Next time, better have a copy of "Nontoonyt Tonight" before playing this game."
					next: (Format @string2 420 76) ; "Al says, "Read Your Manual!""
				)
			)
		)
	)
)

(instance atpPhone of PV
	(properties
		y 96
		x 70
		view 420
		loop 1
		cel 2
		priority 7
	)
)

(instance atpPoster1 of PV
	(properties
		y 87
		x 224
		view 420
		loop 1
		priority 7
	)
)

(instance atpPoster2 of PV
	(properties
		y 93
		x 279
		view 420
		loop 1
		cel 1
		priority 7
	)
)

(instance atpPodium of PV
	(properties
		y 109
		x 166
		view 420
		loop 2
		priority 6
		signal 16384
	)
)

(instance aRope of Prop
	(properties
		y 91
		x 106
		view 420
		loop 3
		signal 16384
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 6 stopUpd:)
	)
)

(instance aManager of Prop
	(properties
		y 1000
		x 1000
		view 421
	)

	(method (init)
		(super init:)
		(self setScript: (ScriptID 421) stopUpd:) ; ManagerScript
	)
)

(instance aDoor of Prop
	(properties
		y 132
		x 42
		view 420
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance aCherri of Act
	(properties
		y 124
		x 82
		view 436
		loop 1
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setScript: (ScriptID 422)) ; CherriScript
	)
)

(instance handIcon of DCIcon
	(properties)
)

