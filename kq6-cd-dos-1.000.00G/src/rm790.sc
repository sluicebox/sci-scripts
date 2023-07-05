;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 790)
(include sci.sh)
(use Main)
(use rgCastle)
(use n913)
(use FlipPoly)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm790 0
)

(local
	local0
	local1 = 1
	local2
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp1 local0)
	(if argc
		(= local0 (+ 1 (not (== local0 2))))
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) dispose:)
			(gCurRoom obstacles: 0)
			(switch local0
				(1
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 81 129 56 138 114 169 114 177 107 177 64 153 26 125 4 99 4 63 33 34 69 18 57 18 24 32 0 49 -10 83 0 164 51 189 230 189 285 185 319 169 319 155 298 146 230 128 186 124 129 124
								yourself:
							)
					)
				)
				(else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 191 124 134 124 90 128 58 134 36 154 44 154 72 134 85 134 48 158 0 158 1 169 35 185 90 189 269 189 320 164 330 83 320 49 296 32 263 18 251 18 287 34 316 63 316 99 294 125 256 153 213 177 206 177 206 169 226 129
								yourself:
							)
					)
				)
			)
		)
	)
	(if (!= temp1 local0)
		(= local2 (not local2))
	)
	(gEgo oldScaleSignal: 0)
	(if local2
		(gEgo setPri: 5 setScale: Scaler 100 56 131 41)
	else
		(gEgo
			setScale:
				Scaler
				(gCurRoom maxScaleSize:)
				(gCurRoom minScaleSize:)
				(gCurRoom maxScaleY:)
				(gCurRoom minScaleY:)
			setPri: -1
		)
	)
	((gEgo scaler:) doit:)
)

(procedure (localproc_1 param1)
	(if (== local0 2)
		(return (- 320 param1))
	else
		(return param1)
	)
)

(instance rm790 of CastleRoom
	(properties
		noun 3
		picture 790
		style 10
		walkOffEdge 1
		autoLoad 0
		minScaleSize 60
		minScaleY 122
		maxScaleY 173
	)

	(method (init)
		(if (== gPrevRoomNum 750)
			(|= style $4000)
		else
			(&= style $bfff)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 81 129 56 138 114 169 114 177 107 177 64 153 26 125 4 99 4 63 33 34 69 18 57 18 24 32 0 49 -10 83 0 164 51 189 230 189 285 185 319 169 319 155 298 146 230 128 186 124 129 124
					yourself:
				)
		)
		(super init: &rest)
		(gEgo init:)
		(gFeatures
			add: stairsFeature doorFeature torchFeature
			eachElementDo: #init
		)
		(switch gPrevRoomNum
			(750
				(FlipPoly)
				(gEgo posn: 256 19)
				(= local2 1)
				(= local0 2)
				(self setScript: enterFromTop)
				(stairs addToPic:)
				(railing addToPic:)
				(doorCover addToPic:)
			)
			(else
				(rglow init: posn: 228 81 setLoop: 0)
				(lglow init: posn: 96 73 setLoop: 2)
				(rflame init: posn: 229 73 setLoop: 4 setCycle: Fwd)
				(lflame init: posn: 97 71 setLoop: 4 setCycle: Fwd)
				(gEgo loop: 2 posn: 159 125)
				(vizier init:)
				(= local0 1)
				(if (or (not gHowFast) (not (HaveMouse)))
					((ScriptID 80 0) loiterTimer: 242) ; rgCastle
				else
					((ScriptID 80 0) loiterTimer: 122) ; rgCastle
				)
			)
		)
		(localproc_0)
		((gEgo scaler:) doit:)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((or (& temp0 $0002) (and (== local0 2) (& temp0 $0044)))
				(self setScript: changeTowerRooms)
			)
			((and (& temp0 $2000) local2)
				(gEgo
					setScale:
						Scaler
						maxScaleSize
						minScaleSize
						maxScaleY
						minScaleY
					setPri: -1
				)
				(= local2 0)
			)
			((and (& temp0 $4020) (not local2))
				(gEgo setPri: 13 setScale: Scaler 100 56 131 41)
				((gEgo scaler:) doit:)
				(= local2 1)
			)
			(local2
				(cond
					((< (gEgo y:) 83)
						(if (== (gEgo priority:) 13)
							(gEgo priority: 5)
						)
					)
					((== (gEgo priority:) 5)
						(gEgo priority: 13)
					)
				)
			)
		)
		(super doit: &rest)
	)

	(method (doLoiter)
		(gCurRoom setScript: castSpell 0 2)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 752)
	)

	(method (newRoom newRoomNumber)
		(lTimer dispose: delete:)
		(rTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance changeTowerRooms of Script
	(properties)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(= register local2)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				((ScriptID 80 0) loiterTimer: 0) ; rgCastle
				(= cycles 2)
			)
			(1
				(= temp0
					(if register
						(localproc_1 64)
					else
						49
					)
				)
				(= temp1 (if register 19 else 149))
				(gEgo setMotion: MoveTo temp0 temp1 self)
			)
			(2
				(= temp2 1)
				(if register
					(if (== local0 2)
						(gCurRoom newRoom: 750)
						(= temp2 0)
					else
						(gEgo posn: 49 149)
					)
				else
					(gEgo posn: 64 19)
				)
				(if temp2
					(localproc_0 register)
					(if (== local0 1)
						(gCurRoom style: (& (gCurRoom style:) $bfff))
					else
						(gCurRoom style: (| (gCurRoom style:) $4000))
					)
					(gCurRoom drawPic: 790)
					(if (== local0 local1)
						(vizier init:)
					)
					(if (== local0 2)
						(stairs addToPic:)
						(railing addToPic:)
						(doorCover addToPic:)
						(rglow init: posn: 223 73 setLoop: 3)
						(rTimer client: rglow)
						(lglow init: posn: 90 81 setLoop: 1)
						(lTimer client: lglow)
						(rflame init: posn: 222 71 setLoop: 4 setCycle: Fwd)
						(lflame init: posn: 90 73 setLoop: 4 setCycle: Fwd)
					else
						(if (gAddToPics contains: stairs)
							(stairs dispose:)
							(railing dispose:)
							(doorCover dispose:)
						)
						(rglow init: posn: 228 81 setLoop: 0 cue:)
						(rTimer client: rglow)
						(lglow init: posn: 96 73 setLoop: 2)
						(lTimer client: lglow)
						(rflame init: posn: 229 73 setLoop: 4 setCycle: Fwd)
						(lflame init: posn: 97 71 setLoop: 4 setCycle: Fwd)
					)
					(= cycles 2)
				)
			)
			(3
				(= temp0
					(if register
						68
					else
						(localproc_1 42)
					)
				)
				(= temp1 (if register 132 else 45))
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(4
				(if (not local2)
					(gEgo reset:)
					(gGame handsOn:)
					(if (or (not gHowFast) (not (HaveMouse)))
						((ScriptID 80 0) loiterTimer: 61) ; rgCastle
					else
						((ScriptID 80 0) loiterTimer: 31) ; rgCastle
					)
					(self dispose:)
				else
					(gCurRoom setScript: castSpell 0 3)
				)
			)
		)
	)
)

(instance enterFromTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 278 29 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance castSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(genie loop: 8 cel: (+ 6 (< (gEgo x:) 160)) setPri: 15)
				(cond
					((>= (gEgo x:) 160)
						(if (== local0 2)
							(genie posn: (localproc_1 257) 162)
						else
							(genie posn: 17 137)
						)
					)
					((== local0 2)
						(genie posn: (localproc_1 17) 137)
					)
					(else
						(genie posn: (localproc_1 257) 162)
					)
				)
				(= cycles 2)
			)
			(1
				(self setScript: (ScriptID 752 1) self genie) ; geniePoofIn
			)
			(2
				(Face gEgo genie self)
			)
			(3
				(= cycles 5)
			)
			(4
				(switch register
					(1
						(gMessager say: 4 5 0 0 self) ; "I'm afraid there's not much more to see in the throne room! There will be more fireworks out here! Tee, hee!"
					)
					(2
						(gMessager say: 1 0 2 0 self) ; "So there you are! Decided to wait around for me, eh?"
					)
					(3
						(gMessager say: 1 0 4 0 self) ; "Changed your mind about chasing after my master, eh? Good idea! You never would have won, anyway, and it's so much easier to just kill you here!"
					)
				)
			)
			(5
				(= global106 gEgo)
				(= global156 getEgo)
				(self setScript: (ScriptID 752 0) 0 genie) ; throwDazzle
			)
		)
	)
)

(instance getEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 749
					normal: 0
					cel: 0
					loop: (mod (gEgo cel:) 4)
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(1
				(if (or (not local2) (and local2 (< (gEgo y:) 43)))
					(gEgo
						loop:
							(switch (gEgo loop:)
								(0 3)
								(1 2)
								(2 1)
								(3 0)
							)
					)
				)
				(gEgo setCycle: End self)
			)
			(2
				(if (> (gEgo loop:) 2)
					(gEgo
						loop: (+ 4 (== (gEgo loop:) 3))
						cycleSpeed: 10
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if register
					(self dispose:)
				else
					(EgoDead 18) ; "Genie, meenie, minie, moe...Alexander can't be slow!"
				)
			)
		)
	)
)

(instance genie of Actor
	(properties
		x 257
		y 162
		view 702
		loop 7
		priority 13
		signal 16
	)
)

(instance vizier of Actor
	(properties
		view 145
		signal 8192
		scaleSignal 1
		scaleX 80
		scaleY 80
	)

	(method (init)
		(= x (localproc_1 20))
		(= y 39)
		(super init: &rest)
		(self
			setCycle: Walk
			setStep: 8 4
			setMotion: MoveTo (localproc_1 80) 14 self
		)
	)

	(method (cue)
		(++ local1)
		(self dispose:)
	)
)

(instance doorFeature of Feature
	(properties
		noun 4
		onMeCheck 8
	)

	(method (onMe param1)
		(return (and (super onMe: param1) (== local0 1)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: castSpell 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stairsFeature of Feature
	(properties
		noun 5
		onMeCheck 52
	)
)

(instance torchFeature of Feature
	(properties
		noun 7
		onMeCheck 128
	)
)

(instance stairs of View
	(properties
		x 84
		y 161
		noun 6
		view 790
		cel 1
		signal 20496
	)
)

(instance railing of View
	(properties
		x 84
		y 161
		noun 6
		view 790
		priority 10
		signal 20496
	)
)

(instance doorCover of View
	(properties
		x 133
		y 65
		onMeCheck 0
		view 790
		loop 1
		signal 16400
	)
)

(instance mainPoly of Polygon ; UNUSED
	(properties)
)

(instance rglow of Prop
	(properties
		view 791
		priority 4
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(rTimer setCycle: self (Random 10 30))
	)

	(method (cue)
		(self cel: (Random 0 2))
		(rflame cycleSpeed: (Random 4 8))
		(rTimer setCycle: self (Random 2 20))
	)
)

(instance lglow of Prop
	(properties
		view 791
		priority 4
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(lTimer setCycle: self (Random 10 30))
	)

	(method (cue)
		(self cel: (Random 0 2))
		(lflame cycleSpeed: (Random 4 8))
		(lTimer setCycle: self (Random 2 20))
	)
)

(instance rflame of Prop
	(properties
		view 791
		priority 5
		signal 18448
	)
)

(instance lflame of Prop
	(properties
		view 791
		priority 5
		signal 18448
	)
)

(instance lTimer of Timer
	(properties)
)

(instance rTimer of Timer
	(properties)
)

