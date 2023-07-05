;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 134)
(include sci.sh)
(use Main)
(use Interface)
(use Wander)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm134 0
)

(local
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
		(aSkimmer
			setLoop: 2
			setCycle: Fwd
			setPri: 2
			cycleSpeed: 3
			isExtra: 1
			init:
		)
		(aMan
			setLoop: 0
			moveSpeed: 3
			cycleSpeed: 3
			setCycle: Fwd
			setCycle: Fwd
			setPri: 3
			setStep: 1 1
			illegalBits: -513
			init:
			setMotion: Wander
		)
		(aFart
			setLoop: 3
			setPri: 5
			illegalBits: 0
			init:
			hide:
			setScript: fartScript
		)
		(aPiss setLoop: 4 setPri: 10 illegalBits: 0 init:)
		(if ((gInventory at: 15) ownedBy: gCurRoomNum) ; Bikini_Top
			(aBra stopUpd: init:)
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

	(method (dispose)
		(DisposeScript 970)
		(super dispose:)
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

(instance aBra of View
	(properties
		y 135
		x 84
		view 314
		loop 1
		priority 2
		signal 16384
	)
)

(instance aSkimmer of Prop
	(properties
		y 27
		x 116
		view 314
		signal 16384
	)
)

(instance aMan of Act
	(properties
		y 19
		x 200
		view 314
	)
)

(instance aPiss of Act
	(properties
		y 999
		x 999
		view 314
		signal 16384
	)
)

(instance aFart of Act
	(properties
		view 314
		signal 16384
	)
)

