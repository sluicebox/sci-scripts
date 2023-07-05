;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm700 0
)

(instance rm700 of Rgn
	(properties)

	(method (init)
		(super init:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and (gEgo has: 28) (Said 'apply,throw/stick')) ; Stout_Stick
			(Print 700 0) ; "You hurl the stick through the jungle as hard as you can. "Whee," you shout."
			(gEgo put: 28 -1) ; Stout_Stick
		)
		(if (gEgo has: 29) ; Vine
			(if (Said 'cigarette/landscape')
				(Ok) ; "Ok."
				(Print 700 1) ; "You haven't done this since you were a kid."
				(Print 700 2 #at -1 152) ; "(You didn't like it then, either!)"
				(gEgo put: 29 -1) ; Vine
			)
			(if (Said 'throw,apply/landscape')
				(Print 700 3) ; "This is not the place."
			)
		)
		(if (and (gEgo has: 30) (Said 'smell,eat,throw,drop,look/ash')) ; Ashes
			(Print 700 4) ; "The ashes have a distinct aroma of burnt iguana flesh!"
		)
		(if (and (gEgo has: 30) (Said 'throw,throw,drop,apply/ash')) ; Ashes
			(Print 700 5) ; "You throw the ashes into the wind and watch them disappear forever."
			(gEgo put: 30 -1) ; Ashes
		)
		(if (Said 'look>')
			(if (Said '/up,overhead,cloud')
				(Print 700 6) ; "The warm tropical sun basks you in its amber glow while the clear blue air refreshes your lungs."
			)
			(if (Said '/chimpanzee')
				(Print 700 7) ; "You bet they are up there somewhere!"
			)
			(if (Said '/boulder,head,art')
				(Print 700 8) ; "Evidently, some of the island's rocks were part of an ancient fertility ceremony."
			)
			(if (Said '/palm')
				(Print 700 9) ; "The dense undergrowth of the jungle brings a sense of foreboding to your heart!"
			)
		)
	)
)

