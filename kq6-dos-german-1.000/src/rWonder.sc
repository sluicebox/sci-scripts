;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Game)
(use System)

(public
	rWonder 0
)

(class rWonder of Rgn
	(properties
		spiderBit 0
		parchmentBit 0
		gotParchment 0
		tomoTalk 0
		stickTalk 0
		grapeTalk 0
		vineTalk 0
		holeLooks 0
		holeGrabs 0
		oysterDozing 0
		flowerDance 0
		babyFed 0
		lampMsg 0
		bottleSucker 0
		alexX 0
		alexY 0
		alexInvisible 0
		grabAtHidingHole 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 450 460 461 470 475 480 490)) ; blackWidowInset
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)
)

