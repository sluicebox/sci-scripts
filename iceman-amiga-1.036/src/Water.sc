;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Interface)
(use n802)
(use RegionPath)
(use n962)
(use Sight)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Water 0
	EgoWaterViewer 1
	bikini3Lady 2
	bikini4Lady 3
)

(local
	local0
	[local1 113] = [32767 7 273 117 104 132 48 235 32767 5 72 104 135 104 325 184 32767 4 76 95 128 103 325 178 32767 3 -5 90 325 100 32767 2 -5 100 180 160 325 185 32767 12 -5 170 175 156 325 128 32767 13 -5 128 325 106 32767 24 -5 116 184 111 155 72 -5 130 32767 13 325 106 -5 128 32767 12 325 128 175 156 -5 170 32767 2 325 150 -5 100 32767 3 325 100 -5 90 32767 4 325 178 128 103 76 95 32767 5 325 184 135 104 72 104 32767 7 48 235 104 132 273 117 -32768]
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp1 (& (= temp0 (GetTime 3)) $001f)) ; SysDate
	(Printf ; ""%02d/%02d/%02d" She replies."
		301
		22
		(& (>> temp0 $0005) $000f)
		(+ (if (< temp1 29) global142) temp1)
		(- (>> temp0 $0009) 60)
	)
)

(instance EgoWaterViewer of Code
	(properties)

	(method (doit &tmp temp0)
		(if (== (= temp0 (gEgo view:)) 206)
			(gEgo observeControl: 4096 2048)
			(if (& (proc802_0 gEgo) $1000)
				(if (not local0)
					(Print 301 0) ; "You can't go swimming with your shirt on."
					(= local0 1)
				)
			else
				(= local0 0)
			)
		else
			(gEgo
				ignoreControl: 4096 2048
				view:
					(switch (gEgo onControl: 1)
						(1024 216)
						(2048 215)
						(4096 214)
						(else
							(if (OneOf temp0 214 215) 200 else temp0)
						)
					)
			)
			(if (and (!= temp0 (gEgo view:)) (gEgo mover:))
				((gEgo mover:) init:)
			)
		)
	)

	(method (dispose)
		(gEgo viewer: 0)
		(super dispose:)
	)
)

(instance Water of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(if (not (= keep (OneOf newRoomNumber 1 2 3 4 5 7 12 13 9 24 8 16))) ; openingScene, thatchedHut, volleyRm, beachHuts1, beachHuts2, endBeach, beachHuts3, beachHuts4, hotelEntrance, eastBeachRm, HutSwimRm, beachSwimRm
			(gGame setScript: 0)
		)
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(Load rsVIEW 217)
		(Load rsVIEW 216)
		(Load rsVIEW 215)
		(Load rsVIEW 214)
		(Load rsVIEW 702)
		(Load rsVIEW 202)
		(Load rsVIEW 902)
		(super init: &rest)
		(gEgo viewer: EgoWaterViewer)
		(closeUpView init:)
		(if (not script)
			(self setScript: beachWalkerScript)
		)
		(if (IsObject (script register:))
			((script register:) init: setMotion: beachWalkerPath)
		)
		(if (not (gGame script:))
			(gGame setScript: musicScript)
		)
	)

	(method (notify param1 param2 &tmp temp0)
		(switch param1
			(0
				(= temp0 0)
				(while (< temp0 (- argc 2))
					((Clone param2)
						x: [param2 (++ temp0)]
						y: [param2 (++ temp0)]
						loop: [param2 (++ temp0)]
						init:
					)
				)
			)
			(1
				(beachWalkerScript register:)
				(return)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'swim')
				(if (== (gEgo view:) 206)
					(Print 301 1) ; "You might want to remove your shirt first."
				else
					(Print 301 2) ; "Go ahead!"
				)
			)
			((or (Said 'climb') (Said 'get/sand,plant,water'))
				(proc0_39) ; "You don't need to do that."
			)
			((Said 'walk,enter,go<in,in/bush')
				(Print 301 3) ; "The vegetation is too thick."
			)
			((Said 'look>')
				(cond
					((Said '/palm,bush,plant,vegetation')
						(Print 301 4) ; "It's just plain old South Pacific native island vegetation."
					)
					((Said '/water,bay,lagoon')
						(Print 301 5) ; "The clear waters of the South Pacific look inviting."
					)
					((Said '<up')
						(Print 301 6) ; "The sky in Tahiti is beautiful."
					)
					((Said '[<at,down,in][/beach,sand,floor]')
						(if (OneOf (gEgo view:) 317 216 215)
							(Print 301 7) ; "That's not convenient right now."
						else
							(switch (Random 1 3)
								(1
									(Print 301 8) ; "The white sandy beaches of Tahiti are some of the most beautiful in the world."
								)
								(2
									(Print 301 9) ; "You look down at the white sand."
								)
								(3
									(Print 301 10) ; "You look at the sand and think, "How beautiful!""
								)
							)
						)
					)
					((Said '[<at,up][/sky]')
						(switch (Random 1 2)
							(1
								(Print 301 11) ; "You look up and see... a deep blue sky."
							)
							(2
								(Print 301 12) ; "You look up and are amazed at the beauty."
							)
						)
					)
				)
			)
			((Said 'kiss,suck,fuck,touch/woman,cunt,boob')
				(Print 301 13) ; "You don't see one."
			)
		)
	)

	(method (dispose)
		(EgoWaterViewer dispose:)
		(super dispose:)
	)
)

(instance musicScript of Script
	(properties)

	(method (doit)
		(if (and (== state 0) (== (gIceGlobalSound prevSignal:) -1))
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gIceGlobalSound number: 5 loop: 2 play:)
			)
			(1
				(gIceGlobalSound number: 4 loop: -1 play:)
			)
		)
	)

	(method (dispose)
		(gIceGlobalSound stop:)
		(super dispose:)
	)
)

(instance closeUpView of View
	(properties
		y 85
		x 265
		loop 4
	)

	(method (init)
		(super init:)
		(self hide: setPri: 15)
	)

	(method (show param1)
		(self view: param1 setLoop: 4)
		(super show:)
	)
)

(instance bikini3Lady of Act
	(properties
		view 702
	)

	(method (init)
		(super init:)
		(self
			setAvoider: Avoid 1
			ignoreHorizon:
			setCycle: Walk
			observeControl: 2048
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((IsOffScreen self))
			((Said 'look[<at][/woman,brunette,native[<native,brunette]]')
				(closeUpView show: view)
				(Animate (gCast elements:) 0)
				(Print 301 14) ; "Whew, what a hot lookin' native girl!"
				(closeUpView hide:)
				(event claimed: 1)
			)
			((Said 'whistle')
				(Print 301 15) ; "She ignores your ancient ploy."
			)
			((Said 'ask<out/woman')
				(Print 301 16) ; "She is out."
			)
			((Said '[/bitch,cunt,boob,brunette,woman[<native]]>')
				(cond
					((Said 'ask//date')
						(localproc_0)
					)
					((Said 'ask//time')
						(Print 301 17) ; "Time has no meaning in Tahiti."
					)
					((Said 'chase')
						(Print 301 18) ; "You can do that."
					)
					((Said 'talk')
						(Print 301 19) ; "She's trying to ignore you."
					)
					((Said 'kiss,suck,fuck,touch')
						(if (> (gEgo distanceTo: self) 50)
							(Print 301 20) ; "You'll have to get closer than this."
						else
							(QueScript self 352)
						)
					)
				)
			)
		)
	)
)

(instance bikini4Lady of Act
	(properties
		view 202
	)

	(method (init)
		(super init:)
		(self
			setAvoider: Avoid 1
			ignoreHorizon:
			setCycle: Walk
			observeControl: 2048
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((IsOffScreen self))
			((Said 'look[<at][/blond,woman[<blond]]')
				(closeUpView show: view)
				(Animate (gCast elements:) 0)
				(Print 301 21) ; "This blonde is definitely a babe."
				(closeUpView hide:)
				(event claimed: 1)
			)
			((Said 'whistle')
				(Print 301 15) ; "She ignores your ancient ploy."
			)
			((Said 'ask<out/woman')
				(Print 301 16) ; "She is out."
			)
			((Said '[/bitch,cunt,boob,blond,woman[<blond]]>')
				(cond
					((Said 'ask//date')
						(localproc_0)
					)
					((Said 'ask//time')
						(Print 301 17) ; "Time has no meaning in Tahiti."
					)
					((Said 'chase')
						(Print 301 18) ; "You can do that."
					)
					((Said 'talk')
						(Print 301 19) ; "She's trying to ignore you."
					)
					((Said 'kiss,suck,fuck,touch')
						(if (> (gEgo distanceTo: self) 50)
							(Print 301 20) ; "You'll have to get closer than this."
						else
							(QueScript self 353)
						)
					)
				)
			)
		)
	)
)

(instance beachWalkerPath of RegionPath
	(properties
		value 29
		endType 0
		theRegion 301
	)

	(method (at param1)
		(return [local1 param1])
	)

	(method (nextRoom)
		(if
			(and
				(== (self at: (+ 2 value)) 3)
				(== gCurRoomNum 3) ; volleyRm
				(gCurRoom notify: 0)
			)
			(repeat
				(-= value 2)
				(breakif (== (self at: (+ 1 value)) 32767))
			)
		)
		(super nextRoom: &rest)
	)
)

(instance beachWalkerScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(switch (Random 2 3)
						(2 bikini3Lady)
						(3 bikini4Lady)
					)
				)
				(beachWalkerPath value: -1)
				(if (IsObject register)
					(register dispose:)
				)
				(if (== temp0 register)
					(self init:)
				else
					((= register temp0) init: setMotion: beachWalkerPath self)
				)
			)
			(1
				(self init:)
			)
		)
	)
)

