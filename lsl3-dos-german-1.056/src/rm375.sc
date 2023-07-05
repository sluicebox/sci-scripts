;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 375)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm375 0
)

(instance rm375 of Rm
	(properties
		picture 375
		horizon 1
		south 370
	)

	(method (init)
		(if (gEgo has: 5) ; Soap-On-A-Rope
			(Load rsVIEW 5)
		)
		(aWater1 init:)
		(aWater2 init:)
		(aWater3 init:)
		(aWater4 init:)
		(aDrain init:)
		(if (TestFlag 49)
			(self picture: 376)
			(Load rsPIC 375)
			(Load rsVIEW 376)
			(gSoundFX number: 375 loop: gBgMusicLoops play:)
		else
			(self picture: 375)
			(Load rsPIC 376)
			(Load rsVIEW 377)
			(Load rsSOUND 375)
			(aWater1 hide:)
			(aWater2 hide:)
			(aWater3 hide:)
			(aWater4 hide:)
			(aDrain hide:)
		)
		(super init:)
		(self setScript: RoomScript)
		(NormalEgo)
		(gEgo
			view:
				(cond
					((TestFlag 49) 377)
					((>= gFilthLevel 3) 376)
					(else 378)
				)
			posn: 53 176
			setPri: 11
			setStep: 5 5
			init:
		)
	)

	(method (newRoom newRoomNumber)
		(gSoundFX fade:)
		(if (InRoom 8 375)
			(gEgo get: 8) ; Beach_Towel
			(Print 375 0) ; "You grab your towel from the hook by the door."
		)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl:) $0004) (TestFlag 49))
			(SetFlag 50)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'shampoo,shampoo')
				(Print 375 1) ; "Ok. Your hair is clean."
			)
			((or (Said 'caress/self') (Said 'jack'))
				(Ok) ; "O.K."
				(Print 375 2 #at -1 144) ; "(That was fast!)"
			)
			(
				(Said
					'stop,close,deactivate,(pull<off)/bath,bath,faucet,channel,handle,water'
				)
				(cond
					((not (TestFlag 49))
						(ItIs) ; "It is."
					)
					((not (& (gEgo onControl:) $0002))
						(Print 375 3) ; "The faucet is near the top of the screen."
					)
					(else
						(Ok) ; "O.K."
						(gEgo view: (if (>= gFilthLevel 3) 376 else 378))
						(ClearFlag 49)
						(gCurRoom drawPic: 375 8)
						(aWater1 hide:)
						(aWater2 hide:)
						(aWater3 hide:)
						(aWater4 hide:)
						(aDrain hide:)
						(gSoundFX stop:)
					)
				)
			)
			(
				(or
					(Said 'bath,bath,bath,bath')
					(Said 'get/bath,bath')
					(Said
						'use,open,activate,(pull<on)/bath,bath,faucet,channel,handle,water'
					)
				)
				(cond
					((TestFlag 49)
						(ItIs) ; "It is."
					)
					((not (& (gEgo onControl:) $0002))
						(Print 375 3) ; "The faucet is near the top of the screen."
					)
					(else
						(Ok) ; "O.K."
						(gEgo view: 377)
						(SetFlag 49)
						(gCurRoom drawPic: 376 8)
						(if (> gMachineSpeed 16)
							(aWater1 show:)
							(aWater2 show:)
							(aWater3 show:)
							(aWater4 show:)
						)
						(aDrain show:)
						(gSoundFX number: 375 loop: gBgMusicLoops play:)
					)
				)
			)
			((Said 'rinse')
				(cond
					((not (TestFlag 49))
						(Print 375 4) ; "You may want to turn on the shower first."
					)
					((not (& (gEgo onControl:) $0004))
						(Print 375 5) ; "Shouldn't you be in the water?"
					)
					(else
						(Ok) ; "O.K."
						(Print 375 6) ; "You rinse your body in the sensually-warm running water."
					)
				)
			)
			((or (Said 'clean') (Said 'clean,use/soap'))
				(cond
					((not (TestFlag 49))
						(Print 375 7) ; "You may want to turn on the shower first."
					)
					((not (& (gEgo onControl:) $0004))
						(Print 375 5) ; "Shouldn't you be in the water?"
					)
					((not (gEgo has: 5)) ; Soap-On-A-Rope
						(Print 375 8) ; "You rub your hands all over yourself in an excellent imitation of a bar of soap. Too bad you don't have one."
						(Print 375 9 #at -1 144) ; "(Bar of soap, that is!)"
					)
					(else
						(Ok) ; "O.K."
						(ClearFlag 8)
						(ClearFlag 10)
						(gGame changeScore: 60)
						(gEgo put: 5 -1) ; Soap-On-A-Rope
						(Print 375 10 #icon 5 0 0) ; "You were so wise to bring your "Soap-On-A-Rope" into the shower with you."
						(Print 375 11) ; "You carefully rub it over every part of your body."
						(if (>= gFilthLevel 3)
							(Print 375 12) ; "...some parts longer than others!"
						)
						(Print 375 13) ; "Soon, it's all gone!"
					)
				)
			)
			((and (not (gEgo has: 5)) (Said 'get,get/soap')) ; Soap-On-A-Rope
				(Print 375 14) ; "Well, look at that! Somebody used up all the soap and left none for you!"
				(Print 375 15 #at -1 144) ; "(Where could you find soap on this island?)"
			)
			((Said 'look,look>')
				(cond
					((Said '/faucet,handle,channel')
						(if (TestFlag 49)
							(Print 375 16) ; "It's "on.""
						else
							(Print 375 17) ; "It's "off.""
						)
					)
					((Said '/drain,drain')
						(if (TestFlag 49)
							(Printf ; "Look! The water is going down the drain in a %sclockwise direction!%"
								375
								18
								(if (= temp0 (Random 0 1)) {counter-} else {})
								(if temp0
									{[German word for `counter' needed]-}
								else
									{}
								)
							)
						else
							(Print 375 19) ; "It looks grate!"
						)
					)
					((Said '[/carpet,bath,bath,area]')
						(Print 375 20) ; "The shower room has a slippery tile floor."
					)
				)
			)
		)
	)
)

(instance aWater1 of Prop
	(properties
		y 91
		x 148
		view 375
		loop 1
		cel 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aWater2 of Prop
	(properties
		y 61
		x 178
		view 375
		loop 2
		cel 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aWater3 of Prop
	(properties
		y 92
		x 170
		view 375
		loop 1
		cel 3
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aWater4 of Prop
	(properties
		y 84
		x 128
		view 375
		loop 2
		cel 4
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aDrain of Prop
	(properties
		y 91
		x 148
		view 375
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd ignoreActors:)
	)
)

