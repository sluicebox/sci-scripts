;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use ExitFeature)
(use OccasionalCycle)
(use BalloonTalker)
(use invCode)
(use ADRoom)
(use PAvoider)
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
	rm250 0
	watchManTalker 1
)

(local
	local0
	local1
	local2
)

(instance rm250 of ADRoom
	(properties
		noun 22
		picture 250
		north 210
		west 240
	)

	(method (init)
		(Load rsSCRIPT 927)
		(self
			addObstacle:
				(roomPoly
					type: PContainedAccess
					init: 208 85 149 135 113 135 113 137 143 137 143 166 91 166 91 176 297 176 297 167 266 146 215 146 215 143 263 143 239 126 188 126
					yourself:
				)
		)
		(super init: &rest)
		(gLongSong number: 250 setLoop: -1 play:)
		(gEgo
			init:
			normalize:
			setScale: 0
			actions: pepperActions
			setAvoider: PAvoider
		)
		(switch gPrevRoomNum
			(116
				(= global114 0)
				(= picture 0)
				(DrawPic 250 100 1)
			)
			(210
				(gEgo posn: 205 90 loop: 2 setScale: Scaler 100 68 108 75)
				(self setScript: sEnterFrom210)
			)
			(else
				(gGame handsOff:)
				(hole init:)
				(bone init:)
				(ClearFlag 10)
				(if (not (IsFlag 11))
					(babyClothes init: stopUpd:)
				)
				(if (not (IsFlag 10))
					(boyClothes init: stopUpd:)
				)
				((ScriptID 895 0) ; pepper
					view: 800
					x: 231
					y: 131
					setHeading: 190
					ignoreActors: 0
				)
				((ScriptID 895 1) ; lockjaw
					init:
					actions: lockjawActions
					x: 247
					y: 145
					setAvoider: PAvoider
					ignoreActors: 0
					setHeading: 225
				)
				(gInventory
					addAfter:
						(gInventory at: 44) ; Wood_Cutting_c
						(Bone init: yourself:)
						(Boy_s_Clothes init: yourself:)
						(Baby_s_Clothes init: yourself:)
				)
				(boyClothesFeature init:)
				(babyClothesFeature init:)
				(watchMan init: setScale: 100 setScript: sWatchMan)
				(self
					addObstacle:
						(lockjawPoly
							type: PBarredAccess
							init: 239 150 239 164 195 164 195 150
							yourself:
						)
				)
				(roomTimer setReal: self 3)
			)
		)
		(if (== gPrevRoomNum 116)
			(self curPic: 250 picture: 250)
		)
		(northEFeature init:)
		(barrel init: setOnMeCheck: 1 16384)
		(blueApron init:)
		(clothesLine init: setOnMeCheck: 1 8192)
		(crate1 init: setOnMeCheck: 1 1024)
		(crate2 init: setOnMeCheck: 1 512)
		(crate3 init:)
		(crate4 init: setOnMeCheck: 1 256)
		(crate5 init: setOnMeCheck: 1 128)
		(crate6 init:)
		(crate8 init:)
		(girlSuit init:)
		(leaves init: setOnMeCheck: 1 4096)
		(pebbles1 init: approachVerbs: 7 setOnMeCheck: 1 2048) ; Do
		(pinkCoat init:)
	)

	(method (doit)
		(cond
			(script)
			((< (gEgo y:) 110)
				(if (or (not (IsFlag 10)) (not (IsFlag 11)))
					(gGame handsOff:)
					(gEgo setMotion: 0 y: (+ (gEgo y:) 2))
					(watchMan
						view: 810
						setMotion: 0
						setLoop: 0
						setScript: sHalt
					)
				else
					(gCurRoom setScript: sExitTo210)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gInventory delete: Bone delete: Boy_s_Clothes delete: Baby_s_Clothes)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 16)
		(super doVerb: theVerb)
	)

	(method (cue)
		(if
			(and
				local2
				(or
					(not (gEgo has: 45))
					(not (gEgo has: 46))
					(not (gEgo has: 47))
					(not (IsFlag 10))
				)
			)
			(gMessager say: 23 0 14) ; "Lockjaw sure is enjoying that bone! He's not going to pay any attention to Pepper as long as he has a bone to chomp on."
		else
			(= local2 1)
			(roomTimer setReal: self 120)
			(gGame handsOn:)
		)
	)
)

(instance pickUpPebbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 19 7 0 0 self) ; "These pebbles just might come in handy!"
			)
			(1
				((ScriptID 895 0) ; pepper
					view: (if (IsFlag 10) 805 else 839)
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(3
				((ScriptID 895 0) get: 4 normalize:) ; pepper, Pebbles
				(gGame points: 254 2 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetBoyClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face (ScriptID 895 0) (ScriptID 895 1)) ; pepper, lockjaw
				(= seconds 2)
			)
			(1
				(gMessager say: 6 25 0 1 self) ; "Get the bone, boy! Go get it!"
			)
			(2
				(gEgo setMotion: PolyPath 154 131 self)
			)
			(3
				((ScriptID 895 0) ; pepper
					view: 251
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
				((ScriptID 895 1) ; lockjaw
					normalize:
					normal: 0
					ignoreActors: 1
					setMotion: MoveTo 183 120 self
				)
			)
			(4
				(bone
					view: 251
					setLoop: 2
					setCycle: Fwd
					x: (+ ((ScriptID 895 0) x:) 15) ; pepper
					y: (- ((ScriptID 895 0) y:) 35) ; pepper
					init:
					setPri: (- ((ScriptID 895 0) priority:) 1) ; pepper
					ignoreActors: 1
					setStep: 9 8
					setMotion: MoveTo 180 55 self
				)
			)
			(5)
			(6
				(bone dispose:)
				((ScriptID 895 0) normalize: setHeading: 90) ; pepper
				((ScriptID 895 1) ; lockjaw
					view: 251
					setLoop: 4
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(7
				(gLongSong2 number: 2502 setLoop: 1 play:)
				(boyClothes hide:)
				((ScriptID 895 1) setCycle: End self) ; lockjaw
			)
			(8
				(gGame points: 251 2)
				(= local1 1)
				(boyClothes show: setCel: 1 x: 183 y: 136 z: 30)
				((ScriptID 895 1) ; lockjaw
					normalize:
					x: 179
					y: 123
					setMotion: MoveTo 232 153 self
				)
			)
			(9
				(sFx number: 2503 setLoop: 1 setVol: 127 play: self)
			)
			(10
				(Face (ScriptID 895 0) (ScriptID 895 1)) ; pepper, lockjaw
				(= seconds 3)
			)
			(11
				(gMessager say: 6 25 0 2 self) ; "Good boy! Good boy!"
			)
			(12
				(lockjawPoly dispose:)
				(if (or (gEgo has: 47) (IsFlag 11) local0)
					(gEgo put: 45)
					(gMessager say: 23 0 12 0 self) ; "Oh, bummer! The bone went on the roof!"
				else
					(self cue:)
				)
			)
			(13
				(lockjawPoly
					type: PBarredAccess
					init: 256 145 256 160 210 160 210 145
					yourself:
				)
				(gGame handsOn:)
				(boyClothesFeature dispose:)
				((ScriptID 895 1) normal: 1) ; lockjaw
				(self dispose:)
			)
		)
	)
)

(instance sGetBabyClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face (ScriptID 895 0) (ScriptID 895 1)) ; pepper, lockjaw
				(= seconds 2)
			)
			(1
				(gMessager say: 2 25 0 1 self) ; "Get the bone, Lockjaw! Get it, boy!"
			)
			(2
				(gEgo setMotion: PolyPath 168 137 self)
			)
			(3
				((ScriptID 895 0) ; pepper
					view: 251
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
				((ScriptID 895 1) ; lockjaw
					normalize:
					normal: 0
					setMotion: MoveTo 240 148 self
				)
			)
			(4
				(bone
					view: 251
					setLoop: 2
					setCycle: Fwd
					x: (+ ((ScriptID 895 0) x:) 15) ; pepper
					y: (- ((ScriptID 895 0) y:) 35) ; pepper
					init:
					setPri: (- ((ScriptID 895 0) priority:) 1) ; pepper
					ignoreActors: 1
					setStep: 9 8
					setMotion: MoveTo 239 58 self
				)
			)
			(5)
			(6
				(bone dispose:)
				((ScriptID 895 0) normalize: setHeading: 90) ; pepper
				((ScriptID 895 1) ; lockjaw
					view: 251
					setLoop: 5
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(7
				(gLongSong2 number: 2502 setLoop: 1 setVol: 127 play: self)
				(babyClothes hide:)
				((ScriptID 895 1) setCycle: End self) ; lockjaw
			)
			(8)
			(9
				(sFx number: 2503 setLoop: 1 setVol: 127 play: self)
			)
			(10
				(gGame points: 250 2)
				(= local0 1)
				((ScriptID 895 1) normalize: setMotion: MoveTo 232 153 self) ; lockjaw
				(babyClothes setCel: 3 setPri: 4 x: 225 y: 140 z: 30 show:)
			)
			(11
				(Face (ScriptID 895 0) (ScriptID 895 1)) ; pepper, lockjaw
				(= seconds 2)
			)
			(12
				(lockjawPoly dispose:)
				(gMessager say: 2 25 0 2 self) ; "Good boy! Awesome boy!"
			)
			(13
				(lockjawPoly
					type: PBarredAccess
					init: 256 145 256 160 210 160 210 145
					yourself:
				)
				(babyClothesFeature dispose:)
				(if (or (gEgo has: 46) (IsFlag 10) local1)
					(gMessager say: 23 0 12) ; "Oh, bummer! The bone went on the roof!"
					(gEgo put: 45)
				)
				((ScriptID 895 1) normal: 1) ; lockjaw
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWrapDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 199 145 self)
			)
			(1
				((ScriptID 895 0) setHeading: 135) ; pepper
				((ScriptID 895 1) ; lockjaw
					normalize:
					normal: 0
					setMotion: PolyPath 232 153 self
				)
			)
			(2
				(gMessager say: 18 121 9 1 3 self) ; "Hold still, Lockjaw-boy, we'll just wrap you up in this..."
			)
			(3
				(gEgo view: 252 setLoop: 2 setCel: 0 setCycle: End self)
				((ScriptID 895 1) hide:) ; lockjaw
			)
			(4
				((ScriptID 2004 0) ; LockjawTalker
					winX: 90
					winY: 131
					tailPosn: 1
					talkWidth: 100
				)
				(gMessager say: 18 121 9 4 5 self) ; "There we go! You look MAHvelous!"
			)
			(5
				(gGame points: 253 2)
				(SetFlag 11)
				(gEgo
					put: 47
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 222 146 self
				)
				(gTheIconBar advanceCurIcon:)
			)
			(6
				(gLongSong fade:)
				(gCurRoom newRoom: 212)
			)
		)
	)
)

(instance sChangeClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 20 120 0 0 self) ; "Hey, I think this will fit just fine! It's actually pretty cool. I'll just--"
			)
			(1
				(gGame points: 252 2)
				(gEgo setMotion: PolyPath 114 137 self)
			)
			(2
				(if (IsFlag 10)
					(ClearFlag 10)
					(gEgo view: 800)
				else
					(SetFlag 10)
					(gEgo view: 790)
				)
				(gEgo put: 46 setMotion: MoveTo 164 139 self)
			)
			(3
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(roomTimer dispose:)
				(gEgo ignoreActors: 1 setMotion: PolyPath 198 152 self)
				(gGame points: 248 1)
			)
			(1
				(bone hide:)
				((ScriptID 895 1) ; lockjaw
					normalize:
					view: 250
					setLoop: 1
					normal: 0
					setCycle: OccasionalCycle self 1 10 20
				)
				(gEgo setHeading: 90 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 5 7 2 1 self) ; "Grrrrrr!"
			)
			(4
				(gLongSong2 number: 905 setLoop: 1 play: self)
			)
			(5
				(gMessager say: 5 7 2 2 self) ; "Oh, don't give me that "grr" stuff. I'll give it right back. Now fork over the bone, bud!"
			)
			(6
				(gLongSong2 number: 1206 setLoop: 1 play: self)
			)
			(7
				((ScriptID 895 1) normalize: normal: 0) ; lockjaw
				(bone show:)
				(gMessager say: 5 7 2 3 4 self) ; "Good boy! Good boy!"
			)
			(8
				((ScriptID 895 0) ; pepper
					view: 839
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(9
				(bone dispose:)
				(roomPoly dispose:)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(10
				((ScriptID 895 0) ; pepper
					get: 45
					normalize:
					setMotion: MoveTo 162 146 self
				)
				((ScriptID 895 1) normalize: setMotion: MoveTo 215 157 self) ; lockjaw
			)
			(11)
			(12
				((ScriptID 895 1) view: 838 cel: 0 normal: 1) ; lockjaw
				(= ticks 30)
			)
			(13
				(roomPoly
					type: PContainedAccess
					init: 208 85 149 135 113 135 113 137 143 137 143 166 91 166 91 176 297 176 297 167 239 126 188 126
					yourself:
				)
				((ScriptID 895 0) setHeading: 90) ; pepper
				((ScriptID 895 1) setPri: 12) ; lockjaw
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom240 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 241 145 self)
			)
			(1
				((ScriptID 895 0) normalize: ignoreActors: 0) ; pepper
				((ScriptID 895 1) ignoreActors: 0) ; lockjaw
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom210 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 188 121 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo210 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: Scaler 100 68 108 75
					setMotion: MoveTo 205 90 self
				)
			)
			(1
				(gLongSong fade:)
				(if (== gAct 1)
					(gCurRoom newRoom: 212)
				else
					(gCurRoom newRoom: 210)
				)
			)
		)
	)
)

(instance sHalt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(if (< (client x:) 204)
					(client setLoop: 2)
				else
					(client setLoop: 3)
				)
				(client view: 815 setCycle: Fwd setMotion: MoveTo 204 92 self)
			)
			(2
				(client view: 810 setCycle: 0 setLoop: 4 stopUpd:)
				((ScriptID 895 0) stopUpd:) ; pepper
				(= ticks 30)
			)
			(3
				(if (not (IsFlag 10))
					(gMessager say: 23 0 8 0 self) ; "Halt! Halt, you little wretch! You'll not get away THAT easily, you won't!"
				else
					(gMessager say: 23 0 7 0 self) ; "Halt! You're a clever one, lass, but I'd recognize that ugly dog anywhere!"
				)
			)
			(4
				(gEgo setHeading: 200 self)
				(client
					view: 815
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 151 92
				)
			)
			(5
				(= global199 2)
				(gLongSong fade:)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sWatchMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 0 5))
				(= seconds (Random 3 6))
			)
			(1
				(if (== (client loop:) 3)
					(client
						setCycle: Fwd
						setLoop: 2
						setMotion: MoveTo 263 92 self
					)
				else
					(client
						setCycle: Fwd
						setLoop: 3
						setMotion: MoveTo 151 92 self
					)
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(if (== (client loop:) 2)
					(client setLoop: 3 setMotion: MoveTo 151 92 self)
				else
					(client setLoop: 2 setMotion: MoveTo 263 92 self)
				)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance jumpForClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(1
						((ScriptID 895 0) setMotion: PolyPath 255 139 self) ; pepper
					)
					(2
						((ScriptID 895 0) setMotion: PolyPath 144 138 self) ; pepper
					)
					(3
						((ScriptID 895 0) setMotion: PolyPath 170 136 self) ; pepper
					)
					(4
						((ScriptID 895 0) setMotion: PolyPath 242 134 self) ; pepper
					)
				)
			)
			(1
				((ScriptID 895 0) ; pepper
					view: 250
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(switch register
					(1
						(gMessager say: 4 7 0 0 self) ; "Oof! I just can't reach it! Oh well, it's ugly anyway."
					)
					(2
						(gMessager say: 21 7 0 0 self) ; "Darn, I just can't reach it! On second thought, it's pretty hideous... I don't think I'd look good in Barfo-Pink!"
					)
					(3
						(gMessager say: 6 7 1 0 self) ; "Darn! I just can't jump high enough!"
					)
					(4
						(gMessager say: 2 7 1 0 self) ; "Shoot, Lockjaw, I can't quite reach it!"
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance boneOnClothes of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: PolyPath 255 139 self) ; pepper
			)
			(1
				(Face (ScriptID 895 0) (ScriptID 895 1) self) ; pepper, lockjaw
			)
			(2
				(gMessager say: 4 25 0 1 self) ; "Well, I guess I should try to get that apron..."
			)
			(3
				((ScriptID 895 0) ; pepper
					view: 251
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
				((ScriptID 895 1) ; lockjaw
					normalize:
					setCycle: Walk
					ignoreActors: 1
					normal: 0
					setMotion: PolyPath 251 146 self
				)
			)
			(4
				(bone
					view: 251
					setLoop: 2
					setCycle: Fwd
					x: ((ScriptID 895 0) x:) ; pepper
					y: (- ((ScriptID 895 0) y:) 14) ; pepper
					init:
					setPri: (- ((ScriptID 895 0) priority:) 1) ; pepper
					ignoreActors: 1
					setStep: 9 8
					setMotion: MoveTo 261 58 self
				)
			)
			(5)
			(6
				(bone dispose:)
				((ScriptID 895 0) normalize:) ; pepper
				((ScriptID 895 1) ; lockjaw
					view: 251
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(7
				((ScriptID 895 1) normalize:) ; lockjaw
				(gMessager say: 4 25 0 2 self) ; "NAH! I just couldn't stand it. My cool-ativity would suffer."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ljGetBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 249 2)
				((ScriptID 895 1) normal: 0) ; lockjaw
				((ScriptID 895 0) setMotion: PolyPath 177 162 self) ; pepper
			)
			(1
				(gMessager say: 18 25 0 1 self) ; "Here, boy!"
			)
			(2
				((ScriptID 895 0) ; pepper
					view: 251
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				((ScriptID 895 1) ; lockjaw
					view: 251
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(gMessager say: 18 25 0 2 self) ; "Whoa! Lockjaw the circus dog!"
			)
			(5
				((ScriptID 895 0) normalize: setHeading: 0) ; pepper
				((ScriptID 895 1) normalize:) ; lockjaw
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pickupClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gMessager say: 6 7 2 0 self) ; "I'll just borrow this outfit..."
				else
					(gMessager say: 2 7 2 0 self) ; "Hmm, this might be just the thing..."
				)
			)
			(1
				(if register
					((ScriptID 895 0) setMotion: PolyPath 161 130 self) ; pepper
				else
					((ScriptID 895 0) setMotion: PolyPath 217 126 self) ; pepper
				)
			)
			(2
				((ScriptID 895 0) ; pepper
					view: (if (not (IsFlag 10)) 839 else 805)
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(3
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(4
				(if register
					(boyClothes dispose:)
					((ScriptID 895 0) get: 46 normalize:) ; pepper
				else
					(babyClothes dispose:)
					((ScriptID 895 0) get: 47 normalize:) ; pepper
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance boyClothes of Actor
	(properties
		x 196
		y 39
		noun 6
		view 250
		priority 4
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (< y 100)
					(gCurRoom setScript: jumpForClothes 0 3)
				else
					(gCurRoom setScript: pickupClothes 0 1)
				)
			)
			(25 ; Bone or invDoggieBone
				(if local1
					(gMessager say: 6 25 2) ; "Pepper doesn't want to put the yucchy, drooly bone on the boy's outfit any more than she has to!"
				else
					(gCurRoom setScript: sGetBoyClothes)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance babyClothes of Actor
	(properties
		x 247
		y 35
		noun 2
		approachX 209
		approachY 126
		view 250
		cel 2
		priority 4
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if local0
					(gCurRoom setScript: pickupClothes 0 0)
				else
					(gCurRoom setScript: jumpForClothes 0 4)
				)
			)
			(25 ; Bone or invDoggieBone
				(if local0
					(gMessager say: 2 25 2) ; "Pepper doesn't want to put the nasty, spitty bone on the baby clothes any more than she has to!"
				else
					(gCurRoom setScript: sGetBabyClothes)
				)
			)
			(6 ; Look
				(if local0
					(gMessager say: 2 6 2) ; "The baby clothes are on the ground now."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bone of Actor
	(properties
		x 220
		y 143
		noun 5
		view 250
		cel 4
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 5 6 2) ; "Lockjaw has dug up a moldy old bone."
			)
			(7 ; Do
				(gCurRoom setScript: sGetBone)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Bone of TWInvItem
	(properties
		loop 1
		cel 7
		message 25
		signal 2
		noun 5
		modNum 250
	)
)

(instance Boy_s_Clothes of TWInvItem
	(properties
		name {Boy's Clothes}
		loop 1
		cel 8
		message 26
		signal 2
		noun 28
		modNum 250
	)
)

(instance Baby_s_Clothes of TWInvItem
	(properties
		name {Baby's Clothes}
		loop 1
		cel 9
		message 27
		signal 2
		noun 27
		modNum 250
	)
)

(instance pepperActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(26 ; Boy_s_Clothes
				(if local0
					(gCurRoom setScript: sChangeClothes)
				else
					(gMessager say: 20 120 15) ; "That's an excellent idea, but Pepper is going to need a disguise for Lockjaw, too."
				)
			)
			(27 ; Baby_s_Clothes
				(gMessager say: 20 121) ; "Well, these baby clothes definitely don't fit ME."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance watchMan of Actor
	(properties
		x 161
		y 92
		noun 25
		view 815
		loop 3
		priority 2
		signal 18448
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lockjawActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (not (IsFlag 248))
					(gCurRoom setScript: sGetBone)
				else
					(gMessager say: 18 7) ; "Good boy! Be quiet, now, Lockjaw."
				)
			)
			(6 ; Look
				(gMessager say: 18 6) ; "Lockjaw doesn't seem tired out by his tunnel-digging experience."
			)
			(25 ; Bone or invDoggieBone
				(gCurRoom setScript: ljGetBone)
				(return 1)
			)
			(26 ; Boy_s_Clothes
				(gMessager say: 18 120) ; "Hmm, let's see... no, I don't think this would fit you, Lockjaw."
			)
			(27 ; Baby_s_Clothes
				(if (IsFlag 10)
					(gCurRoom setScript: sWrapDog)
				else
					(gMessager say: 18 121 10) ; "That's an excellent idea, but Pepper needs to disguise herself first. What if someone walked by and saw her right now?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hole of View
	(properties
		x 234
		y 24
		z -100
		noun 24
		view 250
		cel 5
		priority 3
		signal 18448
	)
)

(instance barrel of Feature
	(properties
		y 170
		noun 3
	)
)

(instance blueApron of Feature
	(properties
		x 264
		y 149
		noun 4
		nsTop 35
		nsLeft 251
		nsBottom 64
		nsRight 277
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 10)
					(gMessager say: 29 7) ; "Pepper realizes it's impossible for her to grab the clothes, so she doesn't try."
				else
					((ScriptID 895 0) setScript: jumpForClothes 0 1) ; pepper
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clothesLine of Feature
	(properties
		y 47
		noun 7
	)
)

(instance crate1 of Feature
	(properties
		y 160
		noun 8
	)
)

(instance crate2 of Feature
	(properties
		y 100
		noun 9
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 67)
		(super doVerb: theVerb)
	)
)

(instance crate3 of Feature
	(properties
		x 91
		y 89
		noun 10
		nsTop 73
		nsLeft 72
		nsBottom 105
		nsRight 110
		sightAngle 40
	)
)

(instance crate4 of Feature
	(properties
		y 120
		noun 11
	)
)

(instance crate5 of Feature
	(properties
		y 90
		noun 12
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 93)
		(super doVerb: theVerb)
	)
)

(instance crate6 of Feature
	(properties
		x 183
		y 107
		noun 13
		nsTop 71
		nsLeft 175
		nsBottom 101
		nsRight 192
		sightAngle 40
	)
)

(instance crate7 of Feature ; UNUSED
	(properties
		x 232
		y 107
		noun 14
		nsTop 85
		nsLeft 223
		nsBottom 103
		nsRight 242
		sightAngle 40
	)
)

(instance crate8 of Feature
	(properties
		x 227
		y 107
		noun 15
		nsTop 85
		nsLeft 210
		nsBottom 118
		nsRight 245
		sightAngle 40
	)
)

(instance girlSuit of Feature
	(properties
		x 219
		y 110
		noun 16
		nsTop 43
		nsLeft 209
		nsBottom 75
		nsRight 230
		sightAngle 40
	)
)

(instance leaves of Feature
	(properties
		y 10
		noun 17
	)
)

(instance pebbles1 of Feature
	(properties
		y 134
		noun 19
		approachX 208
		approachY 134
		approachDist 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (not (gEgo has: 4)) ; Pebbles
					(gCurRoom setScript: pickUpPebbles)
				else
					(gMessager say: 19 7 13) ; "Pepper doesn't need any more pebbles. She has enough to last her a long time."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pinkCoat of Feature
	(properties
		x 137
		y 114
		noun 21
		nsTop 19
		nsLeft 122
		nsBottom 70
		nsRight 153
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 10)
					(gMessager say: 29 7) ; "Pepper realizes it's impossible for her to grab the clothes, so she doesn't try."
				else
					(gCurRoom setScript: jumpForClothes 0 2)
				)
			)
			(25 ; Bone or invDoggieBone
				((ScriptID 895 0) setHeading: 180) ; pepper
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boyClothesFeature of Feature
	(properties
		x 191
		y 103
		noun 6
		nsTop 32
		nsLeft 170
		nsBottom 75
		nsRight 213
	)

	(method (doVerb theVerb)
		(boyClothes doVerb: theVerb)
	)
)

(instance babyClothesFeature of Feature
	(properties
		x 242
		y 152
		noun 2
		nsTop 34
		nsLeft 226
		nsBottom 70
		nsRight 259
	)

	(method (doVerb theVerb)
		(babyClothes doVerb: theVerb)
	)
)

(instance northEFeature of ExitFeature
	(properties
		nsTop 55
		nsLeft 189
		nsBottom 106
		nsRight 237
		cursor 912
		exitDir 1
		modNum 250
		noun 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(= gDictionaryWord 16)
				(super doVerb: theVerb)
			)
			(7 ; Do
				(if (not (gEgo has: 4)) ; Pebbles
					(gCurRoom setScript: pickUpPebbles)
				else
					(gMessager say: 19 7 13) ; "Pepper doesn't need any more pebbles. She has enough to last her a long time."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance watchManTalker of BalloonTalker
	(properties
		talkWidth 140
		tailPosn 4
	)

	(method (init)
		(= x (- (watchMan x:) 160))
		(= y (- (watchMan y:) 25))
		(super init: &rest)
	)
)

(instance lockjawPoly of Polygon
	(properties)
)

(instance roomPoly of Polygon
	(properties)
)

(instance roomTimer of Timer
	(properties)
)

(instance sFx of Sound
	(properties)
)

