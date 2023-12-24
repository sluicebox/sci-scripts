;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 417)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	regCasino 0
)

(instance regCasino of Rgn
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((or (Said 'gamble/game') (Said 'gamble'))
				(Print 417 0) ; "You have no desire to gamble."
				(Print 417 1 #at -1 144) ; "(You got enough of that in "Leisure Suit Larry in the Land of the Lounge Lizards!")"
			)
			((and gDebugging (Said 'increase/backstage'))
				(Printf 417 2 (++ gShowroomState)) ; "Ok, Al. Showroom state is now %d, where 0 = SRshowIsOn 1 = SRshowDone 2 = SRcherriOnPhone 3 = SRknowsAboutDeed 4 = SRcherriBackstage 5 = SRstageDoorUnlocked 6 = SRdone"
			)
			((and gDebugging (Said 'increase/document'))
				(Printf 417 3 (++ gNewspaperState)) ; "Ok, Al. Newspaper state is now %d, where 0 = NSnotYet 1 = NSpComing 2 = NSshowroom 3 = NSpHere 4 = NSlMissing"
			)
			((and gDebugging (Said 'increase/attorney'))
				(Printf 417 4 (++ gLawyerState)) ; "Ok, Al. Lawyer state is now %d, where 0 = LSbusy 1 = LSfree 2 = LSwaiting4deed 3 = LSdeedReady 4 = LSneeds500 5 = LSdivorce 6 = LSwaiting4divorce 7 = LSdivorceReady 8 = LSdone"
			)
			((Said 'look,look>')
				(cond
					((Said '/gambler,entertainer,stair,couple,man,woman')
						(Print 417 5) ; "You see many tourists donating their hard-earned money to "Natives, Inc." Being intimately familiar with the profit margins of gaming, you're glad it's them and not you!"
					)
					((Said '/rail')
						(Print 417 6) ; "The railing prevents you from falling off the side of this balcony."
					)
					((Said '/door')
						(Print 417 7) ; "The doorway leads out of this scene. Wherever could it go?"
					)
					((Said '/mirror')
						(Print 417 8) ; ".kcab gnikool flesruoy ees uoY"
						(if (not (TestFlag 12))
							(SetFlag 12) ; lookedInMirror
							(gGame changeScore: 2)
						)
					)
					((Said '[/area]')
						(Print 417 9) ; "If you would look in the mirror, you would see yourself."
					)
				)
			)
		)
	)
)

