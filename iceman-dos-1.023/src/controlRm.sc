;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n385)
(use Submarine_806)
(use n821)
(use n823)
(use n828)
(use n954)
(use LoadMany)
(use n962)
(use RFeature)
(use Avoid)
(use Extra)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	controlRm 0
	captain 1
	sitControlPanelScript 2
	egosControlScript 3
	controlPanelChair 4
	goToANewRoomScript 5
	ladderFeat 6
	scopeProp2 7
)

(local
	local0
)

(instance controlRm of Rm
	(properties
		picture 25
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 232 133 25 125 225 525)
		(LoadMany rsSCRIPT 385 390 391 393 394)
		(gEgo init: setScript: egosControlScript)
		(proc823_0)
		(HandsOn)
		(gAddToPics
			add:
				rail1Pic
				rail2Pic
				chairPic
				mapPic
				cornerPic
				mapTable
				scopePic
				mapOnWallPic
				crewMember
				scopePic2
				controlPanelPic
				poleToRailPic
			doit:
		)
		(switch gPrevRoomNum
			(27 ; controlPanel
				(gEgo
					setScript:
						(switch ((subMarine script:) state:)
							(1 shouldHaveDroveScript)
							(2
								(ScriptID 395) ; goodJobScript
							)
							(7
								(ScriptID 345) ; goBridgeScript
							)
							(14
								(ScriptID 338) ; finalliScript
							)
							(else standUpScript)
						)
				)
			)
			(28 ; bridgeRm
				(self setScript: (ScriptID 391 1)) ; captainfallsScript
			)
			(26 ; scopeViewRm
				(if (== ((subMarine script:) state:) 14)
					(captain init: setScript: (ScriptID 337)) ; diversionScript
				)
				((if (== (gEgo x:) 104) scopeProp else scopeProp2)
					setScript: downScopeScript
				)
			)
			(31 ; egosQuartersRm
				(gEgo
					posn: 45 178
					heading: 0
					loop: 6
					setScript:
						(if (== ((subMarine script:) state:) 0)
							(ScriptID 390) ; greetingScript
						else
							egosControlScript
						)
				)
			)
			(30 ; captsQuartersRm
				(gEgo posn: 25 177 heading: 90 loop: 0)
			)
			(40 ; chartRm
				(if (== ((subMarine script:) state:) 5)
					(captain
						init:
						posn: 214 100
						heading: 180
						loop: 2
						illegalBits: 0
					)
					(gEgo setScript: (ScriptID 336)) ; mapDoneScript
				)
			)
			(else
				(gEgo view: 232 posn: 69 100 loop: 0 heading: 90)
				(if (and (== ((subMarine script:) state:) 6) (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					(self setScript: (ScriptID 346)) ; fromGalleyScript
				)
			)
		)
		(self
			setFeatures: mapTable ladderFeat crewMember stairFeat
			setRegions: 314 ; subMarine
		)
		(if
			(not
				(= local0
					(or
						(OneOf
							((subMarine script:) state:)
							0
							2
							5
							6
							7
							13
							11
							9
							10
							12
							13
							14
							8
						)
						(== gPrevRoomNum 27) ; controlPanel
					)
				)
			)
			(gEgo observeControl: 8192)
		)
		(if (!= gPrevRoomNum 27) ; controlPanel
			(controlPanelChair init:)
		)
		(scopeProp init:)
		(scopeProp2 init:)
		(leftArms init: isExtra: 1)
		(rightArms init: isExtra: 1)
		(turningProp init: setCycle: Fwd isExtra: 1)
		(rowOfLights init: setCycle: Fwd isExtra: 1)
		(scanningProp init: setCycle: Fwd isExtra: 1)
		(viewerProp init: setCycle: Fwd isExtra: 1)
		(rotateCap init: setCycle: Fwd isExtra: 1)
		(redCap init: setCycle: Fwd isExtra: 1)
		(redCap2 init: setCycle: Fwd isExtra: 1)
		(rotatingGauge init: setCycle: Fwd isExtra: 1)
		(rotatingGauge2 init: setCycle: Fwd isExtra: 1)
		(rotatingGauge3 init: setCycle: Fwd isExtra: 1)
		(anotherGauge init: setCycle: Fwd isExtra: 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<around][/room]')
				(Print 25 0) ; "You're standing in the "Control Room" of the USS Blackhawk."
				(Print 25 1) ; "The "Control Room" is the command center of the boat. It is equipped with the necessary systems for navigation and combat."
				(Print 25 2) ; "A passageway leads to the Captain's quarters and the Executive Officer's quarters."
			)
			((Said 'examine')
				(Print 25 3) ; "All systems are functional."
			)
		)
	)

	(method (dispose)
		(LoadMany 0 395 391 393 390 394)
		(proc0_3)
		(gEgo illegalBits: $8000)
		(super dispose:)
	)
)

(instance goToANewRoomScript of Script
	(properties
		cycles 2
	)

	(method (changeState newState)
		(if (= state newState)
			(gCurRoom newRoom: register)
		)
	)
)

(instance standUpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: (ScriptID 394) self) ; getUpScript
			)
			(1
				(gEgo setScript: egosControlScript)
			)
		)
	)
)

(instance captain of Act
	(properties
		view 133
	)
)

(instance egosControlScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (User controls:)
			(switch (gEgo onControl: 1)
				(-32768
					(return)
				)
				(16384
					(gEgo setScript: walkDownStairsScript)
				)
				(4096
					(gEgo setScript: (ScriptID 393)) ; climbLadderScript
				)
				(8192
					(gEgo setScript: sitControlPanelScript)
				)
				(2048
					(gCurRoom newRoom: 31) ; egosQuartersRm
				)
				(1024
					(gCurRoom newRoom: 30) ; captsQuartersRm
				)
			)
		)
	)
)

(instance walkDownStairsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreControl: -16384 setMotion: MoveTo 67 103 self)
			)
			(1
				(gEgo setMotion: MoveTo 43 120 self)
			)
			(2
				(gCurRoom newRoom: 32) ; galleyRm
			)
		)
	)
)

(instance sitControlPanelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 187 80 self
				)
			)
			(1
				(gEgo loop: 6 cel: 3)
				(= cycles 2)
			)
			(2
				(controlPanelChair hide:)
				(gEgo
					view: 325
					loop: 1
					cel: 0
					posn: 209 80
					setCycle: End self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 27) ; controlPanel
			)
		)
	)
)

(instance mapTable of RPicView
	(properties
		y 146
		x 159
		view 25
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/map,table,course[<map,chart]]>')
				(cond
					((TurnIfSaid self event))
					((GoToIfSaid self event self 30 0 25 4))
					((Said 'look,draw,use')
						(gCurRoom newRoom: 40) ; chartRm
					)
				)
			)
		)
	)
)

(instance mapOnWallPic of PV
	(properties
		y 94
		x 270
		z 20
		view 25
		loop 1
		cel 2
		priority 1
		signal 16384
	)
)

(instance scopePic2 of PV
	(properties
		y 112
		x 110
		view 25
		loop 2
		priority 7
	)
)

(instance scopePic of PV
	(properties
		y 100
		x 144
		view 25
		loop 2
		cel 1
		priority 6
	)
)

(instance scopeProp of Prop
	(properties
		y 112
		x 110
		view 25
		loop 3
		priority 7
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'raise,up/periscope') (Said 'periscope<use'))
				(cond
					((scopeProp2 cel:)
						(Print 25 5) ; "You can't look through two scopes at once."
					)
					((& (Submarine flags:) $0010)
						(Print 25 6) ; "The observation scope has been rendered inoperable."
					)
					((>= (Submarine _depth:) 70)
						(Print 25 7) ; "The sub is too deep."
					)
					((<= (Submarine hSpeed:) 12)
						(if cel
							(Print 25 8) ; "It's up."
						else
							(self setCycle: End self)
						)
					)
					((& (subMarine roomFlags:) $0200)
						(Print 25 9) ; "You were warned about the speed limit for the observation scope. Now it is inoperable."
						(Submarine flags: (| (Submarine flags:) $0010))
					)
					(else
						(Print 25 10) ; "Severe damage will occur when raising the observation scope at speeds in excess of 12 knots."
						(subMarine roomFlags: (| (subMarine roomFlags:) $0200))
					)
				)
			)
			((Said 'lower,down/periscope')
				(if cel
					(self setCycle: Beg self)
					(HandsOff)
				else
					(Print 25 11) ; "It's down."
				)
			)
			((Said 'look/periscope')
				(if cel
					(self setScript: lookScopeScript)
				else
					(Print 25 12) ; "This is the observation scope."
				)
			)
		)
	)

	(method (cue)
		(HandsOn)
		(if cel
			(QueScript self watchSpeedScript 0 12)
		)
		(self stopUpd:)
	)
)

(instance scopeProp2 of Prop
	(properties
		y 100
		x 145
		view 25
		loop 3
		priority 6
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'raise,up/periscope') (Said 'periscope<use'))
				(cond
					((scopeProp cel:)
						(Print 25 5) ; "You can't look through two scopes at once."
					)
					((& (Submarine flags:) $0020)
						(Print 25 13) ; "The attack scope has been rendered inoperable."
					)
					((<= (Submarine hSpeed:) 5)
						(if cel
							(Print 25 8) ; "It's up."
						else
							(self setCycle: End self)
						)
					)
					((>= (Submarine _depth:) 70)
						(Print 25 7) ; "The sub is too deep."
					)
					((& (subMarine roomFlags:) $0100)
						(Print 25 14) ; "You were warned about the speed limit for the attack scope. It is now inoperable."
						(Submarine flags: (| (Submarine flags:) $0020))
					)
					(else
						(Print 25 15) ; "Severe damage will occur when raising the attack scope at speeds in excess of 5 knots."
						(subMarine roomFlags: (| (subMarine roomFlags:) $0100))
					)
				)
			)
			((Said 'lower,down/periscope')
				(if cel
					(HandsOff)
					(self setCycle: Beg self)
				else
					(Print 25 11) ; "It's down."
				)
			)
			((Said 'look/periscope')
				(if cel
					(self setScript: lookScopeScript)
				else
					(Print 25 16) ; "This is the attack scope."
				)
			)
		)
	)

	(method (cue)
		(HandsOn)
		(if cel
			(QueScript self watchSpeedScript 0 5)
		)
		(self stopUpd:)
	)
)

(instance mapPic of PV
	(properties
		y 98
		x 56
		view 25
		loop 1
		priority 0
		signal 16384
	)
)

(instance cornerPic of PV
	(properties
		y 75
		x 130
		view 25
		loop 1
		cel 1
		priority 0
		signal 16384
	)
)

(instance chairPic of PV
	(properties
		y 89
		x 72
		view 25
		cel 1
		priority 5
		signal 16384
	)
)

(instance rail1Pic of PV
	(properties
		y 108
		x 30
		view 25
		cel 2
		priority 7
		signal 16384
	)
)

(instance rail2Pic of PV
	(properties
		y 116
		x 58
		view 25
		cel 3
		priority 8
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[/stair]')
				(Print 25 17) ; "The stairwell leads down to the galley."
			)
		)
	)
)

(instance poleToRailPic of PV
	(properties
		y 108
		x 73
		view 25
		cel 5
		priority 7
	)
)

(instance turningProp of Prop
	(properties
		y 48
		x 84
		view 125
		priority 3
		signal 16384
	)
)

(instance rowOfLights of Prop
	(properties
		y 65
		x 54
		view 125
		loop 1
		priority 3
		signal 16384
	)
)

(instance scanningProp of Prop
	(properties
		y 74
		x 30
		view 125
		loop 2
		priority 3
		signal 16384
	)
)

(instance viewerProp of Prop
	(properties
		y 74
		x 17
		view 125
		loop 3
		priority 3
		signal 16384
	)
)

(instance rotateCap of Extra
	(properties
		y 54
		x 45
		view 125
		loop 4
		priority 3
		signal 16896
		maxPause 100
		minCycles 10
		maxCycles 60
	)
)

(instance redCap2 of Extra
	(properties
		y 53
		x 55
		view 125
		loop 6
		priority 2
		signal 16896
		maxPause 100
		minCycles 10
		maxCycles 60
	)
)

(instance redCap of Extra
	(properties
		y 52
		x 64
		view 125
		loop 5
		priority 3
		signal 16896
		maxPause 100
		minCycles 10
		maxCycles 60
	)
)

(instance leftArms of Prop
	(properties
		view 25
		loop 6
	)

	(method (init)
		(super init:)
		(self
			setScript: sonarMansArmScript
			setPri: 4
			posn: (- (chairPic x:) 4) (- (chairPic y:) 18)
			ignoreActors: 1
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/harbor,rig,distance,sonarman,[man][<sonar]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look')
						(Print 25 18) ; "This is the sonar man."
					)
					((GoToIfSaid self event self 40 0 25 4))
					((Said 'talk')
						(if (== ((subMarine script:) state:) 14)
							(Print 25 19) ; ""What can I do for you, Sir," the sonar man replies."
						else
							(Print 25 20) ; "The sonar man is too busy for chatting right now."
						)
					)
					((Said 'get/distance/!*')
						(Print 25 21) ; "To what?"
					)
					(
						(or
							(Said 'ping/rig[<oil]')
							(Said 'get/distance/rig[<oil]')
						)
						(if (== ((subMarine script:) state:) 14)
							(Print 25 22) ; ""Yes sir,", the sonar man replies."
							(Print 25 23) ; "The oil rig is approximately 2850 yds. from us, Sir."
							(SetScore subMarine 407 256 1)
						else
							(Print 25 24) ; "No fix possible at this time."
						)
					)
					((or (Said 'ping/harbor') (Said 'get/distance/harbor'))
						(if (== ((subMarine script:) state:) 14)
							(Print 25 25) ; ""Already calculated, Sir,", the sonar man replies."
							(Print 25 26) ; "The harbor entrance is 1640 yds. away."
							(SetScore subMarine 407 512 1)
						else
							(Print 25 24) ; "No fix possible at this time."
						)
					)
				)
			)
		)
	)
)

(instance rightArms of Prop
	(properties
		view 25
		loop 7
	)

	(method (init)
		(super init:)
		(self
			setPri: 4
			posn: (- (chairPic x:) 4) (- (chairPic y:) 18)
			ignoreActors: 1
		)
	)
)

(instance crewMember of RPicView
	(properties
		y 76
		x 129
		view 25
		cel 4
		priority 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'read,decode/message')
				(Print 25 27) ; "You will need to utilize available decoding methods in order to read coded messages."
			)
			((Said '[/message,radioman,operator,man[<radio]]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((GoToIfSaid self event self 30 0 25 4))
					((Said 'look[<at]')
						(Print 25 28) ; "You see the radio operator who is busy monitoring his instrument panels."
					)
					((or (Said 'talk') (Said '/message'))
						(Print 25 29) ; "The radio jockey responds..."
						(if
							(+
								(proc385_0 6 0)
								(proc385_0 10 4)
								(proc385_0 12 8)
							)
							(switch ((subMarine script:) state:)
								(6
									(SetScore subMarine 406 -32768 1)
								)
								(10
									(SetScore subMarine 407 64 1)
									(subMarine cue:)
								)
								(12
									(SetScore subMarine 407 128 1)
									(subMarine cue:)
								)
							)
						else
							(Print 25 30) ; "Good day, Commander," he says, "No messages at this time, Sir."
						)
						(DisposeScript 385)
					)
				)
			)
		)
	)
)

(instance controlPanelChair of View
	(properties
		y 80
		x 209
		view 125
		loop 8
		priority 5
	)

	(method (init)
		(super init: &rest)
		(if local0
			(self view: 125 loop: 8 cel: 0)
		else
			(self view: 325 loop: 1 cel: 8)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/chair,panel[<control]]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 25 31) ; "This is the control panel chair for the USS Blackhawk."
					)
					((GoToIfSaid self event self 20 'sit' 25 4))
					((Said 'sit')
						(if local0
							(gEgo setScript: sitControlPanelScript)
						else
							(Print 25 32) ; "The control panel is being operated by another officer right now."
						)
					)
				)
			)
		)
	)
)

(instance controlPanelPic of PV
	(properties
		y 92
		x 203
		view 225
		priority 4
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[/panel,console]')
				(Print 25 33) ; "You are standing next to the Ship's Guidance Control Station."
			)
		)
	)
)

(instance sonarMansArmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rightArms stopUpd:)
				(leftArms stopUpd:)
				(= seconds (Random 5 10))
			)
			(1
				(rightArms hide:)
				(leftArms show: setCycle: End self)
			)
			(2
				(leftArms stopUpd:)
				(= seconds (Random 1 4))
			)
			(3
				(leftArms setCycle: Beg self)
			)
			(4
				(leftArms stopUpd:)
				(= seconds (Random 5 10))
			)
			(5
				(leftArms hide:)
				(rightArms show: setCycle: End self)
			)
			(6
				(rightArms stopUpd:)
				(= seconds (Random 1 4))
			)
			(7
				(rightArms setCycle: Beg self)
			)
			(8
				(self init: client)
			)
		)
	)
)

(instance lookScopeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: Avoid
					setMotion: MoveTo (- (client x:) 6) (+ (client y:) 4) self
				)
			)
			(1
				(client stopUpd:)
				(gEgo
					view: 25
					loop: 4
					heading: 0
					cel: 0
					setAvoider: 0
					setCycle: End self
				)
			)
			(2
				(gCurRoom newRoom: 26) ; scopeViewRm
			)
		)
	)
)

(instance downScopeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setCel: (client lastCel:))
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo view: 232 loop: 3 setCycle: Walk)
				(client setCycle: Beg self)
			)
			(2
				(HandsOn)
				(client stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance rotatingGauge of Prop
	(properties
		y 48
		x 74
		view 125
		loop 7
		priority 1
		signal 16384
		cycleSpeed 2
	)
)

(instance rotatingGauge2 of Prop
	(properties
		y 58
		x 25
		view 125
		loop 9
		priority 2
		signal 16384
	)
)

(instance rotatingGauge3 of Extra
	(properties
		y 60
		x 92
		view 525
		priority 2
		signal 16896
		maxPause 100
		minCycles 10
		maxCycles 60
	)
)

(instance anotherGauge of Prop
	(properties
		y 56
		x 125
		view 25
		loop 8
		priority 2
		signal 16384
	)
)

(instance shouldHaveDroveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: (ScriptID 394) self) ; getUpScript
			)
			(1
				(EgoDead 918 0 0 25 34) ; "Leaving your post too soon has jeopardized the mission."
			)
		)
	)
)

(instance ladderFeat of Feature
	(properties
		y 90
		x 298
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/ladder]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look')
						(Print 25 35) ; "This ladder takes you through a watertight hatch that opens onto the bridge."
					)
					((GoToIfSaid self event x y 'climb[<up]' 25 4))
					((Said 'climb[<up]')
						(gEgo setScript: (ScriptID 393)) ; climbLadderScript
					)
				)
			)
		)
	)
)

(instance stairFeat of Feature
	(properties
		y 98
		x 76
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/stair>')
				(cond
					(
						(GoToIfSaid
							self
							event
							self
							2
							'walk,climb,down[<down]/*'
							25
							4
						))
					((Said 'walk,climb,down[<down]/*')
						(gEgo setMotion: MoveTo 67 103)
					)
				)
			)
		)
	)
)

(instance watchSpeedScript of Script
	(properties)

	(method (doit)
		(if (and (not state) (> (Submarine hSpeed:) register))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(Print 25 36) ; "You were going too fast for the scope. Although you are able to bring the scope back down, it is now inoperable."
				(if (== register 12)
					(subMarine roomFlags: (| (subMarine roomFlags:) $0200))
					(Submarine flags: (| (Submarine flags:) $0010))
				else
					(subMarine roomFlags: (| (subMarine roomFlags:) $0100))
					(Submarine flags: (| (Submarine flags:) $0020))
				)
				(client setCycle: Beg client)
			)
		)
	)
)

