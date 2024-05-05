;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use rm025)
(use Interface)
(use n882)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	carStuff 0
	lightBar 1
	lightFeat 2
	gloveBox 3
	carSong 4
	theTicket 5
	purse 6
	copCar 7
	trackInset 8
	speedo 9
	copBlip 10
	suspBlip 11
	siren 12
	drawCelCode 13
	proc130_14 14
)

(local
	[local0 26] = [8 -54 5 -54 2 -54 -2 -54 -2 -51 -2 -48 -2 -45 -2 -42 -2 -38 -6 -36 -11 -33 -16 -30 -20 -28]
	local26
	[local27 23] = [6 8 9 11 13 15 17 20 21 22 24 27 28 30 32 34 36 39 40 42 44 46 48]
	local50
)

(procedure (proc130_14)
	(HandsOn)
	(if (not (OneOf gDay 1 4))
		(gTheIconBar disable: 5)
	)
)

(instance carStuff of Rgn
	(properties)

	(method (dispose)
		(DisposeScript 882)
		(super dispose:)
	)

	(method (doit)
		(if (GameIsRestarting)
			(drawCelCode doit:)
		)
		(super doit:)
	)

	(method (init &tmp [temp0 2])
		(super init:)
		(if (> gDay 1)
			(ScriptID 882)
		)
		(if
			(or
				(and (> gDay 1) (!= gPrevRoomNum 12))
				(and (== gDay 1) (== gPrevRoomNum 12))
			)
			(gCurRoom overlay: 210)
		else
			(if (not (gEgo has: 10)) ; calibration
				(chart init: hide:)
			)
			(gloveBox init:)
			(hoodPiece init:)
		)
		(lightBar init: view: (copCar view:) z: 1000 hide:)
		(if (== gPrevRoomNum 31)
			(if (IsFlag 196)
				(= global134 1)
				(if (proc882_2 1)
					(= local50 1)
				else
					(= local50 3)
				)
			else
				(SetFlag 225)
				(= global134 0)
				(= local50 2)
			)
			(if (== gDay 4)
				(purse init: cel: (if (proc882_2 1) 1 else 0))
			)
		)
		(if (!= gPrevRoomNum 12)
			(if (== global134 1)
				(purse init: cel: (if (proc882_2 1) 1 else 0))
			)
			(drawCelCode doit:)
			(passengerFeat init:)
			(if (and (not (IsFlag 6)) (not (== (gLongSong number:) 460)))
				(carSong init: flags: 1 number: 290 play:)
			)
		)
		(if ((ScriptID 25 1) mySpeed:) ; mainInset
			(proc25_4 1)
		else
			(proc25_4 0)
		)
		(trackButt init:)
		(trackLight init:)
		(if (IsFlag 213)
			(trackButt doVerb: 3)
		)
		(speedo init:)
		(lightFeat init:)
		(keyFeat init:)
		(compFeat init:)
		(trackFeat init:)
		(cond
			((== gDay 1)
				((ScriptID 132 1) doit:) ; carDay1Code
			)
			((== local50 1)
				(HandsOff)
				((ScriptID 133 2) init: y: 1000 setScript: (ScriptID 133 5)) ; scriptHook, patPissedScript
			)
			((== local50 2)
				((ScriptID 133 4) start: 11) ; patLeaveScript
				((ScriptID 133 2) init: y: 1000 setScript: (ScriptID 133 4)) ; scriptHook, patLeaveScript
			)
			((== local50 3)
				((ScriptID 133 4) start: 14) ; patLeaveScript
				((ScriptID 133 2) init: y: 1000 setScript: (ScriptID 133 4)) ; scriptHook, patLeaveScript
			)
			((== global111 1234)
				(= global111 0)
				((ScriptID 133 4) start: 11) ; patLeaveScript
				((ScriptID 133 2) init: y: 1000 setScript: (ScriptID 133 4)) ; scriptHook, patLeaveScript
			)
			(else
				(cond
					((not (IsFlag 51)) 0)
					((== ((gInventory at: 22) owner:) 47) ; tracker
						(suspBlip
							init:
							setCycle: Fwd
							z: (if (IsFlag 213) 0 else 1000)
							setScript: trackScript 0 global159
						)
					)
					(else
						((ScriptID 133 2) ; scriptHook
							init:
							y: 1000
							setScript: noTrackScript
						)
					)
				)
				(if (!= gPrevRoomNum 12)
					((ScriptID 133 1) doit:) ; carDayXCode
				)
			)
		)
		(if (and (== gPrevRoomNum 204) (IsFlag 209)) ; rmDmv
			(lightFeat doVerb: 3)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (== newRoomNumber 25))
		(= initialized 0)
		(= global129 ((ScriptID 25 1) lastX:)) ; mainInset
		(= global130 ((ScriptID 25 1) lastY:)) ; mainInset
		(= global131 ((ScriptID 25 1) mySpeed:)) ; mainInset
		(= global132 ((ScriptID 25 1) heading:)) ; mainInset
		(= global133 ((ScriptID 25 1) curUnit:)) ; mainInset
		(if ((ScriptID 25 1) leftFlag:) ; mainInset
			(SetFlag 208)
		else
			(ClearFlag 208)
		)
		(if (== gDay 1)
			(if
				(and
					(IsObject ((ScriptID 129 3) script:)) ; suspCar
					(!= ((ScriptID 129 3) script:) (ScriptID 129 12)) ; suspCar, pullOverScript
				)
				(= global154 ((ScriptID 129 3) x:)) ; suspCar
				(= global136 ((ScriptID 129 3) y:)) ; suspCar
				(= global153 ((ScriptID 129 3) cel:)) ; suspCar
				(= global135
					(switch ((ScriptID 129 3) script:) ; suspCar
						((ScriptID 129 0) 1) ; speederScript
						((ScriptID 129 1) 2) ; lowRiderScript
						((ScriptID 129 2) 3) ; drunkScript
						((ScriptID 132 2) 5) ; ladyCallScript
						((ScriptID 129 13) 6) ; alliedScript
						((ScriptID 129 4) ; setUpScript
							(switch (((ScriptID 129 3) script:) register:) ; suspCar
								((ScriptID 129 0) 10) ; speederScript
								((ScriptID 129 1) 20) ; lowRiderScript
								((ScriptID 129 2) 30) ; drunkScript
								((ScriptID 132 2) 50) ; ladyCallScript
								((ScriptID 129 13) 60) ; alliedScript
							)
						)
					)
				)
			else
				(= global154 (= global136 (= global153 -1)))
				(= global135 0)
			)
		)
		(if (and (== newRoomNumber 204) (IsFlag 225)) ; rmDmv
			(= global111 1234)
		)
		(if (== newRoomNumber 31)
			(= global131 0)
		)
		(if (and (== newRoomNumber 204) (gCast contains: trackInset)) ; rmDmv
			(SetFlag 213)
		else
			(ClearFlag 213)
		)
		(if (gCast contains: theTicket)
			(if (== newRoomNumber 29)
				(Print 130 0) ; "You tear the ticket off the computer."
			else
				(Print 130 1) ; "Before exiting, you grab the ticket and the license."
			)
			(theTicket dispose:)
			(gEgo get: 24) ; ticket
		)
		(if (suspBlip script:)
			(if (== ((suspBlip script:) state:) 0)
				(= global159 (+ ((suspBlip script:) register:) 1))
			else
				(= global159 ((suspBlip script:) register:))
			)
			(if (>= global159 25)
				(= global159 99)
			)
		)
		(if (and (IsFlag 209) (== newRoomNumber 29))
			(ClearFlag 209)
		)
		(gLongSong number: 0)
		(super newRoom: newRoomNumber)
	)
)

(instance carSong of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance drawCelCode of Code
	(properties)

	(method (doit)
		((ScriptID 25 5) forceUpd:) ; streetFrame
		(switch global134
			(0
				(return)
			)
			(1
				(DrawCel 269 0 0 169 76 -1)
			)
			(2
				(DrawCel 271 0 0 175 76 -1)
			)
			(3
				(DrawCel 270 0 0 178 74 -1)
			)
		)
	)
)

(instance hoodPiece of View
	(properties
		x 205
		view 263
		cel 2
		priority 6
		signal 24593
	)
)

(instance speedo of Prop
	(properties
		y 66
		view 261
		loop 1
		signal 26640
	)

	(method (init)
		(super init:)
		(ones init:)
		(tens init:)
		(huns init:)
	)

	(method (cue &tmp temp0)
		(= x (+ 38 (* (/ ((ScriptID 25 1) mySpeed:) 5) 2))) ; mainInset
		(huns cel: (if (< (= temp0 ((ScriptID 25 1) mySpeed:)) 100) 10 else 1)) ; mainInset
		(cond
			((< temp0 10)
				(tens cel: 10)
			)
			((> temp0 99)
				(tens cel: 0)
			)
			(else
				(tens cel: (/ temp0 10))
			)
		)
		(ones cel: (if (== (* 10 (/ temp0 10)) temp0) 0 else 5))
	)
)

(instance ones of Prop
	(properties
		x 48
		y 65
		view 261
		loop 2
	)

	(method (doit)
		(super doit:)
		(if (and (not z) (not ((ScriptID 25 1) engineOn:))) ; mainInset
			(= z 1000)
		)
		(if (and z ((ScriptID 25 1) engineOn:)) ; mainInset
			(= z 0)
		)
	)
)

(instance tens of Prop
	(properties
		x 44
		y 65
		view 261
		loop 2
	)
)

(instance huns of Prop
	(properties
		x 40
		y 65
		view 261
		loop 2
	)
)

(instance gloveBox of View
	(properties
		x 251
		y 90
		description {glove compartment}
		lookStr {Wow!__A glove box.__How unusual.}
		view 261
		loop 4
		priority 7
		signal 24592
	)

	(method (setCel param1)
		(if (gCast contains: chart)
			(chart hide:)
		)
		(super setCel: param1)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (& (chart signal:) $0080))
					(Print 130 2) ; "The glove compartment contains miscellaneous car records.  In particular, you notice a record file of some sort."
				else
					(Print 130 3) ; "The glove compartment contains miscellaneous car records."
				)
			)
			(3 ; Do
				(if (not ((ScriptID 25 1) engineOn:)) ; mainInset
					(if (= cel (not cel))
						(Print 130 4) ; "You reach over and open the glove compartment."
						(chart show:)
						(gloveSound number: 257 play:)
					else
						(Print 130 5) ; "You reach over and close the glove compartment."
						(chart hide:)
						(gloveSound number: 258 play:)
					)
					(self forceUpd:)
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance gloveSound of Sound
	(properties)
)

(instance chart of View
	(properties
		x 226
		y 87
		description {speedometer calibration chart}
		lookStr {It's a speedometer calibration chart - a service record for this car's speedometer.__Departmental policy requires that all speedometers be calibrated every 90 days.}
		view 261
		loop 4
		cel 2
		priority 8
		signal 24593
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (or (not (IsFlag 28)) (IsFlag 29) (IsFlag 146))
					(Print 130 6) ; "You should leave that with the vehicle unless you have a specific need for it."
				else
					(self dispose:)
					(gEgo get: 10) ; calibration
					(SetScore 146 5)
					(Print 130 7) ; "Thinking about your upcoming court appearance, you wisely decide to take the speedometer calibration chart with you."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance theTicket of Prop
	(properties
		x 162
		y 100
		description {It's a traffic citation.}
		lookStr { It's a traffic citation.}
		view 267
		loop 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 130 8) ; "You pull the ticket and the license out of the computer."
				(gEgo get: 24) ; ticket
				(self dispose:)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance trackInset of View
	(properties
		x 85
		y 180
		view 262
		priority 13
		signal 16400
	)

	(method (init)
		(super init:)
		(cond
			((!= ((gInventory at: 22) owner:) 47) 0) ; tracker
			((IsObject (suspBlip script:))
				(suspBlip z: 0)
			)
			((IsFlag 31) 0)
		)
		(copBlip init: setCycle: Fwd)
	)

	(method (handleEvent))

	(method (dispose)
		(suspBlip z: 1000)
		(copBlip dispose:)
		(super dispose:)
	)
)

(instance copBlip of Prop
	(properties
		lookStr {Your car}
		view 262
		loop 1
		priority 14
		signal 16400
	)

	(method (doit &tmp temp0 [temp1 10])
		(= x (+ (- (trackInset x:) 58) (* 7 ((ScriptID 25 1) lastX:)))) ; mainInset
		(= y (+ (- (trackInset y:) 66) (* 6 ((ScriptID 25 1) lastY:)))) ; mainInset
		(= temp0 ((ScriptID 25 1) heading:)) ; mainInset
		(if (not ((ScriptID 25 1) freewayFlag:)) ; mainInset
			(switch temp0
				(0
					(if
						(<
							((ScriptID 25 1) curUnit:) ; mainInset
							(/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
						)
						(-= y 3)
					)
				)
				(180
					(if
						(>=
							((ScriptID 25 1) curUnit:) ; mainInset
							(/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
						)
						(+= y 3)
					)
				)
				(90
					(if
						(>=
							((ScriptID 25 1) curUnit:) ; mainInset
							(/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
						)
						(+= x 4)
					)
				)
				(270
					(if
						(<
							((ScriptID 25 1) curUnit:) ; mainInset
							(/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
						)
						(-= x 4)
					)
				)
			)
		else
			(switch temp0
				(90
					(if
						(>
							((ScriptID 25 1) curUnit:) ; mainInset
							(/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
						)
						(+= x 4)
						(-= y [local27 (- (* ((ScriptID 25 1) lastX:) 2) 1)]) ; mainInset
					else
						(-= y [local27 (- (* ((ScriptID 25 1) lastX:) 2) 2)]) ; mainInset
					)
				)
				(270
					(if
						(<
							((ScriptID 25 1) curUnit:) ; mainInset
							(/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
						)
						(-= x 4)
						(-= y [local27 (- (* ((ScriptID 25 1) lastX:) 2) 3)]) ; mainInset
					else
						(-= y [local27 (- (* ((ScriptID 25 1) lastX:) 2) 2)]) ; mainInset
					)
				)
			)
			(cond
				((!= ((ScriptID 25 1) lastY:) 10) 0) ; mainInset
				((and (< ((ScriptID 25 1) lastX:) 2) (== temp0 270)) ; mainInset
					(= x (- (trackInset x:) 51))
					(= y (- (trackInset y:) 12))
				)
				((and (> ((ScriptID 25 1) lastX:) 11) (== temp0 90)) ; mainInset
					(= x (+ (trackInset x:) 26))
					(= y (- (trackInset y:) 54))
				)
			)
		)
		(super doit:)
	)
)

(instance trackScript of Script
	(properties)

	(method (init)
		(if (== global159 99)
			(= start 2)
			(suspBlip
				x: (+ (trackInset x:) [local0 24])
				y: (+ (trackInset y:) [local0 25])
			)
		)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					x: (+ (trackInset x:) [local0 register])
					y: (+ (trackInset y:) [local0 (++ register)])
				)
				(= seconds 2)
			)
			(1
				(if (> (++ register) 25)
					(if (gCast contains: trackInset)
						(Print 130 9) ; "The blip has stopped on the freeway."
					)
					(gLongSong fade:)
					(SetFlag 88)
					((ScriptID 133 2) init: y: 1000 setScript: crashTimerScript) ; scriptHook
				else
					(self init:)
				)
			)
		)
	)
)

(instance noTrackScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(gLongSong fade: self)
			)
			(2
				(crashTimerScript start: 2)
				((ScriptID 133 2) setScript: crashTimerScript) ; scriptHook
			)
		)
	)
)

(instance crashTimerScript of Script
	(properties)

	(method (doit)
		(if
			(and
				(OneOf state 1 2)
				(== ((ScriptID 25 1) lastY:) 10) ; mainInset
				(or
					(and
						(== ((ScriptID 25 1) heading:) 90) ; mainInset
						(== ((ScriptID 25 1) lastX:) 5) ; mainInset
						(>
							((ScriptID 25 1) curUnit:) ; mainInset
							(/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
						)
					)
					(and
						(== ((ScriptID 25 1) heading:) 270) ; mainInset
						(== ((ScriptID 25 1) lastX:) 6) ; mainInset
						(<
							((ScriptID 25 1) curUnit:) ; mainInset
							(- ((ScriptID 25 1) maxUnits:) 1) ; mainInset
						)
					)
				)
			)
			(HandsOff)
			(if (== ((ScriptID 25 1) heading:) 270) ; mainInset
				(Print 130 10) ; "Up ahead you see a car overturned in the middle of the freeway.  You slow to a stop."
			else
				(Print 130 11) ; "Up ahead you see a car overturned on the other side of the freeway. You turn around and slow to a stop."
			)
			(self start: 4 init:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(carSong init: flags: 1 number: 250 play:)
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(2
				(ClearFlag 88)
				(Print 130 12) ; "The car radio interrupts the silence:"
				(Print 130 13) ; "Dispatch says..."64 David.""
				(Print 130 14) ; "Morales responds..."This is 64 David, go ahead with your traffic.""
				(Print 130 15) ; "Respond to an 11-44, west bound on the freeway just east of the Lilly off ramp."
				(Print 130 16) ; "Continuing she says..."Be advised this is your possible suspect vehicle.""
				(Print 130 17) ; "Your partner acknowledges the call and says... "Get this puppy rolling Bonds!""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(Print 130 18) ; "You have failed to respond to the Freeway accident in a reasonable amount of time."
				(EgoDead 0 130 19) ; "Another case of dereliction of duty!"
			)
			(4
				(if (not ((ScriptID 25 1) mySpeed:)) ; mainInset
					(= global127 6)
					(self dispose:)
					(gCurRoom newRoom: 880) ; crash
				else
					(= start state)
					((ScriptID 25 1) ; mainInset
						calcSpeed: (- ((ScriptID 25 1) mySpeed:) 5) ; mainInset
					)
					(= cycles 3)
				)
			)
			(5
				(self init:)
			)
		)
	)
)

(instance suspBlip of Prop
	(properties
		lookStr {Tracking device}
		view 262
		loop 2
		priority 14
		signal 16400
	)
)

(instance trackButt of Prop
	(properties
		x 141
		y 42
		description {tracker screen activation button}
		lookStr {This button activates the tracker.}
		view 267
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (not (gCast contains: trackInset))
					(if ((ScriptID 25 1) engineOn:) ; mainInset
						(trackInset init: stopUpd:)
						(trackLight cue:)
					else
						(Print 130 20) ; "The engine must be running to use the tracker."
					)
				else
					(trackInset dispose:)
					(trackLight cue:)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance trackLight of Prop
	(properties
		x 141
		y 47
		description {light bulb}
		lookStr {The small light indicates that the tracker is activated.}
		view 267
		loop 1
		signal 24577
	)

	(method (cue)
		(= cel (not cel))
		(self forceUpd:)
	)
)

(instance lightFeat of Feature
	(properties
		description {light/siren switch}
		onMeCheck 4
		lookStr {This button controls the emergency lights and siren.}
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(3 ; Do
				(if (= local26 (not local26))
					(if ((ScriptID 25 1) engineOn:) ; mainInset
						(lightBar setCycle: Fwd z: 0)
						(if (and (!= gDay 1) (not (IsFlag 209)))
							(Print 130 21) ; "Pat places the portable red light on the dash."
						)
						(siren play:)
						(SetFlag 209)
					else
						(= local26 (not local26))
						(super doVerb: theVerb invItem)
					)
				else
					(ClearFlag 209)
					(siren fade:)
					(lightBar setCycle: 0 z: 1000)
					(if (not ((ScriptID 25 1) engineOn:)) ; mainInset
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance keyFeat of Feature
	(properties
		nsTop 83
		nsLeft 67
		nsBottom 98
		nsRight 84
		description {ignition key}
		lookStr {An ignition key}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					(((ScriptID 25 1) mySpeed:) ; mainInset
						(Print 130 22) ; "Turning the engine off while you're moving is not a good idea, Sonny."
					)
					(
						(and
							(gEgo has: 23) ; license
							(OneOf ((gInventory at: 23) state:) 1 2) ; license
						)
						(Print 130 23) ; "You need to return the driver's license first."
					)
					((and (== ((gInventory at: 2) owner:) 885) (not (IsFlag 16))) ; handcuff
						(Print 130 24) ; "You left the drunk standing by his car in your handcuffs!"
					)
					((IsFlag 225)
						(Print 130 25) ; "Better wait for your partner."
					)
					((== gPrevRoomNum 12)
						(if (== gDay 1)
							(Print 130 26) ; "You must have forgotten about being temporarily assigned to traffic division. You'll have to drive the black and white today, Sonny."
						else
							(Print 130 27) ; "You're a homicide detective now. You don't drive a black and white anymore."
						)
					)
					((not ((ScriptID 25 1) engineOn:)) ; mainInset
						(keySound play:)
						(proc25_4 1)
					)
					(else
						(proc25_4 0)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance keySound of Sound
	(properties
		number 704
	)
)

(instance compFeat of Feature
	(properties
		nsTop 99
		nsLeft 132
		nsBottom 138
		nsRight 190
		description {computer}
		lookStr {It's a computer.__Lytton sure is going high-tech.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== gPrevRoomNum 12)
					(super doVerb: theVerb invItem)
				else
					(gCurRoom newRoom: 204) ; rmDmv
				)
			)
			(4 ; Inventory
				(switch invItem
					(23 ; license
						(cond
							(
								(or
									(gCast contains: theTicket)
									(gEgo has: 24) ; ticket
								)
								(Print 130 28) ; "You already have the ticket."
							)
							((== ((gInventory at: 23) state:) 3) ; license
								(Print 130 29) ; "A ticket isn't going to keep this guy from killing someone on the road. You're going to have to take him downtown."
							)
							(else
								(Print 130 30) ; "You insert the driver's license into the slot.  This activates the computer."
								((gInventory at: 23) owner: 204) ; license
								(gCurRoom newRoom: 204) ; rmDmv
							)
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lightBar of Prop
	(properties
		loop 2
		priority 5
		signal 2064
		cycleSpeed 3
	)

	(method (doit)
		(if ((ScriptID 25 2) z:) ; roadInset
			(return)
		)
		(self x: (copCar x:) y: (- (copCar y:) 13))
		(if (and (not (copCar cel:)) (& signal $0008))
			(self show:)
		)
		(if (and (copCar cel:) (not (& signal $0008)))
			(self hide:)
		)
		(if
			(and
				(== gDay 1)
				(not cycler)
				((ScriptID 25 1) tZone:) ; mainInset
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
		)
		(if
			(and
				(== gDay 1)
				cycler
				(not ((ScriptID 25 1) tZone:)) ; mainInset
				((ScriptID 25 1) freewayFlag:) ; mainInset
				(or
					(and
						(== ((ScriptID 25 1) heading:) 90) ; mainInset
						(> ((ScriptID 25 1) lastX:) 11) ; mainInset
					)
					(and
						(== ((ScriptID 25 1) heading:) 270) ; mainInset
						(< ((ScriptID 25 1) lastX:) 2) ; mainInset
					)
				)
			)
			((ScriptID 25 1) tZone: 1) ; mainInset
		)
		(super doit:)
	)
)

(instance siren of Sound
	(properties
		flags 1
		number 945
		loop -1
	)
)

(instance passengerFeat of Feature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch global134
					(0
						(super doVerb: theVerb invItem)
					)
					(1
						(Print 130 31) ; "It's your partner, Pat Morales."
					)
					(2
						(Print 130 32) ; "It's your buddy, Mr. Loony Tunes!"
					)
					(3
						(Print 130 33) ; "It's your buddy, Mr."But I only had one beer!""
					)
				)
			)
			(5 ; Talk
				(switch global134
					(0
						(super doVerb: theVerb invItem)
					)
					(1
						(switch (Random 0 4)
							(0
								(Print 130 34) ; "Morales says..."Some day, eh, Sonny?""
							)
							(1
								(Print 130 35) ; "Morales teasingly says..."Ya drive like my Grandma, Bonds.""
							)
							(2
								(Print 130 36) ; "Morales says..."Ya tryin' ta rack up points for pedestrians, or what, Bonds?""
							)
							(3
								(Print 130 37) ; "Morales says..."If ya want me to drive, jus' holler.""
							)
							(4
								(Print 130 38) ; "Excitedly, Morales says..."Did ya see that gorgeous hunka man back there?""
							)
						)
					)
					(2
						(switch (Random 0 2)
							(0
								(Print 130 39) ; "Out of his head, the prisoner says..."Cold!  I'm so f@!#ing cold! Who let the fire go out, for C#$%@ sake?""
							)
							(1
								(Print 130 40) ; "Deliriously, the prisoner says..."I wasn't doin' nothin'. I wasn't the one! Oh, no, don't look at me!""
							)
							(2
								(Print 130 41) ; "The prisoner rambles incoherently..."Don't put that on me. I ain't got nuthin', I told yas.""
							)
						)
					)
					(3
						(if (not ((ScriptID 25 1) mySpeed:)) ; mainInset
							(Print 130 42) ; "The driver says..."This isn't nessethary, Occifer. I'm perfectedly fine.""
						else
							(switch (Random 0 2)
								(0
									(Print 130 43) ; "The driver says..."This isn't nessethary occifer. I'm perfectedly fine.""
								)
								(1
									(Print 130 44) ; "The driver says..."Could you schlow it down, pleasse, Doc? My head is schpinning.""
								)
								(2
									(Print 130 45) ; "The driver says..."We juss passsed my place there. Maybe you could juss drop me off...?""
								)
							)
						)
					)
				)
			)
			(1 ; Walk
				((ScriptID 25 6) doVerb: theVerb) ; theRoom
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance purse of View
	(properties
		x 158
		y 179
		description {Pat's purse}
		lookStr {Pat's purse rests between the seats.}
		view 268
		priority 7
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (proc882_2 1)
					(Print lookStr)
				else
					(Print 130 46) ; "Pat's purse rests between the seats. She keeps a key attached to the handle."
				)
			)
			(3 ; Do
				(cond
					((== global134 1)
						(Print 130 47) ; "You can't just take the key with Pat sitting there."
					)
					((proc882_2 1)
						(Print 130 48) ; "You already have the key. Don't mess with her purse anymore."
					)
					(else
						(proc882_0 1)
						(SetScore 147 5)
						(Print 130 49) ; "You take the key, knowing that it'll have to be returned before Morales notices that it's gone."
						(self setCel: 1)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(3 ; theKeys
						(if (proc882_2 1)
							(Print 130 50) ; "In the nick of time, you replace Morales' key and hope she doesn't notice anything funny."
							(proc882_1 1)
							(SetScore 149 1)
							(self setCel: 0)
							(gTheIconBar curIcon: (gTheIconBar at: 2))
							(gGame setCursor: 20)
						else
							(super doVerb: theVerb invItem)
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance trackFeat of Feature
	(properties
		description {tracking screen}
		onMeCheck 32
		lookStr {It's a tracking screen.__This device allows you to track a person, vehicle, or any other moving object that a tracking device has been attached to.}
	)
)

(instance radioFeat of Feature ; UNUSED
	(properties
		description {police radio}
		onMeCheck 64
		lookStr {It's a police radio.}
	)
)

(instance copCar of Actor
	(properties
		priority 4
		signal 30736
		cycleSpeed 2
		moveSpeed 2
	)

	(method (doit)
		(super doit:)
		(cond
			(
				(or
					(!= gDay 1)
					(and
						(IsFlag 211)
						(not (IsFlag 16))
						(not (IsFlag 68))
						(not (gCast contains: (ScriptID 129 3))) ; suspCar
					)
					(and
						(IsFlag 211)
						(not (IsFlag 16))
						(not (IsFlag 68))
						(== ((ScriptID 129 3) script:) (ScriptID 129 12)) ; suspCar, pullOverScript
					)
					script
				)
				(return)
			)
			(
				(and
					(IsFlag 211)
					(not (IsFlag 16))
					(not (IsFlag 68))
					(gCast contains: (ScriptID 129 10)) ; genCar4
					((ScriptID 25 1) leftFlag:) ; mainInset
					(< (- nsTop 14) ((ScriptID 129 10) y:)) ; genCar4
					(> y ((ScriptID 129 3) nsTop:)) ; suspCar
				)
				(self setScript: (ScriptID 25 3) 0 0) ; changeLanes
				((ScriptID 25 1) calcSpeed: 35) ; mainInset
			)
			(
				(or
					(and
						(IsFlag 211)
						(not (IsFlag 16))
						(not (IsFlag 68))
						(== x ((ScriptID 129 3) x:)) ; suspCar
					)
					(and
						(IsFlag 211)
						(not (IsFlag 16))
						(not (IsFlag 68))
						(== ((ScriptID 129 3) script:) (ScriptID 129 2)) ; suspCar, drunkScript
					)
				)
				(if
					(or
						(and
							(> y ((ScriptID 129 3) y:)) ; suspCar
							(< (- nsTop 7) ((ScriptID 129 3) y:)) ; suspCar
							(>
								((ScriptID 25 1) mySpeed:) ; mainInset
								(((ScriptID 129 3) script:) register:) ; suspCar
							)
						)
						(and
							(< y ((ScriptID 129 3) y:)) ; suspCar
							(> (+ y 7) ((ScriptID 129 3) nsTop:)) ; suspCar
							(<
								((ScriptID 25 1) mySpeed:) ; mainInset
								(((ScriptID 129 3) script:) register:) ; suspCar
							)
						)
					)
					((ScriptID 25 1) ; mainInset
						calcSpeed: (((ScriptID 129 3) script:) register:) ; suspCar
					)
				)
			)
			(
				(and
					(IsFlag 211)
					(not (IsFlag 16))
					(not (IsFlag 68))
					(> x ((ScriptID 129 3) x:)) ; suspCar
					(< nsLeft (+ ((ScriptID 129 3) nsRight:) 5)) ; suspCar
					(or
						(== y ((ScriptID 129 3) y:)) ; suspCar
						(and
							(> y ((ScriptID 129 3) y:)) ; suspCar
							(< nsTop (+ ((ScriptID 129 3) y:) 7)) ; suspCar
						)
						(and
							(< y ((ScriptID 129 3) y:)) ; suspCar
							(> y (- ((ScriptID 129 3) nsTop:) 7)) ; suspCar
						)
					)
				)
				(self setScript: (ScriptID 25 3) 0 0) ; changeLanes
			)
			(
				(and
					(IsFlag 211)
					(not (IsFlag 16))
					(not (IsFlag 68))
					(< x ((ScriptID 129 3) x:)) ; suspCar
					(> nsRight (- ((ScriptID 129 3) nsLeft:) 5)) ; suspCar
					(or
						(== y ((ScriptID 129 3) y:)) ; suspCar
						(and
							(> y ((ScriptID 129 3) y:)) ; suspCar
							(< nsTop (+ ((ScriptID 129 3) y:) 7)) ; suspCar
						)
						(and
							(< y ((ScriptID 129 3) y:)) ; suspCar
							(> y (- ((ScriptID 129 3) nsTop:) 7)) ; suspCar
						)
					)
				)
				(self setScript: (ScriptID 25 3) 0 1) ; changeLanes
			)
		)
	)
)

