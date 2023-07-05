;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm750 0
)

(instance rm750 of Room
	(properties
		picture 750
		style 14
		exitStyle 13
	)

	(method (init)
		(gGame handsOff:)
		(super init:)
		(self setScript: showAMovie)
		(if (!= gPrevRoomNum 216)
			(gGkMusic1
				stop:
				number: 226
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
	)

	(method (dispose)
		(gGkMusic1 fade:)
	)
)

(instance showAMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(switch gPrevRoomNum
					(205
						(travelProp
							view: 750
							loop: 0
							cel: 0
							x: 58
							y: 75
							init:
							cycleSpeed: 22
							setCycle: End self
						)
					)
					(500
						(travelProp
							view: 751
							loop: 0
							cel: 0
							x: 229
							y: 40
							init:
							cycleSpeed: 22
							setCycle: End self
						)
					)
					(else
						(travelProp
							view: 752
							loop: 0
							cel: 0
							x: 217
							y: 117
							init:
							cycleSpeed: 22
							setCycle: End self
						)
						(gMessager sayRange: 1 0 3 1 3 self 206) ; "(ARCC)After arranging for the shipment of Wolfgang's body back to Rittersberg, Gabriel returns to New Orleans."
					)
				)
			)
			(2
				(if (or (== gPrevRoomNum 500) (== gPrevRoomNum 205))
					(self cue:)
				else
					0
				)
			)
			(3
				(switch gPrevRoomNum
					(205
						(gCurRoom newRoom: 500)
					)
					(500
						(= gDay 9)
						(gCurRoom newRoom: 700)
					)
					(else
						(travelProp dispose:)
						(gCurRoom drawPic: 755 270)
						(gMessager say: 1 0 3 4 self 206) ; "(INSINUATING)Or does he?"
						(= seconds 6)
					)
				)
			)
			(4 0)
			(5
				(= gDay 10)
				(gCurRoom newRoom: 205)
			)
		)
	)
)

(instance travelProp of Prop
	(properties)
)

