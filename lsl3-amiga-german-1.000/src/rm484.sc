;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 484)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm484 0
)

(local
	seenMsg
)

(instance aWine of View
	(properties
		x 162
		y 115
		view 480
		loop 4
		cel 3
	)

	(method (init)
		(super init:)
		(self setPri: 10 setCel: 3 ignoreActors: stopUpd:)
	)
)

(instance aDoor of Prop
	(properties
		x 159
		y 65
		view 480
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 3 ignoreActors: stopUpd:)
	)
)

(instance aPanties of View
	(properties
		x 63
		y 131
		view 480
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aBra of View
	(properties
		x 63
		y 131
		view 480
		loop 1
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aPantyhose of View
	(properties
		x 63
		y 141
		view 480
		loop 1
		cel 2
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aDress of Prop
	(properties
		x 39
		y 107
		view 480
		loop 2
	)

	(method (init)
		(super init:)
		(self
			setPri: 11
			setCel: (if (InRoom 17 484) 0 else 255)
			ignoreActors:
			stopUpd:
		)
	)
)

(instance atpTelescope of PicView
	(properties
		x 160
		y 50
		view 480
		loop 3
		priority 1
		signal 16384
	)
)

(instance rm484 of Rm
	(properties
		picture 480
		south 470
	)

	(method (init)
		(super init:)
		(aWine init: setCel: (if (InRoom 13) 1 else 0))
		(aDoor init: setCel: 255 stopUpd:)
		(if (InRoom 14)
			(aPanties init:)
		)
		(if (InRoom 16)
			(aBra init:)
		)
		(if (InRoom 15)
			(aPantyhose init:)
		)
		(aDress init:)
		(gAddToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(NormalEgo)
		(= gEgoState 0)
		(if (== gPrevRoomNum 470)
			(gEgo posn: 159 188 loop: 3 init:)
		else
			(if (or (TestFlag 69) (== gPrevRoomNum 0))
				(ClearFlag 69) ; tookShortcut
				(gSystemWindow color: gTextColor back: gBackgroundColor)
				(gTheMenuBar draw: state: 1)
				(SL enable:)
				(ClearFlag 4) ; preventAutoSave
				(ClearFlag 5) ; noCursor
			)
			(= gNormalEgoView 800)
			(= gEgoIsPatti 1)
			(= gEgoName (Format @gEgoNameBuffer 484 0)) ; "Patti"
			(= gNewspaperState 4)
			(PutInRoom 6 450)
			((Inv at: 6) view: 25) ; A_Twenty_Dollar_Bill
			(Format ((Inv at: 6) name:) 484 1) ; "$43.00 in Tips", A_Twenty_Dollar_Bill
			(PutInRoom 18 450)
			(PutInRoom 2 -1)
			(PutInRoom 8 -1)
			(PutInRoom 9 -1)
			(gEgo get: 12) ; Penthouse_Key
			((Inv at: 12) view: 30) ; Penthouse_Key
			(Format ((Inv at: 12) name:) 484 2) ; "Your Key", Penthouse_Key
			(gGame setSpeed: gOldGameSpeed)
			(Load rsVIEW 800)
			(gEgo view: 482 posn: 160 59 loop: 2 baseSetter: SheetBase init:)
			(gMusic number: 492 loop: gBgMusicLoops play:)
		)
	)

	(method (newRoom newRoomNumber)
		(gMusic fade:)
		(super newRoom: newRoomNumber)
		(gMusic fade:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0040)
			(if (and (not seenMsg) (!= (gEgo view:) gNormalEgoView))
				(= seenMsg 1)
				(Print 484 3) ; "You can't leave dressed in nothing but that blue sheet!"
			)
		else
			(= seenMsg 0)
		)
		(if (!= (gEgo view:) 800)
			(gEgo observeControl: 8192)
		else
			(gEgo ignoreControl: 8192)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'drain,(get<off)/dress,dress')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (gEgo has: 17)) ; Dress
						(DontHave) ; "You don't have it."
					)
					((and (gEgo has: 16) (gEgo has: 14) (gEgo has: 15)) ; Bra, Panties, Pantyhose
						(Print 484 4) ; "Although you enjoy walking around your penthouse nude, you don't want to do it now."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 484 5) ; "Patti! There are people watching!! Move behind your dressing screen first."
					)
					(else
						(self changeState: 2)
					)
				)
			)
			((Said 'wear,drain,(on<drop),(alter,alter<in),(drop<on),get,get>')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((Said '/sheet')
						(if (== (gEgo view:) 482)
							(Print 484 6) ; "You're wearing it!"
						else
							(Print 484 7) ; "No, it's served you well; now just leave it there."
						)
					)
					((Said '/beer,bottle')
						(cond
							((not (InRoom 13))
								(AlreadyTook) ; "You already took it."
							)
							((not (gEgo inRect: 126 126 196 141))
								(NotClose) ; "You're not close enough."
							)
							(else
								(Ok) ; "O.K."
								(aWine setCel: 0 stopUpd:)
								(gGame changeScore: 25)
								(gEgo get: 13) ; Bottle_of_Wine
							)
						)
					)
					((Said '/panties')
						(cond
							((not (InRoom 14))
								(AlreadyTook) ; "You already took it."
							)
							((not (& (gEgo onControl:) $0010))
								(Print 484 5) ; "Patti! There are people watching!! Move behind your dressing screen first."
							)
							(else
								(Ok) ; "O.K."
								(gEgo get: 14) ; Panties
								(gGame changeScore: 20)
								(aPanties dispose:)
								(Print 484 8) ; "You've always enjoyed the feeling of black lace."
							)
						)
					)
					((Said '/bra')
						(cond
							((not (InRoom 16))
								(AlreadyTook) ; "You already took it."
							)
							((not (& (gEgo onControl:) $0010))
								(Print 484 5) ; "Patti! There are people watching!! Move behind your dressing screen first."
							)
							((gEgo has: 17) ; Dress
								(Print 484 9) ; "You want to wear your bra on the outside of your dress?"
							)
							(else
								(Ok) ; "O.K."
								(gEgo get: 16) ; Bra
								(gGame changeScore: 20)
								(aBra dispose:)
								(Print 484 10) ; "You look good in black!"
							)
						)
					)
					((Said '/hose')
						(cond
							((!= gEgoState 0)
								(NotNow) ; "Good idea. You might try that again later."
							)
							((not (InRoom 15))
								(AlreadyTook) ; "You already took it."
							)
							((not (& (gEgo onControl:) $0010))
								(Print 484 5) ; "Patti! There are people watching!! Move behind your dressing screen first."
							)
							(else
								(Ok) ; "O.K."
								(gEgo get: 15) ; Pantyhose
								(gGame changeScore: 20)
								(aPantyhose dispose:)
								(Print 484 11) ; "Patti! You've got "L'eggs!""
							)
						)
					)
					((Said '/dress,dress')
						(cond
							((!= gEgoState 0)
								(NotNow) ; "Good idea. You might try that again later."
							)
							((not (InRoom 17))
								(AlreadyTook) ; "You already took it."
							)
							((not (& (gEgo onControl:) $0010))
								(Print 484 5) ; "Patti! There are people watching!! Move behind your dressing screen first."
							)
							(else
								(self changeState: 1)
							)
						)
					)
				)
			)
			((Said 'look,look<below')
				(Print 484 12) ; "There's nothing under there!"
			)
			((Said 'strip,strip')
				(Print 484 13) ; "Perhaps you could do that later."
			)
			((Said 'drop,drop,decrease,drain,(get<off)/sheet')
				(Print 484 14) ; "Move behind the screen, Patti! No one here wants to see your naked, sensuous body."
			)
			((Said '/sandal')
				(Print 484 15) ; "You put on your shoes when you put on your dress, Patti."
			)
			((Said '/tray')
				(Print 484 16) ; "You decide to leave the tray there. Let room service clean up."
			)
			((Said 'gamble/keyboard')
				(Print 484 17) ; "You consider fighting your depressed feeling with music, but instead realize: finding Larry Laffer is the only medicine you need."
			)
			((Said 'close/door')
				(Print 484 18) ; "There's no need, Patti."
			)
			((Said 'look,look>')
				(cond
					((Said '/lotion,(buffet<dressing),cloth')
						(cond
							((InRoom 15)
								(Print 484 19) ; "A pair of pantyhose lies on your dressing table."
							)
							((InRoom 14)
								(Print 484 20) ; "A pair of black lace panties rests on the dressing table beside the screen."
							)
							((InRoom 16)
								(Print 484 21) ; "A black lace brassiere is all that is left on the dressing table."
							)
							(else
								(Print 484 22) ; "Your dressing table is empty."
							)
						)
						(if (InRoom 17)
							(Print 484 23) ; "Your white gown with the long slit hangs on a hanger on your dressing screen."
						)
					)
					((Said '/buffet')
						(if (InRoom 13)
							(Print 484 24) ; "The now-empty bottle of wine that Larry brought you rests on the table at the foot of your bed."
						else
							(Print 484 25) ; "The table at the foot of your bed contains nothing but an empty room-service tray."
						)
						(if (or (InRoom 15) (InRoom 14) (InRoom 16))
							(Print 484 26) ; "Some of your clothing lies on your dressing table, beside your dressing screen."
						else
							(Print 484 22) ; "Your dressing table is empty."
						)
					)
					((Said '/tray')
						(if (InRoom 13)
							(Print 484 27) ; "The now-empty wine bottle rests on the table at the foot of your bed."
						else
							(Print 484 28) ; "The table at the foot of your bed contains nothing but an empty room-service tray."
						)
					)
					((and (InRoom 13) (Said '/bottle'))
						(Print 484 27) ; "The now-empty wine bottle rests on the table at the foot of your bed."
					)
					((Said '/bed')
						(Print 484 29) ; "That's where it happened, all right!"
					)
					((Said '/keyboard')
						(Print 484 30) ; "Wasn't it nice of the casino management to rent a piano for your suite."
					)
					((Said '/binocular')
						(Print 484 31) ; "There's no use looking for Larry now, you know where he went. Now go find him!"
					)
					((Said '/burn,burn')
						(Print 484 32) ; "The lamps are just hanging around here."
					)
					((Said '/plant,bush')
						(Print 484 33) ; "You're not interested in plants, Patti!"
					)
					((Said '/balcony,display,display,cup')
						(Print 484 34) ; "The view is spectacular, but you want to see your Larry!"
					)
					((Said '[/area]')
						(Print 484 35) ; "You'll never be able to look at this suite again without thinking of your Larry!"
					)
				)
			)
			((Said '/cloth')
				(Print 484 36) ; "You must refer specifically to each article of clothing."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(Ok) ; "O.K."
				(gEgo get: 17 view: 800) ; Dress
				(gGame changeScore: 10)
				(Print 484 37) ; "You slide your dress over the screen and drop the sheet on the floor."
				(aDress setCycle: End self)
				(++ state)
			)
			(2
				(Ok) ; "O.K."
				(PutInRoom 17)
				(gEgo view: 482)
				(gGame changeScore: -10)
				(Print 484 38) ; "You grab the sheet again, and hang your dress back on the screen."
				(aDress setCycle: Beg self)
			)
			(3
				(aDress stopUpd:)
			)
		)
	)
)

(instance SheetBase of Code
	(properties)

	(method (doit)
		(gEgo brBottom: (+ (gEgo y:) 1))
		(gEgo brTop: (- (gEgo brBottom:) 2))
		(gEgo brLeft: (- (gEgo x:) 9))
		(gEgo brRight: (+ (gEgo x:) 9))
	)
)

