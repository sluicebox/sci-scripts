;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6250)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Array)
(use Scaler)
(use Osc)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm6250 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 0)
	(if (and (gCurRoom obstacles:) ((gCurRoom obstacles:) contains: local2))
		(= temp0 1)
		((gCurRoom obstacles:) delete: local2)
	)
	(if local2
		(local2 dispose:)
	)
	(= local2
		(if (and (IsFlag 271) (not (gEgo has: 69))) ; Magic_Bridle
			((Polygon new:)
				type: PContainedAccess
				init: 126 160 104 132 102 116 108 108 130 104 145 100 173 93 196 83 208 78 124 75 117 77 195 79 185 85 158 93 96 105 83 118 71 160
				yourself:
			)
		else
			((Polygon new:)
				type: PContainedAccess
				init: 126 160 103 116 108 108 130 104 145 100 173 93 196 83 208 78 124 75 117 77 195 79 185 85 158 93 96 105 83 118 71 160
				yourself:
			)
		)
	)
	(if temp0
		(gCurRoom addObstacle: local2)
	)
)

(procedure (localproc_1)
	(return
		(cond
			((== (gEgo loop:) 1) 1)
			((== (gEgo loop:) 7) 1)
			((== (gEgo loop:) 5) 1)
			((and (== (gEgo loop:) 8) (== (gEgo cel:) 1)) 1)
			((and (== (gEgo loop:) 8) (== (gEgo cel:) 7)) 1)
			((and (== (gEgo loop:) 8) (== (gEgo cel:) 5)) 1)
			(else 0)
		)
	)
)

(procedure (localproc_2)
	(return
		(cond
			((== (gEgo loop:) 0) 1)
			((== (gEgo loop:) 6) 1)
			((== (gEgo loop:) 4) 1)
			((and (== (gEgo loop:) 8) (== (gEgo cel:) 0)) 1)
			((and (== (gEgo loop:) 8) (== (gEgo cel:) 6)) 1)
			((and (== (gEgo loop:) 8) (== (gEgo cel:) 4)) 1)
			(else 0)
		)
	)
)

(instance rm6250 of KQRoom
	(properties
		picture 6250
	)

	(method (init)
		(SetFlag 21)
		(super init: &rest)
		(localproc_0)
		(= local3
			((Polygon new:)
				type: PContainedAccess
				init: 95 57 97 59 107 60 145 53 164 50 183 45 159 35 156 36 178 45 105 58 102 57
				yourself:
			)
		)
		(= local4
			((Polygon new:)
				type: PContainedAccess
				init: 134 21 147 23 180 14 208 11 200 9 180 12 166 16 158 18 147 21 140 20
				yourself:
			)
		)
		(gEgo normalize:)
		((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
		(switch gPrevRoomNum
			(6300
				(self addObstacle: local2)
				(self setScript: enterRoomSouth)
			)
			(6100
				(self addObstacle: local4)
				(if (IsFlag 217)
					(self setScript: enterValFalls)
				else
					(self setScript: enterRoomNorth)
				)
			)
			(6550
				(self addObstacle: local2)
				(self setScript: enterValPoofs)
			)
			(else
				(self addObstacle: local2)
				(self setScript: enterValPoofs)
			)
		)
		(scirocco
			init:
			hide:
			ignoreActors:
			ignoreHorizon: 1
			setScript: scirrocoTimer
		)
		(borasco
			init:
			hide:
			ignoreActors:
			ignoreHorizon: 1
			setScript: borascoTimer
		)
		(windSound init: hide: setScript: blowTheWind)
		(if (and (IsFlag 271) (not (gEgo has: 69))) ; Magic_Bridle
			(bridle init:)
		)
		(knockOff init:)
		(transfer1Up init:)
		(transfer1Down init:)
		(transfer2Up init:)
		(transfer2Down init:)
		(if (!= (gKqMusic1 number:) 6250)
			(gKqMusic1
				stop:
				number: 6250
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
		(gWalkHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evVERB) (& (event type:) evMOVE))
			(= local5 1)
		)
		(super handleEvent: event &rest)
		(return 0)
	)

	(method (doit)
		(cond
			(script)
			((not local5))
			((not (localproc_1)))
			((transfer1Up onMe: gEgo)
				((self obstacles:) delete: local2)
				(self addObstacle: local3)
				(self setScript: (sTransfer1Up new:))
				(= local5 0)
			)
			((transfer1Down onMe: gEgo)
				((self obstacles:) delete: local3)
				(self addObstacle: local2)
				(self setScript: (sTransfer1Down new:))
				(= local5 0)
			)
			((transfer2Up onMe: gEgo)
				((self obstacles:) delete: local3)
				(self addObstacle: local4)
				(self setScript: (sTransfer2Up new:))
				(= local5 0)
			)
			((transfer2Down onMe: gEgo)
				((self obstacles:) delete: local4)
				(self addObstacle: local3)
				(self setScript: (sTransfer2Down new:))
				(= local5 0)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(if (not ((self obstacles:) contains: local2))
			(local2 dispose:)
			(= local2 0)
		)
		(if (not ((self obstacles:) contains: local3))
			(local3 dispose:)
			(= local3 0)
		)
		(if (not ((self obstacles:) contains: local4))
			(local4 dispose:)
			(= local4 0)
		)
		(borascoEats stop:)
		(borascoPoof stop:)
		(gKqMusic1 client: 0)
		(gKqSound1 client: 0)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		(super dispose: &rest)
	)
)

(instance enterRoomSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 100
					y: 199
					init:
					setScaler: Scaler 82 25 130 80
					setMotion: MoveTo 95 127 self
				)
			)
			(1
				(mySouthExit init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoomNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 202
					y: 10
					init:
					setScaler: Scaler 25 11 80 10
					setMotion: PolyPath 198 12 self
				)
			)
			(1
				(myNorthExit init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterValPoofs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8134)
				(= seconds 1)
			)
			(1
				(gKqSound1 number: 6261 setLoop: 1 play:)
				(poof init: setCycle: CT 7 1 self)
			)
			(2
				(gEgo
					view: 8134
					setLoop: 0 1
					cel: 0
					x: 131
					y: 102
					init:
					setScaler: Scaler 82 25 130 80
					setCycle: 0
				)
				(poof setCycle: End self)
			)
			(3
				(poof hide:)
				(= ticks 20)
			)
			(4
				(gEgo setCycle: Osc 1 self)
			)
			(5
				(mySouthExit init:)
				(gEgo normalize: 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterValFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 924) ; WAVE
				(gGame handsOff:)
				(gEgo
					x: 160
					y: 20
					view: 4313
					loop: 3
					cel: 5
					init:
					setScale:
					scaleX: 29
					scaleY: 29
					setCycle: CT 11 1 self
				)
			)
			(1
				(gKqSound1 number: 924 setLoop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize: 2 setScaler: Scaler 25 11 80 10)
				(gMessager say: 1 0 0 1 self) ; "What in heaven's name was that? I've never seen a creature so swift."
			)
			(3
				(ClearFlag 217)
				(myNorthExit init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sScirrocoKnocks of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if local1
					(self dispose:)
				else
					(gGame handsOff:)
					(= local0 1)
					(Load rsVIEW 6250)
					(Load 140 4073) ; WAVE
					(= ticks 1)
				)
			)
			(1
				(if (not (localproc_2))
					(gEgo setHeading: 90 self)
				else
					(= ticks 1)
				)
			)
			(2
				(gKqMusic1 setVol: 75)
				(wind setLoop: 1 play: setVol: 127)
				(= temp0 (+ (/ (* (- (gEgo y:) 97) 47) 33) 53))
				(scirocco
					cel: 0
					x: 0
					y: (- (gEgo y:) 40)
					setSpeed: 2
					setStep: 12 -1
					setScaler:
						Scaler
						temp0
						10
						(- (gEgo y:) 28)
						(- (gEgo y:) 40)
					show:
					setMotion:
						MoveTo
						(+ (gEgo x:) 6)
						(- (gEgo y:) 28)
						self
				)
				(gEgo setPri: (+ (scirocco priority:) 1))
			)
			(3
				(gEgo setScript: sEgoKnockOff)
				(scirocco setSpeed: 6 setStep: 3 -1 setCycle: End self)
			)
			(4
				(gKqMusic1 setVol: 127)
				(scirocco hide:)
				(= cycles 2)
			)
			(5
				(SetFlag 217)
				(gCurRoom newRoom: 6300)
				(self dispose:)
			)
		)
	)
)

(instance sEgoKnockOff of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gKqSound1 number: 6256 setLoop: 1 play:)
				(if (>= (gEgo y:) 105)
					(= temp0 7)
				else
					(= temp0 4)
				)
				(gEgo
					view: 6250
					setLoop: 1 1
					cel: 0
					setScaler: Scaler 100 53 130 97
					setCycle: CT temp0 1 self
				)
			)
			(1
				(gKqSound1 number: 4073 setLoop: 1 play: self)
				(gEgo setPri: 40 setCycle: End self)
			)
			(2
				(gEgo hide:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sScirrocoFlies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(self dispose:)
				else
					(= local0 1)
					(= ticks 1)
				)
			)
			(1
				(gKqMusic1 setVol: 75)
				(wind setLoop: 1 play: setVol: 127)
				(if (gCast contains: bridle)
					(scirocco setPri: (+ (bridle priority:) 1))
				)
				(scirocco
					cel: 0
					x: 0
					y: 90
					setSpeed: 2
					setStep: 12 -1
					setScaler: Scaler 100 10 102 90
					show:
					setMotion: MoveTo 83 102 self
				)
			)
			(2
				(scirocco setSpeed: 6 setStep: 3 -1 setCycle: End self)
			)
			(3
				(scirocco hide: setPri: 102)
				(gKqMusic1 setVol: 127)
				(= cycles 2)
			)
			(4
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance sBorascoEats of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(self dispose:)
				else
					(gGame handsOff:)
					(= local1 1)
					(gEgo setMotion: 0)
					(Load rsSOUND 62590)
					(Load 140 953) ; WAVE
					(= ticks 1)
				)
			)
			(1
				(gKqMusic1 stop:)
				(gKqSound1 number: 62590 setLoop: -1 play: setVol: 127)
				(borasco
					view: 6250
					setLoop: 2 1
					cel: 0
					x: 26
					y: 0
					setSpeed: 2
					setStep: 6 -1
					setScaler: Scaler 100 10 20 0
					show:
					setMotion: MoveTo 66 20 self
				)
			)
			(2
				(borasco setSpeed: 6 setStep: 3 2 setCycle: End self)
			)
			(3
				(borasco hide:)
				(= seconds 4)
			)
			(4
				(gEgo setHeading: 135 self)
			)
			(5
				(borascoEats setLoop: -1 play: setVol: 127)
				(borascoPoof setLoop: 1 play: setVol: 127)
				(gEgo hide:)
				(borasco
					loop: 3
					cel: 0
					x: (gEgo x:)
					y: (gEgo y:)
					show:
					setScaler: Scaler 100 53 120 90
					setCycle: CT 15 1 self
				)
				(borascoEats setLoop: 1 play:)
			)
			(6
				(gKqSound1 stop: number: 953 setLoop: 1 play: setVol: 127)
				(borasco setCycle: End self)
			)
			(7
				(borascoEats fade: 0 10 15 1 self)
			)
			(8
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(EgoDead 50 self)
			)
			(9
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(borasco hide:)
				(gEgo show:)
				(gKqMusic1 play: setVol: 127)
				(= cycles 2)
			)
			(10
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBorascoFlies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(self dispose:)
				else
					(= local1 1)
					(= ticks 1)
				)
			)
			(1
				(gKqMusic1 setVol: 75)
				(gKqSound1 number: 62590 setLoop: -1 play: setVol: 127)
				(borasco
					view: 6250
					setLoop: 2 1
					cel: 0
					x: 26
					y: 0
					setSpeed: 2
					setStep: 6 -1
					setScaler: Scaler 100 10 20 0
					show:
					setMotion: MoveTo 66 20 self
				)
			)
			(2
				(borasco setSpeed: 6 setStep: 3 2 setCycle: End self)
			)
			(3
				(borasco hide:)
				(= cycles 2)
			)
			(4
				(gKqSound1 fade: 0 20 10 1)
				(gKqMusic1 setVol: 127)
				(= seconds 3)
			)
			(5
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance borascoTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 40 90))
			)
			(1
				(if (and (> (gEgo y:) 90) (< (gEgo y:) 120))
					(self setScript: (sBorascoEats new:) self)
				else
					(self setScript: (sBorascoFlies new:) self)
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance scirrocoTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 60))
			)
			(1
				(if (knockOff onMe: gEgo)
					(self setScript: (sScirrocoKnocks new:) self)
				else
					(self setScript: (sScirrocoFlies new:) self)
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance blowTheWind of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 15 45))
			)
			(1
				(if (and (not local1) (not local0))
					(wind setLoop: 1 play: self setVol: 127)
				else
					(= ticks 1)
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sTransfer1Up of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 120 75 self)
			)
			(1
				(gEgo hide: setScaler: Scaler 25 11 80 10)
				(= cycles 2)
			)
			(2
				(= ticks 90)
			)
			(3
				(gEgo
					x: 97
					y: 67
					setLoop: 2 1
					show:
					setMotion: MoveTo 98 55 self
				)
			)
			(4
				(gEgo setPri: 70 setLoop: -1 setMotion: MoveTo 97 58 self)
			)
			(5
				(gEgo setMotion: PolyPath 112 58 self)
			)
			(6
				(gEgo setPri: -1)
				(mySouthExit dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTransfer1Down of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 70 setMotion: MoveTo 98 56 self)
			)
			(1
				(gEgo setPri: -1 setLoop: 3 1 setMotion: MoveTo 97 67 self)
			)
			(2
				(gEgo hide:)
				(= ticks 90)
			)
			(3
				(gEgo
					x: 120
					y: 75
					setLoop: 4 0
					setScaler: Scaler 82 25 130 80
					show:
					setMotion: PolyPath 178 79 self
				)
			)
			(4
				(mySouthExit init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTransfer2Up of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 147 38 self)
			)
			(1
				(gEgo hide:)
				(= cycles 2)
			)
			(2
				(= ticks 90)
			)
			(3
				(gEgo
					x: 138
					y: 31
					setLoop: 2 1
					show:
					setMotion: MoveTo 138 22 self
				)
			)
			(4
				(gEgo setPri: 50 setLoop: -1 setMotion: PolyPath 146 25 self)
			)
			(5
				(gEgo setPri: -1)
				(myNorthExit init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTransfer2Down of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 138 21 self)
			)
			(1
				(gEgo setLoop: 3 1 setMotion: MoveTo 138 28 self)
			)
			(2
				(gEgo hide:)
				(= ticks 90)
			)
			(3
				(gEgo
					x: 147
					y: 38
					setLoop: -1
					show:
					setMotion: MoveTo 160 38 self
				)
			)
			(4
				(gEgo setMotion: PolyPath 178 45 self)
			)
			(5
				(myNorthExit dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pickUpBridle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bridle setPri: 130)
				(gEgo setMotion: MoveTo 108 129 self)
			)
			(1
				(gEgo view: 8064 loop: 0 setCycle: End self)
			)
			(2
				(gEgo cel: -1 setCycle: Beg self)
				(bridle
					setCycle:
						BridleMove
						(IntArray
							with:
								6250
								5
								111
								121
								6250
								5
								110
								114
								6250
								5
								111
								110
								6250
								5
								108
								108
								6250
								5
								105
								106
								6250
								5
								103
								103
								32768
						)
						self
				)
			)
			(3
				(bridle hide:)
			)
			(4
				(ClearFlag 271)
				(localproc_0)
				(gEgo normalize: 4 get: 69) ; Magic_Bridle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scirocco of Actor
	(properties
		x 73
		y 102
		priority 105
		fixPriority 1
		view 6254
	)
)

(instance borasco of Actor
	(properties
		x 66
		y 20
		priority 140
		fixPriority 1
		view 6250
		loop 2
	)
)

(instance poof of Prop
	(properties
		x 135
		y 90
		priority 140
		fixPriority 1
		view 6554
		loop 4
	)
)

(instance bridle of Prop
	(properties
		approachX 107
		approachY 125
		x 111
		y 121
		view 6250
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 10 8 ; Exit, Do
			setHotspot: 8 10 ; Do, Exit
			setScale:
			scaleX: 100
			scaleY: 100
			setPri: (+ approachY 1)
		)
	)

	(method (doVerb)
		(if (local2 onMe: (gEgo x:) (gEgo y:))
			(gEgo setScript: pickUpBridle)
		)
	)
)

(instance windSound of Prop
	(properties
		view 6554
	)
)

(instance knockOff of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 155 98 110 110 110 118 134 130 66 130 80 109 99 101 123 98
					yourself:
				)
		)
	)
)

(instance transfer1Up of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 71 132 71 128 78 115 78
					yourself:
				)
		)
	)
)

(instance transfer1Down of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 91 55 113 55 110 62 99 62
					yourself:
				)
		)
	)
)

(instance transfer2Up of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 164 36 173 40 166 43 157 38
					yourself:
				)
		)
	)
)

(instance transfer2Down of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 18 149 18 149 23 139 25 132 21
					yourself:
				)
		)
	)
)

(instance myNorthExit of ExitFeature
	(properties
		nsLeft 150
		nsRight 240
		nsBottom 10
		approachX 202
		approachY 10
		x 202
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 8 setHotspot: 8 10) ; Exit, Do, Do, Exit
	)

	(method (doVerb)
		(if (local4 onMe: (gEgo x:) (gEgo y:))
			(gCurRoom newRoom: 6100)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsLeft 57
		nsTop 130
		nsRight 145
		nsBottom 140
		approachX 101
		approachY 160
		x 101
		y 170
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 8 setHotspot: 8 10) ; Exit, Do, Do, Exit
	)

	(method (doVerb)
		(if (local2 onMe: (gEgo x:) (gEgo y:))
			(gCurRoom newRoom: 6300)
		)
	)
)

(instance borascoEats of Sound
	(properties
		number 6260
	)
)

(instance borascoPoof of Sound
	(properties
		number 842
	)
)

(instance wind of Sound
	(properties
		number 6251
	)
)

(instance BridleMove of MCyc
	(properties)

	(method (dispose)
		(if points
			(points dispose:)
		)
		(super dispose: &rest)
	)
)

