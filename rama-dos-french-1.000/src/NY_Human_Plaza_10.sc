;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5210)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SaveManager)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	NY_Human_Plaza_10 0
)

(local
	local0
	local1
)

(instance NY_Human_Plaza_10 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5205 ; humanPlazaRm5
				(self addPicObj: faceSW faceNE faceSW)
			)
			(else
				(self addPicObj: faceNE faceSW faceNE)
			)
		)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
			(= local0 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 5228
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom5 init:)
		(walls_45 init:)
		(pentahedron_45 init:)
		(door_45 init:)
		(super init: &rest)
		(if local0
			(= local0 0)
			(gCurRoom setScript: mantisProwls)
		)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 5227
		edgeS 0
		edgeN 0
	)

	(method (init)
		(statue init:)
		(walls_225 init:)
		(fork_225 init:)
		(= showBlack 1)
		(super init: &rest)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance exitToRoom5 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5205
	)
)

(instance statue of Feature
	(properties
		nsBottom 153
		nsLeft 262
		nsRight 300
		nsTop 44
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 123 124 125 126 127)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(super doVerb: theVerb)
			)
			(126
				(= local1 3)
				(gCurRoom setScript: tuningForkScript)
				(proc201_1 28)
			)
			(else
				(proc201_1 28)
				(= local1 (- (proc70_7 (gTheCursor invItem:)) 117))
				(gCurRoom setScript: tuningForkScript)
			)
		)
	)
)

(instance doorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorSnd number: 5210 setVol: 127 play: self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mantisProwls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mantis_Prowls play: self)
			)
			(1
				(SetFlag 308)
				(door_45 case: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tuningForkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 (+ 5227 local1) 267 47 0 0 250 0 self)
				(forkSound number: (+ 20002 local1) play:)
				(statueSound play:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(if (and (== local1 0) (not local0))
					(= local0 1)
					(gCurRoom setScript: doorOpens)
				)
			)
		)
	)
)

(instance mantis_Prowls of VMDMovie
	(properties
		movieName 5200
		endPic 5228
	)
)

(instance doorSnd of Sound
	(properties
		flags 5
	)
)

(instance forkSound of Sound
	(properties
		flags 5
	)
)

(instance statueSound of Sound
	(properties
		number 5220
		flags 5
	)
)

(instance walls_45 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 591 0 591 195 207 192 207 186 177 185 177 181 -1 181
					yourself:
				)
		)
	)
)

(instance pentahedron_45 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 591 1 591 212 568 209 549 216 322 211 322 207 339 207 339 203 357 202 358 195 378 195 380 188 398 189 398 185 413 182 413 176 438 176 438 172 459 172 459 167 468 166
					yourself:
				)
		)
	)
)

(instance door_45 of Feature
	(properties
		noun 1
	)

	(method (init)
		(= case (if (IsFlag 308) 2 else 1))
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 287 139 295 140 299 160 304 162 306 193 277 194 279 161 284 159
					yourself:
				)
		)
	)
)

(instance walls_225 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 -2 591 -1 590 248 427 248 427 253 381 255 148 253 146 248 -1 248
					yourself:
				)
		)
	)
)

(instance fork_225 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 326 2 320 21 317 21 313 2 298 1 307 47 303 50 304 125 301 161 293 190 331 190 344 206 332 210 332 213 358 218 374 234 368 240 379 247 386 283 381 290 173 292 171 288 176 248 187 242 183 236 196 219 216 213 216 208 212 207 225 193 271 191 262 147 262 50 258 49 257 39 261 26 266 6 268 0 254 0 252 7 248 7 248 20 242 19 243 12 244 7 240 0
					yourself:
				)
		)
	)
)

