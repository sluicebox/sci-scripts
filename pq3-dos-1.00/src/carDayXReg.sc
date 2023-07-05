;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 133)
(include sci.sh)
(use Main)
(use rm025)
(use carStuff)
(use Interface)
(use n882)
(use RandCycle)
(use Game)
(use Actor)
(use System)

(public
	carDayXReg 0
	carDayXCode 1
	scriptHook 2
	alleyScript 3
	patLeaveScript 4
	patPissedScript 5
)

(instance carDayXReg of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep (== newRoomNumber 25))
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)
)

(instance carDayXCode of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			(
				(or
					(and (== gDay 2) (IsFlag 60) (not (IsFlag 79)))
					(and (== gDay 4) (IsFlag 60) (not (IsFlag 84)))
					(and (== gDay 5) (IsFlag 60) (not (IsFlag 198)))
				)
				(scriptHook init: y: 1000 setScript: hospScript 0 0)
			)
			((and (== gDay 3) (IsFlag 61) (not (IsFlag 83)))
				(SetFlag 83)
				(scriptHook init: y: 1000 setScript: wareScript)
			)
			((and (== gDay 4) (IsFlag 62) (not (IsFlag 29)))
				(scriptHook init: y: 1000 setScript: trialScript)
			)
			((and (== gDay 4) (IsFlag 63) (not (IsFlag 80)))
				(scriptHook
					init:
					y: 1000
					setScript: alleyScript 0 (if (== gPrevRoomNum 204) 1 else 0) ; rmDmv
				)
			)
			(
				(or
					(and (== gDay 3) (IsFlag 90) (not (IsFlag 91)))
					(and
						(== gDay 4)
						(not (IsFlag 13))
						(IsFlag 80)
						(not (IsFlag 86))
					)
					(and (== gDay 4) (IsFlag 29) (not (IsFlag 86)))
					(and (== gDay 6) (IsFlag 202) (not (IsFlag 203)))
				)
				(HandsOff)
				(scriptHook init: y: 1000 setScript: patLeaveScript)
			)
			((and (== gDay 5) (IsFlag 64) (not (IsFlag 204)))
				(scriptHook init: y: 1000 setScript: nuggetScript)
			)
			((and (== gDay 6) (IsFlag 65) (not (IsFlag 36)))
				(scriptHook init: y: 1000 setScript: coronerScript)
			)
			((and (== gDay 6) (IsFlag 66))
				(scriptHook
					init:
					y: 1000
					setScript: burnScript 0 (if (== gPrevRoomNum 204) 1 else 0) ; rmDmv
				)
			)
			((and (== gDay 6) (IsFlag 67))
				(scriptHook init: y: 1000 setScript: crackScript)
			)
			((and (== gDay 6) (gEgo has: 9) (not (IsFlag 224))) ; judicialOrder
				(scriptHook init: y: 1000 setScript: judicRadioScript)
			)
			(
				(and
					(== gDay 6)
					(== gPrevRoomNum 55)
					(not (gEgo has: 8)) ; warrant
					(IsFlag 185)
				)
				(scriptHook init: y: 1000 setScript: warrantScript)
			)
		)
	)
)

(instance scriptHook of Prop
	(properties
		x 1000
		y -1000
		view 260
		loop 2
	)
)

(instance hospScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(Print 133 0) ; "*** the radio sez: go to the hospital."
				)
				(= cycles 1)
			)
			(1
				((ScriptID 130 4) number: 250 play:) ; carSong
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(2
				(if register
					(Print 133 1) ; "*** You better get to the hospital."
				)
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(if (== gDay 2)
					(scriptHook setScript: patLeaveScript)
				else
					(Print 133 2) ; "You decide not to go to the hospital to see Marie. The events of the day drained all your energy. You head for home and try to get some rest."
					(gCurRoom newRoom: 38)
				)
			)
		)
	)
)

(instance wareScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Print 133 3) ; "Sonny: "This Carla Reed lives on 325 South Second. That's not a residential area. This better not be someone's idea of a joke.""
				(Print 133 4) ; "Morales: "325 South Second!  That's just a bunch of old abandoned warehouses!""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(2
				(Print 133 5) ; "Morales: "I thought we were going to check out this Reed chick on 325 South Second!""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(self start: 2 init:)
			)
		)
	)
)

(instance trialScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(1
				(Print 133 6) ; "Morales: "Better not keep Judge Simpson waiting, Bonds.""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(2
				(Print 133 7) ; "Morales: "HEY! You gotta date with the judge, pal! Better get the lead out and get to the court house.""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(Print 133 8) ; "Morales: "Well, it's too late, the trial's over by now.""
				(SetFlag 29)
				(client setScript: patLeaveScript)
			)
		)
	)
)

(instance alleyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= cycles 1)
				else
					(= seconds 10)
				)
			)
			(1
				(if (not register)
					(Print 133 9) ; "The radio comes alive..."64 David, Lytton.""
					(Print 133 10) ; "Morales says..."This is 64 David, go ahead.""
					(Print 133 11) ; "Dispatch comes back and says..."187 in alley 300 block of west Rose. One traffic unit is 10-97""
					(Print 133 12) ; "Morales confirms the call..."Lytton, 64 David copies and we are responding.""
					(Print 133 13) ; "Well, you heard it, boss man!" she says... "Let's roll!"
				)
				(= cycles 1)
			)
			(2
				(proc130_14)
				((ScriptID 130 4) number: 250 play:) ; carSong
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(Print 133 14) ; "Morales: "Hey Bonds! You want me to drive us to the murder scene or what? Get out the map!""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(4
				(Print 133 15) ; "You have failed to report to the murder scene in a reasonable amount of time."
				(EgoDead 20) ; "Your failure to respond to the murder scene in the alley resulted in a suspension. An officer who doesn't report to assigned calls puts the public in danger!"
			)
		)
	)
)

(instance nuggetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Print 133 16) ; "Sonny: "According to the crime pattern, this serial killer will probably strike next somewhere around 200 East Palm.""
				(Print 133 17) ; "Morales: "As I recall, the only buildings on the 200 block of East Palm are some warehouses and the Nugget Saloon.""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(2
				(Print 133 18) ; "Morales: "Hey! I thought we were going to check out 200 East Palm!""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(self start: 2 init:)
			)
		)
	)
)

(instance coronerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(1
				(Print 133 19) ; "Morales: "So... we gonna pay the coroner a visit or just cruise all day?""
				(self init:)
			)
		)
	)
)

(instance burnScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(Print 133 20) ; "The car radio interrupts the silence:"
					(Print 133 21) ; "Dispatch: "Attention all units... there is a structure fire at 500 west Peach Ave. Any units in the vicinity please respond for crowd control assistance.""
				)
				(= cycles 1)
			)
			(1
				(if (not register)
					(Print 133 22) ; "Morales: "Hey! That's just a few blocks from here. Let's go to the weenie roast!""
				)
				(= cycles 1)
			)
			(2
				(if (not register)
					(Print 133 23) ; "Morales gets on the radio and informs dispatch that you are on the way."
				)
				((ScriptID 130 4) number: 250 play:) ; carSong
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(Print 133 24) ; "Morales: "Geez Sonny! They're gonna have the fire out before we ever get there. Maybe you should stop and look at the map.""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(4
				(Print 133 25) ; "You have failed to reach the burning house in a reasonable amount of time."
				(EgoDead 21) ; "Your failure to respond to the scene of the fire resulted in a suspension. An officer who doesn't report to assigned calls puts the public in danger!"
			)
		)
	)
)

(instance crackScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(1
				(Print 133 26) ; "Morales: "Are we going somewhere, or just joy ridin'?""
				(self init:)
			)
		)
	)
)

(instance judicRadioScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 224)
				(= seconds 5)
			)
			(1
				(Print 133 27) ; "Sonny picks up the mike: "Lytton 64 S2...""
				(Print 133 28) ; "Dispatch: "64 S2 Lytton go ahead...""
				(Print 133 29) ; "Sonny: "Requesting assistance in gaining access to a suspected crack house. Will need the ram unit and backup at 522 West Palm, over.""
				(Print 133 30) ; "Dispatch: "10-4, Sonny! They're on their way.""
			)
		)
	)
)

(instance warrantScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Print 133 31) ; "Sonny: "I think I've got enough evidence to obtain a search warrant.""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(2
				(Print 133 32) ; "Morales: "If you want that warrant, Bonds... you're going to half to see da judge.""
				(self start: 1 init:)
			)
		)
	)
)

(instance patLeaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(geek init: posn: 255 112)
				(Print 133 33) ; "You notice Morales checking her watch. She suddenly says..."
				(Say geek 133 34) ; "Yo, Sonny. Drive me over to the mall real quick, would ya?  I gotta make a phone call."
				(= seconds 8)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 1)
			)
			(3
				(geek dispose:)
				(= cycles 20)
			)
			(4
				(Print 133 35) ; "Grudgingly, you drive Morales to the mall."
				((ScriptID 25 1) ; mainInset
					lastX: 10
					lastY: 6
					heading: 90
					calcSpeed: 0
					curUnit: (/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
					whichBlocks:
					getStuff:
				)
				(proc25_4 0)
				(proc25_11)
				(SetFlag 59)
				(= cycles 3)
			)
			(5
				(patInset init:)
				(Say patInset 133 36 108) ; "Sit tight, boss! I'll only be a minute."
				(= seconds 4)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patMouth dispose:)
				((ScriptID 130 7) startUpd:) ; copCar
				(= cycles 2)
			)
			(7
				(= register gOverlays)
				(gCurRoom drawPic: 25 0)
				(if (!= register -1)
					(gCurRoom overlay: register 100)
				)
				(= cycles 5)
			)
			(8
				(if (!= gDay 4)
					((ScriptID 130 6) dispose:) ; purse
				)
				(patInset dispose:)
				(SetFlag 225)
				(= global134 0)
				(= seconds 2)
			)
			(9
				(if (== gDay 4)
					(Print 133 37) ; "She seems in an awful hurry this time. She's even neglected to take her purse with her."
				else
					(Print 133 38) ; "You notice that she's careful to take her purse with her."
				)
				((ScriptID 130 7) stopUpd:) ; copCar
				(proc130_14)
				(= seconds 10)
			)
			(10
				(= global110 10)
				(= seconds 100)
			)
			(11
				(= seconds 10)
			)
			(12
				(HandsOff)
				(patInset init:)
				(Say patInset 133 39 108) ; "See! I'm back! Let's go!"
				(= seconds 3)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patMouth dispose:)
				(= global134 1)
				((ScriptID 130 13) doit:) ; drawCelCode
				(if (not (gCast contains: (ScriptID 130 6))) ; purse
					((ScriptID 130 6) init: cel: (if (proc882_2 1) 1 else 0)) ; purse
				)
				(= cycles 2)
			)
			(14
				(HandsOff)
				(patInset dispose:)
				(if (proc882_2 1)
					(self setScript: patPissedScript)
				else
					(ClearFlag 59 196 225)
					(switch gDay
						(2
							(client setScript: stationScript)
						)
						(3
							(SetFlag 91)
							(client setScript: goHomeScript)
						)
						(4
							(SetFlag 86)
							(if (not (IsFlag 80))
								(proc25_8 31)
								(proc25_7 99 45 5 0)
								(client setScript: alleyScript)
							else
								(client setScript: stationScript)
							)
						)
						(6
							(SetFlag 203)
							(client setScript: stationScript)
						)
					)
				)
			)
		)
	)
)

(instance patPissedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(geek init: posn: 255 112)
				(Print 133 40) ; "Noticing her key missing, Pat says..."
				(Say geek 133 41) ; "Hey! What the.. where's my key. Whatcha doin' messing with my purse, Bonds?"
				(= seconds 8)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 1)
			)
			(3
				(EgoDead 0 133 42) ; "BUSTED! You die of embarrasment"
			)
		)
	)
)

(instance goHomeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global105 22)
				(= global106 0)
				(Print 133 43) ; "So ends another shift. You drop Pat off at the station and head home."
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance stationScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 133 44) ; "With nothing further to do, you head back to the station."
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance patInset of Prop
	(properties
		x 253
		y 125
		description {Pat Morales}
		view 27
		priority 14
		signal 16400
	)

	(method (init)
		(patMouth posn: x y setCycle: RandCycle init:)
		(pShirt posn: (+ x 2) (+ y 62) init:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(patMouth dispose:)
		(pShirt dispose:)
	)
)

(instance patMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16400
		cycleSpeed 4
	)
)

(instance pShirt of View
	(properties
		description {pat}
		view 27
		cel 1
		priority 15
		signal 16400
	)
)

(instance geek of View
	(properties
		view 268
		loop 1
	)
)

