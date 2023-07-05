;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1099)
(include sci.sh)
(use Main)
(use Location)
(use VMDMovie)

(public
	ShuttleRide 0
)

(instance ShuttleRide of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self setPicObj: faceN)
		(shuttle_Ride play:)
		(self newRoom: 1000) ; hubCamp0
	)
)

(instance faceN of CameraAngle
	(properties
		picture 61
		edgeW 0
		edgeE 0
		edgeS 0
		edgeN 0
	)
)

(instance shuttle_Ride of VMDMovie
	(properties
		movieName 39999
		options 64
		endPic 61
		cacheSize 1000
	)
)

