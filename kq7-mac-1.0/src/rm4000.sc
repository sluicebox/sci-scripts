;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4000)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n098)
(use Print)
(use Inset)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4000 0
	dogTalker 1
)

(local
	local0
	local1
	local2
	local3
)

(instance rm4000 of KQRoom
	(properties
		picture 4000
	)

	(method (init)
		(gKqMusic1 number: 4000 loop: -1 play:)
		(super init:)
		(if (proc98_9)
			(SetFlag 192)
			(if
				(Print
					addText: {Speech or text?}
					addButton: 1 {Text} 0 20
					addButton: 0 {Speech} 20 20
					init:
				)
				(= gMsgType 1)
			)
			(switch gChapter
				(5
					(if
						(Print
							addText: {Do you want the femur?}
							addButton: 1 {Yes} 0 20
							addButton: 0 {No} 20 20
							init:
						)
						(gEgo get: 72) ; Femur
					)
					(if
						(Print
							addText: {Do you want the boogeyman?}
							addButton: 0 {Yes} 0 20
							addButton: 1 {No} 20 20
							init:
						)
						(SetFlag 192)
					)
				)
			)
		)
		(Load rsMESSAGE 4000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 320 0 320 87 253 87 253 116 140 116 61 100 17 100 48 126 48 136 0 136 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 85 136 97 131 282 133 320 99 320 136
					yourself:
				)
		)
		(eExit init:)
		(sExit init:)
		(gEgo init: normalize: setScaler: Scaler 93 40 116 60)
		(switch gPrevRoomNum
			(4050
				(gEgo posn: 340 97)
				(= local0 1)
				(gCurRoom setScript: sEnterEast)
			)
			(else
				(gEgo posn: 70 170)
				(= local0 0)
				(gCurRoom setScript: sEnterSouth)
			)
		)
		(cond
			((not local0)
				(setupRoom doit:)
			)
			((and (not (IsFlag 216)) (not (IsFlag 247)))
				(Load rsVIEW 4003)
				(Load rsVIEW 40035)
				(Load rsVIEW 4004)
				(Load rsVIEW 40045)
				(Load rsVIEW 4002)
				(Load rsVIEW 4005)
				(= local3 1)
			)
			(
				(and
					(not (IsFlag 247))
					(not (IsFlag 243))
					(not ((gInventory at: 72) ownedBy: 4000)) ; Femur
				)
				(Load rsVIEW 4003)
				(Load rsVIEW 40035)
				(Load rsVIEW 4004)
				(Load rsVIEW 40045)
				(Load rsVIEW 4005)
				(Load rsVIEW 4002)
				(= local3 1)
			)
			(else
				(setupRoom doit:)
			)
		)
	)

	(method (notify param1)
		(switch param1
			(1
				(theDog init: hide: setPri: 110 setScript: sShowDog)
			)
			(2
				(if local0
					(theDog
						view: 4001
						setLoop: 0
						cel: 0
						x: 192
						cycleSpeed: 12
						y: 106
						init:
						setScript: sSecondEntry
					)
				else
					(theDog
						view: 4002
						setLoop: 2
						cycleSpeed: 12
						posn: 175 111
						cel: 0
						init:
						setPri: 110
						setScript: sSecondEntry
					)
				)
			)
		)
	)

	(method (newRoom)
		(ClearFlag 192)
		(if (soundTimer client:)
			(soundTimer client: 0 delete: dispose:)
		)
		(gKqMusic1 fade:)
		(gKqSound1 stop:)
		(localSound stop:)
		(super newRoom: &rest)
	)
)

(instance sSecondEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(gEgo setMotion: PolyPath 70 127 self)
				else
					(= seconds 2)
				)
			)
			(1
				(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				(if local0
					(self setScript: sGetDogOutEast self)
				else
					(= cycles 1)
				)
			)
			(2
				(gKqSound1 number: 4004 loop: -1 play:)
				(theDog cel: 0 setCycle: End self)
			)
			(3
				(theDog cel: 0 setCycle: End self)
			)
			(4
				(theDog cel: 0 setCycle: End self)
			)
			(5
				(gKqSound1 stop:)
				(dogFeature init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetDogOutEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				(gKqSound1 number: 4001 loop: -1 play:)
				(theDog
					view: 4001
					setLoop: 0
					cel: 0
					x: 192
					cycleSpeed: 12
					y: 106
					show:
				)
				(= seconds 4)
			)
			(1
				(theDog setCycle: End self)
			)
			(2
				(theDog
					view: 4002
					setLoop: 0
					cel: 0
					posn: 210 102
					setCycle: End self
				)
			)
			(3
				(theDog
					view: 4002
					setLoop: 2
					cycleSpeed: 12
					posn: 175 111
					cel: 0
					init:
					setPri: 110
					setCycle: Fwd
				)
				(gKqSound1 number: 4004 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sLookGraffiti of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						MoveTo
						(graffiti approachX:)
						(graffiti approachY:)
						self
				)
			)
			(1
				(proc11_3 gEgo graffiti)
				(= seconds 3)
			)
			(2
				(gGame handsOn:)
				(gKqMusic1 number: 41094 loop: -1 play:)
				(gCurRoom setInset: iGraffiti self)
			)
			(3
				(gKqMusic1 number: 4000 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sShowDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(gEgo setMotion: PolyPath 70 127 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				(gKqSound1 number: 4001 loop: -1 play:)
				(theDog
					view: 4001
					setLoop: 0
					cel: 0
					x: 192
					cycleSpeed: 12
					y: 106
					show:
				)
				(= seconds 4)
			)
			(2
				(theDog setCycle: End self)
			)
			(3
				(theDog
					view: 4002
					setLoop: 0
					cel: 0
					posn: 210 102
					setCycle: End self
				)
			)
			(4
				(self setScript: sEgoReacts)
				(theDog setLoop: 1 posn: 167 111 cel: 0 setCycle: End self)
			)
			(5
				(gKqSound1 number: 4003 loop: -1 play:)
				(theDog setLoop: 2 posn: 175 111 cel: 0 setCycle: End self)
			)
			(6
				(theDog cel: 0 setCycle: End self)
			)
			(7
				(theDog cel: 0 setCycle: End self)
			)
			(8
				(gKqSound1 stop:)
				(= seconds 2)
			)
			(9
				(gKqSound1 play:)
				(theDog cel: 0 setCycle: End self)
			)
			(10
				(theDog cel: 0 setCycle: End self)
			)
			(11
				(theDog cel: 0 setCycle: End self)
			)
			(12
				(dogFeature init:)
				(gKqSound1 stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoReacts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localSound number: 4002 loop: 1 play:)
				(gEgo view: 8281 cel: 0 setLoop: 0 setCycle: End self)
			)
			(1
				(= seconds 4)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				(self dispose:)
			)
		)
	)
)

(instance sGetMedal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 269)
				(gEgo setMotion: PolyPath 102 119 self)
			)
			(1
				(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				(= cycles 2)
			)
			(2
				(gMessager say: 1 8 4 0 self) ; "(CURIOUS)Your master was Count Tsepish?"
			)
			(3
				(theDog
					view: 4004
					setLoop: 0 1
					posn: 116 124
					setCel: 17
					setCycle: End self
				)
			)
			(4
				(gEgo setMotion: PolyPath 114 119 self)
			)
			(5
				(gEgo
					setPri: (+ (theDog priority:) 2)
					view: 4004
					cel: 0
					setLoop: 1
					posn: 114 119
					setCycle: CT 21 1 self
				)
			)
			(6
				(SetFlag 227)
				(gEgo get: 73 setCycle: End self) ; Horseman_s_Medal
				(theDog view: 40045 setLoop: 4 cel: 0)
			)
			(7
				(theDog hide:)
				(gEgo
					setLoop: 2
					cycleSpeed: 10
					cel: 0
					posn: 117 127
					setCycle: CT 5 1 self
				)
			)
			(8
				(gKqSound1 number: 4008 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo
					view: 40045
					setLoop: 3
					cel: 0
					posn: 117 128
					setCycle: End self
				)
			)
			(10
				(gEgo setCycle: Beg self)
			)
			(11
				(theDog
					view: 40045
					setLoop: 8
					posn: 116 123
					cel: 0
					setPri: -1
					show:
				)
				(gEgo
					view: 40045
					setLoop: 5
					setPri: (+ (theDog priority:) 30)
					cel: 0
					posn: 112 119
					normalize:
					setPri: (+ (theDog priority:) 30)
					setScaler: Scaler 93 40 116 60
					setMotion: PolyPath 95 118 self
				)
			)
			(12
				((gCurRoom obstacles:) delete:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 320 0 320 87 253 87 252 104 207 105 207 118 103 118 103 107 99 109 61 100 17 100 48 126 48 136 0 136 0 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 85 136 97 131 282 133 320 99 320 136
							yourself:
						)
				)
				(gEgo normalize: setScaler: Scaler 93 40 116 60 setPri: -1)
				(proc11_3 gEgo theDog)
				(gGame handsOn:)
				(sWagTail register: 1)
				(theDog setPri: 110 setScript: sWagTail)
				(self dispose:)
			)
		)
	)
)

(instance sThrowBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 40050)
				(gKqSound1 stop:)
				(SetFlag 569)
				(dogFeature dispose:)
				(SetFlag 192)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 102 119 self)
			)
			(1
				(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				(= cycles 1)
			)
			(2
				(gMessager say: 0 98 8 0 self) ; "Good dog...nice dog."
			)
			(3
				(gEgo
					view: 4003
					setLoop: 0
					posn: 69 125
					cel: 0
					setCycle: CT 32 1 self
				)
			)
			(4
				(gKqSound1 number: 40050 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					normalize: 0
					setScaler: Scaler 93 40 116 60
					posn: 102 119
				)
				(theDog
					view: 4003
					setLoop: 1
					cel: 0
					posn: 145 123
					setCycle: End self
				)
			)
			(6
				(gKqSound1 number: 4006 loop: 1 play:)
				(theDog setLoop: 2 cel: 0 posn: 150 124 setCycle: End self)
			)
			(7
				(SetFlag 192)
				(soundTimer setReal: soundTimer 2)
				(theDog
					view: 40035
					posn: 150 124
					cycleSpeed: 10
					cel: 0
					setLoop: 6
					setCycle: Fwd
				)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 320 0 320 87 253 87 252 104 207 105 207 118 131 118 129 110 99 109 61 100 17 100 48 126 48 136 0 136 0 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 85 136 97 131 282 133 320 99 320 136
							yourself:
						)
				)
				(theDog setPri: 110)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClickOnDogWhenChewingBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(soundTimer client: 0 delete: dispose:)
				(gEgo setMotion: PolyPath 102 119 self)
			)
			(1
				(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				(= cycles 2)
			)
			(2
				(gMessager say: 1 8 3 1 self) ; "(KINDLY)There now. You're not such a bad dog after all."
			)
			(3
				(theDog setCycle: End self)
			)
			(4
				(theDog
					view: 40035
					setLoop: 3
					posn: 139 124
					cel: 0
					setCycle: End self
				)
			)
			(5
				(dogTalker clientCel: -2)
				(gMessager say: 1 8 3 2 self) ; "(AMUSED)And you are not such a bad human."
			)
			(6
				(theDog
					setLoop: 4
					posn: 141 112
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
			)
			(7
				(theDog cel: 0 setCycle: End self)
			)
			(8
				(theDog cel: 0 setCycle: End self)
			)
			(9
				(theBone ignoreActors: 1 init:)
				(theDog
					view: 40035
					setLoop: 5
					posn: 140 124
					cel: 0
					setCycle: End self
				)
			)
			(10
				(dogTalker clientCel: -2)
				(gMessager sayRange: 1 8 3 3 5 self) ; "(GENTLY)You are the first creature to be kind to me since I lost my master and mistress. Thank you."
			)
			(11
				(theDog
					view: 4004
					cel: 0
					posn: 116 124
					setLoop: 0
					setCycle: CT 16 1 self
				)
			)
			(12
				(theDog
					view: 4004
					cel: 0
					setLoop: 3
					posn: 116 124
					setCycle: End self
				)
			)
			(13
				(SetFlag 269)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(theDog setPri: 110)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 320 0 320 87 253 87 252 104 201 104 201 120 104 120 104 105 90 105 61 100 17 100 48 126 48 136 0 136 0 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 85 136 97 131 282 133 320 99 320 136
							yourself:
						)
				)
				(gGame handsOn:)
				(theDog setScript: sWagTail)
				(self dispose:)
			)
		)
	)
)

(instance sWagTail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(theDog
						view: 40045
						setLoop: 8
						posn: 116 124
						cycleSpeed: 10
						cel: 0
						setCycle: End self
					)
				else
					(theDog
						view: 4004
						setLoop: 3
						posn: 116 124
						cycleSpeed: 10
						cel: 0
						setCycle: End self
					)
				)
			)
			(1
				(= cycles 10)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sValTooClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: 4004 loop: -1 play:)
				(gEgo view: 8021 cel: 0 setLoop: 0 setCycle: End)
				(theDog
					view: 4002
					setLoop: 2
					posn: 175 111
					cel: 0
					setCycle: End self
				)
			)
			(1
				(theDog cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(gEgo
					normalize:
					setScaler: Scaler 93 40 116 60
					posn: (- (gEgo x:) 24) (gEgo y:)
				)
				(proc11_3 gEgo theDog)
				(= cycles 2)
			)
			(3
				(theDog cel: 0 setCycle: End self)
			)
			(4
				(gKqSound1 stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDogBarkRandom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: 4004 loop: -1 play:)
				(theDog
					view: 4002
					setLoop: 2
					posn: 175 111
					cel: 0
					setCycle: End self
				)
			)
			(1
				(theDog cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(theDog cel: 0 setCycle: End self)
			)
			(3
				(gKqSound1 stop:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 279 97 self)
			)
			(1
				(gGame handsOn:)
				(if local3
					(= local3 0)
					(setupRoom doit:)
				)
				(if local1
					(gCurRoom notify: local1)
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 70 127 self)
			)
			(1
				(gGame handsOn:)
				(if local1
					(gCurRoom notify: local1)
				)
				(self dispose:)
			)
		)
	)
)

(instance sNotBefriendedDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 8 1 0 self) ; "(VERY CAUTIOUS)Good dog...nice dog..."
			)
			(1
				(gKqSound1 number: 4005 loop: -1 play:)
				(theDog
					view: 4002
					setLoop: 2
					cel: 0
					posn: 175 111
					setCycle: End self
				)
			)
			(2
				(theDog cel: 0 setCycle: End self)
			)
			(3
				(theDog cel: 0 setCycle: End self)
			)
			(4
				(gKqSound1 stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDogLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 51 114 self)
			)
			(1
				(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				(= cycles 10)
			)
			(2
				(gMessager say: 1 8 7 0 self) ; "(REASURING)I'll do my very best to reunite you with your master."
			)
			(3
				(theDog view: 4005 setLoop: 0 posn: 81 117 cel: 0)
				(gEgo
					view: 4005
					setLoop: 1
					posn: 51 114
					cel: 0
					setCycle: End self
				)
			)
			(4
				(theDog hide:)
				(gEgo
					view: 4005
					cycleSpeed: 10
					setLoop: 2
					posn: 63 116
					cel: 0
					setCycle: End self
				)
			)
			(5
				(gEgo
					view: 4005
					setLoop: 5
					cycleSpeed: 6
					setPri: 200
					cel: 0
					setCycle: End
				)
				(theDog
					show:
					view: 4005
					setLoop: 3
					cel: 0
					setPri: (+ (gEgo priority:) 10)
					posn: 82 117
					setCycle: End self
				)
			)
			(6
				(theDog
					view: 4005
					setLoop: 4
					posn: 121 140
					cel: 0
					setPri: (- (gEgo priority:) 10)
					setCycle: End self
				)
			)
			(7
				(theDog hide:)
				(gEgo
					normalize: 0
					setScaler: Scaler 93 40 116 60
					setPri: -1
					posn: 49 116
				)
				(gGame handsOn:)
				(SetFlag 247)
				(client dispose:)
			)
		)
	)
)

(instance sChap4Dog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc11_3 gEgo chapter4Dog)
				(self setScript: sChap4DogSnd)
				(chapter4Dog cycleSpeed: 12 setCycle: CT 4 1 self)
			)
			(1
				(if (IsFlag 151)
					(gEgo
						setMotion:
							PolyPath
							(- (gEgo x:) 24)
							(gEgo y:)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if (IsFlag 151)
					(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				else
					(gEgo
						view: 8381
						setLoop: 0
						cycleSpeed: 10
						cel: 0
						setCycle: End
					)
				)
				(chapter4Dog setCycle: End self)
			)
			(3
				(glint
					view: 4001
					setLoop: 1
					cel: 0
					posn: 192 106
					init:
					setCycle: End self
				)
			)
			(4
				(gKqSound1 stop:)
				(if (IsFlag 151)
					(gEgo normalize: 0 setScaler: Scaler 93 40 116 60)
				else
					(gEgo
						posn: (- (gEgo x:) 24) (gEgo y:)
						normalize: 0
						setScaler: Scaler 93 40 116 60
					)
				)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(= seconds 5)
			)
			(6
				(glint dispose:)
				(chapter4Dog setCycle: Beg self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClickOnMedal1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 78 120 self)
			)
			(1
				(proc11_3 gEgo theDog self)
			)
			(2
				(SetFlag 244)
				(theDog setLoop: 8 cel: 0)
				(dogTalker clientCel: -2)
				(gMessager say: 1 8 5 0 self) ; "What was your mistress like, noble hound?"
			)
			(3
				(gGame handsOn:)
				(sWagTail register: 1)
				(client setScript: sWagTail)
			)
		)
	)
)

(instance sClickOnMedal2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 78 120 self)
			)
			(1
				(proc11_3 gEgo theDog self)
			)
			(2
				(SetFlag 245)
				(theDog setLoop: 8 cel: 0)
				(dogTalker clientCel: -2)
				(gMessager say: 1 8 6 0 self) ; "Why did Malicia slay your master?"
			)
			(3
				(gGame handsOn:)
				(sWagTail register: 1)
				(client setScript: sWagTail)
			)
		)
	)
)

(instance sChap4DogSnd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: (Random 4003 4005) loop: 1 play: self)
			)
			(1
				(= seconds (Random 1 4))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance dogFeature of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 110 105 131 105 131 148 110 148
					yourself:
				)
		)
		(gTheDoits add: self)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (doit)
		(if
			(and
				(not (== (theDog script:) sValTooClose))
				(self onMe: gEgo)
				(not (gCurRoom script:))
				(not ((gInventory at: 72) ownedBy: 4000)) ; Femur
			)
			(gGame handsOff:)
			(gEgo setMotion: 0)
			(theDog setScript: sValTooClose)
		)
	)
)

(instance theDog of Actor
	(properties
		noun 1
		x 167
		y 111
		view 4002
		loop 1
		cel 5
	)

	(method (init)
		(super init: &rest)
		(= signal (| (self signal:) $1000))
		(self setHotspot: 8 10 90 setPri: 110) ; Do, Exit, Femur
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== gChapter 5)
				(not script)
				(not (gCurRoom script:))
				(<= (Random 1 10500) 20)
				(not ((gInventory at: 72) ownedBy: 4000)) ; Femur
			)
			(self setScript: sDogBarkRandom)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(90 ; Femur
				(gEgo put: 72 4000) ; Femur
				(SetFlag 246)
				(self setScript: sThrowBone)
			)
			(8 ; Do
				(cond
					((IsFlag 245)
						(gGame handsOff:)
						(self setScript: sDogLeave)
					)
					((IsFlag 244)
						(self setHotspot: 0)
						(gGame handsOff:)
						(self setScript: sClickOnMedal2)
					)
					((IsFlag 243)
						(gGame handsOff:)
						(self setScript: sClickOnMedal1)
					)
					((IsFlag 269)
						(gGame handsOff:)
						(self setScript: sGetMedal)
						(SetFlag 243)
					)
					((IsFlag 246)
						(gGame handsOff:)
						(ClearFlag 246)
						(self setScript: sClickOnDogWhenChewingBone)
					)
					((IsFlag 242)
						(gMessager say: 1 8 2 0) ; "(THINKS TO HERSELF)Words will get me nowhere with that beast."
					)
					(else
						(gGame handsOff:)
						(SetFlag 242)
						(self setScript: sNotBefriendedDog)
					)
				)
			)
		)
	)
)

(instance graffiti of Feature
	(properties
		nsLeft 203
		nsTop 67
		nsRight 234
		nsBottom 79
		approachX 223
		approachY 112
	)

	(method (init)
		(if (IsFlag 152)
			(self setHotspot: 0)
		else
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 202 70 207 85 239 75 234 63 202 70
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sLookGraffiti)
			)
		)
	)
)

(instance theBone of Prop
	(properties
		x 141
		y 112
		view 40035
		loop 7
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 164 112 198 112 198 124 165 124
					yourself:
				)
		)
	)
)

(instance chapter4Dog of Actor
	(properties
		x 192
		y 106
		view 4001
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 166 106 188 106 188 149 166 149
					yourself:
				)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not script)
				(not (gCurRoom script:))
				(self onMe: gEgo)
				(not local2)
			)
			(= local2 1)
			(gGame handsOff: 0 1)
			(gEgo setMotion: 0)
			(gCurRoom setScript: sChap4Dog)
		)
	)
)

(instance localSound of Sound
	(properties)
)

(instance glint of Prop
	(properties)
)

(instance sExit of ExitFeature
	(properties
		nsLeft 31
		nsTop 130
		nsRight 122
		nsBottom 149
		sightAngle 0
		approachX 72
		approachY 138
		x 31
		y 220
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sEgoExitSouth)
			)
		)
	)
)

(instance sEgoExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 2 setScaler: Scaler 93 40 116 60)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 67 220 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 4101)
			)
		)
	)
)

(instance eExit of ExitFeature
	(properties
		nsLeft 285
		nsTop 82
		nsRight 319
		nsBottom 116
		approachX 325
		approachY 95
		x 297
		y 95
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom newRoom: 4050)
			)
		)
	)
)

(instance dogTalker of KQTalker
	(properties)

	(method (doit)
		(if
			(and
				(!= ticks -1)
				(> (- gGameTime ticks) 0)
				(if (& gMsgType $0002)
					(==
						(DoAudio
							audPOSITION
							audModNum
							audNoun
							audVerb
							audCase
							audSequence
						)
						-1
					)
				else
					1
				)
				(or (!= modeless 0) (& gMsgType $0002))
			)
			(self dispose: disposeWhenDone)
			(return 0)
		)
		(if mouth
			(mouth doit:)
		)
		(return 1)
	)

	(method (init &tmp temp0)
		(= client theDog)
		(= temp0 (client cycler:))
		(client cycler: 0)
		(super init: &rest)
		(client cycler: temp0)
	)
)

(instance iGraffiti of Inset
	(properties
		picture 4010
		priority 100
	)

	(method (init)
		(super init: &rest)
		(proc11_6)
	)
)

(instance boneChew of Sound
	(properties)
)

(instance soundTimer of Timer
	(properties)

	(method (cue)
		(switch (Random 1 3)
			(1
				(if (<= (Random 1 100) 50)
					(boneChew number: 40091 loop: 1 play:)
				else
					(boneChew number: 4009 loop: 1 play:)
				)
			)
			(else
				(boneChew number: 40061 loop: 1 play:)
			)
		)
		(self setReal: self (Random 2 4))
	)
)

(instance setupRoom of Code
	(properties)

	(method (doit)
		(return
			(switch gChapter
				(4
					(Load rsPIC 4010)
					(Load rsSOUND 4003)
					(Load rsSOUND 4004)
					(Load rsSOUND 4005)
					(Load rsVIEW 4001)
					(chapter4Dog init: setPri: 102)
					(graffiti init:)
				)
				(5
					(Load rsSOUND 4001)
					(Load rsSOUND 4002)
					(Load rsSOUND 4003)
					(Load rsSOUND 4004)
					(Load rsSOUND 4005)
					(Load rsSOUND 4006)
					(Load rsSOUND 4008)
					(cond
						((IsFlag 224) 1)
						((and (not (IsFlag 247)) (IsFlag 245))
							(SetFlag 192)
							(Load rsVIEW 4005)
							(theDog
								view: 4005
								setLoop: 0
								posn: 81 117
								cel: 0
								cycleSpeed: 12
								init:
							)
							(theBone
								init:
								ignoreActors: 1
								y: (- (theBone y:) 3)
								setPri: 110
							)
							((gCurRoom obstacles:) dispose:)
							(gCurRoom obstacles: 0)
							(gCurRoom
								addObstacle:
									((Polygon new:)
										type: PBarredAccess
										init: 320 0 320 87 253 87 253 112 124 112 106 120 47 120 54 102 20 102 48 126 48 136 0 136 0 0
										yourself:
									)
									((Polygon new:)
										type: PBarredAccess
										init: 85 136 97 131 282 133 320 99 320 136
										yourself:
									)
							)
						)
						((IsFlag 269)
							(SetFlag 192)
							(theBone ignoreActors: 1 init:)
							(theDog
								view: 4004
								cel: 0
								setLoop: 3
								posn: 116 124
								init:
								setPri: 110
								setScript: sWagTail
							)
							((gCurRoom obstacles:) dispose:)
							(gCurRoom obstacles: 0)
							(gCurRoom
								addObstacle:
									((Polygon new:)
										type: PBarredAccess
										init: 320 0 320 87 253 87 252 104 201 104 201 120 104 120 104 105 90 105 61 100 17 100 48 126 48 136 0 136 0 0
										yourself:
									)
									((Polygon new:)
										type: PBarredAccess
										init: 85 136 97 131 282 133 320 99 320 136
										yourself:
									)
							)
						)
						((IsFlag 246)
							(SetFlag 192)
							(Load rsVIEW 4003)
							(Load rsVIEW 40035)
							(Load rsVIEW 4004)
							(Load rsVIEW 40045)
							(Load rsVIEW 4002)
							(Load rsVIEW 4005)
							(theDog
								view: 40035
								posn: 150 124
								cel: 0
								setLoop: 6
								cycleSpeed: 12
								setCycle: Fwd
								init:
								setPri: 110
							)
							(soundTimer setReal: soundTimer 1)
							((gCurRoom obstacles:) dispose:)
							(gCurRoom obstacles: 0)
							(gCurRoom
								addObstacle:
									((Polygon new:)
										type: PBarredAccess
										init: 320 0 320 87 253 87 252 104 207 105 207 118 131 118 129 110 99 109 61 100 17 100 48 126 48 136 0 136 0 0
										yourself:
									)
									((Polygon new:)
										type: PBarredAccess
										init: 85 136 97 131 282 133 320 99 320 136
										yourself:
									)
							)
						)
						((and (not (IsFlag 216)) (not (IsFlag 247)))
							(SetFlag 192)
							(SetFlag 216)
							(= local1 1)
						)
						(
							(and
								(not (IsFlag 247))
								(not (IsFlag 243))
								(not ((gInventory at: 72) ownedBy: 4000)) ; Femur
							)
							(SetFlag 192)
							(if (not local0)
								(theDog
									view: 4002
									setLoop: 2
									cycleSpeed: 12
									posn: 175 111
									cel: 0
									init:
									setPri: 110
									setCycle: Fwd
								)
								(gKqSound1 number: 4004 loop: -1 play:)
							)
							(= local1 2)
						)
						(
							(and
								(not (IsFlag 247))
								(or
									(IsFlag 243)
									(IsFlag 244)
									((gInventory at: 72) ownedBy: 4000) ; Femur
								)
							)
							(SetFlag 192)
							(Load rsVIEW 4003)
							(Load rsVIEW 40035)
							(Load rsVIEW 4004)
							(Load rsVIEW 40045)
							(Load rsVIEW 4005)
							(Load rsVIEW 4002)
							(sWagTail register: 1)
							(theDog
								view: 40045
								setLoop: 8
								cycleSpeed: 12
								posn: 116 123
								cel: 0
								setPri: 110
								init:
								setScript: sWagTail
							)
							(theBone ignoreActors: 1 init:)
							((gCurRoom obstacles:) delete:)
							(gCurRoom obstacles: 0)
							(gCurRoom
								addObstacle:
									((Polygon new:)
										type: PBarredAccess
										init: 320 0 320 87 253 87 252 104 207 105 207 118 103 118 103 107 99 109 61 100 17 100 48 126 48 136 0 136 0 0
										yourself:
									)
									((Polygon new:)
										type: PBarredAccess
										init: 85 136 97 131 282 133 320 99 320 136
										yourself:
									)
							)
						)
					)
				)
			)
		)
	)
)

