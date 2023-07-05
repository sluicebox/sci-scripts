;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5150)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm5150 0
)

(local
	local0
)

(instance rm5150 of KQRoom
	(properties
		picture 5150
	)

	(method (init)
		(super init:)
		(SetFlag 21)
		(gGame handsOn:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 171 137 166 124 54 124 43 137
					yourself:
				)
				((Polygon new:) type: PContainedAccess init: 47 65 38 89 78 91 68 64 yourself:)
				((Polygon new:) type: PContainedAccess init: 35 36 36 39 95 0 90 0 yourself:)
		)
		(westFront init:)
		(eastFront init:)
		(mySouthExit init:)
		(gEgo init: normalize: posn: 115 130 disableHotspot:)
		(Load rsVIEW (if (== gValOrRoz -3) 5154 else 5152)) ; Roz
		(gMouseDownHandler add: self)
		(cond
			((== gPrevRoomNum 5100)
				(gEgo posn: 119 195 setScaler: Scaler 80 80 160 0)
				(self setScript: removeMask)
			)
			((== gPrevRoomNum 5200)
				(gEgo posn: 262 77 setScaler: Scaler 72 45 126 78)
				(self setScript: fromPowderRoom)
			)
			((== gPrevRoomNum 5250)
				(gEgo
					view: (if (== gValOrRoz -3) 5154 else 5152) ; Roz
					setLoop: 3 1
					posn: 211 47
					setScaler: Scaler 74 74 153 46
				)
				(self setScript: fromOffice)
			)
			(else
				(gEgo setScaler: Scaler 80 80 160 0)
			)
		)
		(gKqMusic1 number: 5150 setLoop: -1 play:)
	)

	(method (handleEvent event)
		(if local0
			(event claimed: 1)
			(return)
			(super handleEvent: event &rest)
		else
			(event claimed: 0)
			(return)
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(gKqMusic1 fade:)
		(gEgo enableHotspot:)
		(if (gMouseDownHandler contains: gCurRoom)
			(gMouseDownHandler delete: gCurRoom)
		)
		(if (gWalkHandler contains: gCurRoom)
			(gWalkHandler delete: gCurRoom)
		)
		(super dispose:)
	)
)

(instance removeMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: Scaler 80 80 160 0
					setMotion: MoveTo 119 129 self
				)
			)
			(1
				(gEgo normalize: setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToTownHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gChapter 3)
					(Load rsVIEW 5309)
				)
				(self cue:)
			)
			(1
				(if (== gChapter 3)
					(gEgo
						setScale: 0
						view: 5309
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					normalize: 2
					setScaler: Scaler 80 80 160 0
					view:
						(cond
							((== gChapter 3) 9050)
							((== gValOrRoz -4) 800) ; Val
							(else 836)
						)
					setMotion: PolyPath 119 149 self
				)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 190 self)
			)
			(4
				(gCurRoom newRoom: 5100)
			)
		)
	)
)

(instance goToUpsideStairsEastB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 59 129 self)
			)
			(1
				(gEgo
					setScale: 0
					posn: 61 131
					view: (if (== gValOrRoz -3) 5154 else 5152) ; Roz
					setLoop: 1 1
					setCel: 0
					setCycle: Fwd
					setPri: 120
					setMotion: MoveTo 0 100 self
				)
			)
			(2
				(gEgo hide:)
				(= seconds 3)
			)
			(3
				(gEgo
					show:
					posn: 321 94
					setLoop: 3
					setCel: 0
					setPri: 60
					setCycle: Fwd
					setMotion: MoveTo 288 65 self
				)
			)
			(4
				(gEgo setCycle: 0)
				(westFront dispose:)
				(eastFront dispose:)
				(mySouthExit dispose:)
				(= local0 1)
				(gMouseDownHandler delete: gCurRoom)
				(gWalkHandler add: gCurRoom)
				(upsideDownEastB init:)
				(upsideDownEastT init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToUpsideDownWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(gMouseDownHandler delete: gCurRoom)
				(gWalkHandler add: gCurRoom)
				(westFront dispose:)
				(eastFront dispose:)
				(mySouthExit dispose:)
				(gEgo setMotion: PolyPath 170 132 self)
			)
			(1
				(gEgo
					setScale: 0
					posn: 163 135
					view: (if (== gValOrRoz -3) 5154 else 5152) ; Roz
					setLoop: 0 1
					setCel: 0
					setCycle: Fwd
					setPri: 158
					setMotion: MoveTo 298 195 self
				)
			)
			(2
				(gEgo hide:)
				(= seconds 3)
			)
			(3
				(gEgo
					show:
					posn: 109 0
					setLoop: 3 1
					setCel: 0
					setPri: -1
					setCycle: Fwd
					setScaler: Scaler 72 72 153 46
					setMotion: MoveTo 72 27 self
				)
			)
			(4
				(gEgo setCycle: 0)
				(upsideDownLT init:)
				(upsideDownLB init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToForeEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gMouseDownHandler contains: gCurRoom)
					(gMouseDownHandler delete: gCurRoom)
				)
				(if (gWalkHandler contains: gCurRoom)
					(gWalkHandler delete: gCurRoom)
				)
				(= local0 0)
				(gEgo
					setLoop: 2 1
					setCycle: Fwd
					setMotion: MoveTo 109 1 self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					setScale: 0
					posn: 298 195
					setLoop: 1 1
					setCycle: Fwd
					setPri: 158
					setMotion: MoveTo 163 135 self
				)
			)
			(3
				(gEgo
					normalize:
					setScaler: Scaler 80 80 160 0
					posn: 170 132
					setMotion: PolyPath 130 132 self
				)
			)
			(4
				(gEgo setHeading: 180 self)
			)
			(5
				(upsideDownLT dispose:)
				(westFront init:)
				(eastFront init:)
				(mySouthExit init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToVerticalMiddle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: 3 1
					setCycle: Fwd
					setPri: 20
					setMotion: MoveTo 42 50 self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					setPri: 150
					posn: 148 0
					setLoop: 12
					setCycle: Fwd
					setScaler: Scaler 100 50 41 6
					setMotion: MoveTo 148 15 self
				)
			)
			(3
				(gEgo setCycle: 0)
				(topVertical init:)
				(bottomVertical init:)
				(upsideDownLT dispose:)
				(upsideDownLB dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToUpsideDownWestB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: 13 1
					setCycle: Fwd
					setMotion: MoveTo 148 0 self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					posn: 42 50
					setLoop: 2 1
					setPri: 20
					setCycle: Fwd
					setScaler: Scaler 72 72 153 46
					setMotion: MoveTo 72 27 self
				)
			)
			(3
				(gEgo setCycle: 0)
				(topVertical dispose:)
				(bottomVertical dispose:)
				(upsideDownLT init:)
				(upsideDownLB init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToPowderStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setPri: 75
					setLoop: 12 1
					setCycle: Fwd
					setMotion: MoveTo 148 100 self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					normalize: 3
					setScaler: Scaler 72 45 126 78
					posn: 262 153
					setMotion: MoveTo 262 105 self
				)
			)
			(3
				(topVertical dispose:)
				(bottomVertical dispose:)
				(bottomPowderStairs init:)
				(powderExit init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromPowderRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(gMouseDownHandler delete: gCurRoom)
				(gWalkHandler add: gCurRoom)
				(gEgo setMotion: MoveTo 262 105 self)
			)
			(1
				(bottomPowderStairs init:)
				(powderExit init:)
				(westFront dispose:)
				(eastFront dispose:)
				(mySouthExit dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToVerticalBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 100 setMotion: MoveTo 262 160 self)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					view: (if (== gValOrRoz -3) 5154 else 5152) ; Roz
					setScale: 0
					posn: 148 100
					setLoop: 13 1
					setCycle: Fwd
					setPri: 75
					setScaler: Scaler 100 50 41 6
					setMotion: MoveTo 148 85 self
				)
			)
			(3
				(gEgo setCycle: 0)
				(topVertical init:)
				(bottomVertical init:)
				(bottomPowderStairs dispose:)
				(powderExit dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToForeWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: 2 1
					setCycle: Fwd
					setPri: 70
					setMotion: MoveTo 321 94 self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					posn: 0 100
					setLoop: 0 1
					setCycle: Fwd
					setPri: 120
					setMotion: MoveTo 61 131 self
				)
			)
			(3
				(eastFront init:)
				(westFront init:)
				(mySouthExit init:)
				(upsideDownEastB dispose:)
				(upsideDownEastT dispose:)
				(if (gMouseDownHandler contains: gCurRoom)
					(gMouseDownHandler delete: gCurRoom)
				)
				(if (gWalkHandler contains: gCurRoom)
					(gWalkHandler delete: gCurRoom)
				)
				(= local0 0)
				(gEgo
					posn: 59 129
					normalize: 0
					setScaler: Scaler 80 80 160 0
					setMotion: PolyPath 100 129 self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToForkEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: 3 1
					setCycle: Fwd
					setMotion: MoveTo 230 0 self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					posn: 165 0
					setLoop: 1 1
					setCycle: Fwd
					setScaler: Scaler 72 72 153 46
					setMotion: MoveTo 64 66 self
				)
			)
			(3
				(gEgo
					normalize: 1
					posn: 64 65
					setScaler: Scaler 60 60 154 66
				)
				(forkEast init:)
				(forkSouth init:)
				(forkWest init:)
				(upsideDownEastT dispose:)
				(upsideDownEastB dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToUpsideEastT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 67 65 self)
			)
			(1
				(gEgo
					posn: 67 66
					view: (if (== gValOrRoz -3) 5154 else 5152) ; Roz
					setLoop: 0 1
					setCycle: Fwd
					setScaler: Scaler 72 72 153 46
					setMotion: MoveTo 165 0 self
				)
			)
			(2
				(gEgo hide:)
				(= seconds 3)
			)
			(3
				(gEgo
					show:
					posn: 230 0
					setLoop: 2 1
					setScale: 0
					setMotion: MoveTo 288 65 self
				)
			)
			(4
				(gEgo setCycle: 0)
				(forkEast dispose:)
				(forkSouth dispose:)
				(forkWest dispose:)
				(upsideDownEastB init:)
				(upsideDownEastT init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToOfficeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 65 setMotion: MoveTo 63 118 self)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					view: (if (== gValOrRoz -3) 5154 else 5152) ; Roz
					posn: 151 0
					setPri: 20
					setLoop: 2 1
					setCycle: Fwd
					setScaler: Scaler 74 74 153 46
					setMotion: MoveTo 197 43 self
				)
			)
			(3
				(gEgo setCycle: 0)
				(officeDoorStairs init:)
				(officeExit init:)
				(forkSouth dispose:)
				(forkEast dispose:)
				(forkWest dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(gMouseDownHandler delete: gCurRoom)
				(gWalkHandler add: gCurRoom)
				(gEgo setPri: 20 setCycle: Fwd setMotion: MoveTo 197 43 self)
			)
			(1
				(gEgo setCycle: 0)
				(officeDoorStairs init:)
				(officeExit init:)
				(westFront dispose:)
				(eastFront dispose:)
				(mySouthExit dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterOffice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW (if (== gValOrRoz -3) 5156 else 5157)) ; Roz
				(gEgo
					setLoop: 2 1
					setCycle: Fwd
					setMotion: MoveTo 211 47 self
				)
				(= register (gEgo cycleSpeed:))
			)
			(1
				(if (or (== gChapter 5) (== gChapter 4))
					(gEgo
						setScale: 0
						view: (if (== gValOrRoz -3) 5156 else 5157) ; Roz
						setLoop: 2
						setCel: 0
						cycleSpeed: 14
						setCycle: Osc 1 self
					)
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gKqSound1 number: 2106 setLoop: 1 play:)
				else
					(gEgo
						setScale: 0
						view: (if (== gValOrRoz -3) 5156 else 5157) ; Roz
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
					(gKqSound1 number: 801 setLoop: 1 play:)
				)
			)
			(2
				(if (or (== gChapter 5) (== gChapter 4))
					(gMessager say: 1 8 0 0 self) ; "It's locked."
				else
					(self cue:)
				)
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(if (or (== gChapter 5) (== gChapter 4))
					(gEgo
						view: (if (== gValOrRoz -3) 5154 else 5152) ; Roz
						setScaler: Scaler 74 74 153 46
						setLoop: 2 1
						setCycle: 0
						setMotion: MoveTo 211 47 self
					)
					(gGame handsOn:)
					(self dispose:)
				else
					(gKqSound1 number: 802 setLoop: 1 play: self)
				)
			)
			(4
				(gCurRoom newRoom: 5250)
			)
		)
	)
)

(instance goToForkSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setLoop: 3 1
					setCycle: Fwd
					setMotion: MoveTo 151 1 self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(gEgo
					show:
					posn: 63 118
					normalize: 3
					setScaler: Scaler 60 60 154 66
					setMotion: MoveTo 64 65 self
				)
			)
			(3
				(officeDoorStairs dispose:)
				(officeExit dispose:)
				(forkSouth init:)
				(forkEast init:)
				(forkWest init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToForeSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 48 66 self)
			)
			(1
				(gEgo
					posn: 50 68
					view: (if (== gValOrRoz -3) 5154 else 5152) ; Roz
					setLoop: 1 1
					setPri: 65
					setCycle: Fwd
					setScaler: Scaler 72 72 153 46
					setMotion: MoveTo 0 48 self
				)
			)
			(2
				(gEgo hide:)
				(= seconds 3)
			)
			(3
				(gEgo
					show:
					normalize:
					setScaler: Scaler 80 80 160 0
					posn: 119 189
					setMotion: MoveTo 119 129 self
				)
			)
			(4
				(forkWest dispose:)
				(forkSouth dispose:)
				(forkEast dispose:)
				(eastFront init:)
				(westFront init:)
				(mySouthExit init:)
				(if (gMouseDownHandler contains: gCurRoom)
					(gMouseDownHandler delete: gCurRoom)
				)
				(if (gWalkHandler contains: gCurRoom)
					(gWalkHandler delete: gCurRoom)
				)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockOnPowderDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1314) ; WAVE
				(Load 140 5152) ; WAVE
				(gEgo setMotion: MoveTo 262 77 self)
			)
			(1
				(if (IsFlag 141)
					(gEgo
						setScale: 0
						view: (if (== gValOrRoz -3) 5156 else 5157) ; Roz
						setLoop: 1
						setCel: 0
						cycleSpeed: 12
						setCycle: End self
					)
					(gKqSound1 number: 801 setLoop: 1 play:)
				else
					(gEgo
						setScale: 0
						view: (if (== gValOrRoz -4) 5151 else 5155) ; Val
						setLoop: 0
						setCel: 13
						setCycle: Beg self
					)
					(gKqSound1 number: 5152 setLoop: 1 play:)
				)
			)
			(2
				(if (IsFlag 141)
					(gKqSound1 number: 802 setLoop: 1 play: self)
				else
					(gEgo setLoop: 1 setCel: 0 setCycle: End self)
				)
			)
			(3
				(if (IsFlag 141)
					(gCurRoom newRoom: 5200)
				else
					(SetFlag 141)
					(gKqSound1 number: 1314 setLoop: 1 play:)
					(gEgo setLoop: 2 setCel: 0 setCycle: End self)
				)
			)
			(4
				(if (== gValOrRoz -4) ; Val
					(gEgo normalize: 2)
				else
					(gEgo normalize: 3)
				)
				(gEgo
					setScaler: Scaler 72 39 126 78
					setMotion: MoveTo 262 82 self
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance officeExit of Feature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 226 34 226 59 207 65 197 51 200 19
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: enterOffice)
		)
	)
)

(instance powderExit of Feature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 245 75 271 75 272 50 252 29 239 47
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: knockOnPowderDoor)
			)
		)
	)
)

(instance eastFront of ExitFeature
	(properties
		exitDir 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 173 136 165 118 219 109 289 136
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToUpsideDownWest)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance westFront of ExitFeature
	(properties
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 38 136 65 105 0 62 0 107
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToUpsideStairsEastB)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance upsideDownLT of ExitFeature
	(properties
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 6 66 24 97 9 94 0 42 0
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToForeEast)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance upsideDownLB of ExitFeature
	(properties
		exitDir 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 66 24 35 6 16 18 47 44 yourself:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToVerticalMiddle)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance topVertical of ExitFeature
	(properties
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 50 167 50 166 27 154 0 143 0 133 30
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToUpsideDownWestB)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance bottomVertical of ExitFeature
	(properties
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 100 132 51 167 51 176 102
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToPowderStairs)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance bottomPowderStairs of ExitFeature
	(properties
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 116 227 136 298 136 298 116
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToVerticalBottom)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance upsideDownEastB of ExitFeature
	(properties
		exitDir 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 276 51 308 15 319 23 319 93 302 93 305 83
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToForeWest)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance upsideDownEastT of ExitFeature
	(properties
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 275 50 309 14 296 0 228 0
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToForkEast)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance forkSouth of ExitFeature
	(properties
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 41 76 70 87 89 34 89 43 66 44 41
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToOfficeDoor)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance forkEast of ExitFeature
	(properties
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 77 70 73 43 139 0 180 0 yourself:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToUpsideEastT)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance forkWest of ExitFeature
	(properties
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 50 40 52 64 39 69 0 45 0 18 14 14
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToForeSouth)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance officeDoorStairs of ExitFeature
	(properties
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 204 36 221 3 216 0 175 0 167 8
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom setScript: goToForkSouth)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance leftMiddle of ExitFeature ; UNUSED
	(properties
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 41 68 48 61 47 46 0 12 0 45
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event)))
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance leftMiddleDown of ExitFeature ; UNUSED
	(properties
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 41 68 48 61 47 46 0 12 0 45
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event)))
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance upsideDownRightSE of ExitFeature ; UNUSED
	(properties
		exitDir 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 304 95 320 95 320 23 314 19
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event)))
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		approachX 119
		approachY 129
		x 160
		y 200
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 39 136 38 133 172 133 175 136
					yourself:
				)
			setHotspot: 10 10 ; Exit, Exit
			approachVerbs: 10 ; Exit
		)
	)

	(method (doVerb)
		(gCurRoom setScript: goToTownHall)
	)
)

