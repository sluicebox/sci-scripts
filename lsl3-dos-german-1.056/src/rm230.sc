;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use FileSelector)
(use DCIcon)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm230 0
)

(local
	seenMsg
	beenWarned
	[string 200]
)

(procedure (PrintMD v l c)
	(Print
		@string
		#at
		-1
		10
		#title
		{the Doorman says}
		#mode
		1
		#icon
		v
		l
		c
	)
	(= string 0)
)

(instance rm230 of Rm
	(properties
		picture 230
		east 240
		south 220
	)

	(method (init)
		(if (and (InRoom 4) (gEgo has: 2) (== 21 ((Inv at: 2) view:))) ; Ginsu_Knife, Ginsu_Knife
			(Load rsVIEW 231)
			(Load rsVIEW 21)
		)
		(super init:)
		(self setScript: RoomScript)
		(atpSign init:)
		(gAddToPics add: atpSign doit:)
		(aDoor init:)
		(if gEgoIsPatti
			(aSign init:)
			(aDoorman init:)
			(Load rsSOUND 11)
			(if (gEgo has: 6) ; A_Twenty_Dollar_Bill
				(Load rsVIEW 25)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(cond
			((== gPrevRoomNum 220)
				(gEgo loop: 3)
				(switch (Random 1 3)
					(1
						(gEgo posn: 52 188)
					)
					(2
						(gEgo posn: 135 188)
					)
					(3
						(gEgo posn: 212 188)
					)
				)
			)
			((== gPrevRoomNum 240)
				(gEgo posn: 317 135 loop: 1)
			)
			((== gPrevRoomNum 235)
				(gEgo posn: 100 128 loop: 0)
			)
			((== gPrevRoomNum 330)
				(= gEgoState 0)
				(HandsOff)
				(aDoorman posn: 149 53 setCycle: Walk)
				(gEgo ignoreActors: illegalBits: 0 posn: 179 48 loop: 2)
				(aDoor setCel: 255)
				(DoormanScript changeState: 23)
			)
			(else
				(gEgo posn: 212 188)
			)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 235)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'pull,pull,break,get,get,break/blade')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(gEgoIsPatti
						(Print 230 0) ; "The tough tropical island grass slices your hands to ribbons, but refuses to budge."
					)
					((not (InRoom 4))
						(AlreadyTook) ; "You already took it."
					)
					((not (& (gEgo onControl:) $0010))
						(NotClose) ; "You're not close enough."
					)
					(else
						(Print 230 0) ; "The tough tropical island grass slices your hands to ribbons, but refuses to budge."
					)
				)
			)
			((Said 'cut,cut/blade>')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(gEgoIsPatti
						(Print 230 0) ; "The tough tropical island grass slices your hands to ribbons, but refuses to budge."
					)
					((not (InRoom 4))
						(AlreadyTook) ; "You already took it."
					)
					((not (& (gEgo onControl:) $0010))
						(NotClose) ; "You're not close enough."
					)
					((not (gEgo has: 2)) ; Ginsu_Knife
						(event claimed: 1)
						(Print 230 1) ; "The tough tropical island grass slices your hands to ribbons, but refuses to budge. If only you had some way to cut it."
					)
					((!= ((Inv at: 2) view:) 21) ; Ginsu_Knife
						(Print 230 2) ; "Good idea! You try and try to cut the grass with your dull knife, but it is just not sharp enough!"
					)
					(else
						(self changeState: 1)
					)
				)
				(event claimed: 1)
			)
			((Said 'use/ginsu>')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (gEgo has: 2)) ; Ginsu_Knife
						(DontHave) ; "You don't have it."
					)
					((not (InRoom 4))
						(AlreadyTook) ; "You already took it."
					)
					((not (& (gEgo onControl:) $0010))
						(NotClose) ; "You're not close enough."
					)
					((not (Said '//blade<cut,cut'))
						(Print 230 3) ; "How would you use the knife?"
					)
					((!= ((Inv at: 2) view:) 21) ; Ginsu_Knife
						(Print 230 2) ; "Good idea! You try and try to cut the grass with your dull knife, but it is just not sharp enough!"
					)
					(else
						(self changeState: 1)
					)
				)
				(event claimed: 1)
			)
			((Said 'look,look>')
				(cond
					((Said '/door,awning,club')
						(Print 230 4 #mode 1) ; "Chip 'N' Dale's Nontoonyt's finest Adult Entertainment"
						(if (not gEgoIsPatti)
							(Print 230 5) ; "CLOSED"
						else
							(Print 230 6 #mode 1) ; "OPEN Admission: $25.00"
						)
					)
					((Said '/boulder,cliff')
						(Print 230 7) ; "There appears to be an opening in the side of the concrete gigantic rock just outside the door to the nightclub."
					)
					((and (InRoom 4) (Said '/blade'))
						(Print 230 8) ; "Long, slender and beautiful, the island's indigenous grass was once worn by the natives as ritual costumes."
						(Print 230 9 #at -1 144) ; "(Now they mostly just order from L. L. Bean!)"
					)
					((Said '/flower')
						(Print 230 10) ; "These flowers are attractive, but nothing out of the ordinary for a beautiful, tropical island like Nontoonyt."
					)
					((Said '/palm')
						(Print 230 11) ; "Trees are everywhere."
						(Print 230 12 #at -1 144) ; "(This is also a dog's paradise!)"
					)
					((Said '[/area]')
						(if (gCast contains: aDoorman)
							(Print 230 13) ; ""Chip 'N' Dale's" is open at last! A familiar face waits near the door."
						else
							(Print 230 14) ; "You are just outside Nontoonyt's famous striptease joint, "Chip 'N' Dale's." A large cliff mostly prevents your passage to the west. In the center of this area is a large clump of island grass."
							(Print 230 15) ; "There is a sign on the door."
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo setMotion: MoveTo 201 123 self)
			)
			(2
				(gEgo
					view: 231
					setLoop: (if (gEgo loop:) 1 else 0)
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: (+ (gEgo loop:) 2) setCycle: Fwd)
				(= cycles 20)
			)
			(4
				(Print 230 16 #at -1 10 #icon 21 0 0) ; "Your razor sharp ginsu knife slices through the blades of grass like a hot samurai's sword through a tub of cheap margarine."
				(= cycles 20)
			)
			(5
				(gEgo get: 4 setLoop: (+ (gEgo loop:) 2) setCycle: End) ; Native_Grass
				(= cycles 10)
			)
			(6
				(NormalEgo (- (gEgo loop:) 4))
				(gGame changeScore: 20)
				(Print 230 17 #at -1 10) ; "Congratulations. You are the proud new owner of some long blades of grass."
			)
		)
	)
)

(instance aDoor of Prop
	(properties
		y 50
		x 179
		view 230
	)

	(method (init)
		(= view (LangSwitch 230 921))
		(super init:)
		(self setPri: 1 stopUpd:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look,look/door')
			(if gEgoIsPatti
				(Print 230 18) ; "Say! It looks like this place is finally open!"
			else
				(Print 230 19) ; "Perhaps it will be open later!"
			)
		)
	)
)

(instance aSign of Prop
	(properties
		x 179
		view 230
		loop 1
		cycleSpeed 3
	)

	(method (init)
		(= view (LangSwitch 230 921))
		(super init:)
		(self setPri: 5 setCycle: Fwd)
	)
)

(instance atpSign of PV
	(properties
		x 179
		view 230
		loop 2
		priority 4
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 230 921))
		(super init:)
	)
)

(instance aDoorman of Act
	(properties
		y 53
		x 179
		view 422
		loop 2
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setScript: DoormanScript setPri: 1 stopUpd:)
	)
)

(instance DoormanScript of Script
	(properties)

	(method (handleEvent event &tmp theObj)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'give/job<blow,blow')
					(Said 'give/blow,blow<job')
					(Said 'give/head')
					(Said 'yes')
					(Said 'give/head<job')
					(Said
						'eat,eat,blow,blow,eat,eat/man,bouncer,bouncer,bouncer,bouncer,guard,guard,ball,coconut,ball'
					)
				)
				(cond
					((not (& (gEgo onControl:) $0020))
						(NotClose) ; "You're not close enough."
					)
					((TestFlag 36)
						(Print 230 20) ; "You really don't want to go back in there."
					)
					((not beenWarned)
						(= beenWarned 1)
						(Print 230 21) ; "Are you sure you want to do that?"
					)
					((< gFilthLevel 3)
						(Print 230 22) ; "Sorry, but you're too young and inexperienced to do that."
						(Print 230 23 #at -1 144) ; "(Or, at least your current "Filth Level" is!)"
					)
					(else
						(self changeState: 11)
					)
				)
			)
			(
				(or
					(Said 'board/club,area,backstage')
					(Said 'ask/dale,chip,show,show')
					(Said 'look/show,show')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0020))
						(Print 230 24) ; "He'll never hear you from here."
					)
					(else
						(Printf 230 25) ; ""Hello, sir" you say to the maitre d'. "Could you give me some information about the show inside?"%"
						(Format @string 230 26) ; "The doorman responds, "Tonight's show is offered at the special low rate of only $25.00. Of course, with tax, that'll come to $43.00 exactly."%"
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said
						'bracelet,give,show,show/pass/man,bouncer,bouncer,bouncer,bouncer,guard,guard'
					)
					(Said
						'bracelet,give,show,show/man,bouncer,bouncer,bouncer,bouncer,guard,guard/pass'
					)
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0020))
						(Print 230 27) ; "He'll never see it from here."
					)
					(else
						(Print 230 28) ; "How about if I show you my pass from the showroom."
						(Format @string 230 29) ; ""No way; this place costs money!"%"
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said
						'bracelet,give,show,show/buck,500,bill/man,bouncer,bouncer,bouncer,bouncer,guard,guard'
					)
					(Said
						'buy,order,bribe,bribe/man,bouncer,bouncer,bouncer,bouncer,guard,guard'
					)
					(Said
						'bracelet,give,show,show/man,bouncer,bouncer,bouncer,bouncer,guard,guard/buck,500,bill'
					)
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((TestFlag 36)
						(Print 230 20) ; "You really don't want to go back in there."
					)
					((not (gEgo has: 6)) ; A_Twenty_Dollar_Bill
						(Print 230 30) ; "You're broke."
					)
					((not (& (gEgo onControl:) $0020))
						(Print 230 27) ; "He'll never see it from here."
					)
					(else
						(self changeState: 3)
					)
				)
			)
			((Said 'talk,talk/man,bouncer,bouncer,bouncer,bouncer,guard,guard')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0020))
						(Print 230 31) ; "No one is near you."
					)
					((TestFlag 36)
						(Print 230 32) ; "Just couldn't get enough of Dale your first time, eh?"
					)
					(else
						(Print 230 33) ; "Hello, sir" you say to the doorman. "Could you give me some information about the show inside?"
						(Format @string 230 34) ; "The maitre 'd responds, "Tonight's show is offered at the special low rate of only $25.00. Of course, with tax, that'll come to $42.95 exactly."%"
						(self changeState: 1)
					)
				)
			)
			((Said 'look,look/man,bouncer,bouncer,bouncer,bouncer,guard,guard')
				(Print 230 35) ; "The maitre d' looks like he would be the life of the party..."
				(Print 230 36 #at -1 144) ; "(...if the party was an undertakers' convention!)"
			)
			((Said 'give>')
				(= theObj (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((not (& (gEgo onControl:) $0020))
						(NotClose) ; "You're not close enough."
					)
					((Said '[/!*]')
						(Print 230 37) ; "What did you want to give him?"
					)
					((not theObj)
						(Print 230 38) ; "It's not yours to give."
					)
					((not (theObj ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					((== theObj (gInventory at: 12)) ; Penthouse_Key
						(Print 230 39) ; "Want to go to my place later?"
						(Format @string 230 40) ; ""Do I look like a fool? You can't make me leave my post that easily."%"
						(self changeState: 1)
					)
					(
						(or
							(== theObj (gInventory at: 14)) ; Panties
							(== theObj (gInventory at: 15)) ; Pantyhose
							(== theObj (gInventory at: 16)) ; Bra
							(== theObj (gInventory at: 17)) ; Dress
						)
						(Format @string 230 41) ; ""Do I look like that kind of man? Pay your way in, just like everyone else!"%"
						(self changeState: 1)
					)
					((== theObj (gInventory at: 18)) ; Magic_Marker
						(Print 230 42) ; "Wow! I don't want that!!"
					)
					((not (== theObj (gInventory at: 6))) ; A_Twenty_Dollar_Bill
						(Print 230 43) ; "The maitre d' replies, "And just exactly what am I supposed to do with that?""
					)
					(else
						(self changeState: 3)
					)
				)
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState &tmp theLine)
		(ShowState self newState 2 2)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(aDoorman setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(aDoorman setCel: 0 stopUpd:)
				(if (not string)
					(Format @string 230 44) ; ""Yes? May I help you madam?"%"
				)
				(PrintMD 422 3 0)
				(HandsOn)
			)
			(3
				(HandsOff)
				(gGame changeScore: 43)
				(Print 230 45 #icon 25 0 0) ; "Here's all the money I have in the world," you say to the doorman, "Boy, what luck! I just happen to have $43.00 in tips!"
				(= gDollars 0)
				(PutInRoom 6)
				(aDoorman setLoop: 2 setCycle: Fwd)
				(= cycles 0)
				(= seconds 3)
			)
			(4
				(aDoorman setCel: 0 stopUpd:)
				(Format @string 230 46) ; ""Why, thank you very much, ma'am. I know you'll enjoy the show!"%"
				(PrintMD 422 3 1)
				(= seconds 2)
			)
			(5
				(User canControl: 1)
				(aDoorman
					illegalBits: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 149 53 self
				)
				(aDoor setCycle: End)
			)
			(6
				(HandsOff)
				(aDoorman setLoop: 2 setCel: 0)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 179 57 self
				)
			)
			(7
				(gEgo setMotion: MoveTo 179 48 self setPri: 0)
				(if (TestFlag 65)
					(Print 230 47) ; "The doorman mumbles something as you enter the club. You, of course, respond, "Come again?""
				)
			)
			(8
				(aDoor setCycle: Beg self)
			)
			(9
				(gSoundFX number: 11 loop: 1 play:)
				(= cycles 5)
			)
			(10
				(gCurRoom newRoom: 330)
			)
			(11
				(HandsOff)
				(Print 230 48) ; "You know, I'm a little short of cash right now," you say to the doorman, "But I do have an idea! Step over behind that rock over there and I'll explain it to you!"
				(aDoorman setLoop: 2 setCel: 0)
				(= cycles 0)
				(= seconds 3)
			)
			(12
				(Format @string 230 49) ; ""Huh?"%"
				(PrintMD 422 3 1)
				(= seconds 3)
			)
			(13
				(Format @string 230 50) ; ""OH!"%"
				(PrintMD 422 3 6)
				(= seconds 3)
			)
			(14
				(User canControl: 1)
				(aDoorman
					illegalBits: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 144 53 self
				)
			)
			(15
				(HandsOff)
				(aDoorman setLoop: 2 setCel: 0 stopUpd:)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 144 57 self
				)
			)
			(16
				(gEgo
					setLoop: 3
					setCel: 0
					setPri:
					setMotion: MoveTo 144 77 self
				)
			)
			(17
				(= seconds 3)
			)
			(18
				(BJicon view: 422 loop: 3)
				(Print
					230
					51
					#at
					-1
					10
					#title
					{the Doorman says}
					#mode
					1
					#icon
					BJicon
				)
				(= seconds 3)
			)
			(19
				(gEgo setMotion: MoveTo 144 57 self)
			)
			(20
				(Print 230 52) ; ""What did you think of that?" you ask him."
				(= seconds 3)
			)
			(21
				(Format @string 230 53) ; ""Walk this way!"%"
				(PrintMD 422 3 9)
				(aDoorman
					setLoop: -1
					setCel: -1
					setCycle: Walk
					setMotion: MoveTo 179 53 self
				)
			)
			(22
				(SetFlag 65)
				(Print 230 54) ; "You think, "If I walked like that...""
				(gEgo setLoop: -1 setCel: -1 setPri: -1 setCycle: Walk)
				(= cycles 12)
				(= state 4)
			)
			(23
				(gEgo setMotion: MoveTo 186 60 self)
			)
			(24
				(aDoor setCycle: Beg self)
			)
			(25
				(gSoundFX number: 11 loop: 1 play:)
				(aDoor stopUpd:)
				(aDoorman setMotion: MoveTo 179 53 self)
			)
			(26
				(aDoorman loop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(27
				(aDoorman setCel: 0 stopUpd:)
				(NormalEgo)
				(Print 230 55) ; "What a show, eh, honey?" slurps the maitre d'. "And how about that Dale?"
			)
		)
	)
)

(instance BJicon of DCIcon
	(properties)

	(method (init)
		(super init:)
		(if cycler
			(cycler dispose:)
		)
		((= cycler (End new:)) init: self)
	)
)

