;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6100)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use ROsc)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm6100 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4] = [207 201 204 200]
	[local9 4] = [28 28 27 27]
	local13
	local14
	local15 = 45
	[local16 9] = [193 201 198 215 205 207 210 202 208]
	[local25 9] = [33 36 30 33 30 35 29 33 32]
)

(procedure (localproc_0)
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

(instance rm6100 of KQRoom
	(properties
		picture 6100
	)

	(method (init &tmp temp0)
		(SetFlag 21)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 240 139 263 126 314 126 314 105 252 117 219 128 151 131 129 131 120 127 154 117 175 105 186 98 228 93 236 84 162 82 143 88 97 86 80 85 49 83 41 88 148 95 147 109 105 116 89 125 88 130 116 139
					yourself:
				)
		)
		(Load rsMESSAGE 6100)
		(gEgo normalize: setScaler: Scaler 83 66 131 91)
		(switch gPrevRoomNum
			(6100
				(self setScript: enterRoomSouth)
			)
			(6150
				(self setScript: enterRoomEast)
			)
			(else
				(self setScript: enterRoomSouth)
			)
		)
		(scirocco
			init:
			hide:
			ignoreActors:
			ignoreHorizon: 1
			setScript: sciroccoTimer
		)
		(borasco
			init:
			hide:
			ignoreActors:
			ignoreHorizon: 1
			setScript: borascoTimer
		)
		(glint init: hide: setScript: glintMe)
		(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
			(ambrosiaSet
				add:
					(((ambrosia new:)
							cel: temp0
							x: [local5 temp0]
							y: [local9 temp0]
							yourself:
						)
						init:
						yourself:
					)
			)
		)
		(if (IsFlag 211)
			(caveExit init:)
		else
			(cave init:)
			(ntmareKillRange init:)
		)
		(if (gEgo has: 69) ; Magic_Bridle
			(rockEdge init:)
			(extra init:)
			(= local15 30)
		else
			(= local15 45)
		)
		(tree init:)
		(knockOff init:)
		(borascoKillRange init:)
		(hidingPlace init:)
		(mySouthExit init:)
		(if (or (!= (gKqMusic1 number:) 6250) (== gPrevRoomNum 6150))
			(gKqMusic1
				stop:
				number: 6250
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
	)

	(method (doit)
		(cond
			(script)
			((IsFlag 211))
			((ntmareKillRange onMe: gEgo)
				(self setScript: (sNtmareMonsterKills new:))
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(ambrosiaSet release:)
		(gKqMusic1 client: 0)
		(if (!= (gKqSound1 number:) 4073)
			(gKqSound1 stop: client: 0)
		)
		(borascoEats stop:)
		(wind stop:)
		(super dispose: &rest)
	)
)

(instance enterRoomSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 159 y: 190 init: setMotion: MoveTo 108 128 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoomEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 299 y: 121 init: setMotion: MoveTo 250 130 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gEgo loop:) 8)
					(= temp0 (gEgo cel:))
				else
					(= temp0 (gEgo loop:))
				)
				(gEgo
					normalize: temp0 801
					setSpeed: 5
					setStep: 8 4
					setMotion: MoveTo (- (gEgo x:) 5) 155 self
				)
			)
			(1
				(gCurRoom newRoom: 6250)
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
				(cond
					(local2
						(= ticks 1)
					)
					(local3
						(self setScript: (valKilledByBorasco new:) self)
						(gCurRoom setScript: 0)
					)
					((borascoKillRange onMe: gEgo)
						(self setScript: (sBorascoEats new:) self)
					)
					(else
						(self setScript: (sBorascoFlies new:) self)
					)
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sciroccoTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 local15))
			)
			(1
				(cond
					(local2
						(= ticks 1)
					)
					((knockOff onMe: gEgo)
						(self setScript: (sSciroccoKnocks new:) self)
					)
					(else
						(self setScript: (sSciroccoFlies new:) self)
					)
				)
			)
			(2
				(if local13
					(self setScript: (sciroccoBridled new:) self)
					(= local13 0)
				else
					(= ticks 1)
				)
			)
			(3
				(= state -1)
				(= cycles 1)
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
				(gKqMusic1 stop:)
				(wind setLoop: 1 play: setVol: 127)
				(gKqSound1 number: 62590 setLoop: -1 play: setVol: 127)
				(borasco
					view: 6250
					setLoop: 2 1
					cel: 0
					x: 0
					y: 50
					setSpeed: 2
					setStep: 6 -1
					setScaler: Scaler 100 10 70 50
					show:
					setMotion: MoveTo 65 70 self
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
				(gKqMusic1 play: setVol: 127)
				(= seconds 2)
			)
			(5
				(= local1 0)
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
					x: 0
					y: 50
					setSpeed: 2
					setStep: 6 -1
					setScaler: Scaler 100 10 70 50
					show:
					setMotion: MoveTo 65 70 self
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
				(if (not (localproc_0))
					(gEgo setHeading: 135)
				)
				(if (> (gEgo x:) 75)
					(borasco
						loop: 4
						cel: 0
						x: 60
						y: 30
						setSpeed: 2
						setStep: 6 4
						setScaler: Scaler 100 20 (gEgo y:) 30
						show:
						setMotion: MoveTo (gEgo x:) (gEgo y:) self
					)
				else
					(= ticks 1)
				)
			)
			(5
				(gEgo hide:)
				(borasco
					loop: 3
					cel: 0
					x: (gEgo x:)
					y: (gEgo y:)
					setSpeed: 6
					setStep: 3 2
					setScaler: Scaler 123 100 131 91
					show:
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
				(EgoDead 50 self)
			)
			(9
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

(instance sSciroccoFlies of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
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
				(if local3
					(Load rsSOUND 6256)
					(Load 140 924) ; WAVE
					(= temp0 93)
					(= temp1 54)
					(= local4 1)
				else
					(= temp0 70)
					(= temp1 95)
					(= local4 0)
				)
				(gKqMusic1 setVol: 75)
				(wind setLoop: 1 play: setVol: 127)
				(scirocco
					cel: 0
					x: 0
					y: (- temp1 10)
					setSpeed: 2
					setStep: 12 -1
					setScaler: Scaler 100 10 temp1 (- temp1 10)
					show:
					setMotion: MoveTo temp0 temp1 self
				)
			)
			(2
				(scirocco setSpeed: 6 setStep: 3 -1 setCycle: CT 7 1 self)
			)
			(3
				(if local4
					(= local4 0)
					(gEgo setScript: valFallsFromTree)
					(gCurRoom setScript: 0)
				)
				(scirocco setCycle: End self)
			)
			(4
				(= local0 0)
				(scirocco hide:)
				(gKqMusic1 setVol: 127)
				(self dispose:)
			)
		)
	)
)

(instance sSciroccoKnocks of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if local1
					(self dispose:)
				else
					(gGame handsOff:)
					(= local0 1)
					(gEgo setMotion: 0)
					(Load rsVIEW 6250)
					(Load 140 4073) ; WAVE
					(= ticks 1)
				)
			)
			(1
				(if (not (localproc_0))
					(gEgo setHeading: 90 self)
				else
					(= ticks 1)
				)
			)
			(2
				(gKqMusic1 setVol: 75)
				(wind setLoop: 1 play: setVol: 127)
				(= temp0 (+ (/ (* (- (gEgo y:) 102) 13) 29) 87))
				(scirocco
					cel: 0
					x: 0
					y: (- (gEgo y:) 46)
					setSpeed: 2
					setStep: 12 -1
					setScaler:
						Scaler
						100
						10
						(- (gEgo y:) 36)
						(- (gEgo y:) 46)
					show:
					setMotion:
						MoveTo
						(- (gEgo x:) 25)
						(- (gEgo y:) 36)
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
				(gCurRoom newRoom: 6250)
				(self dispose:)
			)
		)
	)
)

(instance sEgoKnockOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: 6256 setLoop: 1 play:)
				(gEgo
					view: 6250
					setLoop: 1 1
					cel: 0
					setScaler: Scaler 100 87 131 102
					setCycle: CT 5 1 self
				)
			)
			(1
				(gKqSound1 number: 4073 setLoop: 1 play: self)
				(if (< (gEgo y:) 128)
					(gEgo setPri: 106)
				)
				(gEgo setCycle: End self)
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

(instance sNtmareMonsterKills of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (handleEvent event)
		(if (and (gThePlane onMe: event) (& (event type:) evMOUSEBUTTON))
			(cond
				((OnMeAndLowY theObj:)
					(if
						(and
							(or
								(monster onMe: event)
								(mySouthExit onMe: event)
							)
							register
						)
						(= register 0)
						(gMouseDownHandler delete: self)
						(= seconds 0)
						(if (mySouthExit onMe: event)
							(mySouthExit
								approachX: (gEgo x:)
								approachY: (gEgo y:)
							)
							(gUser canControl: 1 canInput: 1)
						)
						(return 0)
					else
						(= register 0)
						(if (gMouseDownHandler contains: self)
							(gMouseDownHandler delete: self)
						)
						(= seconds 0)
						(self cue:)
						(event claimed: 1)
						(return 1)
					)
				)
				(register
					(gMouseDownHandler delete: self)
					(= seconds (= register 0))
					(self cue:)
					(event claimed: 1)
					(return 1)
				)
				(else
					(return 0)
				)
			)
		else
			(return 0)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local2 1)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 199 134 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gKqSound1 number: 6252 setLoop: -1 play: setVol: 127)
				(monster
					view: 6252
					setLoop: 0 1
					cel: 0
					init:
					setCycle: End self
				)
			)
			(3
				(monster
					setCycle:
						ROsc
						101
						(- (monster lastCel:) 4)
						(monster lastCel:)
				)
				(if (gEgo has: 68) ; Dream_Catcher
					(gMouseDownHandler addToFront: self)
					(= register 1)
					(gGame handsOn:)
					(gUser canControl: 0 canInput: 1)
					(= seconds 8)
				else
					(= ticks 1)
				)
			)
			(4
				(gGame handsOff:)
				(gEgo
					view: 8281
					loop: 0
					cel: 0
					posn: 198 134
					setCycle: End self
				)
			)
			(5
				(gMessager say: 1 8 0 0 self) ; "(TERRIFIED, SCREAMING)NO! GET AWAY!"
			)
			(6
				(if (!= (monster cel:) (- (NumCels monster) 1))
					(monster setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(7
				(gKqSound1 stop: number: 6253 setLoop: 1 play: setVol: 127)
				(monster loop: 1 cel: 0 setCycle: End self)
				(gEgo hide:)
			)
			(8
				(monster hide:)
				(if (scirocco cycler:)
					(scirocco setCycle: 0 hide:)
				)
				(if (scirocco mover:)
					(scirocco setMotion: 0 hide:)
				)
				(if (borasco cycler:)
					(borasco setCycle: 0 hide:)
				)
				(if (borasco mover:)
					(borasco setMotion: 0 hide:)
				)
				(= cycles 2)
			)
			(9
				(cond
					((IsFlag 209)
						(= temp0 53)
					)
					((IsFlag 565)
						(= temp0 52)
					)
					(else
						(= temp0 51)
					)
				)
				(EgoDead temp0 self)
			)
			(10
				(gEgo normalize: 4 posn: 108 128 show:)
				(= local2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(= local2 0)
		(= register 0)
		(super dispose: &rest)
	)
)

(instance sMonsterTrapped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(gGame handsOff:)
				(Load 140 6252 6254) ; WAVE
				(gKqSound1 number: 6252 setLoop: -1 play: setVol: 127)
				(monster view: 6253 setLoop: 0 1 cel: 0 setCycle: Osc 3 self)
				(gEgo hide:)
			)
			(1
				(monster loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gKqSound1 stop: number: 6254 setLoop: 1 play: setVol: 127)
				(monster loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(SetFlag 211)
				(SetFlag 568)
				((gInventory at: 68) ; Dream_Catcher
					view: 381
					cView: 992
					cLoop: 3
					cCel: 5
					yourself:
				)
				(gTheInvCursor view: 992 loop: 3 cel: 5)
				(monster hide:)
				(gEgo x: 199 y: 134 show:)
				(cave dispose:)
				(caveExit init:)
				(ntmareKillRange dispose:)
				(= local2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbTree of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (handleEvent event)
		(if (gThePlane onMe: event)
			(cond
				((OnMeAndLowY theObj:)
					(if
						(and
							(or
								(tree onMe: event)
								(and (IsFlag 211) (caveExit onMe: event))
								(and (not (IsFlag 211)) (cave onMe: event))
								(mySouthExit onMe: event)
							)
							register
						)
						(= register 0)
						(gMouseDownHandler delete: self)
						(self cue:)
						(event claimed: 1)
						(return 1)
					else
						(return 0)
					)
				)
				(register
					(= register 0)
					(gMouseDownHandler delete: self)
					(self cue:)
					(event claimed: 1)
					(return 1)
				)
				(else
					(return 0)
				)
			)
		else
			(return 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 110 78 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 8223 loop: 0 cel: 0 setCycle: CT 14 1 self)
			)
			(3
				(gEgo y: 72 setCycle: End self)
			)
			(4
				(gEgo
					view: 6106
					setLoop: 0 1
					cel: 0
					x: 139
					y: 62
					setScale:
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
				(= local3 1)
			)
			(5
				(gMouseDownHandler addToFront: self)
				(= register 1)
				(ambrosiaSet eachElementDo: #approachVerbs 0)
				(gGame handsOn:)
				(gUser canControl: 0 canInput: 1)
			)
			(6
				(gGame handsOff:)
				(= local3 0)
				(ambrosiaSet eachElementDo: #approachVerbs 8 10)
				(gEgo view: 6106 loop: 0)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(7
				(gEgo
					x: 110
					y: 72
					normalize: 3
					setScaler: Scaler 83 66 131 91
				)
				(= cycles 2)
			)
			(8
				(gEgo setHeading: 180 self)
			)
			(9
				(gEgo view: 8222 loop: 0 cel: 0 setCycle: CT 18 1 self)
			)
			(10
				(gEgo y: 78 setCycle: End self)
			)
			(11
				(gEgo
					x: (+ (gEgo x:) 4)
					normalize:
					setMotion: MoveTo 160 85 self
				)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if local3
			(if (gMouseDownHandler contains: self)
				(gMouseDownHandler delete: self)
			)
			(ambrosiaSet eachElementDo: #approachVerbs 8 10)
			(= local3 0)
		)
		(super dispose: &rest)
	)
)

(instance valGrabsAmbrosia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 6106 loop: 1 cel: 0 setCycle: End self)
				(if register
					(register hide:)
				)
			)
			(1
				(gEgo get: 67) ; Ambrosia
				(ambrosiaSet eachElementDo: #deleteHotspot)
				(tree deleteHotspot:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valReachesAmbrosia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8085 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sciroccoBridled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Load rsVIEW 6254 6104)
				(scirocco
					view: 6254
					setLoop: 1 1
					cel: 0
					x: 0
					y: 80
					setSpeed: 2
					setStep: 12 -1
					setScaler: Scaler 100 10 90 80
					show:
					setMotion: MoveTo 67 90 self
				)
			)
			(2
				(scirocco setCycle: End self)
			)
			(3
				(gEgo setMotion: PolyPath 150 100 self)
			)
			(4
				(gEgo setHeading: 225 self)
			)
			(5
				(scirocco
					view: 6104
					loop: 1
					cel: 0
					x: 111
					y: 115
					setCycle: End self
				)
				(gEgo hide:)
			)
			(6
				(gKqSound1 number: 6257 setLoop: 1 play: setVol: 127)
				(scirocco loop: 2 cel: 0 x: 134 y: 100 setCycle: End self)
			)
			(7
				(scirocco loop: 3 cel: 0 x: 118 y: 115 setCycle: End self)
			)
			(8
				(scirocco hide:)
				(= cycles 2)
			)
			(9
				(gCurRoom newRoom: 6000)
				(self dispose:)
			)
		)
	)
)

(instance valReachesScirocco of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< (gEgo x:) 100)
					(gEgo setHeading: 135 self)
				else
					(gEgo setHeading: 225 self)
				)
			)
			(1
				(if (< (gEgo x:) 100)
					(gEgo view: 8084 loop: 0)
				else
					(gEgo view: 8084 loop: 1)
				)
				(gEgo cel: 0 setCycle: End self)
			)
			(2
				(gKqSound1 number: 6255 setLoop: 1 play: setVol: 127)
				(= ticks 30)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(if (< (gEgo x:) 100)
					(gEgo normalize: 4)
				else
					(gEgo normalize: 5)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valFallsFromTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 6107
					loop: 0
					cel: 0
					x: 167
					y: 46
					setCycle: CT 2 1 self
				)
			)
			(1
				(gKqSound1 number: 6256 setLoop: 1 play:)
				(gEgo setCycle: CT 12 1 self)
			)
			(2
				(gKqSound1 number: 924 setLoop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					x: 197
					y: 85
					normalize: 3
					setScaler: Scaler 83 66 131 91
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valKilledByBorasco of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: (sBorascoFlies new:) self)
			)
			(1
				(= local1 1)
				(gKqMusic1 stop:)
				(wind setLoop: 1 play: setVol: 127)
				(gKqSound1 number: 62590 setLoop: -1 play: setVol: 127)
				(borasco
					view: 6107
					loop: 1
					cel: 0
					x: 136
					y: 14
					setPri: 14
					setScale:
					scaleX: 128
					scaleY: 128
					show:
					setCycle: CT 3 1 self
				)
			)
			(2
				(borasco setPri: 100 setCycle: CT 20 1 self)
			)
			(3
				(gEgo hide:)
				(borasco setCycle: End self)
				(borascoEats setLoop: -1 play:)
			)
			(4
				(gKqSound1 fade: 0 10 15 1 self)
				(borascoEats fade: 0 10 15 1 self)
			)
			(5)
			(6
				(EgoDead 50 self)
			)
			(7
				(borasco hide: setPri: 140)
				(gEgo
					x: 195
					y: 90
					normalize: 5
					setScaler: Scaler 83 66 131 91
				)
				(gKqMusic1 play: setVol: 127)
				(= cycles 2)
			)
			(8
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valThrowsBridle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 856) ; WAVE
				(gEgo
					view: 6104
					loop: 0
					cel: 0
					setScaler: Scaler 109 90 131 91
					setCycle: CT 25 1 self
				)
			)
			(1
				(gKqSound1 number: 856 setLoop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(2
				(if local14
					(= local14 0)
					(SetFlag 271)
					(gEgo put: 69) ; Magic_Bridle
				)
				(gEgo normalize: 5 setScaler: Scaler 83 66 131 91)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance glintMe of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 60 90))
			)
			(1
				(= temp0 (Random 0 8))
				(client
					cel: 0
					x: [local16 temp0]
					y: [local25 temp0]
					show:
					setCycle: End self
				)
			)
			(2
				(client hide:)
				(= cycles 2)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance valHides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 8 3 1 self 1250) ; "Hmmm."
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scirocco of Actor
	(properties
		sightAngle 40
		x 73
		y 102
		priority 140
		fixPriority 1
		view 6254
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 82) ; Do, Exit, Magic_Bridle
	)

	(method (doVerb theVerb)
		(switch theVerb
			(82 ; Magic_Bridle
				(if (hidingPlace onMe: gEgo)
					(= local13 1)
				else
					(gEgo setScript: (valThrowsBridle new:))
				)
				(gGame handsOff:)
			)
			(8 ; Do
				(gEgo setScript: (valReachesScirocco new:))
			)
		)
		(return 1)
	)

	(method (cue)
		(self setScript: sciroccoTimer)
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

(instance monster of Prop
	(properties
		x 297
		y 131
		view 6252
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 81) ; Do, Exit, Dream_Catcher
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; Dream_Catcher
				(gCurRoom setScript: (sMonsterTrapped new:))
			)
			(else
				(if (and (gCurRoom script:) local2)
					((gCurRoom script:) cue:)
				)
			)
		)
		(return 1)
	)
)

(instance glint of Prop
	(properties
		x 193
		y 33
		view 6100
	)
)

(instance ambrosia of View
	(properties
		approachX 187
		approachY 84
		view 6106
		loop 2
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(if (not (gEgo has: 67)) ; Ambrosia
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb)
		(if local3
			(gEgo setScript: (valGrabsAmbrosia new:) 0 self)
		else
			(gEgo setScript: (valReachesAmbrosia new:))
		)
	)
)

(instance ambrosiaSet of Set
	(properties)
)

(instance cave of Feature
	(properties
		approachX 205
		approachY 130
		x 270
		y 130
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 10 8 81 ; Exit, Do, Dream_Catcher
			setHotspot: 8 10 81 ; Do, Exit, Dream_Catcher
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 118 251 65 261 54 284 60 288 95 279 129
					yourself:
				)
		)
	)
)

(instance tree of Feature
	(properties
		approachX 160
		approachY 85
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 67)) ; Ambrosia
			(self
				approachVerbs: 8 10 ; Do, Exit
				setHotspot: 8 10 ; Do, Exit
				setPolygon:
					((Polygon new:)
						type: PContainedAccess
						init: 62 71 62 57 73 50 116 47 148 40 174 33 175 38 163 42 137 52 160 52 191 43 208 43 238 34 224 46 232 52 209 59 191 55 183 65 140 66 113 59 82 61 92 69 111 64 123 66 148 78 114 71 100 75 126 81 129 84 70 80 47 80 39 77
						yourself:
					)
			)
		)
	)

	(method (doVerb)
		(if (not (gCurRoom script:))
			(gCurRoom setScript: sClimbTree)
		)
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
					init: 128 109 156 118 142 136 101 136 81 125 104 114
					yourself:
				)
		)
	)
)

(instance borascoKillRange of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 38 87 56 91 99 94 140 94 136 101 182 105 205 93 210 79 179 79 151 78 144 85 45 81
					yourself:
				)
		)
	)
)

(instance ntmareKillRange of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 125 242 114 294 137 188 138 178 125
					yourself:
				)
		)
	)
)

(instance hidingPlace of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 80 234 77 239 90 193 99
					yourself:
				)
		)
	)
)

(instance rockEdge of Feature
	(properties
		approachX 236
		approachY 84
		x 270
		y 84
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 10 8 ; Exit, Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 71 242 50 250 40 247 22 269 36 248 56 224 90 207 117 169 98 181 90 192 88 203 93 204 81
					yourself:
				)
		)
	)

	(method (doVerb)
		(if (not (gEgo script:))
			(gEgo setScript: valHides)
		)
	)
)

(instance extra of Feature
	(properties
		nsLeft 303
		nsTop 9
		nsRight 304
		nsBottom 10
		x 303
		y 9
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 82) ; Magic_Bridle
	)

	(method (doVerb theVerb)
		(if (== theVerb 82) ; Magic_Bridle
			(= local14 1)
			(gKqSound1 number: 856 setLoop: 1 play: setVol: 127)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsLeft 98
		nsTop 134
		nsRight 168
		nsBottom 138
		approachX 133
		approachY 145
		x 133
		y 155
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 8 setHotspot: 8 10) ; Exit, Do, Do, Exit
	)

	(method (doVerb)
		(if (and (gCurRoom script:) local2)
			(gCurRoom setScript: runAway)
		else
			(gCurRoom newRoom: 6250)
		)
	)
)

(instance caveExit of ExitFeature
	(properties
		approachX 299
		approachY 121
		x 305
		y 121
		exitDir 6
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 10 8 ; Exit, Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 118 251 65 261 54 284 60 288 95 279 129
					yourself:
				)
		)
	)

	(method (doVerb)
		(gKqMusic1 fade:)
		(gCurRoom newRoom: 6150)
	)
)

(instance borascoEats of Sound
	(properties
		number 6260
	)
)

(instance wind of Sound
	(properties
		number 6251
	)
)

