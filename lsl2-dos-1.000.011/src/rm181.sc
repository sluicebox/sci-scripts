;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 181)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm181 0
)

(local
	aWaterfall
	seenMessage
	safeX
	safeY
)

(instance theSound of Sound
	(properties
		number 1
	)
)

(instance blockEast of Blk
	(properties
		top 1
		left 328
		bottom 222
		right 333
	)
)

(instance blockSouth of Blk
	(properties
		top 192
		left 99
		bottom 222
		right 333
	)
)

(instance rm181 of Rm
	(properties
		picture 181
		horizon 33
		north 82
	)

	(method (init)
		(Load rsVIEW 727)
		(Load rsVIEW 103)
		(Load rsSOUND 1)
		(super init:)
		(theSound init:)
		((= aWaterfall (Prop new:))
			view: 727
			setLoop: 0
			posn: 27 189
			setCycle: Fwd
			setPri: 3
			isExtra: 1
			init:
		)
		(blockEast init:)
		(blockSouth init:)
		(self setScript: rm181Script)
		(if (== gPrevRoomNum 82)
			(gEgo posn: 21 36)
		else
			(gEgo posn: 310 186)
		)
		(NormalEgo)
		(gEgo observeBlocks: blockEast blockSouth init:)
	)
)

(instance rm181Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gCurrentStatus 0)
				(or (== (gEgo edgeHit:) EDGE_BOTTOM) (== (gEgo edgeHit:) EDGE_RIGHT))
			)
			(if (== seenMessage 0)
				(= seenMessage 1)
				(Print 181 0) ; "You have no need to return that way. Your quest lies before you. Hurry, Larry!"
			)
		else
			(= seenMessage 0)
		)
		(if (== gCurrentStatus 0)
			(if (< (gEgo y:) 50)
				(gEgo setPri: 3)
			else
				(gEgo setPri: -1)
			)
		)
		(cond
			((and (== (gEgo edgeHit:) EDGE_LEFT) (== gCurrentStatus 0))
				(gCurRoom newRoom: 82)
			)
			((and (& (gEgo onControl:) $0002) (== gCurrentStatus 0))
				(gEgo setPri: 8)
				(self changeState: 1)
			)
			((and (& (gEgo onControl:) $0004) (== gCurrentStatus 0))
				(gEgo setPri: 0)
				(self changeState: 1)
			)
			((== gCurrentStatus 0)
				(= safeX (gEgo x:))
				(= safeY (gEgo y:))
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/hole,cloud,cloud,(boulder<through,in)')
				(Print 181 1) ; "You look through the hole in the rock and see just a cloud."
				(Print 181 2 #at -1 152) ; "(Why? Did you think you see something?)"
			)
			(if (Said '[/airport,hill,cliff,cascade,water,brook]')
				(Print 181 3) ; "Sheer cliffs drop off on both sides. For a moment you consider walking very near the edge, just to see if you can fall off. Perhaps you won't. Perhaps you can fly! Perhaps the love of the beautiful Kalalau has given you amazing, magical powers that are only activated here on this enchanted island."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(Print 181 4 #at -1 20 #dispose) ; "Oh, shhhhhhhh..."
				(= gCurrentStatus 12)
				(theSound play:)
				(gEgo
					view: 103
					illegalBits: 0
					ignoreActors:
					ignoreBlocks: blockSouth blockEast
					posn: (gEgo x:) (- (gEgo y:) 15)
					cel: 0
					setStep: 1 15
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 200) self
				)
			)
			(2
				(cls)
				(= gCurrentStatus 1000)
				(Print 181 5) ; "Perhaps Kalalau's love only SEEMED to give you wings!"
				(= gCurrentStatus 1001)
				(if gDebugging
					(NormalEgo)
					(gEgo
						observeBlocks: blockEast blockSouth
						posn: safeX safeY
					)
					(self changeState: 0)
				)
			)
		)
	)
)

