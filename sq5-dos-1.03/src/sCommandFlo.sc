;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 216)
(include sci.sh)
(use Main)
(use rm201)
(use eureka)
(use Print)
(use Sound)
(use System)

(public
	sCommandFlo 0
	sTalkToFlo 1
)

(local
	local0
	local1
)

(procedure (localproc_0 param1)
	(if (IsFlag 30)
		(gMessager say: 28 0 4 (Random 1 3) param1)
	else
		(gMessager say: 28 0 3 (Random 1 3) param1)
	)
)

(procedure (localproc_1 param1)
	(if (IsFlag 30)
		(gMessager say: 4 0 3 (Random 1 3) param1)
	else
		(gMessager say: 4 0 4 (Random 1 3) param1)
	)
)

(procedure (localproc_2 param1)
	(cond
		((>= (eureka puke:) 4)
			(gMessager say: 18 0 16 1 (if argc param1 else 0)) ; "I'm getting a lot of feedback overload, sir. The com system is useless."
		)
		((IsFlag 61)
			(gMessager say: 18 0 13 1 (if argc param1 else 0)) ; "We're toast unless you think of something real quick, Captain."
		)
		((< gGarbagePickupCount 3)
			(if (IsFlag 31)
				(gMessager say: 25 0 21 1 (if argc param1 else 0) 202) ; "Our last orders were to proceed to garbage pickups at Gangularis, Peeyu, and Kiz Urazgubi."
			else
				(gMessager say: 18 0 4 (Random 1 3) (if argc param1 else 0))
			)
		)
		((not (IsFlag 30))
			(gMessager say: 25 0 22 1 (if argc param1 else 0) 202) ; "We've finished our mission, Captain. Let's take some R and R at the Space Bar."
		)
		((not (IsFlag 93))
			(gMessager say: 25 0 26 1 (if argc param1 else 0) 202) ; "Starcon has ordered us to proceed to Klorox II for an auxiliary garbage pickup, Captain."
		)
		((== gAct 1)
			(if (not (IsFlag 94))
				(gMessager say: 25 0 24 0 (if argc param1 else 0) 202) ; "Since we don't have any orders, I think we should try to check out the source of the Goliath's last transmission."
			else
				(gMessager say: 18 0 33 1 (if argc param1 else 0)) ; "Heavy jamming on all long range frequencies, Captain."
			)
		)
		((== gAct 2)
			(if (and (not (IsFlag 75)) (!= gEurekaLocation 8)) ; genetix environdome
				(gMessager say: 25 0 25 0 (if argc param1 else 0) 202) ; "We don't have any orders to cover this situation, Captain. I think we're on our own."
			else
				(gMessager say: 18 0 33 1 (if argc param1 else 0)) ; "Heavy jamming on all long range frequencies, Captain."
			)
		)
		((IsFlag 30)
			(gMessager say: 18 0 3 (Random 1 3) (if argc param1 else 0))
		)
		(else
			(gMessager say: 18 0 4 (Random 1 3) (if argc param1 else 0))
		)
	)
)

(instance sAbandonShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (eureka puke:) 4)
					(SetFlag 85)
					(SetScore 200 10)
					(gMessager say: 1 0 2 1 self) ; "You don't have to tell me twice, I'm outta here!"
				else
					(gMessager say: 1 0 1 1 self) ; "Are you kidding! NOW?! What in the Pleiades for?"
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sHailPlanet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 201 4) self 3) ; sBusyFlo
			)
			(1
				(switch gEurekaLocation
					(0 ; Nowhere
						(gMessager say: 20 0 32 1 self) ; "We can't transmit beyond the interior of the station while we're inside it, sir."
					)
					(3 ; ku
						(gMessager say: 20 0 31 1 self) ; "No response. The planet is not inhabited, sir."
					)
					(32
						(gMessager say: 20 0 29 1 self) ; "We're ordered to finish our garbage runs immediately, Captain."
					)
					(5 ; clorox2
						(if (IsFlag 30)
							(switch gAct
								(0
									(gMessager say: 20 0 27 1 self) ; "Strange, there's no response from the surface, Captain. Maybe we should call StarCon."
								)
								(else
									(gMessager say: 20 0 54 1 self) ; "No response from the planet, Captain."
								)
							)
						else
							(gMessager say: 20 0 27 2 self) ; "The colony isn't responding to our hails, Captain. They probably have better things to do than talk to us."
						)
					)
					(6 ; thrakus
						(cond
							((IsFlag 42)
								(gMessager say: 20 0 54 1 self) ; "No response from the planet, Captain."
							)
							((== gAct 1)
								(gMessager say: 20 0 30 1 self) ; "No response Captain. The only thing I'm picking up is an escape pod homing beacon on the surface."
							)
							((== gAct 2)
								(gMessager say: 21 0 33 1 self) ; "Unable to comply, Captain. All interplanetary communications are being jammed."
							)
							(else
								(gMessager say: 20 0 31 1 self) ; "No response. The planet is not inhabited, sir."
							)
						)
					)
					(7 ; genetix Space Lab
						(gMessager say: 20 0 28 1 self) ; "There's no further response from the facility, Captain."
					)
					(8 ; genetix environdome
						(gMessager say: 20 0 28 2 self) ; "There's no response, Captain. I don't think there's anyone down there."
					)
					(else
						(cond
							((OneOf gEurekaLocation 9 10 11 12 13) ; generic planet 1, genceric planet 2, generic planet 3, generic planet 4, generic planet 5
								(gMessager say: 20 0 31 1 self) ; "No response. The planet is not inhabited, sir."
							)
							((IsFlag 30)
								(gMessager say: 20 0 3 (Random 1 3) self)
							)
							(else
								(gMessager say: 20 0 4 (Random 1 3) self)
							)
						)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sHailShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gEurekaLocation 0) (IsFlag 34)) ; Nowhere
					(= cycles 1)
				else
					(self setScript: (ScriptID 201 4) self 1) ; sBusyFlo
				)
			)
			(1
				(switch gEurekaLocation
					(0 ; Nowhere
						(if (IsFlag 34)
							(gMessager say: 21 0 34 0 self) ; "Considering how poor your last effort was, sir, I suggest you stay off the com circuits for awhile."
						else
							(self setScript: (ScriptID 211 0) self) ; sQuirkStarCon
						)
					)
					(5 ; clorox2
						(if
							(and
								(not (IsFlag 92))
								(IsFlag 93)
								(< gAct 1)
							)
							(gMessager say: 21 0 0 1 self) ; "The SCS Goliath is responding, sir. Putting it on screen."
							(= local1 1)
						else
							(gMessager say: 21 0 3 3 self) ; "I can't reach anyone sir."
						)
					)
					(6 ; thrakus
						(cond
							((IsFlag 42)
								(if (eureka damaged:)
									(gMessager say: 21 0 20 1 self) ; "She's not responding sir."
								else
									(gMessager say: 21 0 22 1 self) ; "No response, Sir. Perhaps their com system is out."
								)
							)
							((IsFlag 33)
								(gMessager say: 21 0 33 1 self) ; "Unable to comply, Captain. All interplanetary communications are being jammed."
							)
							((IsFlag 30)
								(gMessager say: 21 0 3 (Random 1 3) self)
							)
							(else
								(gMessager say: 21 0 4 (Random 1 3) self)
							)
						)
					)
					(14 ; goliath
						(gMessager say: 21 0 33 1 self) ; "Unable to comply, Captain. All interplanetary communications are being jammed."
					)
					(else
						(if (IsFlag 30)
							(gMessager say: 21 0 3 (Random 1 3) self)
						else
							(gMessager say: 21 0 4 (Random 1 3) self)
						)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance starConMusic of Sound
	(properties)
)

(instance sHailStarcon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gEurekaLocation 0) (IsFlag 31)) ; Nowhere
					(= cycles 1)
				else
					(self setScript: (ScriptID 201 4) self 2) ; sBusyFlo
				)
			)
			(1
				(cond
					((== gEurekaLocation 0) ; Nowhere
						(if (IsFlag 31)
							(gMessager say: 22 0 36 1 self) ; "I've already done that, sir."
						else
							(gMessager say: 22 0 37 0 self) ; "We are cleared for departure, Captain."
							(= local0 1)
							(SetFlag 31)
						)
					)
					((== gEurekaLocation 5) ; clorox2
						(gNarrator keepWindow: 1)
						(gSq5Music2 setVol: 5)
						(starConMusic loop: -1 number: 223 play:)
						(gMessager say: 22 0 27 1 self) ; "You have reached StarCon Central Command. All our wavelengths are busy now, but if you stay on this frequency an operator will answer your call in the order it was received. Currently you are number 2,856,875,333."
					)
					((IsFlag 33)
						(gMessager say: 22 0 33 1 self) ; "Unable to comply, Captain. All interplanetary communications are being jammed."
					)
					((IsFlag 30)
						(gMessager say: 22 0 3 (Random 1 3) self)
					)
					(else
						(gMessager say: 22 0 4 (Random 1 3) self)
					)
				)
			)
			(2
				(gNarrator keepWindow: 0)
				(starConMusic dispose:)
				(gSq5Music2 setVol: 127)
				(self dispose:)
			)
		)
	)
)

(instance sCommandFlo of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc201_6 self)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982 1)
				(switch
					(Print
						mode: 1
						window: (ScriptID 205 0) ; commandWindow
						font: gUserFont
						width: 125
						addColorButton: 0 1 0 0 12 0 0 205 13 29 31 0 0 0 ; "Hail Ship"
						addColorButton: 1 1 0 0 13 0 10 205 13 29 31 0 0 0 ; "Hail Starcon"
						addColorButton: 2 1 0 0 14 0 20 205 13 29 31 0 0 0 ; "Hail Planet"
						addColorButton: 3 1 0 0 15 0 30 205 13 29 31 0 0 0 ; "Status Report"
						addColorButton: 4 1 0 0 16 0 40 205 13 29 31 0 0 0 ; "Act Busy"
						addColorButton: 5 1 0 0 17 0 50 205 13 29 31 0 0 0 ; "Abandon Ship"
						addColorButton: 6 1 0 0 18 0 60 205 13 29 31 0 0 0 ; "Cancel Order"
						init:
					)
					(0
						(gGame handsOff:)
						(self setScript: sHailShip self)
					)
					(1
						(gGame handsOff:)
						(self setScript: sHailStarcon self)
					)
					(2
						(gGame handsOff:)
						(self setScript: sHailPlanet self)
					)
					(3
						(gGame handsOff:)
						(localproc_2 self)
					)
					(4
						(gGame handsOff:)
						(localproc_0 self)
					)
					(5
						(gGame handsOff:)
						(self setScript: sAbandonShip self)
					)
					(6
						(gGame handsOff:)
						(localproc_1 self)
					)
					(else
						(gGame handsOff:)
						(= ticks 5)
					)
				)
			)
			(2
				(self setScript: (ScriptID 201 4) self 0) ; sBusyFlo
			)
			(3
				(gGame handsOff:)
				(cond
					((IsFlag 85)
						(= next (ScriptID 201 23)) ; sAbandonShip
						(self dispose:)
					)
					(local0
						(= local0 0)
						(= next (ScriptID 214 4)) ; sOpenDoors
						(self dispose:)
					)
					(local1
						(= next (ScriptID 211 2)) ; sQuirkClorox
						(self dispose:)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 4))
				(gGame setCursor: 984 1)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 205)
		(DisposeScript 216)
	)
)

(instance sTalkToFlo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(proc201_6 self)
			)
			(2
				(cond
					((== gEurekaLocation 0) ; Nowhere
						(self setScript: (ScriptID 220 1) self) ; sFStarconChoices
					)
					((== gSpikeState 1)
						(self setScript: (ScriptID 220 6) self) ; sFNoiseChoices
					)
					((and (not (IsFlag 30)) (< 8 gEurekaLocation 14)) ; genetix environdome, goliath
						(self setScript: (ScriptID 220 8) self) ; sFGenericChoices
					)
					((IsFlag 61)
						(gMessager say: 12 0 89 0 self 202) ; "Shouldn't you be going now, sir? I'll make sure your family is notified should anything unfortunate happen."
					)
					(
						(and
							(IsFlag 36)
							(not (IsFlag 30))
							(or
								(== (eureka prevLocation:) 2)
								(== (eureka curLocation:) 2) ; garbage2
							)
						)
						(self setScript: (ScriptID 220 4) self) ; sFAlienChoices
					)
					((and (IsFlag 30) (not (IsFlag 93)))
						(self setScript: (ScriptID 220 5) self) ; sFCloroxChoices
					)
					((and (== gEurekaLocation 5) (IsFlag 93) (not (IsFlag 76))) ; clorox2
						(if (IsFlag 92)
							(gMessager say: 12 0 61 0 self 202) ; "How may I help you, sir?"
						else
							(gMessager say: 12 0 62 0 self 202) ; "Any suggestions, Flo?"
						)
					)
					((and (== gAct 1) (not (IsFlag 94)))
						(self setScript: (ScriptID 220 13) self) ; sFAfterClorox
					)
					((and (== gEurekaLocation 15) (not (IsFlag 87))) ; empty space
						(gMessager say: 11 2 59 1 self 202) ; "Oh Captain, you've got to |f8|do|f| something! Cliffy's in trouble!"
					)
					((and (== gAct 2) (not (IsFlag 75)))
						(self setScript: (ScriptID 220 10) self) ; sFThrakusChoices
					)
					((>= (eureka puke:) 4)
						(gMessager say: 12 0 9 3 self 202) ; "My life stinks, and it's all your fault, sir."
					)
					((and (IsFlag 75) (!= gEurekaLocation 14)) ; goliath
						(self setScript: (ScriptID 220 12) self) ; sFBeforeGoliath
					)
					((and (IsFlag 75) (== gEurekaLocation 14)) ; goliath
						(gMessager say: 12 0 91 0 self 202) ; "We've got to stop the Goliath, sir--before it's too late."
					)
					(else
						(self setScript: (ScriptID 220 7) self) ; sFDefault
					)
				)
			)
			(3
				(self setScript: (ScriptID 201 4) self 0) ; sBusyFlo
			)
			(4
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 3))
				(gGame setCursor: 983 1)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 220)
		(DisposeScript 216)
	)
)

