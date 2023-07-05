;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm019 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 49]
	[local55 50]
	[local105 50]
	local155
)

(procedure (localproc_0 param1 param2)
	(if (< global598 16)
		(= param2 15)
	)
	(= local1
		(Display param1 dsWIDTH 135 dsALIGN alCENTER dsCOORD 168 12 dsCOLOR param2 dsBACKGROUND 0 dsFONT 600 dsSAVEPIXELS)
	)
)

(procedure (localproc_1 param1)
	(Display 19 1 dsRESTOREPIXELS param1)
	(RedrawCast)
)

(procedure (localproc_2)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(RedrawCast)
)

(instance rm019 of Rm
	(properties
		picture 19
		picAngle 1
	)

	(method (init &tmp [temp0 50])
		(HandsOff)
		(User mapKeyToDir: 0)
		(self setRegions: 701) ; travrg
		(HandsOff)
		(if (> global598 4)
			(Load rsPIC 191)
		else
			(Load rsPIC 300)
		)
		(Load rsVIEW 49)
		(Load rsVIEW 50)
		(Load rsVIEW 212)
		(Load rsSOUND 25)
		(super init:)
		(if (and (== global214 75) (not global217))
			(= global161 3)
			(= global162 7)
			(= global163 3)
			(= global164 7)
			(= global213 75)
		)
		(controls add: scanBut courseBut returnBut eachElementDo: #init draw:)
		(self setScript: rmScript)
		(scanner play:)
	)

	(method (doit)
		(if global167
			(gCurRoom newRoom: 17)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp [temp0 100])
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
	)

	(method (newRoom newRoomNumber)
		(scanner stop:)
		(HandsOn)
		(User mapKeyToDir: 1)
		(gTimers eachElementDo: #dispose 84)
		(if local2
			(localproc_1 local2)
			(= local2 0)
		)
		(if local1
			(localproc_1 local1)
			(= local1 0)
		)
		(if local3
			(localproc_2 local3)
			(= local3 0)
		)
		(if local4
			(localproc_1 local4)
			(= local4 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scanBut state: 0 draw:)
				(courseBut state: 0 draw:)
				(returnBut state: 0 draw:)
				(= cycles 6)
			)
			(1
				(if (> global598 4)
					(gCurRoom overlay: 191 1)
				else
					(gCurRoom overlay: 300 1)
				)
				(= cycles 2)
			)
			(2
				(= local2
					(Display
						19
						0
						dsWIDTH
						135
						dsALIGN
						alCENTER
						dsCOORD
						168
						3
						dsCOLOR
						14
						dsBACKGROUND
						0
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(scanBut state: 1 draw:)
				(courseBut draw:)
				(returnBut state: 1 draw:)
				(scanBox init:)
				(you init:)
				(= cycles 2)
			)
			(3
				(if global217
					(= local2
						(Display
							(Format @local55 {DESTINATION: SECTOR %d} global217)
							dsWIDTH
							135
							dsALIGN
							alCENTER
							dsCOORD
							168
							3
							dsCOLOR
							9
							dsBACKGROUND
							0
							dsFONT
							600
							dsSAVEPIXELS
						)
					)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance scanScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(if local2
					(localproc_1 local2)
					(= local2 0)
				)
				(cond
					(
						(and
							(!= global213 39)
							(!= global213 62)
							(!= global213 82)
							(!= global213 69)
						)
						(self changeState: 2)
					)
					((and (== global213 69) (not global256))
						(self changeState: 2)
					)
					(local0
						(= local0 0)
						(self changeState: 2)
					)
					(else
						(if
							(!=
								local5
								(Format @local105 {SCANNING SECTOR %d} global213)
							)
							(= local5
								(Format @local105 {SCANNING SECTOR %d} global213)
							)
							(if local1
								(localproc_1 local1)
								(= local1 0)
							)
						)
						(scanBox setCycle: Fwd)
						(scanBut state: 0 cel: 2 draw:)
						(returnBut state: 0 cel: 1 draw:)
						(= cycles 10)
					)
				)
			)
			(1
				(localproc_0
					(Format @local105 {SCANNING SECTOR %d} global213)
					14
				)
				(gCurRoom setScript: zoomScript)
			)
			(2
				(= cycles 1)
			)
			(3
				(if (< global213 108)
					(++ global213)
				else
					(= global213 1)
				)
				(= global164 (/ global213 12))
				(if (> (= global163 (- global213 (* global164 12))) 0)
					(++ global164)
				else
					(= global163 12)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance zoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scanBut cel: 2 state: 0 draw:)
				(returnBut cel: 1 state: 0 draw:)
				(courseBut cel: 1 state: 0 draw:)
				(scanBox
					setLoop:
						(cond
							((== global213 82) 1)
							((== global213 39) 2)
							((== global213 62) 3)
							((== global213 69) 5)
						)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(you hide:)
			)
			(1
				(returnBut cel: 0 state: 1 draw:)
				(courseBut cel: 0 state: 1 draw:)
				(scanBut cel: 1 state: 1 draw:)
				(Timer setCycle: self 2)
			)
			(2
				(if local1
					(localproc_1 local1)
					(= local1 0)
				)
				(= global193 1)
				(= local3
					(Print
						(cond
							((== global213 39) {NAME:\n PLANET PHLEEBHUT\nSECTOR: 39\n\nLIGHT ATMOSPHERE\n1 KNOWN SETTLEMENT})
							((== global213 62) {NAME:\n MONOLITH BURGER FAST FOOD DIVE\nSECTOR: 62\n\nA FINITE\nNUMBER SERVED})
							((== global213 69) {NAME:\n PESTULON\nSECTOR: 69\nHABITANTS: UNKNOWN\nSURFACE UNCHARTED.\nIT FIGURES...})
							((== global213 82) {NAME:\n PLANET ORTEGA\nSECTOR: 82\nHABITANTS: UNKNOWN\nVOLCANIC CRATER-STREWN\nSURFACE})
						)
						100
						(if (< global163 7)
							(+ (* (- global163 1) 25) 62)
						else
							(- (* (- global163 1) 25) 111)
						)
						(+ (* (- global164 1) 18) 6)
						105
						600
						91
					)
				)
			)
			(3
				(scanBox setCycle: Beg self)
				(if local3
					(localproc_2 local3)
					(= local3 0)
				)
				(= global193 0)
			)
			(4
				(scanBox setLoop: 0)
				(= local0 1)
				(gCurRoom setScript: scanScript)
				(you show:)
			)
		)
	)
)

(instance courseScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 49])
		(switch (= state newState)
			(0
				(if local2
					(localproc_1 local2)
					(= local2 0)
				)
				(= global162 (/ global214 12))
				(if (> (= global161 (- global214 (* global162 12))) 0)
					(++ global162)
				else
					(= global161 12)
				)
				(if (> global163 global161)
					(= global165 1)
				)
				(if (< global163 global161)
					(= global165 -1)
				)
				(if (== global163 global161)
					(= global165 0)
				)
				(if (> global164 global162)
					(= global166 1)
				)
				(if (< global164 global162)
					(= global166 -1)
				)
				(if (== global164 global162)
					(= global166 0)
				)
				(= seconds 2)
			)
			(1
				(= temp0
					(if (== global213 global214)
						{COURSE ALREADY ACHIEVED}
					else
						{STANDBY\nCALCULATING COURSE}
					)
				)
				(if (!= global213 global214)
					(= global217 global213)
				)
				(if local1
					(localproc_1 local1)
					(= local1 0)
				)
				(= local4
					(Display
						temp0
						dsWIDTH
						135
						dsALIGN
						alCENTER
						dsCOORD
						168
						3
						dsCOLOR
						14
						dsBACKGROUND
						0
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(if (== temp0 {COURSE ALREADY ACHIEVED})
					(scanBut state: 0)
					(gCurRoom newRoom: 17)
				)
				(= seconds 3)
			)
			(2
				(if local4
					(localproc_1 local4)
					(= local4 0)
				)
				(if (!= global213 global214)
					(= cycles 2)
				)
			)
			(3
				(= local4
					(Display
						{COURSE LOCKED}
						dsWIDTH
						135
						dsALIGN
						alCENTER
						dsCOORD
						168
						3
						dsCOLOR
						9
						dsBACKGROUND
						0
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(4
				(if local4
					(localproc_1 local4)
					(= local4 0)
				)
				(= cycles 1)
			)
			(5
				(localproc_1
					(Format @local55 {DESTINATION: SECTOR %d} global217)
				)
				(= global220 local155)
				(gCurRoom newRoom: 17)
			)
		)
	)
)

(instance scanBut of DIcon
	(properties
		state 1
		nsTop 3
		nsLeft 7
		key 49
	)

	(method (init)
		(super init:)
		(= view (if (> global598 4) 49 else 149))
	)

	(method (doit)
		(self cel: 3 state: 0 draw:)
		(courseBut state: 0 cel: 1 draw:)
		(returnBut state: 0 cel: 1 draw:)
		(if (< (scanBox cel:) 2)
			(scanBox startUpd: setLoop: 0 setCel: 0 setCycle: 0)
			(= local155 global220)
			(= global220 0)
			(gCurRoom setScript: scanScript)
		else
			(zoomScript changeState: 3)
		)
	)
)

(instance courseBut of DIcon
	(properties
		nsTop 3
		nsLeft 60
		key 50
		loop 3
		cel 1
	)

	(method (init)
		(super init:)
		(= view (if (> global598 4) 49 else 149))
	)

	(method (doit)
		(if (!= global213 global214)
			(self cel: 2 state: 0 draw:)
			(scanBut state: 0 cel: 2 draw:)
			(returnBut state: 0 cel: 1 draw:)
		)
		(gCurRoom setScript: courseScript)
	)
)

(instance returnBut of DIcon
	(properties
		state 1
		nsTop 3
		nsLeft 113
		key 51
		loop 4
	)

	(method (init)
		(super init:)
		(= view (if (> global598 4) 49 else 149))
	)

	(method (doit)
		(self cel: 2 state: 0 draw:)
		(courseBut state: 0 cel: 1 draw:)
		(scanBut state: 0 cel: 2 draw:)
		(gCurRoom newRoom: 17)
	)
)

(instance scanBox of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 50
			posn: (+ (* (- global163 1) 25) 22) (+ (* (- global164 1) 18) 32)
			setPri: 13
			setCel: 0
			setLoop: 0
			ignoreActors: 1
		)
	)

	(method (doit)
		(super doit:)
		(self posn: (+ (* (- global163 1) 25) 22) (+ (* (- global164 1) 18) 32))
	)
)

(instance you of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 50
			posn: (+ (* (- global161 1) 25) 22) (+ (* (- global162 1) 18) 32)
			setPri: 14
			setLoop: 4
			ignoreActors: 1
		)
	)

	(method (doit)
		(super doit:)
		(self posn: (+ (* (- global161 1) 25) 22) (+ (* (- global162 1) 18) 32))
	)
)

(instance scanner of Sound
	(properties
		number 25
		priority 1
		loop -1
	)
)

