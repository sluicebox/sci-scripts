;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm23 0
)

(local
	work
	askedAlready
	trashHere
	garageClosed
)

(instance rm23 of Rm
	(properties
		picture 23
		horizon 107
		north 19
		east 24
	)

	(method (init)
		(Load rsVIEW 253)
		(if (== gPrevRoomNum 99)
			(self style: 7)
		)
		(super init:)
		(if (not ((gInventory at: 1) ownedBy: gCurRoomNum)) ; Dollar_Bill
			(= garageClosed 1)
			((View new:)
				view: 253
				loop: 0
				cel: 1
				posn: 93 135
				setPri: 9
				addToPic:
			)
			(gEgo observeControl: 16384)
		else
			((View new:)
				view: 253
				loop: 0
				cel: 0
				posn: 95 130
				setPri: 1
				ignoreActors:
				addToPic:
			)
		)
		((View new:)
			view: 253
			loop: 0
			cel: 2
			posn: 136 139
			setPri: 9
			ignoreActors:
			addToPic:
		)
		((View new:) view: 253 loop: 0 cel: 2 posn: 49 138 setPri: 9 addToPic:)
		((View new:) view: 253 loop: 0 cel: 2 posn: 35 143 setPri: 9 addToPic:)
		((View new:)
			view: 253
			loop: 0
			cel: 3
			posn: 149 110
			setPri: 13
			addToPic:
		)
		((View new:) view: 253 loop: 0 cel: 1 posn: 15 135 setPri: 1 addToPic:)
		(if (and garageClosed (gEgo has: 3) ((gInventory at: 7) ownedBy: gCurRoomNum)) ; Cruise_Ticket, Passport
			(= trashHere 1)
			((View new:)
				view: 253
				loop: 1
				cel: 0
				posn: 101 167
				setPri: 12
				addToPic:
			)
			((View new:)
				view: 253
				loop: 1
				cel: 1
				posn: 122 167
				setPri: 12
				brRight: 128
				addToPic:
			)
		)
		(cond
			((== gPrevRoomNum 19)
				(gEgo posn: 299 110)
			)
			((!= gPrevRoomNum 24)
				(TheMenuBar draw:)
				(SL enable:)
				(gEgo loop: 1 posn: 135 151)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm23Script) ; rm200
	)
)

(instance rm23Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (or (& (gEgo onControl:) $0002) (& (gEgo onControl:) $0008))
			(gEgo setPri: 2)
		else
			(gEgo setPri: -1)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said '(look<in),explore/bra,bra')
			(cond
				((not ((gInventory at: 1) ownedBy: gCurRoomNum)) ; Dollar_Bill
					(AlreadyTook) ; "You already took it."
				)
				((& (gEgo onControl:) $0002)
					(Ok) ; "Ok."
					(Print 23 0) ; "You carefully go through Eve's pants and find nothing but a crumpled-up dollar bill."
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(if (Said 'look/bra')
			(cond
				((not ((gInventory at: 1) ownedBy: gCurRoomNum)) ; Dollar_Bill
					(Print 23 1) ; "Except for that dollar bill, her pants contain nothing to hold your interest."
					(if (> gFilthLevel 4)
						(Print 23 2 #at -1 152) ; "(At least, now that she's not in them!)"
					)
				)
				((not (& (gEgo onControl:) $0002))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(Print 23 0) ; "You carefully go through Eve's pants and find nothing but a crumpled-up dollar bill."
				)
			)
		)
		(if (Said 'get/buck,bill,(bill<buck)')
			(cond
				((not ((gInventory at: 1) ownedBy: gCurRoomNum)) ; Dollar_Bill
					(AlreadyTook) ; "You already took it."
				)
				((not (& (gEgo onControl:) $0002))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(Print 23 3) ; "You briefly consider the morality of this move, but after all she hasn't done for you, you decide it's probably the least she can do!"
					(gEgo get: 1) ; Dollar_Bill
					(gGame changeScore: 3)
				)
			)
		)
		(if (Said 'get/bra')
			(Print 23 4) ; "It's not her pants that you want!"
		)
		(if
			(or
				(Said 'explore,look,board/barrel,barrel,(barrel<barrel)')
				(and askedAlready (Said 'yes,me'))
			)
			(cond
				((not trashHere)
					(Print 23 5) ; "Where?!"
				)
				((not (gEgo inRect: 81 148 144 172))
					(NotClose) ; "You're not close enough."
				)
				(((gInventory at: 7) ownedBy: gCurRoomNum) ; Passport
					(if (not askedAlready)
						(= askedAlready 1)
						(Print 23 6) ; "Who'd want to search through Eve's can?"
					else
						(Print 23 7) ; "Ok, ok!"
						(Print 23 8) ; "Searching through the trash until your suit turns off-white, you discover your passport stuffed between the pages of an old "Cosmo.""
					)
				)
				(else
					(Print 23 9) ; "You find nothing else of interest."
				)
			)
		)
		(if (Said '/balcony')
			(Print 23 10) ; "What is this -- "Romeo and Juliet?!""
		)
		(if (Said 'board,open,(board<in)/building')
			(Print 23 11) ; "You'd better not. She said she wanted you out of here!"
		)
		(if
			(Said
				'get/(barstool<duty),cosmo,barrel,barrel,mower,rack,barstool,buffet'
			)
			(Print 23 12) ; "That will not help you."
		)
		(if (Said 'break/cup')
			(Print 23 13) ; "Larry!"
			(Print 23 14 #at -1 152) ; "(Really!)"
		)
		(if (Said 'close,open,close,unbolt,bolt/door')
			(Print 23 15) ; "There is no need to fool around with Eve's garage door."
		)
		(if (Said '/flower')
			(Print 23 16) ; "They smell lovely, but reveal nothing."
		)
		(if (Said 'look,(look<in),(look<through),open>')
			(if (and trashHere (Said '/barrel,barrel,(barrel<barrel)'))
				(Print 23 17) ; "They are open."
			)
			(if (Said '/cup')
				(Print 23 18) ; "Eve keeps her windows locked."
			)
			(if (Said '/door<garage')
				(Print 23 19) ; "The garage door is locked."
			)
			(if (Said '/door')
				(Print 23 20) ; "There are no doors here except the garage door."
			)
		)
		(if (Said 'explore,look>')
			(if (Said '/pole,sign')
				(Print 23 21) ; "Eve lives at the corner of Ascot Place and Ball Road."
			)
			(if (Said '/(barstool<duty),mower,rack,barstool,buffet')
				(Print 23 22) ; "You see nothing that will help you."
			)
			(if (Said '/carpet,carpet')
				(Print 23 23) ; "Part of the lawn looks freshly mowed!"
			)
			(if (Said '/art')
				(Print 23 24) ; "You love auto parts calendars."
			)
			(if (Said '[/airport,carpet,building,garage]')
				(cond
					((& (gEgo onControl:) $0008)
						(Print 23 25) ; "You search carefully, but find nothing in this part of the garage."
					)
					((not (& (gEgo onControl:) $0002))
						(Print 23 26) ; "You were so sure this would be the location of your future, happy life with Eve. But, some things are not to be."
					)
					(((gInventory at: 1) ownedBy: gCurRoomNum) ; Dollar_Bill
						(Print 23 27) ; "Hey! What's this? Eve left a dollar bill stuffed in this old pair of pants!"
					)
					(else
						(Print 23 28) ; "You carefully search the garage and find nothing but junk, which is of no use to you."
					)
				)
			)
		)
		(if (Said 'get/passport')
			(cond
				((not trashHere)
					(Print 23 5) ; "Where?!"
				)
				((not (gEgo inRect: 81 148 144 172))
					(NotClose) ; "You're not close enough."
				)
				(((gInventory at: 7) ownedBy: gCurRoomNum) ; Passport
					(Ok) ; "Ok."
					(gEgo get: 7) ; Passport
					(gGame changeScore: 5)
					(Print 23 29) ; "You now smell like a combination of cheap department store credit card bills and road kill!"
				)
				(else
					(AlreadyTook) ; "You already took it."
				)
			)
		)
	)
)

