;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 881)
(include sci.sh)
(use Main)
(use Interface)
(use Actor)

(class trunk of Prop
	(properties
		view 205
		priority 15
		signal 16401
		cycleSpeed 0
		marked 0
		noPlay 1
		showing 0
	)

	(method (init)
		(= gTrunk self)
		(Case x: (+ x 29) y: (- y 36) init:)
		(if marked
			(theFlares x: (- x 46) y: (- y 43) loop: 1 cel: 6 init:)
		else
			(theFlares
				x: (- x 46)
				y: (- y 43)
				loop: (if (== ((gInventory at: 15) owner:) 26) 0 else 1) ; flares
				cel: (if (== ((gInventory at: 15) owner:) 26) 6 else 1) ; flares
				init:
			)
		)
		(trunklid x: (+ x 2) y: (- y 91) stopUpd: init:)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 881 0) ; "The trunk contains items you may need in the field."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (open)
		(gTheIconBar disable: 6)
		(cond
			(marked
				(theFlares loop: 0 cel: 6)
			)
			((== ((gInventory at: 15) owner:) 26) ; flares
				(theFlares loop: 0 cel: 6)
			)
			(else
				(theFlares loop: 1 cel: 1)
			)
		)
		(= showing 1)
		(gUser canControl: 0)
		(super show:)
		(Case show:)
		(trunklid show:)
		(theFlares show:)
		(if (== noPlay 0)
			(gLongSong number: 902 loop: 1 play:)
		)
		(= noPlay 0)
	)

	(method (close)
		(gTheIconBar enable: 6)
		(if (== noPlay 0)
			(gLongSong number: 903 loop: 1 play:)
		)
		(= noPlay 0)
		(Case hide:)
		(theFlares hide:)
		(trunklid hide:)
		(super hide:)
		(gUser canControl: 1)
	)

	(method (cue param1)
		(cond
			((not showing) 0)
			(param1
				(self noPlay: 1 cycleSpeed: 0)
				(Animate (gCast elements:) 0)
				(self open:)
			)
			(else
				(self noPlay: 1 cycleSpeed: 1)
				(Animate (gCast elements:) 0)
				(self close:)
			)
		)
	)

	(method (dispose)
		(= gTrunk 0)
		(Case dispose:)
		(theFlares dispose:)
		(trunklid dispose:)
		(super dispose:)
	)
)

(class Case of Prop
	(properties
		view 205
		cel 1
		priority 15
		signal 16
		caseOpen 0
	)

	(method (init)
		(caseLid x: (- x 20) y: (- y 33) init:)
		(if (== ((gInventory at: 7) owner:) 881) ; camera
			(thecamera init: posn: (- x 12) (- y 34) -30)
		)
		(if (== ((gInventory at: 39) owner:) 881) ; scraper
			(thescraper init: posn: (- x 11) (- y 39) -20)
		)
		(if (== ((gInventory at: 40) owner:) 881) ; toothpick
			(thetoothpicks init: posn: (+ x 14) (- y 42) -40)
		)
		(if (== ((gInventory at: 42) owner:) 881) ; sampleEnv
			(thebags init: posn: (+ x 9) (- y 36) -20)
		)
		(super init:)
	)

	(method (dispose)
		(caseLid dispose:)
		(thebags dispose:)
		(thecamera dispose:)
		(thescraper dispose:)
		(thetoothpicks dispose:)
		(super dispose:)
	)

	(method (hide)
		(if (== (trunk cycleSpeed:) 0)
			(= caseOpen 0)
			(caseLid cel: 7)
		)
		(super hide:)
		(caseLid hide:)
		(self showContents: 0)
	)

	(method (show)
		(super show:)
		(caseLid show:)
		(self showContents: 1)
	)

	(method (toggleCase)
		(self showContents: (= caseOpen (not caseOpen)))
		(caseLid cel: (+ 7 caseOpen))
	)

	(method (showContents param1)
		(if (and argc param1)
			(if (and (!= gCurRoomNum 45) (== ((gInventory at: 7) owner:) 881)) ; camera
				(thecamera show:)
			)
			(if (== ((gInventory at: 39) owner:) 881) ; scraper
				(thescraper show:)
			)
			(if (== ((gInventory at: 40) owner:) 881) ; toothpick
				(thetoothpicks show:)
			)
			(if (== ((gInventory at: 42) owner:) 881) ; sampleEnv
				(thebags show:)
			)
		else
			(if (== ((gInventory at: 7) owner:) 881) ; camera
				(thecamera hide:)
			)
			(if (== ((gInventory at: 39) owner:) 881) ; scraper
				(thescraper hide:)
			)
			(if (== ((gInventory at: 40) owner:) 881) ; toothpick
				(thetoothpicks hide:)
			)
			(if (== ((gInventory at: 42) owner:) 881) ; sampleEnv
				(thebags hide:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 881 1) ; "The briefcase contains tools and supplies for evidence collection."
			)
			(4 ; Inventory
				(switch invItem
					(40 ; toothpick
						(gEgo put: 40 881) ; toothpick
						(thetoothpicks
							posn: (+ (Case x:) 14) (- (Case y:) 42) -40
							init:
							show:
						)
					)
					(7 ; camera
						(gEgo put: 7 881) ; camera
						(thecamera
							posn: (- (Case x:) 12) (- (Case y:) 34) -30
							init:
							show:
						)
					)
					(39 ; scraper
						(gEgo put: 39 881) ; scraper
						(thescraper
							posn: (- (Case x:) 11) (- (Case y:) 39) -20
							init:
							show:
						)
					)
					(42 ; sampleEnv
						(gEgo put: 42 881) ; sampleEnv
						(thebags
							posn: (+ (Case x:) 9) (- (Case y:) 36) -20
							init:
							show:
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance thetoothpicks of View
	(properties
		view 205
		cel 2
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 881 2) ; "The toothpicks are useful for removing evidence from small places."
			)
			(3 ; Do
				(gEgo get: 40) ; toothpick
				(self hide:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thebags of View
	(properties
		view 205
		cel 3
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 881 3) ; "The envelopes are used for protecting and storing collected evidence."
			)
			(3 ; Do
				(gEgo get: 42) ; sampleEnv
				(self hide:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thecamera of View
	(properties
		view 205
		cel 4
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 881 4) ; "The camera is used to visually record a crime scene or a piece of evidence."
			)
			(3 ; Do
				(Print 881 5) ; "You don't need the camera."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thescraper of View
	(properties
		view 205
		cel 5
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 881 6) ; "The scraping tool is used to scrape dried evidence such as blood or paint off of other surfaces."
			)
			(3 ; Do
				(gEgo get: 39) ; scraper
				(self hide:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theFlares of View
	(properties
		view 205
		cel 6
		priority 15
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((== (self loop:) 0)
						(Print 881 7) ; "You have a full flare box."
					)
					((== (self loop:) 1)
						(Print 881 8) ; "There are no flares in the flare box."
					)
					(else
						(Print 881 9) ; "OOPS we shouldn't have gotten here with the flares."
					)
				)
			)
			(3 ; Do
				(if (trunk marked:)
					(Print 881 10) ; "You have no use for the flares right now."
				else
					(gEgo get: 15) ; flares
					(self loop: 1 cel: 1)
				)
			)
			(4 ; Inventory
				(switch invItem
					(15 ; flares
						(if (trunk marked:)
							(Print 881 11) ; "Your flare box is already full!"
						else
							(gEgo put: 15 26) ; flares
							(self init: loop: 0 cel: 6)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance caseLid of View
	(properties
		view 205
		cel 7
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 881 12) ; "There's a metal briefcase in the trunk."
			)
			(3 ; Do
				(Case toggleCase:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trunklid of View
	(properties
		view 205
		loop 1
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(trunk showing: 0 close:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

