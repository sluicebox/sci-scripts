;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use rCliffs)
(use KQ6Print)
(use n301)
(use n913)
(use Conversation)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm300 0
	stepDownToBeach 1
)

(local
	[local0 37] = [0 0 0 0 0 0 0 0 0 0 0 0 0 -3 108 142 200 219 170 156 170 166 188 46 53 90 25 258 223 245 122 112 106 111 113 109 117]
	[local37 28] = [1 1 1 1 1 1 1 1 1 2 2 2 2 2 3 3 3 3 3 3 4 4 4 4 4 4 4 4]
	[local65 28] = [0 1 2 3 4 5 6 7 8 0 1 2 3 4 0 1 2 3 4 5 0 1 2 3 4 5 6 7]
	[local93 28] = [0 0 0 0 1 0 0 0 0 0 2 0 0 0 0 0 3 0 0 0 4 0 4 0 0 0 4 0]
	[local121 28] = [105 111 124 137 152 166 177 191 204 134 146 153 163 172 115 134 141 153 166 181 116 126 135 146 158 170 180 190]
	[local149 28] = [56 56 56 56 56 56 56 56 56 73 73 73 73 73 89 89 89 89 89 89 105 105 105 105 105 105 105 105]
	[local177 28] = [49 49 49 49 49 49 49 49 49 66 66 66 66 66 82 82 82 82 82 82 98 98 98 98 98 98 98 98]
	[local205 28] = [102 108 121 134 149 163 174 188 201 131 143 150 160 169 112 131 138 150 163 178 113 123 132 143 155 167 177 187]
	[local233 28] = [108 121 134 149 163 174 188 201 214 143 150 160 169 183 131 138 150 163 178 188 123 132 143 155 167 177 187 200]
	[local261 28] = [65 65 65 65 65 65 65 65 65 81 81 81 81 81 98 98 98 98 98 98 113 113 113 113 113 113 113 113]
	[local289 32] = [1 1 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 5 5 5 5 5]
	[local321 32] = [0 1 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 0 1 2 3 4 5 6 7 8 0 1 2 3 4]
	[local353 32] = [0 0 4 0 0 0 5 0 0 0 4 0 0 0 0 0 0 0 1 0 3 4 0 2 5 4 0 0 0 0 0 0]
	[local385 32] = [146 156 96 103 117 130 145 159 172 185 198 205 116 134 147 158 175 185 104 117 130 142 149 163 176 190 197 129 139 149 159 173]
	[local417 32] = [155 168 102 116 129 144 158 171 184 197 204 217 133 146 157 174 184 197 116 129 141 148 162 175 189 196 209 138 148 158 172 185]
	[local449 32] = [32 32 52 52 52 52 52 52 52 52 52 52 72 72 72 72 72 72 92 92 92 92 92 92 92 92 92 112 112 112 112 112]
	[local481 32] = [48 48 68 68 68 68 68 68 68 68 68 68 88 88 88 88 88 88 108 108 108 108 108 108 108 108 108 128 128 128 128 128]
	[local513 31] = [1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 3 3 4 4 4 4 4 4 4 4 5 5 5 5 5]
	[local544 31] = [0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 0 1 0 1 2 3 4 5 6 7 0 1 2 3 4]
	[local575 31] = [1 7 0 0 0 5 4 0 0 4 0 0 0 7 0 2 1 4 6 4 0 0 2 0 0 4 2 1 2 3 4]
	[local606 31] = [89 106 113 126 141 154 165 179 194 207 121 133 145 158 166 178 140 151 104 114 128 141 154 165 178 191 126 137 147 157 168]
	[local637 31] = [88 105 112 125 140 153 164 178 193 206 120 132 144 157 165 177 139 150 103 113 127 140 153 164 177 190 125 136 146 156 167]
	[local668 31] = [96 110 123 139 151 162 176 191 203 218 130 142 154 163 175 185 148 162 111 125 138 151 162 175 188 202 134 144 154 165 179]
	[local699 31] = [59 59 59 59 59 59 59 59 59 59 72 72 72 72 72 72 85 85 98 98 98 98 98 98 98 98 111 111 111 111 111]
	[local730 31] = [58 58 58 58 58 58 58 58 58 58 71 71 71 71 71 71 84 84 97 97 97 97 97 97 97 97 110 110 110 110 110]
	[local761 31] = [69 69 69 69 69 69 69 69 69 69 82 82 82 82 82 82 95 95 108 108 108 108 108 108 108 108 121 121 121 121 121]
	[local792 38] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 18 1 2 6 0 0]
	local830
	local831
	local832
	local833
	local834
)

(procedure (localproc_0)
	(return
		(switch (gGame printLang:)
			(34
				@local449
			)
			(39
				@local730
			)
			(else
				@local177
			)
		)
	)
)

(procedure (localproc_1)
	(return
		(switch (gGame printLang:)
			(34
				@local385
			)
			(39
				@local637
			)
			(else
				@local205
			)
		)
	)
)

(procedure (localproc_2)
	(return
		(switch (gGame printLang:)
			(34
				@local417
			)
			(39
				@local668
			)
			(else
				@local233
			)
		)
	)
)

(procedure (localproc_3)
	(return
		(switch (gGame printLang:)
			(34
				@local481
			)
			(39
				@local761
			)
			(else
				@local261
			)
		)
	)
)

(procedure (localproc_4)
	(return
		(switch (gGame printLang:)
			(34
				@local289
			)
			(39
				@local513
			)
			(else
				@local37
			)
		)
	)
)

(procedure (localproc_5)
	(return
		(switch (gGame printLang:)
			(34
				@local321
			)
			(39
				@local544
			)
			(else
				@local65
			)
		)
	)
)

(procedure (localproc_6)
	(return
		(switch (gGame printLang:)
			(34
				@local385
			)
			(39
				@local606
			)
			(else
				@local121
			)
		)
	)
)

(procedure (localproc_7)
	(return
		(switch (gGame printLang:)
			(34
				@local449
			)
			(39
				@local699
			)
			(else
				@local149
			)
		)
	)
)

(procedure (localproc_8)
	(return
		(switch (gGame printLang:)
			(34
				@local353
			)
			(39
				@local575
			)
			(else
				@local93
			)
		)
	)
)

(class WalkFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (gUser curEvent:))
		(if (== theVerb 3) ; Walk
			(cond
				((and (== (gEgo view:) 301) (== (gEgo loop:) 3)) 0)
				((< (gEgo y:) 38)
					(gCurRoom setScript: splatterDie 0 1)
				)
				((< (gEgo y:) 95)
					(gCurRoom setScript: splatterDie 0 0)
				)
				((<= (gEgo y:) 105)
					((ScriptID 21 0) cue:) ; rCliffs
					(gCurRoom setScript: stepDownToBeach)
				)
				((OneOf (== (gEgo view:) 301 301)) 0)
				(else
					(if (and (> (temp0 y:) 160) (== (gEgo onControl: 1) 64))
						(temp0 y: 160)
					)
					(gEgo setScript: walkThere 0 temp0)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rm300 of CliffRoom
	(properties
		noun 8
		picture 300
		horizon 0
		walkOffEdge 1
	)

	(method (notify)
		(gCurRoom setScript: rockStair)
	)

	(method (cue)
		(cond
			((< (gEgo y:) 38)
				(gCurRoom setScript: splatterDie 0 1)
			)
			((< (gEgo y:) 95)
				(gCurRoom setScript: splatterDie 0 0)
			)
		)
	)

	(method (makeARock)
		(= local831 1)
		(super makeARock:)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 253 189 241 181 238 175 233 159 230 149 223 114 211 113 209 111 190 116 103 115 88 124 73 122 72 125 66 135 70 155 90 189 6 189 0 189 0 0 319 0
					yourself:
				)
		)
		(if (!= gPrevRoomNum 380)
			(gGlobalSound number: 915 setLoop: -1 play:)
		)
		(gGlobalSound4 number: 916 setLoop: -1 play:)
		(if (IsFlag 157)
			(self north: 340)
		else
			(self north: 320)
		)
		(if (== gPrevRoomNum 320)
			(self style: 13)
		else
			(self style: -32758)
		)
		(super init:)
		(gFeatures add: cliffs ocean rock stone beach eachElementDo: #init)
		(if (IsFlag 5)
			(self allRocksOut:)
		)
		(LoadMany rsVIEW 320 321 308 3081 3082)
		(wave init: hide: setScript: waveScr)
		(sanScript init:)
		(shimmer1 init:)
		(shimmer2 init:)
		(if (== ((gInventory at: 12) owner:) gCurRoomNum) ; feather
			(feather init: stopUpd:)
		)
		(if (== ((gInventory at: 13) owner:) gCurRoomNum) ; flower
			(stench init: stopUpd:)
		)
		(gEgo actions: egoDoVerb)
		(cond
			((OneOf gPrevRoomNum 370 380)
				(gEgo init: reset: posn: 340 -10)
				(proc301_0)
			)
			((OneOf gPrevRoomNum 320 340)
				(if (== gPrevRoomNum 320)
					(UnLoad 128 322)
				)
				(Load rsVIEW 321)
				(gEgo view: 301 setLoop: 1 cel: 0 init: posn: 70 4)
				(gCurRoom setScript: stepDownFromCliff)
			)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(== (gEgo onControl: 1) 64)
					(== (gEgo view:) 308)
					(!= (gEgo view:) 900)
				)
				(= local832 0)
				(gGlobalSound2 fade: 0 10 15 1)
				(gEgo view: 900)
			)
			(
				(and
					(== (gEgo onControl: 1) 32)
					(or (== (gEgo view:) 900) (== (gEgo view:) 3081))
					(!= (gEgo view:) 308)
				)
				(gGlobalSound2 number: 922 setLoop: -1 play:)
				(cond
					((!= (gEgo view:) 900) 0)
					((< (gEgo heading:) 135)
						(gEgo loop: 0)
					)
					((> (gEgo heading:) 225)
						(gEgo loop: 1)
					)
					(else
						(gEgo loop: 2)
					)
				)
				(gEgo view: 308)
			)
			(
				(and
					(or
						(== (gEgo onControl: 1) 512)
						(== (gEgo onControl: 1) 1024)
					)
					(!= (gEgo view:) 3081)
				)
				(gEgo view: 3081)
			)
			(
				(and
					(or
						(== (gEgo onControl: 1) 4096)
						(== (gEgo onControl: 1) 2048)
					)
					(!= (gEgo view:) 3082)
					(not local830)
				)
				(gEgo view: 3082)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 320)
			(gGlobalSound fade: 0 5 5)
			(gGlobalSound4 fade: 0 5 5)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(DisposeScript 301)
		(super dispose:)
	)
)

(instance myConv of Conversation
	(properties)
)

(instance puzzle of PuzzleInset
	(properties
		x 157
		y 39
		z -45
		view 320
		signal 16384
		maxButtons 4
		buttNumber 32
		buttView 321
		lookMsg 8
		puzzNumber 1
	)

	(method (init)
		(self
			buttNumber: (proc913_5 28 32 28 31 28)
			maxButtons: (proc913_5 4 5 4 7 4)
			buttTop: (localproc_0)
			buttLeft: (localproc_1)
			buttRight: (localproc_2)
			buttBottom: (localproc_3)
			buttLoop: (localproc_4)
			buttCel: (localproc_5)
			buttX: (localproc_6)
			buttY: (localproc_7)
			buttVal: (localproc_8)
			buttKill: @local792
		)
		(gEgo hide: view: 300)
		(UnLoad 128 900)
		(words init:)
		(super init:)
	)

	(method (dispose)
		(words dispose:)
		(gEgo view: 900 loop: 3 show:)
		(super dispose:)
	)
)

(instance words of View
	(properties
		x 209
		y 71
		z -40
		view 321
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(puzzle doVerb: theVerb &rest)
	)
)

(instance stench of View
	(properties
		x 68
		y 127
		noun 12
		view 300
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((< (gEgo y:) 105)
					(gMessager say: 6 12 14 1) ; "Not while Alexander is on the steps!"
				)
				((== ((gInventory at: 13) owner:) gCurRoomNum) ; flower
					(gCurRoom setScript: pickItem 0 self)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance feather of View
	(properties
		x 210
		y 128
		noun 11
		view 310
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (< (gEgo y:) 105)
				(gMessager say: 6 12 14 1) ; "Not while Alexander is on the steps!"
			else
				(gCurRoom setScript: pickItem 0 self)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wave of Prop
	(properties
		x 162
		y 159
		noun 7
		view 300
		priority 1
		signal 16
	)
)

(instance shimmer1 of Prop
	(properties
		x 24
		y 177
		noun 7
		view 300
		loop 1
		priority 1
		signal 16400
		cycleSpeed 30
		detailLevel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance shimmer2 of Prop
	(properties
		x 261
		y 182
		noun 7
		view 300
		loop 2
		priority 1
		signal 16400
		cycleSpeed 30
		detailLevel 3
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance sanScript of View
	(properties
		x 138
		y 189
		z 124
		noun 3
		sightAngle 180
		view 326
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(self onMe: event)
				(not ((ScriptID 21 0) puzzleIsUp:)) ; rCliffs
				(or
					(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(or (== (event message:) KEY_RETURN) (== (event type:) evMOUSEBUTTON))
				(User canInput:)
				(!= (event type:) evVERB)
				(not (event modifiers:))
			)
			(event claimed: 1)
			(cond
				((<= (gEgo y:) 105)
					(if gModelessDialog
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
					else
						(gMessager say: 3 1 14 1) ; "Alexander can't see the words on the cliff from where he is. Besides, there's nothing more to be done with the words now that the steps are out."
					)
				)
				((or (IsFlag 6) (IsFlag 5))
					(puzzle puzzSolved:)
				)
				(else
					(gEgo setScript: goToInset)
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance stone of WalkFeature
	(properties
		noun 9
		onMeCheck 256
	)
)

(instance rock of WalkFeature
	(properties
		noun 9
		onMeCheck 3072
	)
)

(instance ocean of WalkFeature
	(properties
		noun 7
		onMeCheck 4640
	)
)

(instance cliffs of WalkFeature
	(properties
		noun 8
		onMeCheck 128
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(if local831
					(gMessager say: 8 1 22 0) ; "Boulders emerging from the cliffs provide a tricky stairway to the top."
				else
					(gMessager say: 8 1 5 0) ; "There appears to be no way past the cliffs. Though roughly hewn, the cliffs do not provide regular handholds for climbing, and they seem otherwise impenetrable."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beach of Feature
	(properties
		noun 2
		onMeCheck 64
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (gUser curEvent:))
		(switch theVerb
			(3 ; Walk
				(cond
					((and (== (gEgo view:) 301) (== (gEgo loop:) 3)) 0)
					((< (gEgo y:) 38)
						(gCurRoom setScript: splatterDie 0 1)
					)
					((< (gEgo y:) 95)
						(gCurRoom setScript: splatterDie 0 0)
					)
					((<= (gEgo y:) 105)
						((ScriptID 21 0) cue:) ; rCliffs
						(gCurRoom setScript: stepDownToBeach)
					)
					((or (== (gEgo view:) 301) (== (gEgo view:) 301)) 0)
					(else
						(if
							(and
								(> (temp0 y:) 160)
								(== (gEgo onControl: 1) 64)
							)
							(temp0 y: 160)
						)
						(gEgo setScript: walkThere 0 temp0)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 5)
					(gMessager say: 2 1 22 1) ; "Alexander is standing on the small sandy cove of a rocky island. Around him, sheer granite cliffs block any further movement east or west. To the south he is blocked by the sea. Boulders have emerged from the cliffs, providing a staircase to the top."
				else
					(gMessager say: 2 1 5 1) ; "Alexander is standing on the small sandy cove of a rocky island. Around him, sheer granite cliffs block any further movement north, east, or west. To the south he is blocked by the sea."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gGame detailLevel:) (wave detailLevel:))
					(wave show: cel: 0 setCycle: End self)
				else
					(+= state 1)
					(self cue:)
				)
			)
			(1
				(wave setCycle: Beg self)
			)
			(2
				(= state -1)
				(wave hide:)
				(= seconds (Random 1 7))
			)
		)
	)
)

(instance walkThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(== (gEgo onControl: 1) 32)
						(== (gEgo onControl: 1) 512)
						(== (gEgo onControl: 1) 1024)
					)
					(= local832 1)
				else
					(= local832 0)
				)
				(gEgo setMotion: PolyPath (register x:) (register y:) self)
			)
			(1
				(= cycles 2)
			)
			(2
				(cond
					(
						(and
							(not local832)
							(or
								(== (gEgo onControl: 1) 32)
								(== (gEgo onControl: 1) 512)
								(== (gEgo onControl: 1) 1024)
							)
						)
						(gMessager say: 7 3 24 1 self) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
					)
					(
						(or
							(== (gEgo onControl: 1) 4096)
							(== (gEgo onControl: 1) 2048)
						)
						(myConv add: -1 7 3 26 1 add: -1 7 3 26 2 init: self) ; "The underwater tow is amazingly strong here. It pulls ferociously at Alexander's legs.", "Before Alexander can retreat, the currents grab his legs! The shifting sand vanishes from beneath his feet! Against his best efforts, he is dragged out to sea!"
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if
					(or
						(== (gEgo onControl: 1) 4096)
						(== (gEgo onControl: 1) 2048)
					)
					(self cue:)
				else
					(self dispose:)
				)
			)
			(4
				(gGame handsOff:)
				(= local830 1)
				(gGlobalSound2 number: 921 setLoop: 1 play:)
				(gEgo
					view: 309
					cel: 0
					normal: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance splatterDie of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rCliffs cheatCount: 0)
				(if (== register 0)
					(Load rsVIEW 201)
				)
				((ScriptID 21 0) cue:) ; rCliffs
				(gMessager say: 4 3 8 1 self) ; "Oh, no! Alexander loses his balance!"
			)
			(1
				(if (< (gEgo loop:) 6)
					(gEgo
						setLoop: 4
						posn: (- (gEgo x:) 19) (+ (gEgo y:) 6)
						cel: 2
					)
					(= ticks 2)
				else
					(self cue:)
				)
			)
			(2
				(gGlobalSound3 number: 305 setLoop: 1 play:)
				(if (== (gEgo loop:) 6)
					(gEgo
						view: 3011
						posn: (+ (gEgo x:) 18) (+ (gEgo y:) 10)
						cycleSpeed: 6
						setLoop: 1
					)
				else
					(gEgo
						view: 301
						posn: (gEgo x:) (+ (gEgo y:) 2)
						cycleSpeed: 6
						setLoop: 3
					)
				)
				(gEgo cel: 0 setCycle: End self)
			)
			(3
				(if (== (gEgo view:) 301)
					(gEgo setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(4
				(if (== (gEgo view:) 301)
					(gEgo
						posn: (+ (gEgo x:) 18) (- (gEgo y:) 7)
						setLoop: (Random 1 2)
					)
				else
					(gEgo
						posn: (- (gEgo x:) 18) (- (gEgo y:) 10)
						setLoop: 6
					)
				)
				(gEgo view: 301 cycleSpeed: 6 cel: 0)
				(= cycles 10)
			)
			(5
				(if (== (gEgo loop:) 4)
					(gEgo posn: (- (gEgo x:) 1) (- (gEgo y:) 9))
				else
					(gEgo posn: (- (gEgo x:) 1) (- (gEgo y:) 3))
				)
				(gEgo view: 307 cycleSpeed: 1 setLoop: 0)
				(SetFlag 59)
				(if (& gMsgType $0002)
					(KQ6Print modeless: 1 posn: -1 10 say: 0 4 3 8 2 init:) ; "Whoa, whoa, WHOA!!!"
				)
				(= cycles 4)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(ClearFlag 59)
				(gGlobalSound3 number: 306 setLoop: 1 play:)
				(gEgo setLoop: 1 yStep: 35)
				(if (== register 0)
					(= temp0 15)
				else
					(= temp0 0)
				)
				(gEgo
					setStep: 10 12
					setMotion: PolyPath (+ (gEgo x:) temp0) 116 self
				)
			)
			(8
				(if (== register 0)
					(self setScript: bounceButt self)
				else
					(gEgo setLoop: 2 setCycle: End self)
				)
				(gGlobalSound3 stop:)
				(gGlobalSound2 number: 307 setLoop: 1 play:)
			)
			(9
				(if (== register 0)
					(gEgo
						setLoop: 4
						cel: 0
						posn: (- (gEgo x:) 55) (+ (gEgo y:) 19)
						setCycle: End self
					)
				else
					(gMessager say: 4 3 9 1 self) ; "The unforgiving rocks break his long fall!"
				)
			)
			(10
				(if (== register 0)
					(gEgo
						posn: (+ (gEgo x:) 33) (+ (gEgo y:) 4)
						reset: 5
					)
					(= cycles 8)
				else
					(self cue:)
				)
			)
			(11
				(if (== register 0)
					(if (== local833 3)
						(gMessager say: 1 0 15 1 self) ; "Hey! Quit making me fall!"
					else
						(gMessager say: 4 3 8 3 self) ; "Ow! Hey!"
					)
				else
					(self cue:)
				)
			)
			(12
				(if (== register 0)
					(gGame handsOn:)
					(gEgo actions: egoDoVerb)
					(self dispose:)
				else
					(gGlobalSound4 fade: 0 5 5)
					(EgoDead 8) ; "That wasn't a very logical step!"
				)
			)
		)
	)
)

(instance bounceButt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ local833)
				(gEgo
					view: 307
					setLoop: 3
					cel: 0
					normal: 0
					setSpeed: 6
					posn: (gEgo x:) (gEgo y:)
				)
				(= ticks 4)
			)
			(1
				(gEgo cel: 1 posn: (+ (gEgo x:) 4) (- (gEgo y:) 1))
				(= ticks 4)
			)
			(2
				(gEgo cel: 2 posn: (gEgo x:) (- (gEgo y:) 1))
				(= ticks 4)
			)
			(3
				(gEgo cel: 3 posn: (gEgo x:) (- (gEgo y:) 5))
				(= ticks 4)
			)
			(4
				(gEgo cel: 4 posn: (gEgo x:) (- (gEgo y:) 1))
				(= ticks 4)
			)
			(5
				(gEgo cel: 5 posn: (gEgo x:) (- (gEgo y:) 1))
				(= ticks 4)
			)
			(6
				(gEgo cel: 6 posn: (gEgo x:) (- (gEgo y:) 1))
				(= ticks 4)
			)
			(7
				(gDirectionHandler delete: gCurRoom)
				(self dispose:)
			)
		)
	)
)

(instance stepDownFromCliff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rCliffs cue: cheatCount: 8 stepDirection: 1)
				(gEgo
					view: 301
					setLoop: 8
					cel: 0
					cycleSpeed: 16
					posn: (+ (gEgo x:) 1) (gEgo y:)
				)
				(= cycles 8)
			)
			(1
				(if (== local834 0)
					(if (== gPrevRoomNum 340)
						(gMessager say: 1 0 6 1 self) ; "Alexander climbs carefully down the long face of the logic cliffs."
					else
						(= cycles 1)
					)
				else
					(self cue:)
				)
			)
			(2
				(proc21_1)
				(gEgo cel: 1 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(3
				(gEgo cel: 2 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(4
				(gEgo cel: 3 posn: (gEgo x:) (gEgo y:))
				(= cycles 8)
			)
			(5
				(gEgo cel: 4 posn: (+ (gEgo x:) 1) (gEgo y:))
				(= cycles 8)
			)
			(6
				(gEgo cel: 5 posn: (- (gEgo x:) 1) (gEgo y:))
				(= cycles 8)
			)
			(7
				(gEgo cel: 6 posn: (+ (gEgo x:) 2) (gEgo y:))
				(= cycles 8)
			)
			(8
				(if (== local834 3)
					(self cue:)
				else
					(gEgo
						view: 301
						setLoop: 8
						cel: 0
						posn: (+ (gEgo x:) 27) (+ (gEgo y:) 12)
					)
					(= cycles 8)
				)
			)
			(9
				(if (< local834 3)
					(++ local834)
					(-= state 9)
				else
					(= local834 0)
					(gEgo setLoop: 2 cel: 0 posn: 188 50)
				)
				(self cue:)
			)
			(10
				(gGame handsOn:)
				((ScriptID 21 0) notify:) ; rCliffs
				(self dispose:)
			)
		)
	)
)

(instance stepDownToBeach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (rCliffs stepDirection:) 2)
					(gEgo
						view: 301
						setLoop: 5
						cel: 0
						posn: (+ (gEgo x:) 18) (+ (gEgo y:) 7)
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				(if (== (rCliffs stepDirection:) 2)
					(rCliffs stepDirection: 3)
					(gEgo
						view: 301
						setLoop: 1
						cel: 0
						posn: (+ (gEgo x:) 16) (- (gEgo y:) 6)
					)
					(= cycles 8)
				else
					(self cue:)
				)
			)
			(2
				(gEgo
					view: 301
					x: (- (gEgo x:) 20)
					y: (+ (gEgo y:) 11)
					setLoop: 0
					cel: 5
					setCycle: Beg self
				)
			)
			(3
				(if (== gPrevRoomNum 340)
					(gMessager say: 1 0 6 1 self) ; "Alexander climbs carefully down the long face of the logic cliffs."
				else
					(self cue:)
				)
			)
			(4
				(gEgo posn: 110 112 actions: egoDoVerb reset: 3)
				(= cycles 8)
			)
			(5
				(gEgo setHeading: 180)
				(= cycles 14)
			)
			(6
				(gGame handsOn:)
				(gDirectionHandler delete: gCurRoom)
				(self dispose:)
			)
		)
	)
)

(instance goToInset of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 5)
					(self cue:)
				else
					(gMessager say: 3 1 0 1 self) ; "There appears to be something etched into the face of the cliff. Alexander decides to get closer."
				)
			)
			(1
				(if (gEgo inRect: 140 110 180 125)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 146 127 self)
				)
			)
			(2
				(gEgo setHeading: 0)
				(= ticks 18)
			)
			(3
				(gGame handsOn:)
				(puzzle init:)
				(self dispose:)
			)
		)
	)
)

(instance pickItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register stench)
					(gEgo
						setMotion:
							PolyPath
							(+ (register x:) 34)
							(+ (register y:) 2)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (register x:) 7)
							(- (register y:) 12)
							self
					)
				)
			)
			(1
				(if (== register stench)
					(gEgo setHeading: 315)
				else
					(gEgo setHeading: 180)
				)
				(= ticks 18)
			)
			(2
				(if (== register stench)
					(gEgo
						view: 302
						setLoop: 0
						normal: 0
						cel: 0
						setPri: (gEgo priority:)
						posn: 89 135
						cycleSpeed: 6
						setCycle: CT 2 1 self
					)
				else
					(gEgo
						view: 311
						setLoop: 0
						normal: 0
						cel: 0
						setPri: (gEgo priority:)
						posn: (- (gEgo x:) 2) (+ (gEgo y:) 11)
						cycleSpeed: 6
						setCycle: CT 3 1 self
					)
				)
				(gGame givePoints: 1)
			)
			(3
				(if (== register feather)
					(feather dispose:)
				else
					(stench dispose:)
				)
				(gEgo setCycle: End self)
			)
			(4
				(if (== register feather)
					(gEgo get: 12) ; feather
					(gMessager say: 11 5 0 1 self) ; "Alexander takes the feather."
				else
					(gEgo get: 13) ; flower
					(gMessager say: 12 5 0 1 self) ; "Alexander picks the flower and is startled by its hideously strong, skunk-like odor. For a moment, he can smell nothing else."
				)
			)
			(5
				(if (== register stench)
					(gEgo
						reset: 7
						posn: (+ (gEgo x:) 11) (- (gEgo y:) 5)
					)
					(UnLoad 128 302)
				else
					(gEgo
						reset: 2
						posn: (+ (gEgo x:) 2) (- (gEgo y:) 9)
					)
					(UnLoad 128 311)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rockStair of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 5)
				(= seconds 2)
			)
			(1
				(gCurRoom flipRocks: 0 callForRocks:)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 12) ; map
			(if (== (gEgo onControl: 1) 64)
				(gCurRoom setScript: 130) ; pullOutMapScr
				(return 1)
			else
				(gCurRoom setScript: 130) ; pullOutMapScr
				(return 1)
			)
		else
			(return 0)
		)
	)
)

