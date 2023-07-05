;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm370 0
)

(local
	hisCombination1
	hisCombination2
	hisCombination3
	seenMsg
	howFar
	[string 200]
)

(instance rm370 of Rm
	(properties
		picture 370
		horizon 54
	)

	(method (init)
		(Load rsVIEW (+ 706 gEgoIsHunk))
		(Load rsVIEW (+ 702 gEgoIsHunk))
		(Load rsVIEW (+ 704 gEgoIsHunk))
		(Load rsVIEW (+ 700 gEgoIsHunk))
		(if (gEgo has: 8) ; Beach_Towel
			(Load rsVIEW (+ 703 gEgoIsHunk))
			(Load rsVIEW 8)
		)
		(super init:)
		(if (> gMachineSpeed 16)
			(aMan1 init:)
			(aMan2 init:)
			(aMan3 init:)
		)
		(aLocker init:)
		(self setScript: RoomScript)
		(NormalEgo)
		(cond
			((== gPrevRoomNum 375)
				(gEgo loop: 2 posn: 221 58)
			)
			((== gPrevRoomNum 380)
				(gEgo loop: 2 posn: 313 62)
			)
			(else
				(= gEgoState 7)
				(gEgo posn: 307 179)
			)
		)
		(gEgo
			view:
				(switch gEgoState
					(6
						(+ 706 gEgoIsHunk)
					)
					(5
						(+ 702 gEgoIsHunk)
					)
					(8
						(+ 703 gEgoIsHunk)
					)
					(9
						(+ 704 gEgoIsHunk)
					)
					(else
						(+ 700 gEgoIsHunk)
					)
				)
			init:
		)
	)

	(method (newRoom newRoomNumber)
		(if (< (aLocker y:) 999)
			(SetFlag 51)
		)
		(if (and (== newRoomNumber 375) (gEgo has: 8)) ; Beach_Towel
			(Print 370 0 #at 10 -1 #width 290) ; "You hang your towel just outside the shower room where you'll be able to reach it easily upon exit."
			(PutInRoom 8 375)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(switch gEgoState
			(5
				(gEgo observeControl: 4096 8192 ignoreControl: 16384)
			)
			(6
				(gEgo observeControl: 4096 8192 ignoreControl: 16384)
			)
			(9
				(gEgo observeControl: 16384 4096 ignoreControl: 8192)
			)
			(8
				(gEgo observeControl: 8192 4096 ignoreControl: 16384)
			)
			(else
				(gEgo observeControl: 8192 16384 ignoreControl: 4096)
			)
		)
		(if (& (gEgo onControl:) $0800)
			(gEgo setPri: 3)
		)
		(if (& (gEgo onControl:) $0400)
			(gEgo setPri: -1)
		)
		(cond
			((& (gEgo onControl:) $0004)
				(gCurRoom newRoom: 375)
			)
			((& (gEgo onControl:) $0002)
				(if (not seenMsg)
					(cond
						((== gEgoState 7)
							(= seenMsg 1)
							(Print 370 1) ; "You can't walk into a shower wearing your leisure suit!"
						)
						((== gEgoState 9)
							(= seenMsg 1)
							(Print 370 2) ; "The sweatsuit would weigh a ton if you wore it into the shower!"
						)
					)
				)
			)
			((& (gEgo onControl:) $0010)
				(gCurRoom newRoom: 380)
			)
			((& (gEgo onControl:) $0008)
				(if (not seenMsg)
					(cond
						((or (== gEgoState 5) (== gEgoState 6))
							(= seenMsg 1)
							(Print 370 3) ; "You're far too modest to work out on those weight machines in the nude. In fact, you can hear women snickering because you're standing here in front of the open doorway!"
						)
						((== gEgoState 7)
							(= seenMsg 1)
							(Print 370 4) ; "In order to work out on the weight machines, you must change into a sweatsuit!"
							(if (not gEgoIsHunk)
								(Print 370 5 #at -1 144) ; "(And from the looks of that stomach you could certainly stand to spend a few hours in there!)"
							)
						)
						((== gEgoState 8)
							(= seenMsg 1)
							(Print 370 6) ; "That's a nice towel, but it's not suitable garb for a man using exercise machines!"
						)
					)
				)
			)
			((== 2 (gEgo edgeHit:))
				(= gEgoState 0)
				(= gNormalEgoView (+ 700 gEgoIsHunk))
				(gCurRoom newRoom: 360)
			)
			((& (gEgo onControl:) $0020)
				(if (not seenMsg)
					(cond
						((or (== gEgoState 5) (== gEgoState 6))
							(= seenMsg 1)
							(Print 370 7) ; "While it appears you enjoy gallivanting around in the nude here in the locker room, Fat City's strictly prohibits naked people in the lobby!"
						)
						((== gEgoState 9)
							(= seenMsg 1)
							(Print 370 8) ; "You can't go into the lobby wearing sweats!"
						)
						((== gEgoState 8)
							(= seenMsg 1)
							(Print 370 9) ; "Hey! Take off that towel, and put on your leisure suit if you want to visit the lobby!"
						)
					)
				)
			)
			(else
				(= seenMsg 0)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said '/combination')
					(Said 'yes')
					(Said 'unbolt,use,open/locker,door')
				)
				(if (< (aLocker y:) 999)
					(ItIs) ; "It is."
				else
					(Print 370 10) ; "You clear the mechanism by quickly spinning the lock several turns to the right. Which three numbers do you wish to try?"
					(while (<= hisCombination1 0)
						(= hisCombination1 (GetNumber {First number:}))
					)
					(while (<= hisCombination2 0)
						(= hisCombination2 (GetNumber {Second number:}))
					)
					(while (<= hisCombination3 0)
						(= hisCombination3 (GetNumber {Third number:}))
					)
					(Printf 370 11 hisCombination1 hisCombination1 hisCombination2 hisCombination3) ; "You carefully turn the dial to the right until you reach the number %d, then left all the way around past %d until you reach %d, then right again stopping on %d. You lift the handle of the locker."
					(cond
						((not (& (gEgo onControl:) $0040))
							(Print 370 12) ; "Darn. Nothing happens. This must not be the correct locker."
						)
						(
							(or
								(!= hisCombination1 gLockerCombination1)
								(!= hisCombination2 gLockerCombination2)
								(!= hisCombination3 gLockerCombination3)
							)
							(Print 370 13) ; "Here you are at locker #69 and you don't know the combination!"
						)
						(else
							(if (not (TestFlag 40))
								(SetFlag 40)
								(gGame changeScore: 100)
								(Print 370 14) ; "You did it!"
							else
								(Print 370 15) ; "The locker opens."
							)
							(aLocker posn: 88 65)
						)
					)
					(= hisCombination1 0)
					(= hisCombination2 0)
					(= hisCombination3 0)
				)
			)
			(
				(or
					(Said 'unknownnumber/')
					(Said '/unknownnumber')
					(Said '//unknownnumber')
				)
				(Print 370 16) ; "Do you want to dial the combination of a locker?"
			)
			((Said 'bolt,close/locker,door')
				(cond
					((not (< (aLocker y:) 999))
						(ItIs) ; "It is."
					)
					((not (& (gEgo onControl:) $0040))
						(NotClose) ; "You're not close enough."
					)
					(else
						(Ok) ; "O.K."
						(aLocker posn: 1111 1111)
					)
				)
			)
			((Said 'drain,get/art')
				(Print 370 17) ; "You don't need to take the photo."
			)
			(
				(or
					(Said 'naked')
					(Said 'wear/nothing')
					(Said 'get/naked')
					(Said 'naked')
					(Said
						'(alter<(out<of),from),(get<off),drain/cloth,towel,sweatpants,cloth'
					)
				)
				(cond
					((or (== gEgoState 5) (== gEgoState 6))
						(Print 370 18) ; "You're as naked as you're going to get!"
					)
					((not (& (gEgo onControl:) $0040))
						(Print 370 19) ; "You have no place to hang your clothes! Find your locker."
					)
					((not (< (aLocker y:) 999))
						(Print 370 20) ; "Your locker is still closed."
					)
					(else
						(Format @string 370 21) ; "You remove everything you are wearing and toss it in the locker. Congratulations! You're quickly turning this family-oriented entertainment software into an X-rated game! Next thing you know, you'll probably begin to enjoy walking around like this. THEN where will we be?!"
						(if (< gFilthLevel 3)
							(= gEgoState 6)
						else
							(= gEgoState 5)
						)
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said 'dress<get')
					(Said 'get/dress')
					(Said 'wear,get,(alter<in,to),(drop<on)/cloth[<leisure]')
				)
				(cond
					((== gEgoState 7)
						(Print 370 22) ; "You're already wearing your leisure suit."
					)
					((TestFlag 50)
						(Print 370 23) ; "You can't change into your leisure suit with water all over your body!"
					)
					((not (& (gEgo onControl:) $0040))
						(Print 370 24) ; "You can't reach your clothes from here!"
					)
					((not (< (aLocker y:) 999))
						(Print 370 20) ; "Your locker is still closed."
					)
					((TestFlag 51)
						(Print 370 25) ; "Your locker is empty! You didn't leave it open when you left before, did you?"
					)
					(else
						(Format @string 370 26) ; "You return to your leisure suit, once again ready to face the world of women."
						(= gEgoState 7)
						(self changeState: 1)
					)
				)
			)
			((Said 'wear,get,(alter<in),(drop<on)/towel')
				(cond
					((== gEgoState 8)
						(Print 370 27) ; "You're already wearing the towel."
					)
					((not (gEgo has: 8)) ; Beach_Towel
						(DontHave) ; "You don't have it."
					)
					((not (& (gEgo onControl:) $0040))
						(Print 370 28) ; "You would, but you really don't want to!"
					)
					((not (< (aLocker y:) 999))
						(Print 370 20) ; "Your locker is still closed."
					)
					((TestFlag 51)
						(Print 370 25) ; "Your locker is empty! You didn't leave it open when you left before, did you?"
					)
					(else
						(Format @string 370 29) ; "You carefully tie the beach towel around your waist, leaving your leisure suit in the locker with the sweatsuit."
						(= gEgoState 8)
						(self changeState: 1)
					)
				)
			)
			(
				(Said
					'wear,get,(alter<in),(drop<on)/sweatpants,(cloth<perspiration)'
				)
				(cond
					((== gEgoState 9)
						(Print 370 30) ; "You're already wearing the sweatsuit."
					)
					((TestFlag 50)
						(Print 370 31) ; "You can't change into the sweatsuit with water all over your body!"
					)
					((not (& (gEgo onControl:) $0040))
						(Print 370 24) ; "You can't reach your clothes from here!"
					)
					((not (< (aLocker y:) 999))
						(Print 370 20) ; "Your locker is still closed."
					)
					((TestFlag 51)
						(Print 370 25) ; "Your locker is empty! You didn't leave it open when you left before, did you?"
					)
					(else
						(Format @string 370 32) ; "Gosh! Don't you look sweet in a pair of (newly-larger) women's sweats!"
						(= gEgoState 9)
						(if (not (TestFlag 41))
							(SetFlag 41)
							(gGame changeScore: 4)
						)
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said '(look<for),find/locker,69')
					(Said '(look<for),find//locker,69')
				)
				(cond
					(
						(>
							(= howFar
								(GetDistance (gEgo x:) (gEgo y:) 88 65)
							)
							150
						)
						(Print 370 33) ; "You're freezing; not even close."
					)
					((> howFar 80)
						(Print 370 34) ; "You're cold."
					)
					((& (gEgo onControl:) $0200)
						(Print 370 35) ; "You're warm."
					)
					((& (gEgo onControl:) $0100)
						(Print 370 36) ; "You're getting warmer."
					)
					((& (gEgo onControl:) $0080)
						(Print 370 37) ; "You're hot; very hot! You're burning up!!"
					)
					((& (gEgo onControl:) $0040)
						(Print 370 38) ; "HEY! This is it! You've found good ol' number 69!"
					)
					(else
						(Print 370 39) ; "It must be in here somewhere."
					)
				)
			)
			((Said 'pick/bolt,locker,69')
				(Print 370 40) ; "You feel fortunate when you can successfully pick your nose!"
			)
			((Said 'caress/locker,top,bay')
				(Print 370 41) ; "It feels rusty."
			)
			((Said '(look<in),explore,(look<in)/locker,(door<locker)')
				(cond
					((not (& (gEgo onControl:) $0040))
						(Print 370 42) ; "It's difficult to see through those narrow slots."
					)
					((not (< (aLocker y:) 999))
						(Print 370 43) ; "It's difficult to see through the narrow slots of your closed locker door."
					)
					((TestFlag 51)
						(Print 370 44) ; "It's empty!"
						(Print 370 45) ; "Where's your stuff?"
						(Print 370 46) ; "You didn't leave the area without locking your locker, did you?"
					)
					((== gEgoState 7)
						(Print 370 47) ; "There's a photo of a scantily-clad Tom Selleck, some spray deodorant, and a set of woman's sweats."
					)
					((== gEgoState 8)
						(Print 370 48) ; "There's a photo of a scantily-clad Tom Selleck, some spray deodorant, your leisure suit, and a set of woman's sweats."
					)
					((== gEgoState 9)
						(Print 370 49) ; "There's a photo of a scantily-clad Tom Selleck, some spray deodorant, and your leisure suit."
					)
					((or (== gEgoState 5) (== gEgoState 6))
						(Print 370 48) ; "There's a photo of a scantily-clad Tom Selleck, some spray deodorant, your leisure suit, and a set of woman's sweats."
					)
				)
			)
			((Said 'get,spray,wear,use/can,spray,deodorant')
				(cond
					((not (& (gEgo onControl:) $0040))
						(Print 370 50) ; "You can't reach the deodorant from here."
					)
					((not (< (aLocker y:) 999))
						(Print 370 20) ; "Your locker is still closed."
					)
					((or (== gEgoState 5) (== gEgoState 6) (== gEgoState 8))
						(Print 370 51) ; "Pssssssst."
						(Print 370 51) ; "Pssssssst."
						(ClearFlag 62)
						(if (not (TestFlag 60))
							(SetFlag 60)
							(gGame changeScore: 27)
						)
						(Print 370 52) ; "You spray on some deodorant, then return the can to the locker."
					)
					(else
						(Print 370 53 #at -1 144) ; "(Does it really help to spray that stuff on your clothes?)"
						(gGame changeScore: -1)
					)
				)
			)
			(
				(or
					(Said 'dry,dry[/body,me]')
					(Said 'caress/self,me')
					(Said 'dry')
					(Said 'use,(dry<with),(dry<off)/towel')
				)
				(cond
					((not (gEgo has: 8)) ; Beach_Towel
						(Print 370 54) ; "You have no towel."
					)
					((and (!= gEgoState 8) (!= gEgoState 6) (!= gEgoState 5))
						(Print 370 55) ; "Now?"
					)
					((not (TestFlag 50))
						(Print 370 56) ; "You're not wet."
					)
					(else
						(ClearFlag 50)
						(if (not (TestFlag 39))
							(SetFlag 39)
							(gGame changeScore: 22)
						)
						(Print 370 57 #icon 8 0 0) ; "Good idea. You carefully dry every tiny pore to prevent chafing!"
					)
				)
			)
			((Said 'talk')
				(Print 370 58) ; "You are all alone in the locker room, but you can hear severe grunting coming from the weight room."
			)
			(
				(or
					(Said '/combination')
					(Said 'are<where,what/combination,locker')
				)
				(Print 370 59) ; "Yes. That's the puzzle, isn't it?!"
			)
			((Said 'look>')
				(cond
					((Said '/man')
						(Print 370 60) ; "Looking around, you see some naked men."
					)
					((Said '/door,door')
						(cond
							((& (gEgo onControl:) $0002)
								(Print 370 61) ; "You peer through the doorway and see lots of naked men!"
							)
							((& (gEgo onControl:) $0008)
								(Print 370 62) ; "You look through the doorway and see lots of men and women exercising on weight machines."
								(Print 370 63) ; "They are all wearing sweatsuits..."
								(Print 370 64) ; "...sweaty sweatsuits!"
							)
							(else
								(Print 370 65) ; "The left door on the far wall leads to the showers."
								(Print 370 66) ; "The right door leads to the weight room."
							)
						)
					)
					((and (< (aLocker y:) 999) (Said '/art'))
						(Print 370 67) ; "In your opinion, he looks a lot like you."
					)
					((Said '/number')
						(if
							(or
								(& (gEgo onControl:) $0040)
								(& (gEgo onControl:) $0080)
							)
							(Print 370 68) ; "Hey! There's locker #69 over there!!"
						else
							(Printf 370 69 (Random 1 999)) ; "The locker nearest you might be #%d."
							(Print 370 70 #at -1 144) ; "(Then again, it might not.)"
						)
					)
					((Said '/69,(locker<69)')
						(Print 370 71) ; "It's over there in that skinny little corner of the lockers. You can just walk to it from here."
					)
					((Said '/locker<my')
						(Print 370 59) ; "Yes. That's the puzzle, isn't it?!"
					)
					((Said '/locker,bay')
						(Print 370 72) ; "The lockers are made of steel, painted in a lovely cyan hue."
					)
					((Said '/sweatpants')
						(if (!= gEgoState 9)
							(DontHave) ; "You don't have it."
						else
							(Print 370 73) ; "These sweats are so bulky, you can't tell what shape your body's in!"
						)
					)
					((Said '/deodorant,can,spray')
						(Print 370 74) ; "Perhaps you should use it!"
					)
					((Said '[/area]')
						(Print 370 75) ; "You are in the "Fat City" spa's locker room. On the far wall are two doorways. There is another door that leads to the lobby. Identical lockers are everywhere. Which one should you use?"
					)
				)
			)
			((or (Said '/69') (Said '//69'))
				(Print 370 76) ; "There you go again!"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(gEgo
					illegalBits: 0
					setPri:
					setLoop: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20) self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 20)
					view:
						(switch gEgoState
							(6
								(+ 706 gEgoIsHunk)
							)
							(5
								(+ 702 gEgoIsHunk)
							)
							(8
								(+ 703 gEgoIsHunk)
							)
							(9
								(+ 704 gEgoIsHunk)
							)
							(else
								(+ 700 gEgoIsHunk)
							)
						)
				)
				(= cycles 22)
			)
			(4
				(Print @string)
				(NormalEgo 0 (gEgo view:))
			)
		)
	)
)

(instance aLocker of View
	(properties
		y 1111
		x 1111
		view 370
		loop 2
	)
)

(instance aMan1 of Act
	(properties
		view 370
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			posn: (Random 80 200) 14
			setStep: 1 1
			setCycle: Walk
			setScript: Man1Script
		)
	)
)

(instance Man1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(aMan1 setMotion: MoveTo (Random 81 200) 14 self)
			)
			(2
				(= seconds (Random 6 12))
			)
			(3
				(aMan1 setMotion: MoveTo (Random 80 100) 14 self)
				(= state -1)
			)
		)
	)
)

(instance aMan2 of Act
	(properties
		view 370
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			posn: (Random -60 1) 8
			setStep: 1 1
			setCycle: Walk
			setScript: Man2Script
		)
	)
)

(instance Man2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(aMan2 setMotion: MoveTo (Random 2 40) 8 self)
			)
			(2
				(= seconds (Random 6 12))
			)
			(3
				(aMan2 setMotion: MoveTo (Random -60 1) 8 self)
				(= state -1)
			)
		)
	)
)

(instance aMan3 of Act
	(properties
		view 370
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			posn: (Random -60 0) 20
			setStep: 1 1
			setCycle: Walk
			setScript: Man3Script
		)
	)
)

(instance Man3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(aMan3 setMotion: MoveTo (Random 2 22) 20 self)
			)
			(2
				(= seconds (Random 6 12))
			)
			(3
				(aMan3 setMotion: MoveTo (Random -60 1) 20 self)
				(= state -1)
			)
		)
	)
)

