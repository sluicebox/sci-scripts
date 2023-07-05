;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Feature)
(use LoadMany)
(use Sound)
(use Actor)
(use System)

(public
	rm046 0
)

(instance rm046 of PQRoom
	(properties
		picture 46
	)

	(method (init)
		(LoadMany rsVIEW 495 496)
		(LoadMany rsSOUND 503 461)
		(if (not (IsFlag 222))
			(erieSound play:)
			(SetFlag 222)
		)
		(upperbody init:)
		(lowerbody init:)
		(face init:)
		(dumpster init:)
		(bodyhand init:)
		(if (!= global114 96)
			(= global114 86)
		)
		(shirtview init: stopUpd:)
		(OutSide init:)
		(HandsOn)
		(super init:)
	)
)

(instance CheckHandsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(Print 46 0 #icon 495 2 0 #at 5 5 #width 300) ; "Using the toothpick, you scrape under the victim's fingernails. You then place the collected skin and hair into a sample envelope."
				(= seconds 1)
			)
			(2
				(gEgo get: 33) ; skinHair
				(SetFlag 38)
				(SetScore 151 5)
				(handinset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance CheckShirtScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(shirtview dispose:)
				(if (not (IsFlag 219))
					(mOpenShirt play:)
				)
				(SetFlag 219)
				(= seconds 1)
			)
			(1
				(Print 46 1 #at 60 120) ; "You look carefully at the knife wounds in the upper chest. Not a pretty sight. But it's the pentagram carved into the flesh that really hits you between the eyes."
				(Print 46 2 #at 60 120) ; ""Not another one!" You mutter."
				(Print 46 3 #at 60 120) ; "That's all Lytton needs - some freaked-out serial killer that thinks he's got a hot-line to Satan!"
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance changeToFarAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shirtview init:)
				(= cycles 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 45)
			)
		)
	)
)

(instance shirtview of View
	(properties
		x 163
		y 108
		view 495
		priority 14
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: CheckShirtScript)
			)
			(2 ; Look
				(Print 46 4) ; "A bloody shirt covers the upper torso."
			)
			(1 ; Walk
				(OutSide doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance handinset of View
	(properties
		x 71
		y 178
		view 495
		loop 1
		priority 15
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 151)
					(Print 46 5) ; "You already have the hair and skin sample."
				else
					(Print 46 6) ; "That is a good idea, but you'll need the proper equipment."
				)
			)
			(4 ; Inventory
				(if (== invItem 40) ; toothpick
					(cond
						((gEgo has: 33) ; skinHair
							(Print 46 5) ; "You already have the hair and skin sample."
						)
						((gEgo has: 42) ; sampleEnv
							(gCurRoom setScript: CheckHandsScript)
						)
						(else
							(Print 46 7) ; "That's a good idea, but you'll need to use the proper field equipment."
						)
					)
				)
			)
			(2 ; Look
				(if (not (gEgo has: 33)) ; skinHair
					(Print 46 8) ; "Looking closely at the victim's hands, you notice what appears to be hair and skin imbedded under the fingernails."
				else
					(Print 46 9) ; "Looks like somebody attacked this guy with toothpicks."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance id of View
	(properties
		x 253
		y 186
		view 496
		priority 15
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self dispose:)
			)
			(4 ; Inventory
				(cond
					((and (== invItem 28) (not (IsFlag 82))) ; noteBook
						(SetFlag 82)
						(Print 46 10) ; "You carefully write down the information in your notebook."
					)
					((IsFlag 82)
						(Print 46 11) ; "You already have the information in your notebook."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(self dispose:)
			)
			(evMOUSEBUTTON
				(self dispose:)
			)
		)
	)
)

(instance OutSide of Feature
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Walk
				(if (gCast contains: handinset)
					(handinset dispose:)
				else
					(gCurRoom setScript: changeToFarAway)
				)
			)
		)
	)
)

(instance lowerbody of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 46 12) ; "You examine the body. By its skin color and state of rigor mortis, you'd guess that the victim's been dead for at least a few hours."
			)
			(3 ; Do
				(if
					(and
						(!= ((gInventory at: 23) owner:) 45) ; license
						(not (gEgo has: 23)) ; license
						(not (IsFlag 150))
						(not (IsFlag 49))
					)
					(Print 46 13) ; "You carefully search the body and remove the victim's identification."
					(id init:)
					(gEgo get: 23) ; license
					((gInventory at: 23) state: 5) ; license
					(SetFlag 49)
					(SetScore 150 5)
				else
					(Print 46 14) ; "There's nothing more in the victim's pockets."
				)
			)
			(1 ; Walk
				(OutSide doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance upperbody of Feature
	(properties
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(cond
					((and (== invItem 28) (not (IsFlag 152))) ; noteBook
						(Print 46 10) ; "You carefully write down the information in your notebook."
						(SetScore 152 5)
					)
					((== invItem 28) ; noteBook
						(Print 46 11) ; "You already have the information in your notebook."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Print 46 15) ; "You examine the knife wounds in the upper chest.  Leon will be able to tell you more about the wounds in the Coroner's report."
			)
			(2 ; Look
				(Print 46 1) ; "You look carefully at the knife wounds in the upper chest. Not a pretty sight. But it's the pentagram carved into the flesh that really hits you between the eyes."
			)
			(1 ; Walk
				(OutSide doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bodyhand of Feature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 151)
					(Print 46 5) ; "You already have the hair and skin sample."
				else
					(Print 46 6) ; "That is a good idea, but you'll need the proper equipment."
				)
			)
			(4 ; Inventory
				(if (== invItem 40) ; toothpick
					(cond
						((gEgo has: 33) ; skinHair
							(Print 46 5) ; "You already have the hair and skin sample."
						)
						((gEgo has: 42) ; sampleEnv
							(gCurRoom setScript: CheckHandsScript)
						)
						(else
							(Print 46 7) ; "That's a good idea, but you'll need to use the proper field equipment."
						)
					)
				)
			)
			(2 ; Look
				(handinset init:)
				(if (not (gEgo has: 33)) ; skinHair
					(Print 46 8) ; "Looking closely at the victim's hands, you notice what appears to be hair and skin imbedded under the fingernails."
				else
					(Print 46 9) ; "Looks like somebody attacked this guy with toothpicks."
				)
			)
			(1 ; Walk
				(OutSide doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance face of Feature
	(properties
		onMeCheck 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 46 16) ; "His face looks anything but peaceful."
			)
			(3 ; Do
				(Print 46 17) ; "That's a nasty habit!"
			)
			(4 ; Inventory
				(switch invItem
					(40 ; toothpick
						(Print 46 18) ; "I don't think he'd care to have his teeth picked right now."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(1 ; Walk
				(OutSide doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dumpster of Feature
	(properties
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 46 19) ; "What an awful smelly place to die."
			)
			(3 ; Do
				(Print 46 20) ; "You have plenty of trash at home."
			)
			(1 ; Walk
				(OutSide doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mOpenShirt of Sound
	(properties
		flags 1
		number 461
		priority 14
	)
)

(instance erieSound of Sound
	(properties
		flags 1
		number 503
	)
)

