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
	local4
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
			(gAddToPics add: aView1 doit:)
			(gEgo observeControl: 16384)
		else
			(gAddToPics add: aView2 doit:)
		)
		(gAddToPics add: aView3 aView4 aView5 aView6 aView7 doit:)
		(if (and garageClosed (gEgo has: 3) ((gInventory at: 7) ownedBy: gCurRoomNum)) ; Cruise_Ticket, Passport
			(= trashHere 1)
			(gAddToPics add: aView8 aView9 doit:)
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
						(Print 23 2 #at -1 130) ; "(At least, now that she's not in them!)"
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
		(if (Said 'women/eat')
			(if (not gDebugging)
				(event claimed: 0)
				(return)
			)
			(switch
				(= local4
					(Print ; "You don't like LA? (Press ESC to stay here)"
						23
						10
						#mode
						1
						#title
						{Cheater!}
						#icon
						836
						0
						1
						#button
						{Ship}
						1
						#button
						{Resort}
						2
						#button
						{Airport}
						3
						#button
						{Airplane}
						4
						#button
						{Island}
						5
					)
				)
				(1
					(gEgo get: 5 6 7 8 9 10) ; Swimsuit
					(Animate (gCast elements:) 0)
					(^= gDebugging $0001)
					(gCurRoom newRoom: 31)
				)
				(2
					(gEgo get: 6 7 10 15) ; Wad_O__Dough
					(Animate (gCast elements:) 0)
					(^= gDebugging $0001)
					(gCurRoom newRoom: 42)
				)
				(3
					(gEgo get: 6 7 20 19 17) ; Wad_O__Dough
					(= gCurrentEgoView 149)
					(Animate (gCast elements:) 0)
					(^= gDebugging $0001)
					(gCurRoom newRoom: 50)
				)
				(4
					(gEgo get: 6 7 17 19 26 21 23 24 25) ; Wad_O__Dough
					(Animate (gCast elements:) 0)
					(^= gDebugging $0001)
					(gCurRoom newRoom: 58)
				)
				(5
					(gEgo get: 19 17 21 27) ; Matches
					(Animate (gCast elements:) 0)
					(^= gDebugging $0001)
					(gCurRoom newRoom: 70)
				)
			)
		)
		(if (Said '/balcony')
			(Print 23 11) ; "What is this -- "Romeo and Juliet?!""
		)
		(if (Said 'board,open,(board<in)/building')
			(Print 23 12) ; "You'd better not. She said she wanted you out of here!"
		)
		(if
			(Said
				'get/(barstool<duty),cosmo,barrel,barrel,mower,rack,barstool,buffet'
			)
			(Print 23 13) ; "That will not help you."
		)
		(if (Said 'break/cup')
			(Print 23 14) ; "Larry!"
			(Print 23 15 #at -1 130) ; "(Really!)"
		)
		(if (Said 'close,open,close,unbolt,bolt/door')
			(Print 23 16) ; "There is no need to fool around with Eve's garage door."
		)
		(if (Said '/flower')
			(Print 23 17) ; "They smell lovely, but reveal nothing."
		)
		(if (Said 'look,(look<in),(look<through),open>')
			(if (and trashHere (Said '/barrel,barrel,(barrel<barrel)'))
				(Print 23 18) ; "They are open."
			)
			(if (Said '/cup')
				(Print 23 19) ; "Eve keeps her windows locked."
			)
			(if (Said '/door<garage')
				(Print 23 20) ; "The garage door is locked."
			)
			(if (Said '/door')
				(Print 23 21) ; "There are no doors here except the garage door."
			)
		)
		(if (Said 'explore,look>')
			(if (Said '/pole,sign')
				(Print 23 22) ; "Eve lives at the corner of Ascot Place and Ball Road."
			)
			(if (Said '/(barstool<duty),mower,rack,barstool,buffet')
				(Print 23 23) ; "You see nothing that will help you."
			)
			(if (Said '/carpet,carpet')
				(Print 23 24) ; "Part of the lawn looks freshly mowed!"
			)
			(if (Said '/art')
				(Print 23 25) ; "You love auto parts calendars."
			)
			(if (Said '[/airport,carpet,building,garage]')
				(cond
					((& (gEgo onControl:) $0008)
						(Print 23 26) ; "You search carefully, but find nothing in this part of the garage."
					)
					((not (& (gEgo onControl:) $0002))
						(Print 23 27) ; "You were so sure this would be the location of your future, happy life with Eve. But, some things are not to be."
					)
					(((gInventory at: 1) ownedBy: gCurRoomNum) ; Dollar_Bill
						(Print 23 28) ; "Hey! What's this? Eve left a dollar bill stuffed in this old pair of pants!"
					)
					(else
						(Print 23 29) ; "You carefully search the garage and find nothing but junk, which is of no use to you."
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
					(Print 23 30) ; "You now smell like a combination of cheap department store credit card bills and road kill!"
				)
				(else
					(AlreadyTook) ; "You already took it."
				)
			)
		)
	)
)

(instance aView1 of PV
	(properties
		y 135
		x 93
		view 253
		cel 1
		priority 9
	)
)

(instance aView2 of PV
	(properties
		y 130
		x 95
		view 253
		priority 1
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 139
		x 136
		view 253
		cel 2
		priority 9
		signal 16384
	)
)

(instance aView4 of PV
	(properties
		y 138
		x 49
		view 253
		cel 2
		priority 9
	)
)

(instance aView5 of PV
	(properties
		y 143
		x 35
		view 253
		cel 2
		priority 9
	)
)

(instance aView6 of PV
	(properties
		y 110
		x 149
		view 253
		cel 3
		priority 13
	)
)

(instance aView7 of PV
	(properties
		y 135
		x 15
		view 253
		cel 1
		priority 1
	)
)

(instance aView8 of PV
	(properties
		y 167
		x 101
		view 253
		loop 1
		priority 12
	)
)

(instance aView9 of PV
	(properties
		y 167
		x 122
		view 253
		loop 1
		cel 1
		priority 12
	)
)

