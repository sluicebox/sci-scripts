;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm24 0
)

(local
	aPeople
)

(instance rm24 of Rm
	(properties
		picture 24
		horizon 5
		north 20
		east 25
		west 23
	)

	(method (init)
		(Load rsVIEW 255)
		(super init:)
		((= aPeople (Act new:))
			view: 255
			setLoop: 0
			setStep: 1 1
			setCycle: Fwd
			illegalBits: 0
			ignoreHorizon:
			ignoreActors:
			posn: -5 64
			init:
			setScript: detailScript
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 155 180)
			)
			((== gPrevRoomNum 20)
				(gEgo posn: 99 111)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm24Script) ; rm200
	)
)

(instance rm24Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said '/film')
			(Print 24 0) ; "From here you can just make out the promo board on the latest project now in production: "Debbie Does Oakhurst! An extraordinary trip down mammary lane! A behind the scenes look when sex was still dirty.""
			(Print 24 1 #at -1 152) ; "(Must be a documentary!)"
		)
		(if (Said 'look>')
			(if (Said '[/building,unreversal,krod,airport]')
				(Print 24 2) ; "Why, that must be "Unreversal Studios!""
			)
			(if (Said '/children,man,woman')
				(Print 24 3) ; "They're on one of those famous "Unreversal Studios Tours.""
			)
		)
	)
)

(instance detailScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 12)
			)
			(1
				(aPeople setPri: -1 setLoop: 0 setMotion: MoveTo 190 64 self)
			)
			(2
				(aPeople hide:)
				(= seconds (Random 2 9))
			)
			(3
				(aPeople
					setLoop: 1
					posn: -5 64
					show:
					setMotion: MoveTo 190 64 self
				)
			)
			(4
				(aPeople hide:)
				(= seconds (Random 2 9))
			)
			(5
				(aPeople
					setLoop: 2
					posn: -5 64
					show:
					setMotion: MoveTo 210 64 self
				)
			)
			(6
				(aPeople hide:)
				(= seconds (Random 2 9))
			)
			(7
				(aPeople setLoop: 3 posn: 299 104 setPri: 11 show:)
				(= seconds (Random 5 15))
			)
			(8
				(aPeople hide:)
				(self changeState: 0)
			)
		)
	)
)

