;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 134)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm134 0
)

(local
	aSkimmer
	aBra
	aMan
	aFart
	aPiss
	egoPissing
	passInRoom
)

(instance rm134 of Rm
	(properties
		picture 134
		horizon 5
		north 34
	)

	(method (init)
		(Load rsVIEW 136)
		(Load rsVIEW 314)
		(super init:)
		((= aSkimmer (Prop new:))
			view: 314
			setLoop: 2
			setPri: 2
			posn: 116 28
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors:
			isExtra: 1
			init:
		)
		((= aMan (Act new:))
			view: 314
			setLoop: 0
			setPri: 3
			setCycle: Fwd
			moveSpeed: 3
			cycleSpeed: 3
			setCycle: Fwd
			setStep: 1 1
			illegalBits: -513
			posn: 200 20
			init:
			setMotion: Wander
		)
		((= aFart (Act new:))
			view: 314
			setLoop: 3
			setPri: 5
			ignoreActors:
			illegalBits: 0
			init:
			hide:
			setScript: fartScript
		)
		((= aPiss (Act new:))
			view: 314
			setLoop: 4
			setPri: 10
			illegalBits: 0
			ignoreActors:
			posn: 999 999
			init:
		)
		(if ((gInventory at: 15) ownedBy: gCurRoomNum) ; Bikini_Top
			((= aBra (View new:))
				view: 314
				setLoop: 1
				setPri: 2
				posn: 84 136
				ignoreActors:
				stopUpd:
				init:
			)
		)
		(gEgo
			view: 136
			setLoop: 0
			cel: 0
			illegalBits: -32768
			observeControl: 512
			posn: 88 6
			setPri: 11
			setMotion: 0
			init:
		)
		(User canControl: 1 canInput: 1)
		(= gCurrentStatus 19)
		(self setRegions: 300 setScript: rm134Script) ; rm300
	)
)

(instance rm134Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (++ passInRoom) 200)
			(Print 134 0) ; "Exactly how long do you think you can hold your breath?"
		)
		(if (and (== passInRoom 400) (!= gCurrentStatus 1001))
			(= gCurrentStatus 1001)
			(gEgo hide:)
			(Print 134 1 #draw) ; "You feel your lungs explode as you think to yourself, "Gee, I wish I could hold my breath longer, or I owned a faster computer!""
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/drain,bottom')
				(if ((gInventory at: 15) ownedBy: gCurRoomNum) ; Bikini_Top
					(Print 134 2) ; "There is a bikini top caught in the pool's drain!"
				else
					(Print 134 3) ; "You can remember when there was a bikini top caught in that drain!"
				)
			)
			(if (Said '[/water,inner,water,man,airport]')
				(Print 134 4) ; "The water is clear enough to see too much of that guy in the inner tube!"
				(if ((gInventory at: 15) ownedBy: gCurRoomNum) ; Bikini_Top
					(Print 134 2) ; "There is a bikini top caught in the pool's drain!"
				)
			)
		)
		(if (Said 'get/inner,man')
			(Print 134 5) ; "No way!"
		)
		(if (Said '/drain')
			(Print 134 6) ; "Why do you have such a fascination with plumbing?"
		)
		(if (Said 'bathing,dive,(climb<off)')
			(Print 134 7) ; "Just move wherever you want to go."
		)
		(if (Said 'get/lid,bikini,job,(lid<bikini)')
			(cond
				((not ((gInventory at: 15) ownedBy: gCurRoomNum)) ; Bikini_Top
					(Print 134 8) ; "Where?"
				)
				((not (gEgo inRect: 60 130 105 150))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(aBra dispose:)
					(gEgo get: 15) ; Bikini_Top
					(gGame changeScore: 7)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not egoPissing) (== 5 (Random 1 22)))
					(= egoPissing 1)
					(aPiss
						cel: 0
						posn: (+ (gEgo x:) 7) (- (gEgo y:) 41)
						setCycle: End
					)
				)
				(gEgo setCycle: End self)
			)
			(1
				(= cycles 4)
				(if (== egoPissing 1)
					(= egoPissing 255)
					(aPiss posn: 999 999)
					(Print 134 9) ; "Oops."
				)
			)
			(2
				(if (and (> (gEgo heading:) 90) (< (gEgo heading:) 270))
					(gEgo setLoop: 0)
				)
				(if (or (< (gEgo heading:) 90) (> (gEgo heading:) 270))
					(gEgo setLoop: 1)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance fartScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 22 44))
			)
			(1
				(aFart
					posn: (+ (aMan x:) 8) (- (aMan y:) 4)
					cel: 0
					setCycle: End self
					show:
				)
			)
			(2
				(aFart hide:)
				(self changeState: 0)
			)
		)
	)
)

